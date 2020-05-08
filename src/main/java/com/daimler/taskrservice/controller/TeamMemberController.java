/*
A controller to handle HTTP requests in regards to TeamMember class
 */
package com.daimler.taskrservice.controller;

import com.daimler.taskrservice.model.Task;
import com.daimler.taskrservice.model.Team;
import com.daimler.taskrservice.model.TeamMember;
import com.daimler.taskrservice.repository.TaskRepository;
import com.daimler.taskrservice.repository.TeamMemberRepository;
import com.daimler.taskrservice.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //This means that this class is a Controller
@RequestMapping("/api/teammember") // This means URL's start with /api/teammember (after Application path)
public class TeamMemberController {
    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired //This means to get the bean called teamRepository Which is auto-generated by Spring, we will use it to handle the data
    TeamMemberRepository teamMemberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TaskRepository taskRepository;

    @PostMapping(path="/create")// Map ONLY POST Requests to add a new team member
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    public @ResponseBody Object createTeamMember(@RequestParam String name, @RequestParam boolean availability){
        //Here we just create a new team object from the parameters passed to our API call and saves it to the database
        TeamMember t = new TeamMember();
        t.setName(name);
        t.setAvailability(availability);
        return teamMemberRepository.saveAndFlush(t);
    }

    @GetMapping(path="/getAll")  // Map ONLY GET Requests to retrieve all the team members
    public @ResponseBody Iterable<TeamMember> getAllTeamMembers(){
        return teamMemberRepository.findAll(); // This returns a JSON or XML with the members
    }

    //Getting a particular team member
    @GetMapping(path="{id}")
    public @ResponseBody TeamMember getTeamMember(@PathVariable long id){
        return teamMemberRepository.getOne(id);
    }

    //Function to add a team Member to a team
    @PostMapping(path="/add/{id}/team")
    public @ResponseBody Object assignTeamMember(@PathVariable long id, @RequestParam Team team){
        TeamMember tm = teamMemberRepository.getOne(id);
        tm.setTeam(team); // Retrieving the list of team members and adding new team member
        return teamMemberRepository.saveAndFlush(tm);
    }

    //This is where we get all the tasks for a particular team member
    @GetMapping(path="/{id}/getTasks")
    public @ResponseBody List<Task> getTasksForMember(@PathVariable long id){
        return taskRepository.findByTeammember(teamMemberRepository.getOne(id));
    }

    //Updating a team member
    @PostMapping(path="/update/{id}")
    public @ResponseBody TeamMember updateMember(@PathVariable long id, @RequestParam boolean availability){
        TeamMember t = teamMemberRepository.getOne(id);
        t.setAvailability(availability);
        return teamMemberRepository.saveAndFlush(t);
    }
}

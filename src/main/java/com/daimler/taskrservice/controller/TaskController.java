package com.daimler.taskrservice.controller;

import com.daimler.taskrservice.model.Task;
import com.daimler.taskrservice.model.Team;
import com.daimler.taskrservice.model.TeamMember;
import com.daimler.taskrservice.repository.TaskRepository;
import com.daimler.taskrservice.repository.TeamMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController //Indicates a controller for our application
@RequestMapping("/api/task")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TeamMemberRepository teamMemberRepository;

    @PostMapping(path="/create")// Map ONLY POST Requests to add a new team member
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    public @ResponseBody Object createTask(@RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String description, @RequestParam boolean status, @RequestParam boolean help){
        //Here we just create a new task object from the parameters passed to our API call and saves it to the database
        Task t = new Task();
        t.setStartDate(startDate);
        t.setEndDate(endDate);
        t.setDescription(description);
        t.setStatus(status);
        t.setHelp(help);
        return taskRepository.saveAndFlush(t);
    }

    //Function to assign a task to a teammeber
    @PostMapping(path="/add/{id}/teammember")
    public @ResponseBody Object assignMember(@PathVariable long id, @RequestParam TeamMember tm){
        Task t = taskRepository.getOne(id);
        t.setTeammember(tm);
        return taskRepository.saveAndFlush(t);
    }

    @GetMapping(path="/getAll")  // Map ONLY GET Requests to retrieve all the asks
    public @ResponseBody Iterable<Task> getAllTasks(){
        return taskRepository.findAll(); // This returns a JSON or XML with the tasks
    }

    //Get method to return a particular task
    @GetMapping(path="{id}")
    public @ResponseBody Task getTask(@PathVariable long id){
        return taskRepository.getOne(id);
    }

    //Updating help for a task
    @PostMapping(path="/updateHelp/{id}")
    public @ResponseBody Task updateHelp(@PathVariable long id, @RequestParam boolean help){
        Task t = taskRepository.getOne(id);
        t.setHelp(help);
        return taskRepository.saveAndFlush(t);
    }

    //Updating status for a task
    @PostMapping(path="/updateStatus/{id}")
    public @ResponseBody Task updateStatus(@PathVariable long id, @RequestParam boolean status){
        Task t = taskRepository.getOne(id);
        t.setStatus(status);
        return taskRepository.saveAndFlush(t);
    }
}

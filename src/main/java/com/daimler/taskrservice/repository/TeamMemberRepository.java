package com.daimler.taskrservice.repository;

import com.daimler.taskrservice.model.Team;
import com.daimler.taskrservice.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* This will be AUTO IMPLEMENTED by Spring into a Bean called taskRepository
This interface, though empty on the surface, packs a punch given it supports CRUD
CRUD refers to Create, Read, Update, Delete
*/
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    public List<TeamMember> findByTeam(Team team);
}

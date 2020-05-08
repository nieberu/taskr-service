package com.daimler.taskrservice.repository;

import com.daimler.taskrservice.model.Task;
import com.daimler.taskrservice.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* This will be AUTO IMPLEMENTED by Spring into a Bean called taskRepository
This interface, though empty on the surface, packs a punch given it supports CRUD
CRUD refers to Create, Read, Update, Delete
*/
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTeammember(TeamMember tm);
}

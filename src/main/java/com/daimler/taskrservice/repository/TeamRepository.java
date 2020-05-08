package com.daimler.taskrservice.repository;

import com.daimler.taskrservice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/* This will be AUTO IMPLEMENTED by Spring into a Bean called taskRepository
This interface, though empty on the surface, packs a punch given it supports CRUD
CRUD refers to Create, Read, Update, Delete
*/
public interface TeamRepository extends JpaRepository<Team, Long> {
}

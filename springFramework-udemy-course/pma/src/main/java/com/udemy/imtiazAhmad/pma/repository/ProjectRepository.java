package com.udemy.imtiazAhmad.pma.repository;

import com.udemy.imtiazAhmad.pma.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

}

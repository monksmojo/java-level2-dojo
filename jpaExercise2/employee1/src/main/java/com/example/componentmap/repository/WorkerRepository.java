package com.example.componentmap.repository;

import com.example.componentmap.entity.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker,Integer> {
}

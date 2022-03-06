package com.example.mapping.many2many;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyRepository extends CrudRepository<Author,Integer> {

}

package com.example.mapping.one2many.unidirectional;

import org.springframework.data.repository.CrudRepository;

public interface UniRepository extends CrudRepository<Author,Integer> {

}

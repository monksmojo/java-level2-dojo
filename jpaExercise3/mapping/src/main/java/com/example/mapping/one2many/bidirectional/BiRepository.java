package com.example.mapping.one2many.bidirectional;

import com.example.mapping.one2many.bidirectional.Author;
import org.springframework.data.repository.CrudRepository;

public interface BiRepository extends CrudRepository<Author,Integer> {
}

package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByName(String name);
}

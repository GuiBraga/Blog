package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Author;
import com.blog.service.AuthorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	@Autowired
	private AuthorService service;
	
	
	@GetMapping("/all")
	public List<Author> allAccess() {
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Author> show(@PathVariable Long id) {
		Author author = service.getAuthor(id);
		if (author != null) {
			return new ResponseEntity<>(author, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}

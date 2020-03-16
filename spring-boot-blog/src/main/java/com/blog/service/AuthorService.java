package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Author;
import com.blog.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public Boolean isEmpty() {
    	return repository.findAll().isEmpty();
    }

    public Author save(Author author) {
      return repository.save(author);
    }

    public String deleteAuthor(Long id) {
        Author author = repository.getOne(id);
        
        repository.delete(author);

        return "Author deleted";
    }

	public List<Author> getAll() {
		return repository.findAll();
	}

	public Author findByName(String name) {
		return repository.findByName(name);
	}

	public Author getAuthor(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Error: Author is not found."));
	}

}

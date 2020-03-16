package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Post;
import com.blog.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;

	public Boolean isEmpty() {
		return repository.findAll().isEmpty();
	}

	public Post save(Post post) {
		post.setUpdated_at(new Date());
		return repository.save(post);
	}

	public String deletePost(Long id) {
		Post post = repository.getOne(id);

		repository.delete(post);

		return "Post deleted";
	}

	public List<Post> getAll() {
		return repository.findAll();
	}

	public Post getPost(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Error: Post is not found."));
	}

}

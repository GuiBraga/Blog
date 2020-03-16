package com.blog.service.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.blog.model.Author;
import com.blog.model.ERole;
import com.blog.model.Post;
import com.blog.model.Role;
import com.blog.model.User;
import com.blog.service.AuthorService;
import com.blog.service.PostService;
import com.blog.service.RoleService;
import com.blog.service.UserService;
import com.github.javafaker.Faker;

@Service
public class DatabaseTableSeeder implements CommandLineRunner {
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PostService postService;
	
	public static Faker faker = new Faker();

	@Override
	public void run(String... args) throws Exception {
		initTables();
	}

	private void initTables() {
		if (roleService.isEmpty()) {
			roleService.save(new Role(ERole.ROLE_ADMIN));
			roleService.save(new Role(ERole.ROLE_MODERATOR));
			roleService.save(new Role(ERole.ROLE_USER));
		}
		
		if (authorService.isEmpty()) {
			authorService.save(new Author("Autor 1", "Esta é uma descrição completa do autor",
					"Está é uma descrição breve do autor"));
			authorService.save(new Author("Autor 2", "Esta é uma descrição completa do autor",
					"Está é uma descrição breve do autor"));
		}

		if (userService.isEmpty()) {
			Set<Role> rolesAdmin = new HashSet<>();
			Role adminRole = roleService.findByName(ERole.ROLE_ADMIN);
			rolesAdmin.add(adminRole);
			userService.create(new User("admin", "admin@email.com", "12345678", rolesAdmin, null));

			Set<Role> rolesMod = new HashSet<>();
			Role modRole = roleService.findByName(ERole.ROLE_MODERATOR);
			rolesMod.add(modRole);
			userService.create(new User("mod", "mod@email.com", "12345678", rolesMod, null));

			Set<Role> rolesUser = new HashSet<>();
			Role userRole = roleService.findByName(ERole.ROLE_USER);
			rolesUser.add(userRole);
			Author author1 = authorService.findByName("Autor 1");
			userService.create(new User("user1", "user1@email.com", "12345678", rolesUser, author1));
			Author author2 = authorService.findByName("Autor 2");
			userService.create(new User("user2", "user2@email.com", "12345678", rolesUser, author2));
		}

		
		if (postService.isEmpty()) {
			Author author1 = authorService.findByName("Autor 1");
			postService.save(new Post("Postagem 1", "Conteúdo da Postagem", author1, faker.internet().image()));
			postService.save(new Post("Postagem 2", "Conteúdo da Postagem", author1, faker.internet().image()));
			postService.save(new Post("Postagem 3", "Conteúdo da Postagem", author1, faker.internet().image()));
			Author author2 = authorService.findByName("Autor 2");
			postService.save(new Post("Postagem 4", "Conteúdo da Postagem", author2, faker.internet().image()));
			postService.save(new Post("Postagem 5", "Conteúdo da Postagem", author2, faker.internet().image()));
			postService.save(new Post("Postagem 6", "Conteúdo da Postagem", author2, faker.internet().image()));
		}
	}
}

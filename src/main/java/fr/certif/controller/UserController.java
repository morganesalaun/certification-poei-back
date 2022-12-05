package fr.certif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.certif.model.User;
import fr.certif.service.UserService;


@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;

	/*
	 * Exemple avec JPA
	 */

	@GetMapping(path = "/read", // path / url
			produces = { "application/json" } // négociation de contenu / par défaut JSON
	)
	public List<User> getUser() {

		return userService.getAll();

	}

	@PostMapping(path = "/post", // path / url
			consumes = { "application/json" } // négociation de contenu / par défaut JSON
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void getTodosJpa(@RequestBody User user) {

		userService.saveUser(user);

	}

	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deletUser(@PathVariable ("id") Long id) {

		userService.deleteUser(id);
		System.out.println("todolist effacé");

	}
}

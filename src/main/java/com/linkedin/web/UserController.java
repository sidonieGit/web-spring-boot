package com.linkedin.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.data.User;
import com.linkedin.service.UserService;

@RestController // ce contrôleur est un contrôleur rest
@RequestMapping("/") // il intercepte toutes les requêtes http de l'application
public class UserController {

	private final UserService userService;

	// dans le constructeur on injecte le service utilisé pour récupérer les données
	public UserController(UserService personService) {
		this.userService = personService;
	}

	// qui va intercepter toutes les requêtes http de type GET qui seront destinées
	// à la classe users
	@GetMapping("users") //
	public List<User> getUsers() {

		return userService.getAllUsers();

	}

}

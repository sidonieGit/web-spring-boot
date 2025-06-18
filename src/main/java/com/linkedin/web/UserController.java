package com.linkedin.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linkedin.data.User;
import com.linkedin.service.UserService;

@Controller
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
	public String getUsers(Model model) {

		List<User> users = userService.getAllUsers();
		// on passe users au model
		model.addAttribute("users", users);
		// on retourne la vue utilisée pour afficher les données representée par une
		// page html qui s'appelle vue
		return "UserView";
	}

}

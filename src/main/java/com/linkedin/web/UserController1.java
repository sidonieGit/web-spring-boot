package com.linkedin.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linkedin.data.User;
import com.linkedin.service.UserService;

@Controller
@RequestMapping("/") // pour intercepter les requêtes http qui se font sur le site
public class UserController1 {

	UserService service;

	public UserController1(UserService service) {
		this.service = service;
	}

	@GetMapping("users") // reliée cette méthode à l'url /users
	public String getUsers(Model model) {// model pour faire une correspondance avec le template
		List<User> users = service.findAllUsers();
		model.addAttribute("users", users);
		return "UserView";// retourne le template
	}

	// public void addUser(User user) {
	// repository.save(user);
	// }

	// public void deleteUser(User user) {

}

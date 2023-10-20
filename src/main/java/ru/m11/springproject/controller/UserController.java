package ru.m11.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.m11.springproject.models.User;
import ru.m11.springproject.services.UsersService;


@Controller
@RequestMapping("/users") // users - это начальная страница
public class UserController {
	@Autowired
	private UsersService usersService;

	@GetMapping()
	public String showListOfUsers(Model model) {
		model.addAttribute("users", usersService.showListOfUsers());
		return "/users";
	}

	@GetMapping("/new")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "/new";
	}

	@PostMapping()
	public String createdUser(@ModelAttribute("user") User user) {
		usersService.saveUser(user);
		return "redirect:/users";
	}

	@PostMapping ("/delete")
	public String deleteUser(@RequestParam("id") long id) {
		usersService.deleteUser(id);
		return "redirect:/users";
	}

	@GetMapping("/edit")
	public String updateUser(@RequestParam("id") long id, Model model) {
		model.addAttribute("user", usersService.findUserById(id));
		return "/edit";
	}

	@PostMapping ("/edit")
	public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") long id) {
		usersService.updateUser(id, user);
		return "redirect:/users";
	}
}
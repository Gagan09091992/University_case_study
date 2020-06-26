package com.ibm.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.university.entity.User;
import com.ibm.university.service.UserServiceImplemtation;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImplemtation userService ;

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/user")
	public User addUser(@RequestBody User user) throws Exception {
		return this.userService.saveUser(user);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/getalluser")
	public List<User> getAllUsers() {
		return this.userService.getAll();
	}

	@GetMapping("/getuserdetail")
	public User getUserDetails(@RequestHeader("username") String username) {
		return this.userService.getUserDetails(username);
	}

}

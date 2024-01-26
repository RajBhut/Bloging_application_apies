package com.rajbhut.blog.controllers;


import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajbhut.blog.paylod.UserDto;
import com.rajbhut.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/")
	public ResponseEntity <UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public java.util.List<UserDto> getusers()
	{
		java.util.List<UserDto> list = userService.getAllUser();
		return list;
	}

}

package com.rajbhut.blog.controllers;


import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajbhut.blog.paylod.ApiResponse;
import com.rajbhut.blog.paylod.UserDto;
import com.rajbhut.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/")
	public ResponseEntity <UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<java.util.List<UserDto>> getallusers()
	{
	return	ResponseEntity.ok(this.userService.getAllUser());
		
		
	}
	@GetMapping( "/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
		
	}
	@PutMapping("/{UserId}")
	public ResponseEntity<UserDto> UpdateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer UserId)
	{
		UserDto  updateduserdto = this.userService.updateUser(userDto, UserId);
		return ResponseEntity.ok(updateduserdto);
	}
	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponse> deleteUSer(@PathVariable Integer userid)
	{
		this.userService.deleteUser(userid);
		return new ResponseEntity(new ApiResponse("User Deleted succesfully!",true),HttpStatus.OK);
	}

}

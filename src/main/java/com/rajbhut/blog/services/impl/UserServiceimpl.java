package com.rajbhut.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajbhut.blog.entities.User;
import com.rajbhut.blog.paylod.UserDto;
import com.rajbhut.blog.reposetories.UserRepo;
import com.rajbhut.blog.services.UserService;
import com.rajbhut.blog.exaptions.*;

@Service
public class UserServiceimpl implements UserService {
@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtotoUser(userDto);
		User saveduser = this.userRepo.save(user);
		return this.usertoDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResorceNotFoundExaption("User"," id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.usertoDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResorceNotFoundExaption("User", "id", userId));
		return usertoDto(user);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos =users.stream().map(user->this.usertoDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
	User user =this.userRepo.findById(userId).orElseThrow(()-> new ResorceNotFoundExaption("User", "id", userId));
	
this.userRepo.delete(user);	
	}

	public User dtotoUser(UserDto userDto) {
		User user = new User();
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setId(userDto.getId());
		user.setPassword(userDto.getPassword());
		return user;

	}

	public UserDto usertoDto(User user) {
		UserDto userdto = new UserDto();
		userdto.setPassword(user.getPassword());
		userdto.setName(user.getName());
		userdto.setAbout(user.getAbout());
		userdto.setId(user.getId());
		userdto.setEmail(user.getEmail());
		return userdto;
	}

}

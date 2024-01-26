package com.rajbhut.blog.services;

import java.util.List;

import com.rajbhut.blog.paylod.UserDto;

public interface UserService {
public	UserDto createUser(UserDto user);
public	UserDto updateUser(UserDto user,Integer userId);
public	UserDto getUserById(Integer userId);
public	List<UserDto> getAllUser();
public	void deleteUser(Integer userId);

}

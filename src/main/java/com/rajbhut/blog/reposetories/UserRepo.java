package com.rajbhut.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajbhut.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}

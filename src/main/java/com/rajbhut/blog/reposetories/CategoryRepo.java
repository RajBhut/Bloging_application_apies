package com.rajbhut.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajbhut.blog.entities.Catagory;

public interface CategoryRepo extends JpaRepository<Catagory, Integer> {
	
	

}

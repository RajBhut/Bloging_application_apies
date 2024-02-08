package com.rajbhut.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rajbhut.blog.paylod.CatagoryDto;


public interface CatagoryService {

	public CatagoryDto Createcatagory(CatagoryDto catagoryDto);
	CatagoryDto UpdateCatagory(CatagoryDto catagoryDto  ,Integer catagoryId);
	public void deletCatagory(Integer catagoryId);
	public CatagoryDto getCatagory(Integer catagoryId);
	public List<CatagoryDto> getCatagories();
	
}

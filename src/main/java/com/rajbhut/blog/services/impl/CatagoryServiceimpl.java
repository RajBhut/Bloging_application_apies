package com.rajbhut.blog.services.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajbhut.blog.entities.Catagory;
import com.rajbhut.blog.entities.User;
import com.rajbhut.blog.exaptions.ResorceNotFoundExaption;
import com.rajbhut.blog.paylod.CatagoryDto;
import com.rajbhut.blog.reposetories.CategoryRepo;
import com.rajbhut.blog.services.CatagoryService;
@Service
public class CatagoryServiceimpl implements CatagoryService{

	@Autowired
	private CategoryRepo categortRepo;
	@Autowired
	private ModelMapper modelmapper;
	
	
	@Override
	public CatagoryDto Createcatagory(CatagoryDto catagoryDto) {
	Catagory cat = 	this.modelmapper.map(catagoryDto, Catagory.class);
	   Catagory addedCat = this.categortRepo.save(cat);
		return this.modelmapper.map(addedCat, CatagoryDto.class);
		
	}

	@Override
	public CatagoryDto UpdateCatagory(CatagoryDto catagoryDto, Integer catagoryId) {
		
		Catagory catagory = this.categortRepo.findById(catagoryId).orElseThrow(()->new ResorceNotFoundExaption("catagory", "id", catagoryId));
		
		catagory.setCatagoryDiscryption(catagoryDto.getCatagoryDiscryption());
		catagory.setCatagoryTitle(catagoryDto.getCatagoryTitle());
		
		return modelmapper.map(catagory, CatagoryDto.class);
		}
		
		
		
		
	

	@Override
	public void deletCatagory(Integer catagoryId) {
	Catagory catagory = this.categortRepo.findById(catagoryId).orElseThrow(()->new ResorceNotFoundExaption("catagory", "id", catagoryId));
		this.categortRepo.delete(catagory);
	}

	@Override
	public CatagoryDto getCatagory(Integer catagoryId) {
		
		return modelmapper.map(this.categortRepo.findById(catagoryId).orElseThrow(()->new ResorceNotFoundExaption("catagory", "id", catagoryId)), CatagoryDto.class);
	}

	@Override
	public List<CatagoryDto> getCatagories() {
		
		return this.categortRepo.findAll().stream().map((cat)->modelmapper.map(cat, CatagoryDto.class)).collect(Collectors.toList());
	}

	
}

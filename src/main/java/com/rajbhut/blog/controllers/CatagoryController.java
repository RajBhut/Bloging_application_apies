package com.rajbhut.blog.controllers;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
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
import com.rajbhut.blog.paylod.CatagoryDto;
import com.rajbhut.blog.reposetories.CategoryRepo;
import com.rajbhut.blog.services.CatagoryService;

@RestController
@RequestMapping("/api/categories")
public class CatagoryController {
	@Autowired
	private CatagoryService catagoryservice;

	@PostMapping("/")
	public ResponseEntity<CatagoryDto> creatCatagory(@RequestBody CatagoryDto catagorydto) {
		return new ResponseEntity<CatagoryDto>(this.catagoryservice.Createcatagory(catagorydto), HttpStatus.CREATED);

	}

	@GetMapping("/{catagoryId}")
	public ResponseEntity<CatagoryDto> getCatagory(@PathVariable Integer catagoryId) {
		return new ResponseEntity<CatagoryDto>(this.catagoryservice.getCatagory(catagoryId), HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<CatagoryDto>> getallCatagories() {
		return ResponseEntity.ok(this.catagoryservice.getCatagories());
	}

	@PutMapping("/{catagoryId}")
	public ResponseEntity<CatagoryDto> updateCatagory(@RequestBody CatagoryDto catagorydto,
			@PathVariable Integer catagoryId) {
		return ResponseEntity.ok(this.catagoryservice.UpdateCatagory(catagorydto, catagoryId));
	}

	@DeleteMapping("/{catagoryId}")
	public ResponseEntity<ApiResponse> deleteCatagory(@PathVariable Integer catagoryId) {
		this.catagoryservice.deletCatagory(catagoryId);
		return ResponseEntity.ok(new ApiResponse("Catagory Deleted Successfully!!", true));
	}

}

package com.rajbhut.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Catagory
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catagoryId;
	@Column(name = "title",length =100 )
	private String CatagoryTitle;
	@Column(name = "dicryption")
	private String  CatagoryDiscryption;
	
}
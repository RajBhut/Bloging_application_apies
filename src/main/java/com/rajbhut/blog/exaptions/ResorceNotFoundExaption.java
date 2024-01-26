package com.rajbhut.blog.exaptions;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ResorceNotFoundExaption extends RuntimeException {
String resorcename;
String fieldname;
long fieldValue;
public ResorceNotFoundExaption(String resorcename, String fieldname, long fieldValue) {
	super(String.format("%s not found with %s : %l",resorcename,fieldname,fieldValue));
	this.resorcename = resorcename;
	this.fieldname = fieldname;
	this.fieldValue = fieldValue;
}
}

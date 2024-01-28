package com.rajbhut.blog.exaptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rajbhut.blog.paylod.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResorceNotFoundExaption.class)
	public ResponseEntity<ApiResponse> resorceNotFoundExceptionHandler(ResorceNotFoundExaption ex)
	{
		String message = ex.getMessage();
		ApiResponse apiresponce = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiresponce,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodNotValidExaption(MethodArgumentNotValidException ex)
	{
Map<String , String>	resp = new HashMap<String, String>();
ex.getBindingResult().getAllErrors().forEach((error)->{
	String fieldname = ((FieldError)(error)).getField();
	String message = error.getDefaultMessage();
	resp.put(fieldname, message);
	});


return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
}
}

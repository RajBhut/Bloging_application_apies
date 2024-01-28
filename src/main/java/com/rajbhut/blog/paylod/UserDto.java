package com.rajbhut.blog.paylod;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
private int id;
@NotEmpty
@Size(min = 4,message = "USername must be min of 4 charactesr !!")
private String name;
@Email
@NotEmpty
private String email;
@NotNull
@Size(min = 3 , max = 10 , message = "Password must be min of 3 chars and max of 10 chars !!")
private String password;
@NotNull
private String about;
}

package com.example.webservciesfinalproject.auth;

import com.example.webservciesfinalproject.user.Role;
import com.example.webservciesfinalproject.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private LocalDate bornAt;
}

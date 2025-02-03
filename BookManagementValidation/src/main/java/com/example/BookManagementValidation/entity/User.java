package com.example.BookManagementValidation.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "User Name must not be empty")
   private String userName;
    @Size(min = 6 , message =  "Password must be at least 6 characters")
    @NotBlank(message = "Password must not be empty")
    private String password;
    @NotBlank(message = "Email must not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "This Email Is Invalid")
   private String email;
    @Pattern(regexp = "^[0-9]{11}" , message = "Phone number must be 11 digits")
   private String phone;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

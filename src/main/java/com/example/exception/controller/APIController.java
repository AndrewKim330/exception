package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api")
@Validated
public class APIController {

    @GetMapping("/user")
    public User get(@Size(min=2) @RequestParam String name, @NotNull @RequestParam @Min(1) Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;

        return user;
    }

    @PostMapping("/user")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }
}

package org.example.controllers;

import org.example.dtos.UserRequestDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getList() {
        return new ResponseEntity<>(userService.getList(), HttpStatus.OK);
    }

    @GetMapping("/user_no_password")
    public ResponseEntity<?> getListWithoutPassword() {
        return new ResponseEntity<>(userService.getListWithoutPassword(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> add(@RequestBody() @Valid UserRequestDto user) {
        return new ResponseEntity<>(userService.add(user), HttpStatus.OK);
    }
}

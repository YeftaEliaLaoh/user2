package org.example.services;

import org.example.dtos.UserDto;
import org.example.dtos.UserRequestDto;
import org.example.entity.Users;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<Users> getList() {
        return userRepository.findAll();
    }

    public List<UserDto> getListWithoutPassword() {
        return userRepository.findWithoutPassword();
    }

    public Object add(UserRequestDto user) {
        return userRepository.save(
                Users.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build());

    }
}

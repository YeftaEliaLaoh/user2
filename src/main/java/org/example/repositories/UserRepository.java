package org.example.repositories;

import org.example.dtos.UserDto;
import org.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "select new org.example.dtos.UserDto(id,username) from Users")
    List<UserDto> findWithoutPassword();
}

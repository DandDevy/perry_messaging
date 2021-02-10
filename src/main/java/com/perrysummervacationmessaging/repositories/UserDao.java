package com.perrysummervacationmessaging.repositories;

import com.perrysummervacationmessaging.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}

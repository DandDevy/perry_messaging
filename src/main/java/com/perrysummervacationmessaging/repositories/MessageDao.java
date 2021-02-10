package com.perrysummervacationmessaging.repositories;

import com.perrysummervacationmessaging.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message, Integer> {
}

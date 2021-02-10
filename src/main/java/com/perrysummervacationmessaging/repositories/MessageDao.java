package com.perrysummervacationmessaging.repositories;

import com.perrysummervacationmessaging.entities.Message;
import com.perrysummervacationmessaging.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageDao extends JpaRepository<Message, UUID> {
    List<Message> findAllByOriginAndDestination(@NotNull User origin, @NotNull User destination);

}

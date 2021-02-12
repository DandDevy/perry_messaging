package com.perrysummervacationmessaging.repositories;

import com.perrysummervacationmessaging.entities.Message;
import com.perrysummervacationmessaging.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MessageDaoTest {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void findAllByOriginAndDestination() {
        User u = new User();
        userDao.save(u);
        User u2 = new User();
        userDao.save(u2);
        Message m = new Message("wasd", u, u2);
        messageDao.save(m);

        List<Message> allByOriginAndDestination = messageDao.findAllByOriginAndDestination(u, u2);
        System.out.println("Test Message =>" + allByOriginAndDestination);
        assertNotNull(allByOriginAndDestination);
    }
}

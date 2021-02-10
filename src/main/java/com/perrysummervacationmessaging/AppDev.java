package com.perrysummervacationmessaging;

import com.perrysummervacationmessaging.entities.Message;
import com.perrysummervacationmessaging.entities.User;
import com.perrysummervacationmessaging.repositories.MessageDao;
import com.perrysummervacationmessaging.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class AppDev implements CommandLineRunner {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        userDao.save(u);
        User u2 = new User();
        userDao.save(u2);
        Message m = new Message("wasd", u, u2);
        messageDao.save(m);

    }
}

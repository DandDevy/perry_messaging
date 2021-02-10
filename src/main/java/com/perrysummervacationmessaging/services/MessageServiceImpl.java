package com.perrysummervacationmessaging.services;

import com.perrysummervacationmessaging.entities.Message;
import com.perrysummervacationmessaging.entities.User;
import com.perrysummervacationmessaging.repositories.MessageDao;
import com.perrysummervacationmessaging.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDao messageDao;

    /**
     * create a new message.
     * @param text
     * @param senderId
     * @param receiverId
     * @return Message
     */
    @Override
    public Message create(String text, UUID senderId, UUID receiverId) {
        Message message = new Message(text, new User(senderId), new User(receiverId));
        return messageDao.save(message);
    }

    /**
     * change text of a message.
     * @param messageId
     * @param newText
     * @return Message
     */
    @Override
    public Message editTextByMessageId(UUID messageId, String newText) {
        Message one = messageDao.getOne(messageId);
        one.setText(newText);
        return messageDao.save(one);
    }

    /**
     * remove message.
     * @param messageId
     * @return isDeleted
     */
    @Override
    public boolean deleteByMessageId(UUID messageId) {
        messageDao.deleteById(messageId);
        Optional<Message> optionalMessage = messageDao.findById(messageId);
        if (optionalMessage.isPresent()) {
            return false;
        }
        return true;
    }

    /**
     * get messages shared between 2 users by their ids.
     * @param senderId
     * @param receiverId
     * @return List<Message>
     */
    @Override
    public List<Message> getMessageByOriginIdAndDestinationId(UUID senderId, UUID receiverId) {
        return messageDao.findAllByOriginAndDestination(new User(senderId), new User(receiverId));
    }
}

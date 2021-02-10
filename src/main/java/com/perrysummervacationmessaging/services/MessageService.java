package com.perrysummervacationmessaging.services;

import com.perrysummervacationmessaging.entities.Message;
import com.perrysummervacationmessaging.repositories.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface MessageService {
    /**
     * create a new message.
     * @param text
     * @param senderId
     * @param receiverId
     * @return Message
     */
    public Message create(String text, UUID senderId, UUID receiverId);

    /**
     * change text of a message.
     * @param messageId
     * @param newText
     * @return Message
     */
    public Message editTextByMessageId(UUID messageId, String newText);

    /**
     * remove message.
     * @param messageId
     * @return isDeleted
     */
    public boolean deleteByMessageId(UUID messageId);

    /**
     * get messages shared between 2 users by their ids.
     * @param senderId
     * @param receiverId
     * @return List<Message>
     */
    public List<Message> getMessageByOriginIdAndDestinationId(UUID senderId, UUID receiverId);
}

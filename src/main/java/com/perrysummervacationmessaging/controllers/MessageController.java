package com.perrysummervacationmessaging.controllers;

import com.perrysummervacationmessaging.entities.Message;
import com.perrysummervacationmessaging.entities.User;
import com.perrysummervacationmessaging.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


/**
 * MessageController is the controller for all message endpoints.
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * create makes a new Message and returns it with 201 or returns only 409.
     * Expects a text string and userIds for origin and destination users.
     */
    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message newMessage){
        Message message = messageService.create(
                newMessage.getText(), newMessage.getOrigin().getUserId(), newMessage.getDestination().getUserId()
        );
        if (message == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    /**
     * findall finds all users and returns them with 200 or returns only 404.
     */
    @GetMapping
    public ResponseEntity<List<Message>> findAllByOriginAndDestination(@RequestBody Message getMessage){
        List<Message> messages = messageService.getMessageByOriginIdAndDestinationId(
                getMessage.getOrigin().getUserId(), getMessage.getDestination().getUserId()
        );
        if (messages == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    /**
     * edit will change the text of a message and return it with a 201 or return only a 404.
     */
    @PutMapping
    public ResponseEntity<Message> edit(@RequestBody Message messageEdit){
        Message message = messageService.editTextByMessageId(
                messageEdit.getMessageId(), messageEdit.getText()
        );
        if (message == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    /**
     * delete will delete a message and return a 201 or return  a 204.
     */
    @DeleteMapping("/{messageId}")
    public ResponseEntity<Message> delete(@PathVariable(name = "messageId") String messageIdString){
        UUID messageId = UUID.fromString(messageIdString);
        boolean isDeleted = messageService.deleteByMessageId(messageId);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

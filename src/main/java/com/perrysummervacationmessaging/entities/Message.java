package com.perrysummervacationmessaging.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Message represents a message of the messaging system.
 * All Messages have a unique id and its text must be between 1 and 256.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @JsonIgnore
    public static final int MAX_MESSAGE_SIZE = 256;
    @JsonIgnore
    public static final int MIN_MESSAGE_SIZE = 1;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID messageId;

    @Size(min = MIN_MESSAGE_SIZE, max = MAX_MESSAGE_SIZE)
    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "origin_user_id", nullable = false)
    private User origin;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "destination_user_id", nullable = false)
    private User destination;


    public Message(@Size(min = MIN_MESSAGE_SIZE, max = MAX_MESSAGE_SIZE) String text, User originUser, User destinationUser) {
        this.text = text;
        this.origin = originUser;
        this.destination = destinationUser;
    }


}

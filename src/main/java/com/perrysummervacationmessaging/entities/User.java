package com.perrysummervacationmessaging.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User is an entity representing a user of the messaging system.
 * All Users have a unique id.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID userId;

    @JsonIgnore
    @OneToMany(mappedBy = "origin", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Message> messagesReceived = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Message> messagesSend = new ArrayList<>();
}

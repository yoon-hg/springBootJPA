package com.example.jpasetting.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String userType;

    @CreationTimestamp
    private LocalDateTime created;

    @Builder
    public User (String username, String password, String userType){
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
}

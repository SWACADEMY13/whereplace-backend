package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    private String userId;    // NOT NULL

    @Column(name = "password", nullable = false, length = 20)
    private String password;        // NOT NULL

    @Column(name = "name", nullable = false, length = 20)
    private String name;            // NOT NULL

    @Column(name = "phone", length = 11)
    private String phone;           // NULLABLE

    @Column(name = "email", nullable = false, length = 30)
    private String email;     // NOT NULL

    @OneToMany(mappedBy = "commented_user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "posted_user")
    private List<Comment> posts = new ArrayList<>();

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

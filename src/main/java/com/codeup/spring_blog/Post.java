package com.codeup.spring_blog;

import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Stack;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

    //table creation
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long id;

        @Column(nullable = false, length = 100)
        public String title;

        @Column(nullable = false, length = 2000)
        public String body;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;


    //empty constructor
        public Post() {

    }

    public Post(long id, String title, String body, User user) {
            this.id = id;
            this.title = title;
            this.body = body;
            this.user = user;
    }

    public Post(String title, String body, User user){
            this.title = title;
            this.body = body;
            this.user = user;

    }

    public int search(String keyword){
        Stack<Object> repo = null;
        return repo.search(keyword);
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

package models;

import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {


        //table creation
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long id;

        @Column(nullable = false, length = 100)
        public String title;

        @Column(nullable = false)
        public String body;



        //empty constructor
        public Post() {

    }

    public Post(String title, String body) {
            this.title = title;
            this.body = body;
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
}

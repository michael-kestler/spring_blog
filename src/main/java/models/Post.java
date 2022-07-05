package models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long id;

        @Column(nullable = false)
        public String title;

        @Column(nullable = false)
        public String body;




//    private String title;
//    private String body;

    //constructors

        public Post() {

        }

        //getters and setters

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

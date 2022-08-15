package com.codeup.spring_blog;

import com.codeup.spring_blog.Post;
import com.codeup.spring_blog.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

        Post getById(long id);


        List<Post> getByUser(User user);

    @Query(value = "SELECT * FROM spring_blog_db.posts WHERE "
    + "MATCH(title, body) "
    + "AGAINST (?1)",
     nativeQuery = true)
    List<Post> search(String keyword);
}

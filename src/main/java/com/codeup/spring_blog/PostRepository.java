package com.codeup.spring_blog;

import com.codeup.spring_blog.Post;
import com.codeup.spring_blog.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

        Post getById(long id);


        List<Post> getByUser(User user);

    @Query("SELECT post FROM Post post WHERE post.title like %:query% or post.body like %:query%")
    List<Post> search(String query);


}

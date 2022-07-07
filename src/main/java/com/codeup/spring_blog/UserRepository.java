package com.codeup.spring_blog;

import com.codeup.spring_blog.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
    extends JpaRepository<User, Long> {
    User getUserById(long id);
    User findByUsername(String username);
}


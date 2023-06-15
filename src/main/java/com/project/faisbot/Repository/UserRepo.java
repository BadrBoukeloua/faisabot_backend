package com.project.faisbot.Repository;

import com.project.faisbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepositoryImplementation<User,Integer> {
    public User findByEmailAndPassword(String email , String password);

    
}

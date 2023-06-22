package com.project.faisabot.Repository;

import com.project.faisabot.model.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
//    @Query("{email:'?0'},{password:'?1'}")
    public User findByEmailAndPassword(String email , String password);

    
}

package com.project.faisabot.Repository;

import com.project.faisabot.model.Forum;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ForumRepo extends MongoRepository<Forum, ObjectId> {

    @Query("{ 'forum_user._id' : ?0 }")
    public List<Forum> findByuserId(ObjectId id);
}

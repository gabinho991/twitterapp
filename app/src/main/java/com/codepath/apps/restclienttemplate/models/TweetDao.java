package com.codepath.apps.restclienttemplate.models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TweetDao {
    @Query("SELECT Tweet.body AS tweet_body, Tweet.createdAT AS tweet_createdAT, Tweet.id AS tweet_id, User.* "+
            "FROM Tweet INNER JOIN User ON Tweet.userId=User.id ORDER BY Tweet.createdAT DESC LIMIT 5")
    List<TweetWithUser> recentItems();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(Tweet... tweets);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(User... users);
}


package com.example.project3.repository;

import com.example.project3.Entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {
    Page<Post> findByPostIdLessThanOrderByCreatedAtDesc(Long lastPostId, Pageable pageable);

    List<Post> findByMemberIdOrderByCreatedAtDesc(Long memberId);
    Page<Post> findByPostHashtags_Hashtag_HashtagNameAndPostIdLessThanOrderByCreatedAtDesc(
            String hashtagName, Long lastPostId, Pageable pageable);
//  @Query("SELECT p FROM Post p JOIN p.postHashtags ph WHERE ph.hashtag.hashtagName = :hashtagName AND p.postId < :lastPostId ORDER BY p.createdAt DESC")
//  Page<Post> findByHashtagAndPostIdLessThanOrderByCreatedAtDesc(
//      @Param("hashtagName") String hashtagName, @Param("lastPostId") Long lastPostId, Pageable pageable);
}


package com.codereview.assistant.respository;

import com.codereview.assistant.model.CodeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CodeReviewRepository extends JpaRepository<CodeReview, Long> {
    List<CodeReview> findByStatusOrderBySubmittedAtDesc(String status);
}


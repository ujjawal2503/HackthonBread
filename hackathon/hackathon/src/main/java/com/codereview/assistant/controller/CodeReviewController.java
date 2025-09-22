package com.codereview.assistant.controller;

import com.codereview.assistant.model.CodeReview;
import com.codereview.assistant.service.CodeReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/reviews")
//@CrossOrigin(origins = "http://localhost:3000")
public class CodeReviewController {

    @Autowired
    private CodeReviewService codeReviewService;

    @PostMapping
    public ResponseEntity<CodeReview> submitCode(
            @RequestParam String fileName,
            @RequestParam String language,
            @RequestBody String code) {
        CodeReview review = codeReviewService.submitCode(fileName, language, code);
        return ResponseEntity.ok(review);
    }

    @GetMapping
    public ResponseEntity<List<CodeReview>> getAllReviews() {
        List<CodeReview> reviews = codeReviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodeReview> getReviewById(@PathVariable Long id) {
        Optional<CodeReview> review = codeReviewService.getReviewById(id);
        return review.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<CodeReview>> getPendingReviews() {
        List<CodeReview> reviews = codeReviewService.getPendingReviews();
        return ResponseEntity.ok(reviews);
    }
}

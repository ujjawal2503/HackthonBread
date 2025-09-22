package com.codereview.assistant.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "code_reviews")
public class CodeReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String language;
    private String code;
    private String status; // PENDING, PROCESSING, COMPLETED
    private int issuesCount;
    private int suggestionsCount;
    private double rating;
    private LocalDateTime submittedAt;
    private LocalDateTime completedAt;

    @OneToMany(mappedBy = "codeReview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feedback> feedback;

    // Constructors
    public CodeReview() {}

    public CodeReview(String fileName, String language, String code) {
        this.fileName = fileName;
        this.language = language;
        this.code = code;
        this.status = "PENDING";
        this.submittedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getIssuesCount() { return issuesCount; }
    public void setIssuesCount(int issuesCount) { this.issuesCount = issuesCount; }

    public int getSuggestionsCount() { return suggestionsCount; }
    public void setSuggestionsCount(int suggestionsCount) { this.suggestionsCount = suggestionsCount; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    public List<Feedback> getFeedback() { return feedback; }
    public void setFeedback(List<Feedback> feedback) { this.feedback = feedback; }
}

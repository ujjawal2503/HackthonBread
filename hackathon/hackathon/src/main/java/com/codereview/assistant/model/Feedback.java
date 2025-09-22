package com.codereview.assistant.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // SECURITY, PERFORMANCE, BEST_PRACTICE
    private String message;
    private int line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_review_id")
    @JsonIgnore
    private CodeReview codeReview;

    // Constructors
    public Feedback() {}

    public Feedback(String type, String message, int line) {
        this.type = type;
        this.message = message;
        this.line = line;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getLine() { return line; }
    public void setLine(int line) { this.line = line; }

    public CodeReview getCodeReview() { return codeReview; }
    public void setCodeReview(CodeReview codeReview) { this.codeReview = codeReview; }
}


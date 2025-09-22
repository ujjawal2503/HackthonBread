package com.codereview.assistant.service;

import com.codereview.assistant.model.CodeReview;
import com.codereview.assistant.model.Feedback;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class AIAnalysisService {

    public void analyzeCode(CodeReview codeReview) {
        // Simulate AI analysis delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Generate mock feedback based on code content
        List<Feedback> feedbackList = new ArrayList<>();
        Random random = new Random();

        // Security issues
        if (codeReview.getCode().contains("get()") || codeReview.getCode().contains(".get(")) {
            feedbackList.add(new Feedback("SECURITY", "Potential NullPointerException", 3));
        }

        if (codeReview.getCode().contains("find(") && !codeReview.getCode().contains("validate")) {
            feedbackList.add(new Feedback("SECURITY", "Missing input validation", 1));
        }

        // Performance issues
        if (codeReview.getCode().contains("for(") && codeReview.getCode().contains("for(")) {
            feedbackList.add(new Feedback("PERFORMANCE", "Nested loops may cause performance issues", 5));
        }

        // Best practices
        if (codeReview.getCode().contains("public static void main")) {
            feedbackList.add(new Feedback("BEST_PRACTICE", "Consider separating business logic from main method", 2));
        }

        // Set feedback to code review
        codeReview.setFeedback(feedbackList);
        codeReview.setIssuesCount(feedbackList.size());
        codeReview.setSuggestionsCount(feedbackList.size() + random.nextInt(3));
//        codeReview.setRating(5.0 - (feedbackList.size() * 0.5));
        codeReview.setStatus("COMPLETED");
    }
}


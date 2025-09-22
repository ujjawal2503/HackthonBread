package com.codereview.assistant.service;

import com.codereview.assistant.model.CodeReview;
import com.codereview.assistant.respository.CodeReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CodeReviewService {

    @Autowired
    private CodeReviewRepository codeReviewRepository;

    @Autowired
    private AIAnalysisService aiAnalysisService;

    public CodeReview submitCode(String fileName, String language, String code) {
        CodeReview codeReview = new CodeReview(fileName, language, code);
//        codeReview = codeReviewRepository.save(codeReview);

//         Process in background
//        CodeReview finalCodeReview = codeReview;
        new Thread(() -> {
            aiAnalysisService.analyzeCode(codeReview);
            codeReviewRepository.save(codeReview);
        }).start();


        return codeReview;
    }

    public List<CodeReview> getAllReviews() {
        return codeReviewRepository.findAll();
    }

    public Optional<CodeReview> getReviewById(Long id) {
        return codeReviewRepository.findById(id);
    }

    public List<CodeReview> getPendingReviews() {
        return codeReviewRepository.findByStatusOrderBySubmittedAtDesc("PENDING");
    }
}


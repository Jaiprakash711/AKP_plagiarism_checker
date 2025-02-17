package com.AKP.plagiarism.plagiarism_checker.DataModel.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PlagiarismCheckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String service;
    private String scanTime;
    private String inputType;
    private double score;
    private int sourceCounts;
    private int textWordCounts;
    private int totalPlagiarismWords;
    private int identicalWordCounts;
    private int similarWordCounts;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getSourceCounts() {
        return sourceCounts;
    }

    public void setSourceCounts(int sourceCounts) {
        this.sourceCounts = sourceCounts;
    }

    public int getTextWordCounts() {
        return textWordCounts;
    }

    public void setTextWordCounts(int textWordCounts) {
        this.textWordCounts = textWordCounts;
    }

    public int getTotalPlagiarismWords() {
        return totalPlagiarismWords;
    }

    public void setTotalPlagiarismWords(int totalPlagiarismWords) {
        this.totalPlagiarismWords = totalPlagiarismWords;
    }

    public int getIdenticalWordCounts() {
        return identicalWordCounts;
    }

    public void setIdenticalWordCounts(int identicalWordCounts) {
        this.identicalWordCounts = identicalWordCounts;
    }

    public int getSimilarWordCounts() {
        return similarWordCounts;
    }

    public void setSimilarWordCounts(int similarWordCounts) {
        this.similarWordCounts = similarWordCounts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UploadTextEntity getUploadText() {
        return uploadText;
    }

    public void setUploadText(UploadTextEntity uploadText) {
        this.uploadText = uploadText;
    }

    @ManyToOne
    @JoinColumn(name = "upload_text_id", nullable = false)
    private UploadTextEntity uploadText;
}

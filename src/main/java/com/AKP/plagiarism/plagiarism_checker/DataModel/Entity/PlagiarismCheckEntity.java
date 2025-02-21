package com.AKP.plagiarism.plagiarism_checker.DataModel.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "plagiarism_check")
public class PlagiarismCheckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plagiarism_check_seq")
    @SequenceGenerator(name = "plagiarism_check_seq", sequenceName = "plagiarism_check_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String service;

    @Column(nullable = false)
    private String scanTime;

    @Column(nullable = false)
    private String inputType;

    @Column(nullable = false)
    private double score;

    @Column(nullable = false)
    private int sourceCounts;

    @Column(nullable = false)
    private int textWordCounts;

    @Column(nullable = false)
    private int totalPlagiarismWords;

    @Column(nullable = false)
    private int identicalWordCounts;

    @Column(nullable = false)
    private int similarWordCounts;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


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


}

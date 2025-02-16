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

    private int score;
    private int sourceCounts;
    private int textWordCounts;
    private int totalPlagiarismWords;
    private int identicalWordCounts;
    private int similarWordCounts;

    private LocalDateTime scanTime = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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

    public LocalDateTime getScanTime() {
        return scanTime;
    }

    public void setScanTime(LocalDateTime scanTime) {
        this.scanTime = scanTime;
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

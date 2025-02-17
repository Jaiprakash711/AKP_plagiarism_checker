package com.AKP.plagiarism.plagiarism_checker.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlagiarismCheckResponseDTO {
    private String service;
    private String scanTime;
    private String inputType;
    private double score;
    private int sourceCounts;

    public PlagiarismCheckResponseDTO(String service, String scanTime, String inputType, double score, int sourceCounts, int textWordCounts, int totalPlagiarismWords, int identicalWordCounts, int similarWordCounts) {
        this.service = service;
        this.scanTime = scanTime;
        this.inputType = inputType;
        this.score = score;
        this.sourceCounts = sourceCounts;
        this.textWordCounts = textWordCounts;
        this.totalPlagiarismWords = totalPlagiarismWords;
        this.identicalWordCounts = identicalWordCounts;
        this.similarWordCounts = similarWordCounts;
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

    private int textWordCounts;
    private int totalPlagiarismWords;
    private int identicalWordCounts;
    private int similarWordCounts;
}

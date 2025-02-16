package com.AKP.plagiarism.plagiarism_checker.DTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlagiarismCheckResponseDTO {
    private int score;
    private int sourceCounts;
    private int textWordCounts;
    private int totalPlagiarismWords;
    private int identicalWordCounts;

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

    private int similarWordCounts;
}

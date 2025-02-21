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

    @ManyToOne
    @JoinColumn(name = "upload_text_id", nullable = false)
    private UploadTextEntity uploadText;
}

package com.AKP.plagiarism.plagiarism_checker.DataModel.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "upload_text_entity")
public class UploadTextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "upload_text_seq")
    @SequenceGenerator(name = "upload_text_seq", sequenceName = "upload_text_seq", allocationSize = 1)
    private Long id;

    @Column(name = "text_content", columnDefinition = "TEXT", nullable = false)
    private String textContent;  // Use TEXT instead of LONGTEXT

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "uploadText", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlagiarismCheckEntity> plagiarismChecks;
}

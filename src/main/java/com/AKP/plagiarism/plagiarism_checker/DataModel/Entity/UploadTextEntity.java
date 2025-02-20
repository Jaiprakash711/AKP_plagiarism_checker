//package com.AKP.plagiarism.plagiarism_checker.DataModel.Entity;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "upload_text_entity")
//public class UploadTextEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "text_content", columnDefinition = "LONGTEXT", nullable = false)
//    private String textContent;  // Updated from "text" to "textContent"
//
//    @Column(name = "created_at", updatable = false, nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt = new Date();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTextContent() {
//        return textContent;
//    }
//
//    public void setTextContent(String textContent) {
//        this.textContent = textContent;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//// Getters and Setters
//}

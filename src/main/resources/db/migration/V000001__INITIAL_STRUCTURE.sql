-- V1__create_upload_text_table.sql
CREATE TABLE upload_textEntity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text LONGTEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- V2__create_plagiarism_check_table.sql
CREATE TABLE plagiarism_checkEntity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    upload_text_id BIGINT NOT NULL,
    score INT NOT NULL,
    source_counts INT NOT NULL,
    text_word_counts INT NOT NULL,
    total_plagiarism_words INT NOT NULL,
    identical_word_counts INT NOT NULL,
    similar_word_counts INT NOT NULL,
    scan_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_upload_text FOREIGN KEY (upload_text_id) REFERENCES upload_text(id) ON DELETE CASCADE
);

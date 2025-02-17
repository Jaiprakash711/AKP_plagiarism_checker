CREATE TABLE upload_text_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text_content LONGTEXT NOT NULL,  -- Renamed to avoid keyword conflict
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE plagiarism_check_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    upload_text_id BIGINT NOT NULL,
    service VARCHAR(255) NOT NULL,
    scan_time TIMESTAMP NOT NULL,
    input_type VARCHAR(50) NOT NULL,
    score DOUBLE NOT NULL,
    source_counts INT NOT NULL,
    text_word_counts INT NOT NULL,
    total_plagiarism_words INT NOT NULL,
    identical_word_counts INT NOT NULL,
    similar_word_counts INT NOT NULL,
    CONSTRAINT fk_upload_text FOREIGN KEY (upload_text_id) REFERENCES upload_text_entity(id) ON DELETE CASCADE
);

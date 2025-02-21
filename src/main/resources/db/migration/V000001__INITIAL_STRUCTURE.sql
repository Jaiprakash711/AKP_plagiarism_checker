CREATE SEQUENCE plagiarism_check_seq START 1;
CREATE SEQUENCE upload_text_seq START 1;

CREATE TABLE upload_text_entity (
    id BIGINT PRIMARY KEY DEFAULT nextval('upload_text_seq'),
    text_content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE plagiarism_check (
    id BIGINT PRIMARY KEY DEFAULT nextval('plagiarism_check_seq'),
    upload_text_id BIGINT NOT NULL,
    service VARCHAR(255) NOT NULL,
    scan_time VARCHAR(255) NOT NULL,
    input_type VARCHAR(50) NOT NULL,
    score DOUBLE PRECISION NOT NULL,
    source_counts INT NOT NULL,
    text_word_counts INT NOT NULL,
    total_plagiarism_words INT NOT NULL,
    identical_word_counts INT NOT NULL,
    similar_word_counts INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (upload_text_id) REFERENCES upload_text_entity(id) ON DELETE CASCADE
);

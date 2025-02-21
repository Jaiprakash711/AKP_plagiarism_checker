CREATE SEQUENCE upload_text_seq START 1;

CREATE TABLE plagiarism_check (
    id BIGINT PRIMARY KEY DEFAULT nextval('plagiarism_check_seq'),
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
);

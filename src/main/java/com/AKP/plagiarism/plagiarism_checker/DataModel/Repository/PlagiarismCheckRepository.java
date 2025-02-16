package com.AKP.plagiarism.plagiarism_checker.DataModel.Repository;

import com.AKP.plagiarism.plagiarism_checker.DataModel.Entity.PlagiarismCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlagiarismCheckRepository extends JpaRepository<PlagiarismCheckEntity, Long> {
}

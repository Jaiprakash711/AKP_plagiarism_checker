package com.AKP.plagiarism.plagiarism_checker.Service;

import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckResponseDTO;

public interface PlagiarismCheckService {
    PlagiarismCheckResponseDTO checkPlagiarism(PlagiarismCheckRequestDTO requestDTO);
}

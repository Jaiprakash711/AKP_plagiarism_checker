package com.AKP.plagiarism.plagiarism_checker.Service;

import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;

//public interface PlagiarismCheckService {
//    PlagiarismCheckResponseDTO checkPlagiarism(PlagiarismCheckRequestDTO requestDTO);
//}
public interface PlagiarismCheckService {
    String checkPlagiarism(PlagiarismCheckRequestDTO requestDTO);
}
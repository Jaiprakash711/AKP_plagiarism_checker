package com.AKP.plagiarism.plagiarism_checker.Controller;

import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
import com.AKP.plagiarism.plagiarism_checker.Service.PlagiarismCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plagiarism")
public class PlagiarismCheckController {

    @Autowired
    private PlagiarismCheckService plagiarismCheckService;

//    @PostMapping("/check")
//    public PlagiarismCheckResponseDTO checkPlagiarism(@RequestBody PlagiarismCheckRequestDTO requestDTO) {
//        return plagiarismCheckService.checkPlagiarism(requestDTO);
//    }
@PostMapping("/check")
public String checkPlagiarism(@RequestBody PlagiarismCheckRequestDTO requestDTO) {
    return plagiarismCheckService.checkPlagiarism(requestDTO).toString();
}
}

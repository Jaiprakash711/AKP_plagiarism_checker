package com.AKP.plagiarism.plagiarism_checker.Controller;
import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckResponseDTO;
import com.AKP.plagiarism.plagiarism_checker.Service.PlagiarismCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342")  // Allow only frontend origin
@RestController
@RequestMapping("/api/plagiarism")
public class PlagiarismCheckController {

    @Autowired
    private PlagiarismCheckService plagiarismCheckService;

@PostMapping("/check")
public PlagiarismCheckResponseDTO checkPlagiarism(@RequestBody PlagiarismCheckRequestDTO requestDTO) {
    return plagiarismCheckService.checkPlagiarism(requestDTO);
}

}

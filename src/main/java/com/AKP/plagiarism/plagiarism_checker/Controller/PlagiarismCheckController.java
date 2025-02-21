package com.AKP.plagiarism.plagiarism_checker.Controller;
import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckResponseDTO;
import com.AKP.plagiarism.plagiarism_checker.Service.PlagiarismCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "https://akp-plagiarism-checker.onrender.com",
        "https://akp-plagiarism-checker-front-end.onrender.com"})  // Allow only frontend origin
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

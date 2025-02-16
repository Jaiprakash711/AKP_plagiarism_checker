//package com.AKP.plagiarism.plagiarism_checker.Service.impl;
//
//import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
//import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckResponseDTO;
//import com.AKP.plagiarism.plagiarism_checker.DataModel.Entity.PlagiarismCheckEntity;
//import com.AKP.plagiarism.plagiarism_checker.DataModel.Entity.UploadTextEntity;
//import com.AKP.plagiarism.plagiarism_checker.DataModel.Repository.PlagiarismCheckRepository;
//import com.AKP.plagiarism.plagiarism_checker.DataModel.Repository.UploadTextRepository;
//import com.AKP.plagiarism.plagiarism_checker.Service.PlagiarismCheckService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class PlagiarismCheckServiceImpl implements PlagiarismCheckService {
//
//    @Autowired
//    private UploadTextRepository uploadTextRepository;
//
//    @Autowired
//    private PlagiarismCheckRepository plagiarismCheckRepository;
//
//    // Hardcoded API credentials
//    private static final String API_URL = "https://api.gowinston.ai/v2/plagiarism";
//    private static final String TOKEN = "FezqKNGx96fb1GMQU5s4veHld3Q1Dc24UuQkfDXt7a0628ca";
//
//    @Override
//    public PlagiarismCheckResponseDTO checkPlagiarism(PlagiarismCheckRequestDTO requestDTO) {
//        // Save uploaded text to DB
//        UploadTextEntity uploadText = new UploadTextEntity();
//        uploadText.setText(requestDTO.getText());
//        uploadTextRepository.save(uploadText);
//
//        // Prepare API request headers
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(TOKEN);
//
//        // Ensure required request payload format
//        PlagiarismCheckRequestDTO requestPayload = new PlagiarismCheckRequestDTO();
//        requestPayload.setText(requestDTO.getText());
//        //requestPayload.setExcludedSources(Collections.emptyList()); // Required field
//        //requestPayload.setLanguage("en"); // Required field
//        //requestPayload.setCountry("us"); // Required field
//
//        // Send request to API
//        HttpEntity<PlagiarismCheckRequestDTO> request = new HttpEntity<>(requestPayload, headers);
//        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, request, String.class);
//
//        try {
//            // Convert API response to DTO
//            ObjectMapper objectMapper = new ObjectMapper();
//            PlagiarismCheckResponseDTO responseDTO = objectMapper.readValue(response.getBody(), PlagiarismCheckResponseDTO.class);
//
//            // Save API response to DB
//            PlagiarismCheckEntity entity = new PlagiarismCheckEntity();
//            entity.setScore(responseDTO.getScore());
//            entity.setSourceCounts(responseDTO.getSourceCounts());
//            entity.setTextWordCounts(responseDTO.getTextWordCounts());
//            entity.setTotalPlagiarismWords(responseDTO.getTotalPlagiarismWords());
//            entity.setIdenticalWordCounts(responseDTO.getIdenticalWordCounts());
//            entity.setSimilarWordCounts(responseDTO.getSimilarWordCounts());
//            entity.setUploadText(uploadText);
//
//            plagiarismCheckRepository.save(entity);
//
//            return responseDTO;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to process plagiarism response", e);
//        }
//    }
//}
package com.AKP.plagiarism.plagiarism_checker.Service.impl;

import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
import com.AKP.plagiarism.plagiarism_checker.Service.PlagiarismCheckService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class PlagiarismCheckServiceImpl implements PlagiarismCheckService {

    private static final String API_URL = "https://api.gowinston.ai/v2/plagiarism";
    private static final String TOKEN = "FezqKNGx96fb1GMQU5s4veHld3Q1Dc24UuQkfDXt7a0628ca";

    @Override
    public String checkPlagiarism(PlagiarismCheckRequestDTO requestDTO) {
        // Ensure required fields are set
        if (requestDTO.getExcludedSources() == null) {
            requestDTO.setExcludedSources(Collections.emptyList());
        }
        requestDTO.setLanguage("en");
        requestDTO.setCountry("us");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(TOKEN);

        HttpEntity<PlagiarismCheckRequestDTO> request = new HttpEntity<>(requestDTO, headers);
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, request, String.class);

        return response.getBody(); // Return raw API response
    }
}

//package com.AKP.plagiarism.plagiarism_checker.Service.impl;
//import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
//import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckResponseDTO;
//import com.AKP.plagiarism.plagiarism_checker.Service.PlagiarismCheckService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import java.util.Map;
//
//@Service
//public class PlagiarismCheckServiceImpl implements PlagiarismCheckService {
//
//    private static final String WINSTON_API_URL = "https://api.gowinston.ai/v2/plagiarism";
//    private static final String BEARER_TOKEN = "xCsA8SilRUpqCt9O427Ixd8TjiDLri6KNuIts5OKd3b4477f";
//
//    @Override
//    public PlagiarismCheckResponseDTO checkPlagiarism(PlagiarismCheckRequestDTO requestDTO) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + BEARER_TOKEN);
//        headers.set("Content-Type", "application/json");
//
//        Map<String, String> requestBody = Map.of("text", requestDTO.getText());
//        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);
//
//        try {
//            ResponseEntity<WinstonApiResponse> response = restTemplate.exchange(
//                    WINSTON_API_URL, HttpMethod.POST, entity, WinstonApiResponse.class);
//
//            if (response.getBody() != null) {
//                WinstonApiResponse responseBody = response.getBody();
//                return new PlagiarismCheckResponseDTO(
//                        responseBody.getScanInformation().getService(),
//                        responseBody.getScanInformation().getScanTime(),
//                        responseBody.getScanInformation().getInputType(),
//                        responseBody.getResult().getScore(),
//                        responseBody.getResult().getSourceCounts(),
//                        responseBody.getResult().getTextWordCounts(),
//                        responseBody.getResult().getTotalPlagiarismWords(),
//                        responseBody.getResult().getIdenticalWordCounts(),
//                        responseBody.getResult().getSimilarWordCounts()
//                );
//            }
//        } catch (Exception e) {
//            return new PlagiarismCheckResponseDTO("", "", "", 0.0, 0, 0, 0, 0, 0);
//        }
//        return new PlagiarismCheckResponseDTO("", "", "", 0.0, 0, 0, 0, 0, 0);
//    }
//
//    private static class WinstonApiResponse {
//        private int status;
//        private ScanInformation scanInformation;
//        private Result result;
//
//        public ScanInformation getScanInformation() {
//            return scanInformation;
//        }
//
//        public Result getResult() {
//            return result;
//        }
//    }
//
//    private static class ScanInformation {
//        private String service;
//        private String scanTime;
//        private String inputType;
//
//        public String getService() {
//            return service;
//        }
//
//        public String getScanTime() {
//            return scanTime;
//        }
//
//        public String getInputType() {
//            return inputType;
//        }
//    }
//
//    private static class Result {
//        private double score;
//        private int sourceCounts;
//        private int textWordCounts;
//        private int totalPlagiarismWords;
//        private int identicalWordCounts;
//        private int similarWordCounts;
//
//        public double getScore() {
//            return score;
//        }
//
//        public int getSourceCounts() {
//            return sourceCounts;
//        }
//
//        public int getTextWordCounts() {
//            return textWordCounts;
//        }
//
//        public int getTotalPlagiarismWords() {
//            return totalPlagiarismWords;
//        }
//
//        public int getIdenticalWordCounts() {
//            return identicalWordCounts;
//        }
//
//        public int getSimilarWordCounts() {
//            return similarWordCounts;
//        }
//    }
//}
package com.AKP.plagiarism.plagiarism_checker.Service.impl;
import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckRequestDTO;
import com.AKP.plagiarism.plagiarism_checker.DTO.PlagiarismCheckResponseDTO;
import com.AKP.plagiarism.plagiarism_checker.DataModel.Entity.PlagiarismCheckEntity;
import com.AKP.plagiarism.plagiarism_checker.DataModel.Repository.PlagiarismCheckRepository;
import com.AKP.plagiarism.plagiarism_checker.Service.PlagiarismCheckService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PlagiarismCheckServiceImpl implements PlagiarismCheckService {

    private static final String WINSTON_API_URL = "https://api.gowinston.ai/v2/plagiarism";
    private static final String BEARER_TOKEN = "xCsA8SilRUpqCt9O427Ixd8TjiDLri6KNuIts5OKd3b4477f";

    @Autowired
    private PlagiarismCheckRepository plagiarismCheckRepository;

    @Override
    @Transactional
    public PlagiarismCheckResponseDTO checkPlagiarism(PlagiarismCheckRequestDTO requestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + BEARER_TOKEN);
        headers.set("Content-Type", "application/json");

        Map<String, String> requestBody = Map.of("text", requestDTO.getText());
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<WinstonApiResponse> response = restTemplate.exchange(
                    WINSTON_API_URL, HttpMethod.POST, entity, WinstonApiResponse.class);

            if (response.getBody() != null) {
                WinstonApiResponse responseBody = response.getBody();

                // **Save result to database without UploadTextEntity**
                PlagiarismCheckEntity plagiarismCheckEntity = new PlagiarismCheckEntity();
                plagiarismCheckEntity.setService(responseBody.getScanInformation().getService());
                plagiarismCheckEntity.setScanTime(responseBody.getScanInformation().getScanTime());
                plagiarismCheckEntity.setInputType(responseBody.getScanInformation().getInputType());
                plagiarismCheckEntity.setScore(responseBody.getResult().getScore());
                plagiarismCheckEntity.setSourceCounts(responseBody.getResult().getSourceCounts());
                plagiarismCheckEntity.setTextWordCounts(responseBody.getResult().getTextWordCounts());
                plagiarismCheckEntity.setTotalPlagiarismWords(responseBody.getResult().getTotalPlagiarismWords());
                plagiarismCheckEntity.setIdenticalWordCounts(responseBody.getResult().getIdenticalWordCounts());
                plagiarismCheckEntity.setSimilarWordCounts(responseBody.getResult().getSimilarWordCounts());

                plagiarismCheckRepository.save(plagiarismCheckEntity);

                // **Return DTO response**
                return new PlagiarismCheckResponseDTO(
                        plagiarismCheckEntity.getService(),
                        plagiarismCheckEntity.getScanTime(),
                        plagiarismCheckEntity.getInputType(),
                        plagiarismCheckEntity.getScore(),
                        plagiarismCheckEntity.getSourceCounts(),
                        plagiarismCheckEntity.getTextWordCounts(),
                        plagiarismCheckEntity.getTotalPlagiarismWords(),
                        plagiarismCheckEntity.getIdenticalWordCounts(),
                        plagiarismCheckEntity.getSimilarWordCounts()
                );
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new PlagiarismCheckResponseDTO("", "", "", 0.0, 0, 0, 0, 0, 0);
        }
        return new PlagiarismCheckResponseDTO("", "", "", 0.0, 0, 0, 0, 0, 0);
    }

    private static class WinstonApiResponse {
        private int status;
        private ScanInformation scanInformation;
        private Result result;

        public ScanInformation getScanInformation() {
            return scanInformation;
        }

        public Result getResult() {
            return result;
        }
    }

    private static class ScanInformation {
        private String service;
        private String scanTime;
        private String inputType;

        public String getService() {
            return service;
        }

        public String getScanTime() {
            return scanTime;
        }

        public String getInputType() {
            return inputType;
        }
    }

    private static class Result {
        private double score;
        private int sourceCounts;
        private int textWordCounts;
        private int totalPlagiarismWords;
        private int identicalWordCounts;
        private int similarWordCounts;

        public double getScore() {
            return score;
        }

        public int getSourceCounts() {
            return sourceCounts;
        }

        public int getTextWordCounts() {
            return textWordCounts;
        }

        public int getTotalPlagiarismWords() {
            return totalPlagiarismWords;
        }

        public int getIdenticalWordCounts() {
            return identicalWordCounts;
        }

        public int getSimilarWordCounts() {
            return similarWordCounts;
        }
    }
}

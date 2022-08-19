package com.ramkishore.pensionerdetail.service;


import com.ramkishore.pensionerdetail.exception.ResourceNotFoundException;
import com.ramkishore.pensionerdetail.model.BankDetail;
import com.ramkishore.pensionerdetail.model.PensionerDetail;
import com.ramkishore.pensionerdetail.repository.PensionerDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PensionerDetailService {

    private final PensionerDetailRepository pensionerDetailRepository;

    //Reading all pensioner details from CSV file.
    @Bean
    CommandLineRunner run() {
        return args -> {

            log.info("START: Loading all Pensioner Data from CSV File.");

            List<PensionerDetail> pensionerDetailList = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader("src/main/resources/pensioner_details.csv"));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    PensionerDetail pensionerDetail = new PensionerDetail();
                    pensionerDetail.setAadhaarNumber(data[0]);
                    pensionerDetail.setName(data[1]);
                    pensionerDetail.setDateOfBirth(data[2]);
                    pensionerDetail.setPan(data[3]);
                    pensionerDetail.setSalaryEarned(Double.parseDouble(data[4]));
                    pensionerDetail.setAllowances(Double.parseDouble(data[5]));
                    pensionerDetail.setPensionType(data[6]);
                    pensionerDetail.setBankDetail(new BankDetail(data[7], data[8], data[9]));
                    pensionerDetailList.add(pensionerDetail);
                }
                br.close();

            } catch (Exception e) {
                log.error("Exception - savePensionerData");
                throw new ResourceNotFoundException("Error in Adding Pensioner Detail from CSV File.");
            }

            pensionerDetailRepository.saveAll(pensionerDetailList);
            log.info("END: Finished loading of Pensioner Data from CSV File.");
        };
    }

    public List<PensionerDetail> findAllPensionerDetails() {
        log.info("START: findAllPensionerDetails.");
        log.info("END: findAllPensionerDetails.");
        return pensionerDetailRepository.findAll();
    }

    public PensionerDetail findbyAadhaarNumber(String aadhaarNumber) {
        log.info("START: findByAadhaarNumber.");
        log.info("END: findByAadhaarNumber.");
        return pensionerDetailRepository.findById(aadhaarNumber).orElseThrow(() -> new ResourceNotFoundException("Aadhaar number not found"));

    }

}
package com.ramkishore.pensionerdetail.controller;

import com.ramkishore.pensionerdetail.model.PensionTransactionDetail;
import com.ramkishore.pensionerdetail.model.PensionerDetail;
import com.ramkishore.pensionerdetail.restClient.AuthorizationClient;
import com.ramkishore.pensionerdetail.service.PensionTransactionDetailService;
import com.ramkishore.pensionerdetail.service.PensionerDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PensionerDetailController {

    private final AuthorizationClient authorizationClient;
    private final PensionerDetailService pensionerDetailService;
    private final PensionTransactionDetailService pensionTransactionDetailService;


    // Find all Pensioner Details
    @GetMapping("/allPensionerDetails")
    public List<PensionerDetail> getAllPensionerDetails() {
        log.info("START: getAllPensionerDetails");
        log.info("END: getAllPensionerDetails");
        return pensionerDetailService.findAllPensionerDetails();
    }

    // Find all Pension Transaction Details
    @GetMapping("/allTransactionDetails")
    public List<PensionTransactionDetail> getAllPensionTransactionDetails() {
        log.info("START: getAllPensionerDetails");
        log.info("END: getAllPensionerDetails");
        return pensionTransactionDetailService.findAllPensionTransactionDetails();
    }

    // Find Pensioner Detail based on provided Aadhaar Number
    @GetMapping("/PensionerDetailByAadhaar/{aadhaarNumber}")
    public ResponseEntity<PensionerDetail> findByAadhaarNumber(@RequestHeader("Authorization") String token,
                                              @PathVariable String aadhaarNumber) throws Exception {
        log.info("START: findByAadhaarNumber");
        if (authorizationClient.authorization(token)) {
            PensionerDetail pensionerDetail = pensionerDetailService.findbyAadhaarNumber(aadhaarNumber);
            log.info("END: findByAadhaarNumber");
            return new ResponseEntity<>(pensionerDetail, HttpStatus.OK);
        } else {
            log.error("EXCEPTION: findByAadhaarNumber");
            throw new Exception("Invalid Token");
        }
    }

    // Save Pension Transaction Details
    @PostMapping("/saveTransactionDetail")
    public boolean savePensionTransactionDetail(@RequestHeader("Authorization") String token,
                                                @RequestBody PensionTransactionDetail pensionTransactionDetail) throws Exception {
        log.info("START: savePensionTransactionDetail");
        if (authorizationClient.authorization(token)) {
            boolean saveStatus =
                    pensionTransactionDetailService.savePensionTransactionDetail(pensionTransactionDetail);
            log.info("END: savePensionTransactionDetail");
            return saveStatus;
        } else {
            log.error("EXCEPTION: savePensionTransactionDetail");
            throw new Exception("Invalid Token");
        }
    }
}

package com.ramkishore.pensionerdetail.service;

import com.ramkishore.pensionerdetail.model.PensionTransactionDetail;
import com.ramkishore.pensionerdetail.repository.PensionTransactionDetailRepository;
import com.ramkishore.pensionerdetail.repository.PensionerDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PensionTransactionDetailService {

	private final PensionTransactionDetailRepository pensionTransactionDetailRepository;
	private final PensionerDetailRepository pensionerDetailRepository;
	
	public List<PensionTransactionDetail> findAllPensionTransactionDetails() {
		log.info("START - fetchAllPensionTransactionDetails -Service");
		log.info("END - fetchAllPensionTransactionDetails -Service");
		return pensionTransactionDetailRepository.findAll();
	}
	
	public boolean savePensionTransactionDetail(PensionTransactionDetail pensionTransactionDetail) {
		log.info("START - savePensionTransactionDetail -Service");
		log.info("END - savePensionTransactionDetail -Service");
		if (pensionTransactionDetail!=null) {
			pensionTransactionDetailRepository.save(pensionTransactionDetail);
			return true;
		}
		else
			return false;

	}
}

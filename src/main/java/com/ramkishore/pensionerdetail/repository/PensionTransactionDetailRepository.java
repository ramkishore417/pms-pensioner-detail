package com.ramkishore.pensionerdetail.repository;

import com.ramkishore.pensionerdetail.model.PensionTransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionTransactionDetailRepository extends JpaRepository<PensionTransactionDetail, String> {

}

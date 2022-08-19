package com.ramkishore.pensionerdetail.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ModelTest {

	@Test
	public void testNoArgsBankDetailTest() {
		assertThat(new BankDetail()).isNotNull();
	}

	@Test
	public void testAllArgsBankDetailTest() {
		BankDetail bankDetails = new BankDetail("SBI", "1234567890", "Private") ;
		assertNotNull(bankDetails) ;
	}

	@Test
	public void testSetterBankTest() {
		BankDetail b = new BankDetail();
		b.setAccountNumber("102233445566");
		b.setBankName("SBI");
		b.setBankType("public");
		assertThat(assertThat(b).isNotNull());

	}
	
	@Test
	public void SetterArgsBankDetailTest() {
		BankDetail bankDetails = new BankDetail("SBI", "1234567890", "private") ;
		assertEquals("SBI", bankDetails.getBankName()) ;
		assertEquals("1234567890", bankDetails.getAccountNumber()) ;
		assertEquals("private", bankDetails.getBankType()) ;
	}


	@Test
	public void testSetterPensionerDetailTest() {
		PensionerDetail pensionerDetail = new PensionerDetail();
		pensionerDetail.setAadhaarNumber("986543276547");
		pensionerDetail.setDateOfBirth("6-11-1998");
		pensionerDetail.setName("Mounika");
		pensionerDetail.setPan("GTYIK7412L");
		pensionerDetail.setSalaryEarned(70000);
		pensionerDetail.setAllowances(12000);
		pensionerDetail.setPensionType("family");

		BankDetail bankDetail = new BankDetail();
		bankDetail.setAccountNumber("102233445566");
		bankDetail.setBankName("SBI");
		bankDetail.setBankType("public");

		pensionerDetail.setBankDetail(bankDetail);
		assertThat(assertThat(pensionerDetail).isNotNull());
		
		assertEquals("986543276547",pensionerDetail.getAadhaarNumber() ) ;
		assertEquals("6-11-1998", pensionerDetail.getDateOfBirth()) ;
		assertEquals("Mounika", pensionerDetail.getName()) ;
		assertEquals("GTYIK7412L", pensionerDetail.getPan()) ;
		assertEquals(70000, pensionerDetail.getSalaryEarned()) ;
		assertEquals(12000, pensionerDetail.getAllowances()) ;
		assertEquals("family", pensionerDetail.getPensionType()) ;
		
		assertEquals("102233445566",bankDetail.getAccountNumber() ) ;
		assertEquals("SBI", bankDetail.getBankName()) ;
		assertEquals("public",bankDetail.getBankType() ) ;
		
	}

}

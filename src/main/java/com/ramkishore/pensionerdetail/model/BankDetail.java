package com.ramkishore.pensionerdetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BankDetail {
    private String bankName;		// Bank-Name of Pensioner
    private String accountNumber;	// Account Number of Pensioner
    private String bankType;		// Bank Type of pensioner Example: Private or Public
}

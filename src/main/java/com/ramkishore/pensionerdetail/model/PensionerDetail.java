package com.ramkishore.pensionerdetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PensionerDetail {

    @Id
    private String aadhaarNumber;                   // AadhaarNumber of Pensioner
    private String name;                            // Name of Pensioner
    private String dateOfBirth;                     // DateOfBirth of Pensioner
    private String pan;                             // PAN Number of Pensioner
    private double salaryEarned;					// SalaryEarned by Pensioner
    private double allowances;						// Allowances - Pensioner
    private String pensionType;                     // PensionType - Self or Family

    @Embedded
    private BankDetail bankDetail;                  // Bank Detail of Pensioner
}

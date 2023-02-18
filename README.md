# Pension Management System | PensionerDetail Microservice
The intent of this Microservice is to provide the Pensioner detail based on Aadhaar number. Post Authorization using JWT, pensioner detail like the name, PAN detail, Bank name and bank account number

## Functional Requirements

The intent of this Microservice is to provide the Pensioner detail based on Aadhaar number. Post Authorization using JWT, pensioner detail like the name, PAN detail, Bank name and bank account number

------------

### REQ_02 : Pensioner detail module
This module is a Middleware Microservice that performs the following operations: · Provides information about the registered pensioner detail i.e., Pensioner name, PAN, bank name, bank account number, bank type – private or public

------------


### Entities

#### PensionerDetail 
1. Name <Pensioner name> 
2. Date of birth <Pensioner date of birth> 
3. PAN <Permanent account number>
4. SalaryEarned <Last earned salary by the pensioner> 
5. Allowances <Sum of all the allowances> 
6. Self or Family pension <Is the pension classification self or family pension> 
7. Bank detail 
	a. Bank name 
	b. Account number 
	c. Public or Private bank <Bank detail> 

------------


### End Points
REST End Points PensionerDetail Microservice o GET: /PensionerDetailByAadhaar (Input: aadhaarNumber | Output: pensionerDetail)

> Trigger – Should be invoked from ProcessPension microservice

------------


### Steps and Actions

1. This Microservice is to fetch the pensioner detail by the Aadhaar number. This should
 be consumed by Process pension microservice.

2. Flat file(CSV file with pre-defined data) should be created as part of the Microservice.
This file has to contain data for 20 Pensioners. This has to be read and loaded into List
for ALL the operations of the microservice.

------------


### Non-Functional Requirement:

· Only Authorized requests can access these REST End Points

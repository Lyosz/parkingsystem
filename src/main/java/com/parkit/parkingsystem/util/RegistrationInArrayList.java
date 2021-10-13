package com.parkit.parkingsystem.util;

import java.io.IOException;
import java.util.List;

public class RegistrationInArrayList {
	
	private String vehicleRegNumber;
	private String filepath = "resources/vehicleRegistrationNumber.txt"; 
	
	public RegistrationInArrayList(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}
	
	public boolean VerifyRegistration(){
		
		ReadRegistrationFromFile registrationFromFile = new ReadRegistrationFromFile(filepath);
		List<String> allRegistrations = registrationFromFile.GetRegistration();
		boolean regNumberNotInList = VerifyRegistrationInList(allRegistrations);
		return regNumberNotInList;
	}
	
	public void AddRegistrationsToTxt() throws IOException {
		ReadRegistrationFromFile registrationFromFile = new ReadRegistrationFromFile(filepath);
		List<String> allRegistrations = registrationFromFile.GetRegistration();
		boolean regNumberNotInList = VerifyRegistrationInList(allRegistrations);
		if (regNumberNotInList == false) {
			FileWriterFromString.FileWriterToTxt(vehicleRegNumber);
		}
	}
	public boolean VerifyRegistrationInList(List<String> allRegistrations) {
		for (String regNumber : allRegistrations ) {
			if (regNumber.equals(vehicleRegNumber)) {
				return true;
			}
		}
		return false;
	}
}
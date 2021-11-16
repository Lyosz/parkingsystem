package com.parkit.parkingsystem.util;

import java.io.IOException;
import java.util.List;

public class RegistrationInArrayList {
	
	private String vehicleRegNumber;
	private String filepath = "resources/vehicleRegistrationNumber.txt"; 
	
	public RegistrationInArrayList(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}
	
	public boolean verifyRegistration(){
		
		ReadRegistrationFromFile registrationFromFile = new ReadRegistrationFromFile(filepath);
		List<String> allRegistrations = registrationFromFile.getRegistration();
		boolean regNumberNotInList = verifyRegistrationInList(allRegistrations);
		return regNumberNotInList;
	}
	
	public void addRegistrationsToTxt() throws IOException {
		ReadRegistrationFromFile registrationFromFile = new ReadRegistrationFromFile(filepath);
		List<String> allRegistrations = registrationFromFile.getRegistration();
		boolean regNumberNotInList = verifyRegistrationInList(allRegistrations);
		if (regNumberNotInList == false) {
			FileWriterFromString.fileWriterToTxt(vehicleRegNumber);
		}
	}
	public boolean verifyRegistrationInList(List<String> allRegistrations) {
		for (String regNumber : allRegistrations ) {
			if (regNumber.equals(vehicleRegNumber)) {
				return true;
			}
		}
		return false;
	}
}
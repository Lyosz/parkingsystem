package com.parkit.parkingsystem.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class FileWriterFromString {
		
	public static void fileWriterToTxt(String vehicleRegNumber) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("resources/vehicleRegistrationNumber.txt",true));
		writer.write(vehicleRegNumber + "\n");
		writer.close();
	}
}
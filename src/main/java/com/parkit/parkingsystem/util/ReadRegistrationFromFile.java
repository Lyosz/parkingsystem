package com.parkit.parkingsystem.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadRegistrationFromFile{

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with registrations strings in it, one per line
	 */
	public ReadRegistrationFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	public List<String> getRegistration() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
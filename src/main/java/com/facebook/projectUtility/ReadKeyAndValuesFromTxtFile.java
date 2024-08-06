package com.facebook.projectUtility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadKeyAndValuesFromTxtFile {
	
	public static Logger logger = LogManager.getLogger(ReadKeyAndValuesFromTxtFile.class);

	public static void main(String[] args) {
		String fileAddress = "D:\\Eclipse Project\\WebAutomation\\Facebook_WATM\\AutoIT\\Text.txt";
		Map<String, String> values = readValuesFromFile(fileAddress);
		String runtimeUploadFileAddress = values.get("uploadFileAddress");
		String runtimeUploadFileName = values.get("uploadFileName");
		System.out.println("runtimeUploadFileAddress: "+runtimeUploadFileAddress);
		System.out.println("runtimeUploadFileName: "+runtimeUploadFileName);
	}

	// Method to read uploadFileAddress and uploadFileName from text.txt
	public static Map<String, String> readValuesFromFile(String fileAddress) {
		Map<String, String> values = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileAddress))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("=");
				if (parts.length == 2) {
					values.put(parts[0], parts[1]);
				}
			}
			logger.info(values);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return values;
	}
}

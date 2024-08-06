package com.facebook.projectUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UploadFileWithAutoIT {
	private static final Logger logger = LogManager.getLogger(UploadFileWithAutoIT.class);

	public static void uploadFileWithAutoIT(String fileAddress) {
		StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTraceElement[2].getMethodName();
		logger.info("Method called uploadFileWithAutoIT & caller method name: " + callerMethodName);
		
		String autoItExecutableName = "autoITApplication.exe";
		String autoItExecutablePath = System.getProperty("user.dir") + "\\AutoIT\\" + autoItExecutableName;
		logger.info("autoItExecutablePath: " + autoItExecutablePath);
		logger.info("Text file address: "+fileAddress);
		
		Map<String, String> values = ReadKeyAndValuesFromTxtFile.readValuesFromFile(fileAddress);
		System.out.println(values);
		String uploadFileAddress = values.get("uploadFileAddress");
		String uploadFileName = values.get("uploadFileName");
		

		try {
			Thread.sleep(2000);
			// Update the autoIT script
			logger.info("uploadFileAddress: " + uploadFileAddress);
			logger.info("uploadFileName: " + uploadFileName);
			
			logger.info("AutoIT script before update");
			ReadKeyAndValuesFromTxtFile.readValuesFromFile(System.getProperty("user.dir") + "\\AutoIT\\autoITScript.au3");
			
			AddArgumentsInAutoITScriptFile.setFileDirectoryAndName(uploadFileAddress, uploadFileName,true);
			Thread.sleep(3000);
			
			logger.info("AutoIT script after update");
			ReadKeyAndValuesFromTxtFile.readValuesFromFile(System.getProperty("user.dir") + "\\AutoIT\\autoITScript.au3");
			
			// Compile the autoIT script
			OpenCMDAndRunBatFile.openCMDAndRunBatFile(System.getProperty("user.dir") + "\\AutoIT", "AutoIT.bat");
			Thread.sleep(5000);
			logger.info("Starting AutoIt script execution...");

			// Construct the path to the AutoIt executable
			ProcessBuilder processBuilder = new ProcessBuilder(autoItExecutablePath);
			Process process = processBuilder.start();

			// Capture and log the output of the process
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			String s;
			while ((s = stdInput.readLine()) != null) {
				logger.info("AutoIt Output: " + s);
			}
			while ((s = stdError.readLine()) != null) {
				logger.info("AutoIt Error: " + s);
			}

			int exitCode = process.waitFor(); // Wait for the process to complete
			logger.info("AutoIt script execution completed with exit code: " + exitCode);

			Thread.sleep(2000); // Optional delay
			// This is used to regain the file changes
			AddArgumentsInAutoITScriptFile.setFileDirectoryAndName(uploadFileAddress, uploadFileName, false);
			Thread.sleep(3000);

		} catch (IOException | InterruptedException e) {
			logger.info("Exception during AutoIt script execution: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for detailed error analysis
		}
	}

//    public static void main(String[] args) {
//    	String autoItExecutablePath = System.getProperty("user.dir") + "\\autoITApplication.exe";
//    	String uploadFileAddress = "C:\\Users\\koiri\\Downloads\\LeonardoAI";
//        String uploadFileName = "lord-hanuman-8535687.png";
//    	uploadFileWithAutoIT(uploadFileAddress,uploadFileName, true);
//    }
}

package com.facebook.projectUtility;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpenCMDAndRunBatFile {
	private static final Logger logger = LogManager.getLogger(OpenCMDAndRunBatFile.class);
	

    public static void openCMDAndRunBatFile(String batFileAddress, String batchFileName) throws InterruptedException {
    	StackTraceElement stackTraceElement[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTraceElement[2].getMethodName();
		logger.info("Method called setFileDirectoryAndName & caller method name: " + callerMethodName);
		
        try {
            System.out.println("CMD directory address: " + batFileAddress);

            // Construct the command to change directory and execute the batch file
            String command = "cd /d " + batFileAddress + " && " + batchFileName;

            // Create and start the Command Prompt process
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", "cmd", "/k", command);
            Process process = processBuilder.start();
            process.waitFor();
            Thread.sleep(5000);
            CloseCMD.closeAllOpenCMD();
        } catch (IOException e) {
            e.printStackTrace();
 
        }
        
    
    }
    
    public static void main(String[] args) throws InterruptedException {
        String directory = System.getProperty("user.dir") + "\\AutoIT";
        openCMDAndRunBatFile(directory, "AutoIT.bat");
        System.out.println("Command Prompt executed successfully");
    }
}

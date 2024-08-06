package com.facebook.projectUtility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CloseCMD {

	public static void closeAllOpenCMD() {
		try {
			
			// Find the cmd processes
			String findCmdCommand = "tasklist /FI \"IMAGENAME eq cmd.exe\"";
			Process findCmdProcess = Runtime.getRuntime().exec(findCmdCommand);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(findCmdProcess.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("cmd.exe")) {
					// Extract the process ID (PID) from the tasklist output
					String[] parts = line.trim().split("\\s+");
					String pid = parts[1];
					System.out.println("Found cmd.exe with PID: " + pid);

					// Kill the cmd process
					String killCmdCommand = "taskkill /F /PID " + pid;
					Process killCmdProcess = Runtime.getRuntime().exec(killCmdCommand);
					killCmdProcess.waitFor();
					System.out.println("Killed cmd.exe with PID: " + pid);
				}
			}

			reader.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

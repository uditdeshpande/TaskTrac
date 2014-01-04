package core.function.read;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadTask implements Runnable{

	private Process process_read;
	
	/* Reads the tasklist from the command prompt command. Then this scanner class will differentiate the various parameters*/
	public void run() {
	try {
		process_read=Runtime.getRuntime().exec("tasklist");
		Scanner task_scanner=new Scanner(new InputStreamReader(process_read.getInputStream()));
	//first 4 lines are headers null lines and the system idle process variable.
		task_scanner.next();task_scanner.next();task_scanner.next();task_scanner.next();
		
		
		
		} catch (IOException e) {
		
		e.printStackTrace();
		}
	
	}

	public static void main(String []args)
	{
		Thread t=new Thread(new ReadTask(),"mma");
		t.start();
	}

}

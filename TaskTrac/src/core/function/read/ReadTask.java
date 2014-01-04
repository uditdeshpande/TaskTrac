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
		Scanner s=new Scanner(new InputStreamReader(process_read.getInputStream()));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
/*
	public static void main(String []args)
	{
		Thread t=new Thread(new ReadTask(),"mma");
		t.start();
	}
*/
}

package core.function.read;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import core.global.env.Task;


public class ReadTask implements Runnable{

	private Process process_read;
	
	Task temp;
	
	/* Reads the tasklist from the command prompt command. Then this scanner class will differentiate the various parameters*/
	public void run() {
	try {
		process_read=Runtime.getRuntime().exec("tasklist");
		Scanner task_scanner=new Scanner(new InputStreamReader(process_read.getInputStream()));
	//first 4 lines are headers null lines and the system idle process variable.
		task_scanner.nextLine();task_scanner.nextLine();task_scanner.nextLine();task_scanner.nextLine();
		
		while(task_scanner.hasNextLine())
		{
			/*
			System.out.println("1"+task_scanner.next());
			System.out.println("2"+task_scanner.nextInt());
			System.out.println("3"+task_scanner.next());
			System.out.println("4"+task_scanner.nextInt());
			System.out.println("5"+task_scanner.nextDouble());
			task_scanner.nextLine();
			*/
			temp=new Task();
			try{
			if(task_scanner.hasNext())
			temp.setImage_name(task_scanner.next());
			if(task_scanner.hasNextInt())
			temp.setPid(task_scanner.nextInt());
			if(task_scanner.hasNext())
			temp.setSession_name(task_scanner.next());
			if(task_scanner.hasNextInt())
			temp.setSession_no(task_scanner.nextInt());
			if(task_scanner.hasNextDouble())
			temp.setMem_usage(task_scanner.nextDouble());
			task_scanner.nextLine();
			System.out.println(temp.toString());
			//add to array list
			//tlist.task_list.add(temp);
			FileOutputStream ser_file=new FileOutputStream("C:\\Users\\User\\git\\TaskTrac\\TaskTrac\\src\\core\\function\\read\\temp.txt");
			ObjectOutputStream oout=new ObjectOutputStream(ser_file);
			oout.writeObject(temp);
			}
			catch (Exception e) {
			System.out.println("Error");
			}
			}
		
		
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

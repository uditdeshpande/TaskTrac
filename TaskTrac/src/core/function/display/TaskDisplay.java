package core.function.display;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import core.global.env.Task;

public class TaskDisplay implements Runnable{

	
	public void run() {
		FileInputStream ser_file;
		
		try {
			Task temp=new Task();
			ser_file = new FileInputStream("src\\core\\function\\read\\temp.txt");
			ObjectInputStream oin=new ObjectInputStream(ser_file);
			while(ser_file.available()!=0)
			{
				temp=(Task)oin.readObject();
				System.out.println(temp.toString());
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}

	public static void main(String[]args)
	{
		Thread t1=new Thread(new TaskDisplay(),"MMA");
		t1.start();
	}
	
}

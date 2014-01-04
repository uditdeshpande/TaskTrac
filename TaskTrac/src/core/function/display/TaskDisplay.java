package core.function.display;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import core.global.env.Task;
import core.global.env.TaskList;

public class TaskDisplay implements Runnable{
	public ArrayList<Task> TList=new ArrayList<Task>();
	public void run() {
			FileInputStream ser_file;
			int sum=0;
		try {
			
			Task temp=new Task();
			ser_file = new FileInputStream("src\\core\\function\\read\\temp.txt");
			ObjectInputStream oin=new ObjectInputStream(ser_file);
			while(ser_file.available()!=0)
			{
				temp=(Task)oin.readObject();
				TList.add(temp);
			}
			System.out.println(TList.size());
			while(TList.iterator().hasNext())
				sum+=TList.iterator().next().getMem_usage();			
			System.out.print(sum);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[]args)
	{
	
		Thread t1=new Thread(new TaskDisplay(),"MMA");
		t1.setPriority(8);
		t1.start();
		while(t1.isAlive())
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}

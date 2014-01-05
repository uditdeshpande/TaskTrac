package core.function.display;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import core.function.read.ReadTask;
import core.global.env.Task;
import core.global.env.TaskList;

public class TaskDisplay implements Runnable{
	int sum=0;
	public ArrayList<Task> TList=new ArrayList<Task>();
	public void run() {
			FileInputStream ser_file;
			
			double tmp;
		try {
				TaskList.TList.clear();
				Task temp = new Task();
				ser_file = new FileInputStream("src\\core\\function\\read\\temp.txt");
				synchronized (temp) {
					ObjectInputStream oin = new ObjectInputStream(ser_file);
					while (ser_file.available()!= 0) {
						temp = (Task) oin.readObject();
						TaskList.TList.add(temp);
						//System.out.println(temp.getMem_usage());
						transform(temp);
						
					}
					//System.out.println(sum);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[]args)
	{
	
		Thread t1=new Thread(new TaskDisplay(),"MMA");
		Thread t2=new Thread(new ReadTask(),"MMA");

		try {
			t2.start();
			t2.join();
			t1.start();	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void transform(Task temp)
	{
		sum+=temp.getMem_usage();
	}
	
}

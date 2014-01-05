package core.ui.entry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SplashDemo extends JFrame implements Runnable{

	JPanel root;
	JLabel main,sub1,sub2,foot;
	
	
	public SplashDemo() {
		
		root=new JPanel();
		root.setLayout(null);
		main=new JLabel("TaskTrac");
		main.setBounds(170, 75, 500, 140);
		main.setFont(new Font(Font.SERIF, Font.BOLD, 100));
		main.setForeground(Color.green);
		add(root);
		root.add(main);
		root.setBackground(Color.BLACK);
		
	}

	public void run() {
		 Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		 SplashDemo s=new SplashDemo();
		 s.setSize(800, 300);
		 s.setLocation((dim.width-s.getSize().width)/2,(dim.height-s.getSize().height)/2);
		 s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 s.setUndecorated(true);
		 s.setVisible(true);
		 try {
			Thread.sleep(3100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.exit(1);
		
		
	}
	
	 public static void main(String []args)
	{
		Thread t=new Thread(new SplashDemo(),"MMA");
		t.start();
	}

	
	
}
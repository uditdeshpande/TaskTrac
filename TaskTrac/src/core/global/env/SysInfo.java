package core.global.env;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SysInfo extends JFrame {
	
static String os_name,os_version,user_name;
static ImageIcon icon;

	public static void main(String []args)
	{
		JPanel j=new JPanel();
		SysInfo s=new SysInfo();
		s.setLayout(new FlowLayout(FlowLayout.LEFT));
		os_name=System.getProperty("os.name");
		os_version=System.getProperty("os.version");
		user_name=System.getProperty("user.name");
		System.out.print(os_name+os_version+user_name);
		os_name="Linux";
		if(os_name.startsWith(new String("Linux")))
	icon=new ImageIcon("src\\img\\icons\\extra\\Linux-Logo.jpg","This is a desc" );	
		else if(os_name.startsWith(new String("Windows")))
		icon=new ImageIcon("src\\img\\icons\\extra\\windows_logo.jpg","This is a desc" );	
		else
			s.setBackground(Color.DARK_GRAY);
		s.invalidate();
		s.repaint();
	s.add(new JLabel(icon));
	s.add(new JLabel(os_name));
	s.add(new JLabel(os_version));
	s.add(new JLabel(user_name));
	s.setSize(600, 400);
	s.setVisible(true);
	
	}
}

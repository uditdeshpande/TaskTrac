package core.global.env;
import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable{
	private String Image_name;
	private int pid;
	private String Session_name;
	private int Session_no;
	private double mem_usage;
	
	public Task() {
		Image_name="";
		pid=-1;
		Session_name="";
		Session_no=-1;
		mem_usage=0; 
	}

	public Task(String image_name, int pid, String session_name,
			int session_no, double mem_usage) {
		super();
		Image_name = image_name;
		this.pid = pid;
		Session_name = session_name;
		Session_no = session_no;
		this.mem_usage = mem_usage;
	}

	public String getImage_name() {
		return Image_name;
	}

	public void setImage_name(String image_name) {
		Image_name = image_name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSession_name() {
		return Session_name;
	}

	public void setSession_name(String session_name) {
		Session_name = session_name;
	}

	public int getSession_no() {
		return Session_no;
	}

	public void setSession_no(int session_no) {
		Session_no = session_no;
	}

	public double getMem_usage() {
		return mem_usage;
	}

	public void setMem_usage(double mem_usage) {
		this.mem_usage = mem_usage;
	}

	public String toString() {
		return "Task [Image_name=" + Image_name + ", pid=" + pid
				+ ", Session_name=" + Session_name + ", Session_no="
				+ Session_no + ", mem_usage=" + mem_usage + "]";
	}	
	
	
}
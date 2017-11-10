package kr.hs.hcinfo;
public class JobSchedule {
	int jobTime;
	String jobTodo;
	public JobSchedule() {
		// TODO Auto-generated constructor stub
		jobTime = 0;
		jobTodo = "";
	}
	public JobSchedule(int jobTime, String jobTodo) {
		super();
		this.jobTime = jobTime;
		this.jobTodo = jobTodo;
	}
	public int getJobTime() {
		return jobTime;
	}
	public void setJobTime(int jobTime) {
		this.jobTime = jobTime;
	}
	public String getJobTodo() {
		return jobTodo;
	}
	public void setJobTodo(String jobTodo) {
		this.jobTodo = jobTodo;
	}
	@Override
	public String toString() {
		return "" + CalcTime.intToString(jobTime) + "\nTodo=[" + jobTodo + "]";
	}
	
	
	
	
}

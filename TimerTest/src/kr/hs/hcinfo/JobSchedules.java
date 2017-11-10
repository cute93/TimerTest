package kr.hs.hcinfo;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JobSchedules {
	private ArrayList<JobSchedule> schedule;
	private File jobFile;
	
	public JobSchedules(){
		super();
		schedule = new ArrayList<JobSchedule>();
		jobFile = new File("schedule.sche");
	}
	
	public JobSchedules(String filename) {
		super();
		schedule = new ArrayList<JobSchedule>();
		jobFile = new File(filename);
	}
	
	public void readFile(){
		Scanner sc = null;
		try {
			sc = new Scanner(jobFile);
			while(sc.hasNextLine()){
				JobSchedule js = new JobSchedule(CalcTime.stringToInt(sc.next()), sc.next());
				schedule.add(js);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveFile(){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(jobFile));
			for(JobSchedule js:schedule){
				bw.write(CalcTime.intToString(js.jobTime));
				bw.write(" ");
				bw.write(js.jobTodo);
				bw.write("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String toString() {
		String rtn="";
		rtn += "JobSchedules [schedule=" + schedule + ", jobFile=" + jobFile + "]";
		for(JobSchedule js : schedule){
			rtn += "\n" + CalcTime.intToString(js.jobTime) + ", " +js.jobTodo;
		}
		return rtn;
	}
	public void add(JobSchedule e){
		schedule.add(e);
	}
	public JobSchedule remove(){
		return schedule.remove(0);
	}
	public JobSchedule get(int n){
		return schedule.get(n);
	}
	public int size(){
		return schedule.size();
	}

	public ArrayList<JobSchedule> getSchedule() {
		return schedule;
	}

	
	
}

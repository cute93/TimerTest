package kr.hs.hcinfo;

public class CalcTime {
	String timeString;
	int timeInt;
	public CalcTime(){
		timeString = "00:00:00";
		timeInt = 0;
	}
	public CalcTime(String tmString, int tmInt) {
		timeString = tmString;
		timeInt = tmInt;
	}
	public CalcTime(String tmString) {
		timeString = tmString;
		timeInt = stringToInt();
	}
	private String intToString() {
		// TODO Auto-generated method stub
		int n = timeInt;
		String rtnValue="";
		int rest;
		int temp;
		temp = n/3600;
		n %= 3600;
		rtnValue += (temp<10)?"0"+temp+":":""+temp+":";
		temp = n/60;
		n %= 60;
		rtnValue += (temp<10)?"0"+temp+":":""+temp+":";
		rtnValue += (n<10)?"0"+n:""+n;
		
		return rtnValue;
	}
	public CalcTime(int tmInt) {
		timeInt = tmInt;
		timeString = intToString();
	}
	private int stringToInt() {
		// TODO Auto-generated method stub
		String st = timeString;
		String stsplit[] = st.split(":");
		return Integer.parseInt(stsplit[0])*60*60 + Integer.parseInt(stsplit[1])*60 + Integer.parseInt(stsplit[2]);	
	}
	public static String intToString(int n) {
		// TODO Auto-generated method stub
		String rtnValue="";
		int rest;
		int temp;
		temp = n/3600;
		n %= 3600;
		rtnValue += (temp<10)?"0"+temp+":":""+temp+":";
		temp = n/60;
		n %= 60;
		rtnValue += (temp<10)?"0"+temp+":":""+temp+":";
		rtnValue += (n<10)?"0"+n:""+n;
		
		return rtnValue;
	}
	public static int stringToInt(String st) {
		String stsplit[] = st.split(":");
		return Integer.parseInt(stsplit[0])*60*60 + Integer.parseInt(stsplit[1])*60 + Integer.parseInt(stsplit[2]);	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return timeInt + " <-:-> " + timeString;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
		this.timeInt = stringToInt();
	}
	public int getTimeInt() {
		return timeInt;
	}
	public void setTimeInt(int timeInt) {
		this.timeInt = timeInt;
		this.timeString = intToString();
	}
}

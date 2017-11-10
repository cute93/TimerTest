package kr.hs.hcinfo;

public class CalcTime {
	String timeString;
	int timeInt;
	public CalcTime() {
		// TODO Auto-generated constructor stub
		timeString = "";
		timeInt = 0;
	}
	public CalcTime(String st) {
		// TODO Auto-generated constructor stub
		timeString = st;
		timeInt = strToInt(st);
	}
	public int strToInt(String st) {
		st = st.trim();
		String stsplit[] = st.split(":");
		return Integer.parseInt(stsplit[0])*60*60 + Integer.parseInt(stsplit[1])*60 + Integer.parseInt(stsplit[2]);	
	}
	
	public CalcTime(int ti) {
		// TODO Auto-generated constructor stub
		timeInt = ti;
		timeString = intToStr(ti);
	}
	public String intToStr(int n){
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
	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public int getTimeInt() {
		return timeInt;
	}

	public void setTimeInt(int timeInt) {
		this.timeInt = timeInt;
	}

	public String toString() { return timeString; }
}

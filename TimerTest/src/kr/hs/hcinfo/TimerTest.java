package kr.hs.hcinfo;

public class TimerTest {
	public static void main(String args[]){
		//TimerFrame tf = new TimerFrame("ȭõ�����������б� �۾�Ÿ�̸�");
		//tf.display();
		
		CalcTime ct = new CalcTime(8062);
		System.out.println(ct);
		ct = new CalcTime("02:14:22");
		System.out.println(ct.strToInt(ct.toString()));
	}
}

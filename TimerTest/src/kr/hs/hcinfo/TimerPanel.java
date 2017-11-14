package kr.hs.hcinfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel showLabel;
	private JLabel showJob;
	private Timer tm;
	private int timeDelay;
	private String showStr;
	private JobSchedules schedule;
	private JobSchedule nowschedule;
	private int nowTime;
	
	public TimerPanel() {
		// TODO Auto-generated constructor stub
		super(new GridLayout(2, 1));
		setAlignmentX((float) 5.0);
		setBackground(Color.BLACK);
		timeDelay=0;
		tm = new Timer(0, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timeDelay++;
				repaint();
			}
		});
		showLabel = new JLabel("00000");
		showLabel.setHorizontalAlignment(JLabel.CENTER);
		showJob = new JLabel("Job");
		showJob.setHorizontalAlignment(JLabel.CENTER);
		showLabel.setFont(new Font("±¼¸²", 1, 40));
		showLabel.setForeground(Color.WHITE);
		showJob.setFont(new Font("±¼¸²", 1, 40));
		showJob.setForeground(Color.WHITE);
		
		add(showLabel);
		add(showJob);
		schedule = new JobSchedules("schedule.sche");
		schedule.readFile();
		nowTime=0;
		nowschedule = schedule.getSchedule().get(nowTime);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawTimer();	
	}
	
	private void drawTimer() {
		// TODO Auto-generated method stub
		showStr = CalcTime.intToString(timeDelay);
		
		if(timeDelay>=nowschedule.getJobTime()){
			nowTime++;	
		}
		if(nowTime>=schedule.size()){
			timeDelay = 0;
			nowTime = 0;
			repaint();
			tm.stop();
			return;
		}
		nowschedule = schedule.getSchedule().get(nowTime);
		showJob.setText(nowschedule.getJobTodo());
		showLabel.setFont(new Font("HY °ß°íµñ", 1, getWidth()/5));
		showJob.setFont(new Font("HY °ß°íµñ", 1, getWidth()/8));
		if(nowschedule.getJobTime()-timeDelay<=10){
			if(timeDelay%2==0){
				//showJob.setForeground(Color.BLACK);
				showLabel.setForeground(Color.RED);
			}else{
				//showJob.setForeground(Color.RED);
				showLabel.setForeground(Color.WHITE);
			}
			showJob.setForeground(Color.RED);
		}else{
			showJob.setForeground(Color.WHITE);
			showLabel.setForeground(Color.WHITE);
		}
		showLabel.setText(showStr);
	}
	public void startTime(){
		tm.setDelay(1000);
		tm.start();
	}
	public void pauseTime() {
		// TODO Auto-generated method stub
		tm.stop();
	}
	public void resetTime() {
		showJob.setForeground(Color.WHITE);
		showLabel.setForeground(Color.WHITE);
		timeDelay = 0;
		nowTime = 0;
		repaint();
		tm.stop();
	}
}

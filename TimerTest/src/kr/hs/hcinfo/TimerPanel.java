package kr.hs.hcinfo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel showLabel;
	private Timer tm;
	private int timeDelay;
	private String showStr;
	public TimerPanel() {
		// TODO Auto-generated constructor stub
		super();
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
		showLabel.setFont(new Font("±¼¸²", 1, 20));
		add(showLabel);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawTimer();
		
	}
	
	private void drawTimer() {
		// TODO Auto-generated method stub
		showStr = "";
		
		showLabel.setText(showStr);
	}
	public void startTime(){
		tm.setDelay(100);
		tm.start();
	}
	public void pauseTime() {
		// TODO Auto-generated method stub
		tm.stop();
	}
	public void resetTime() {
		timeDelay = 0;
		tm.start();
	}
	
	
	

}

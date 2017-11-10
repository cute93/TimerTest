package kr.hs.hcinfo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private TimerPanel centerPanel;
	private JPanel rightPanel;
	private JButton startButton;
	private JButton pauseButton;
	private JButton restartButton;
	private JButton exitButton;

	
	public TimerFrame(){
		super();
		init();
	}

	public TimerFrame(String string) {
		// TODO Auto-generated constructor stub
		super(string);
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		centerPanel = new TimerPanel();
		
		rightPanel = new JPanel(new GridLayout(4, 1));
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				centerPanel.startTime();
			}
		});
		pauseButton = new JButton("pause");
		pauseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				centerPanel.pauseTime();
			}
		});
		restartButton = new JButton("reset");
		restartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				centerPanel.resetTime();
			}
		});
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	public void display() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(centerPanel);
		
		// Panel.addComponent
		rightPanel.add(startButton);
		rightPanel.add(pauseButton);
		rightPanel.add(restartButton);
		rightPanel.add(exitButton);
		
		add(rightPanel, BorderLayout.EAST);
		
		setSize(350, 150);
		setVisible(true);
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TimerFrame extends JFrame{
	private static final long serialVersionUID = 3974977196233834289L;
	private JLabel label=new JLabel();
	private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Timer timer=new Timer();
	public void launchFrame(){	
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
			
		});
		label.setBounds(140, 180, 200, 10);
		this.add(label);
		timer.schedule(new TimerFrame.TimeTask(), new Date(), 1000);
		this.setVisible(true);
	}

public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TimerFrame frame=new TimerFrame();
				frame.launchFrame();
			}
		});
	}
	
	class TimeTask extends TimerTask{

		@Override
		public void run() {
			Date date=new Date();
			label.setText(format.format(date));
		}
		
	}
}

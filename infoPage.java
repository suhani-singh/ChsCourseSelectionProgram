import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class infoPage extends JFrame{

	final static int WINDOW_WIDTH = 500;
	final static int WINDOW_HEIGHT = 500;
	JButton start;
	JButton info;
	JFrame frame2;
	JButton back;
	Image image = null;
	
	public infoPage() {
		frame2 = new JFrame("CHS Course Selection Program");
		frame2.setLayout(new GridLayout(3, 1));
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set size
		frame2.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
		
		//make label
		String text = "Information Page:" + "<br>" +
	              "Based on the information a Cupertino High School student tells us about them and the goals they have for graduation, we will show them the classes they must take for the next year to complete their requirements.";
		JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		
		frame2.add(label);//adding button in JFrame
		
		//back button
		back =new JButton("Back");//creating instance of JButton  
		back.addActionListener(new choiceListener()); 
		frame2.add(back);//adding button in JFrame
		       
		frame2.setVisible(true);//making the frame visible
	}
	
	private class choiceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				new MainPage();
				frame2.setVisible(false);
			}
		}
	}
	
}

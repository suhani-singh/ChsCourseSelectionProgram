import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class DataGrade extends JFrame{

	final static int WINDOW_WIDTH = 500;
	final static int WINDOW_HEIGHT = 500;
	JButton ask;
	JFrame frame3;
	JFrame frameErrorNoGrade;
	JButton back;
	JButton next;
	Image image = null;
	JRadioButton g9;
	JRadioButton g10;
	JRadioButton g11;
	JRadioButton g12;
	
	public DataGrade() {
		frame3 = new JFrame("CHS Course Selection Program");
		frame3.setLayout(new GridLayout(7, 1));
		frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//set size
		frame3.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
		
		//make label
		String text = "Which grade are you going to in the next year?";
		JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		
		frame3.add(label);//adding button in JFrame
		
		//RadioButtons
		   
		g9=new JRadioButton("Grade 9");   
		g9.addActionListener(new choiceListener());
		g10=new JRadioButton("Grade 10");
		g10.addActionListener(new choiceListener());
		g11=new JRadioButton("Grade 11");    
		g11.addActionListener(new choiceListener());
		g12=new JRadioButton("Grade 12");
		g12.addActionListener(new choiceListener());
		ButtonGroup bg=new ButtonGroup();  
		bg.add(g9);
		bg.add(g10);
		bg.add(g11);
		bg.add(g12);
		frame3.add(g9);
		frame3.add(g10);
		frame3.add(g11);
		frame3.add(g12);
		
		//next button
				next =new JButton("Next");//creating instance of JButton  
				next.addActionListener(new choiceListener()); 
				frame3.add(next);//adding button in JFrame
		
		//back button
		back =new JButton("Back");//creating instance of JButton  
		back.addActionListener(new choiceListener()); 
		frame3.add(back);//adding button in JFrame
		       
		frame3.setVisible(true);//making the frame visible
	}
	
	private class choiceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				new MainPage();
				frame3.setVisible(false);
			}
			if(e.getSource() == next) {
				if (g9.isSelected() == true || g10.isSelected() == true || g11.isSelected() == true || g12.isSelected() == true) {
					new DataGradType();
					frame3.setVisible(false);
				} else {
					//error frame
					frameErrorNoGrade = new JFrame("CHS Course Selection Program");
					frameErrorNoGrade.setLayout(new GridLayout(1, 1));
					frameErrorNoGrade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					//set size
					frameErrorNoGrade.setSize(WINDOW_WIDTH/3, WINDOW_HEIGHT/3);		
					
					//make label
					String text = "Error:" + "<br>" +
				              "You must select a grade!";
					JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
					
					frameErrorNoGrade.add(label);//adding button in JFrame
					frameErrorNoGrade.setVisible(true);//making the frame visible
				}
			}
		}
	}

}

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class DataGradType extends JFrame{

	final static int WINDOW_WIDTH = 500;
	final static int WINDOW_HEIGHT = 500;
	JButton ask;
	JFrame frame4;
	JFrame frameErrorNoGradType;
	JFrame frameImage;
	JButton wit;	
	JButton back;
	JRadioButton gradFuhsd;    
	JRadioButton gradUcCsu;
	JRadioButton gradBoth; 

	JButton next;
	Image image = null;
	
	public DataGradType() {
		frame4 = new JFrame("CHS Course Selection Program");
		frame4.setLayout(new GridLayout(7, 1));
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set size
		frame4.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);		
		
		//make label
		String text = "Which type of graduation are you looking to complete?";
		JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		
		frame4.add(label);//adding button in JFrame
		
		//RadioButtons
		   
		gradFuhsd=new JRadioButton("FUHSD Graduation");    
		gradUcCsu=new JRadioButton("UC/CSU A-G Requirements");
		gradBoth=new JRadioButton("Both");    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(gradFuhsd);
		bg.add(gradUcCsu);
		bg.add(gradBoth);
		gradFuhsd.addActionListener(new choiceListener());
		gradUcCsu.addActionListener(new choiceListener());
		gradBoth.addActionListener(new choiceListener());
		frame4.add(gradFuhsd);
		frame4.add(gradUcCsu);
		frame4.add(gradBoth);
		
		//what is this button
		wit =new JButton("What are each of their requirements?");//creating instance of JButton  
		wit.addActionListener(new choiceListener()); 
		frame4.add(wit);//adding button in JFrame
		
		//next button
		next =new JButton("Next");//creating instance of JButton  
		next.addActionListener(new choiceListener()); 
		frame4.add(next);//adding button in JFrame
		
		//back button
		back =new JButton("Back");//creating instance of JButton  
		back.addActionListener(new choiceListener()); 
		frame4.add(back);//adding button in JFrame
		       
		frame4.setVisible(true);//making the frame visible
	}
	
	private class choiceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				new DataGrade();
				frame4.setVisible(false);
			}
			if(e.getSource() == next) {
				if (gradFuhsd.isSelected() == true || gradUcCsu.isSelected() == true || gradBoth.isSelected() == true) {
					new DataClasses();
					frame4.setVisible(false);
				} else {
					//error frame
					frameErrorNoGradType = new JFrame("CHS Course Selection Program");
					frameErrorNoGradType.setLayout(new GridLayout(1, 1));
					frameErrorNoGradType.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					//set size
					frameErrorNoGradType.setSize(WINDOW_WIDTH/2, WINDOW_HEIGHT/3);		
					
					//make label
					String text = "Error:" + "<br>" +
				              "You must select a Graduation Type!";
					JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
					
					frameErrorNoGradType.add(label);//adding button in JFrame
					frameErrorNoGradType.setVisible(true);//making the frame visible
				}
			}
			if(e.getSource() == wit) { //create image frame
				frameImage = new JFrame("CHS Course Selection Program");
				frameImage.setLayout(new GridLayout(2, 1));
				frameImage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//set size
				frameImage.setSize(WINDOW_WIDTH/2, WINDOW_HEIGHT/3);		
				
				//make label
				String text = "Here is the info:";
				JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
				frameImage.add(label);//adding button in JFrame
				
				JLabel labelImg = new JLabel("");
				ImageIcon logo = new ImageIcon(("src\\gradReqs.jpg"));
				Image image = logo.getImage();
				image = image.getScaledInstance(500/3, 500/3, Image.SCALE_SMOOTH);
				ImageIcon pic = new ImageIcon(image);
				labelImg.setIcon(pic);
				
				labelImg.setBackground(Color.WHITE);
				labelImg.setOpaque(true);
				frameImage.add(labelImg);
				
				frameImage.setVisible(true);//making the frame visible
			}
		}
	}

}

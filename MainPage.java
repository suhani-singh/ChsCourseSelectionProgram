import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MainPage extends JFrame{

	final static int WINDOW_WIDTH = 500;
	final static int WINDOW_HEIGHT = 500;
	JButton start;
	JButton info;
	JFrame frame1;
	JButton a;
	JButton b;
	Image image = null;
	
	public MainPage() {
		frame1 = new JFrame("CHS Course Selection Program");
		frame1.setLayout(new GridLayout(3, 1));
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set size
		frame1.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		/*//logo
		JPanel topRight = new JPanel(new GridLayout(1,3));

		try {
			BufferedImage icon = ImageIO.read(new File ("C:\\Suhani\\eclipse\\eclipse\\eclipse-workspace\\ChsCourseSelectionProgram\\src\\logo.jpg") );
			ImageIcon logo = new ImageIcon(icon);
			JLabel img = new JLabel(logo);
			//img.setIcon(logo);
			//topRight.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			topRight.add(img);
			System.out.print("hi");
			frame1.add(topRight);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//ImageIcon imageLogo = new ImageIcon("logo.jpg");
		//frame1.add(imageLogo);
		
		JLabel label = new JLabel("");
		ImageIcon logo = new ImageIcon(("src\\logo.jpg"));
		Image image = logo.getImage();
		image = image.getScaledInstance(500/3, 500/3, Image.SCALE_SMOOTH);
		ImageIcon pic = new ImageIcon(image);
		label.setIcon(pic);
		
		label.setBackground(Color.WHITE);
		label.setOpaque(true);
		frame1.add(label);
		
		//start button
		
		a =new JButton("Start");//creating instance of JButton  
		       
		frame1.add(a);//adding button in JFrame
		          
		b=new JButton("Instructions");//creating instance of JButton  
		          
		frame1.add(b, BorderLayout.CENTER);//adding button in JFrame  
		b.addActionListener(new choiceListener());          
		frame1.setVisible(true);//making the frame visible
	}
	
	private class choiceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b) {
				frame1.setVisible(false);//making the frame visible
				new infoPage();
			}
		}
	}
	
	public static void main(String[] args) {
		new MainPage();
	} 

}

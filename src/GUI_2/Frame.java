package GUI_2;
import java.awt.EventQueue;
import sun.audio.*;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Frame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 28));
		frame.setBounds(100, 100, 788, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add Files");
		Image img=new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnAdd.setIcon(new ImageIcon(img));
		btnAdd.setForeground(new Color(128, 0, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				Add add2=new Add();
				add2.setVisible(true);
				
			}
		});
		
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
		btnAdd.setBounds(50, 167, 176, 100);
		frame.getContentPane().add(btnAdd);
		
		JButton btnClearAll = new JButton("Clear Data");
		Image img2=new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		btnClearAll.setIcon(new ImageIcon(img2));
		btnClearAll.setFont(new Font("Arial", Font.BOLD, 20));
		btnClearAll.setForeground(new Color(128, 0, 0));
		btnClearAll.setBackground(new Color(255, 255, 255));
		btnClearAll.setBounds(269, 167, 176, 100);
		frame.getContentPane().add(btnClearAll);
		
		JButton btnCreatKml = new JButton("Create KML");
		Image img3=new ImageIcon(this.getClass().getResource("/kml.png")).getImage();
		btnCreatKml.setIcon(new ImageIcon(img3));
		btnCreatKml.setFont(new Font("Arial", Font.BOLD, 20));
		btnCreatKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreatKml.setForeground(new Color(128, 0, 0));
		btnCreatKml.setBackground(new Color(255, 255, 255));
		btnCreatKml.setBounds(500, 167, 176, 100);
		frame.getContentPane().add(btnCreatKml);
		
		JButton btnRestore = new JButton("Restore Data");
		Image img4=new ImageIcon(this.getClass().getResource("/restore.png")).getImage();
		btnRestore.setIcon(new ImageIcon(img4));
		btnRestore.setForeground(new Color(128, 0, 0));
//		btnRestore.setHorizontalTextPosition(SwingContants.CENTER);
		btnRestore.setFont(new Font("Arial", Font.BOLD, 20));
		btnRestore.setBackground(new Color(255, 255, 255));
		btnRestore.setBounds(500, 312, 176, 100);
		frame.getContentPane().add(btnRestore);
		
		JButton btnSaveAsMerge = new JButton("Save As CSV");
		Image img5=new ImageIcon(this.getClass().getResource("/csv.png")).getImage();
		btnSaveAsMerge.setIcon(new ImageIcon(img5));
		btnSaveAsMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveAsMerge.setFont(new Font("Arial", Font.BOLD, 20));
		btnSaveAsMerge.setForeground(new Color(128, 0, 0));
		btnSaveAsMerge.setBackground(new Color(255, 255, 255));
		btnSaveAsMerge.setBounds(269, 312, 176, 100);
		frame.getContentPane().add(btnSaveAsMerge);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FilterChoice filt=new FilterChoice();
				filt.setVisible(true);	
			}
		});
		Image img6=new ImageIcon(this.getClass().getResource("/filter.png")).getImage();
		btnFilter.setIcon(new ImageIcon(img6));
		btnFilter.setFont(new Font("Arial", Font.BOLD, 20));
		btnFilter.setForeground(new Color(128, 0, 0));
		btnFilter.setBackground(new Color(255, 255, 255));
		btnFilter.setBounds(50, 312, 176, 100);
		frame.getContentPane().add(btnFilter);
		
		JLabel label = new JLabel("");
		Image img7=new ImageIcon(this.getClass().getResource("/database.png")).getImage();
		label.setIcon(new ImageIcon(img7));
		label.setBounds(285, 8, 176, 149);
		frame.getContentPane().add(label);
	}
}

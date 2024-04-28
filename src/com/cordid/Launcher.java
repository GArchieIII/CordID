package com.cordid;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Launcher {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
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
	public Launcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(254, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setBackground(new Color(64, 64, 64));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSelectImage = new JButton("Select Cord Image");
		btnSelectImage.setBackground(new Color(0, 0, 0));
		btnSelectImage.setBounds(168, 204, 138, 29);
		frame.getContentPane().add(btnSelectImage);
		
		btnSelectImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				
				int response = fileChooser.showOpenDialog(null);
				
				if(response == JFileChooser.APPROVE_OPTION) {
					
					File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
					System.out.print(file);
					
							try {
						imagePasser(file.toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
							CordDes mydes = new CordDes("ETHERNET");
							mydes.Show();	
					
					
					
					
					
				}
				
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("Cord Identifier");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Buster\\Downloads\\CordIDApp\\CordIDApp\\CordID\\audio.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(44, 44, 296, 148);
		frame.getContentPane().add(lblNewLabel);
	}
	
	//method that passes params to model exe 
	public String imagePasser(String myFile) throws Exception {
		Process process = new ProcessBuilder("C:\\Users\\Buster\\Downloads\\CordIDApp\\CordIDApp\\CordID\\710 Tensor4 (1).exe",myFile).start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		BufferedReader brs = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String lines = null;
		
		while((lines=br.readLine())!=null) {
				System.out.println("lines"+lines);
				
			
		}
		while((lines = brs.readLine())!=null) {
			
			System.out.println("Error Lines"+lines);
			
		}
		
		return lines;
	}
}

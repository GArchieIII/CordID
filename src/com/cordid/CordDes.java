package com.cordid;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class CordDes {

	private JFrame frame2;
	private JTextArea lblCordID,lblCordCreator,lblCordUtilities;
	private JLabel cordImage;
	private String cordIdentifier;
	
	//HDMI
	
	Cord hdmi = new Cord("/Users/garlandarchie/eclipse-workspace/CordID/hdmi.png","HDMI (High-Definition Multi-Media Interface) cable",
			"HDMI Licensing Administrator, Inc. (a consortium of companies including Sony, Panasonic, Toshiba, Philips, and others)",
			"Used to transmit high-definition audio and video signals between devices such as TVs, monitors, computers, gaming consoles, and a selection of other devices.");
	   
	   
	//AUDIO
	
	Cord audio = new Cord("/Users/garlandarchie/eclipse-workspace/CordID/audio.png","3.5mm audio jack (also known as a headphone jack or TRS connector)"
			,"The concept of audio connectors dates back to the late 19th century, with various inventors and manufacturers contributing to their development over time. However, the 3.5mm audio jack as we know it today has evolved over the years, and its invention cannot be attributed to a single individual."
			,"Audio jacks are used for connecting headphones, speakers, microphones, and other audio equipment to devices such as smartphones, tablets, laptops, and audio players.");
	//USBA
	
	Cord usbA = new Cord("/Users/garlandarchie/eclipse-workspace/CordID/usba.png","USB (Universal Serial Bus) Type-A cable",
			"USB Implementers Forum (USB-IF)",
			"USB-A cables are widely used for connecting various peripherals, such as keyboards, mice, printers, external hard drives, and more, to computers and other devices.");
	
	//USBC
	
	Cord usbC = new Cord("/Users/garlandarchie/eclipse-workspace/CordID/usbc.png","USB Type-C cable",
			"USB Implementers Forum (USB-IF)",
			"USB-C cables are a newer standard of USB cables designed for faster data transfer rates, higher power delivery, and reversible connectors. They are used for charging smartphones, laptops, tablets, and connecting peripherals.");
	//Ethernet
	
	Cord ethernet = new Cord("/Users/garlandarchie/git/repository/CordID/ethernet.png","Ethernet cable (usually categorized by the type of twisted-pair cable used, such as Cat5, Cat6, etc.)",
			"Robert Metcalfe and David Boggs (at Xerox PARC in the 1970s)",
			"Ethernet cables are used to connect devices in a local area network (LAN) to enable data transmission between devices, such as computers, routers, switches, and network-attached devices.");
	
	//ELECTRICAL
	
	Cord electrical = new Cord("/Users/garlandarchie/eclipse-workspace/CordID/electrical.png","Power cable (various types exist, such as AC power cables, DC power cables, etc.)",
			"Electricity has been harnessed and used by humans for various purposes for centuries, so it's challenging to attribute a specific creator.",
			"Electrical cables are used to transmit electrical power from a power source (such as a wall outlet) to electrical devices and appliances, providing the necessary energy for operation.");
	
	

	public CordDes(String imstr) {
		System.out.println("string"+imstr);
		initialize(imstr);
	}

	private void initialize(String data) {
		frame2 = new JFrame();
		frame2.setBackground(new Color(30, 144, 255));
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(177, 6, 253, 260);
		frame2.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		scrollPane.setViewportView(panel);
		
		
		lblCordID = new JTextArea("Cord Name:");
		lblCordID.setBounds(6, 6, 222, 43);
		lblCordID.setEditable(false);
		lblCordID.setLineWrap(true);
		lblCordID.setWrapStyleWord(true);
		panel.add(lblCordID);
		
		lblCordCreator = new JTextArea("Creator:");
		lblCordCreator.setBounds(6, 61, 222, 47);
		lblCordCreator.setEditable(false);
		lblCordCreator.setLineWrap(true);
		lblCordCreator.setWrapStyleWord(true);
		panel.add(lblCordCreator);
		
		lblCordUtilities = new JTextArea("Cord Utilities");
		lblCordUtilities.setColumns(50);
		lblCordUtilities.setRows(50);
		lblCordUtilities.setBounds(6, 120, 222, 137);
		lblCordUtilities.setLineWrap(true);
		lblCordUtilities.setEditable(false);
		lblCordUtilities.setWrapStyleWord(true);
		panel.add(lblCordUtilities);
		
		cordImage = new JLabel("New label");
		cordImage.setBounds(23, 6, 118, 214);
		cordImage.setIcon(new ImageIcon("/Users/garlandarchie/eclipse-workspace/CordID/electrical.png"));
		frame2.getContentPane().add(cordImage);
		// Implement  
		System.out.println(data);
		DisplayCordDes(data);
	}
	
	private void DisplayCordDes(String cord) {
		
		switch(cord) {

		case "ETHERNET":
			
			lblCordID.setText(cord);
			lblCordCreator.setText(ethernet.cordCreator);
			lblCordUtilities.setText(ethernet.cordUtilities);
			cordImage.setIcon(scaleImage(ethernet.cordIcon));
			
			break;
			
		case "HDMI":
			lblCordID.setText(hdmi.cordName);
			lblCordCreator.setText(hdmi.cordCreator);
			lblCordUtilities.setText(hdmi.cordUtilities);
			cordImage.setIcon(scaleImage(hdmi.cordIcon));
			
			break;
			
		case "USB A":
			lblCordID.setText(usbA.cordName);
			lblCordCreator.setText(usbA.cordCreator);
			lblCordUtilities.setText(usbA.cordUtilities);
			cordImage.setIcon(scaleImage(usbA.cordIcon));
			
			break;
			
		case "USB C":
			lblCordID.setText(usbC.cordName);
			lblCordCreator.setText(usbC.cordCreator);
			lblCordUtilities.setText(usbC.cordUtilities);
			cordImage.setIcon(scaleImage(usbC.cordIcon));
			
			break;
			
		case "ELECTRICAL":
			lblCordID.setText(electrical.cordName);
			lblCordCreator.setText(electrical.cordCreator);
			lblCordUtilities.setText(electrical.cordUtilities);
			cordImage.setIcon(scaleImage(electrical.cordIcon));
			
			break;
			
		case "Audio":
			lblCordID.setText(audio.cordName);
			lblCordCreator.setText(audio.cordCreator);
			lblCordUtilities.setText(audio.cordUtilities);
			cordImage.setIcon(scaleImage(audio.cordIcon));
			
			
			break;
			
		default:
			
			lblCordID.setText("Cord ID: Unidentified");
			lblCordCreator.setText("Creator: Unidentified");
			lblCordUtilities.setText("Cord Utilities: Unidentified");
			cordImage.setText("No Image");
			break;
				
				
			
			
			
			
		}
		
	}
	
	public void Show() {
		frame2.setVisible(true);
	}
	
	private ImageIcon scaleImage(String imageStr) {
		
		ImageIcon imageIcon = new ImageIcon(imageStr); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		
		return imageIcon;
		
		
	}
}

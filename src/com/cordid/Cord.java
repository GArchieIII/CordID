package com.cordid;

public class Cord {
	
	String cordIcon;
	String cordName;
	String cordCreator; 
	String cordUtilities;
	
	public Cord() {
		cordIcon ="";
		cordName ="Rj45";
		cordCreator = "IDK";
		cordUtilities ="Well.....";
	}
	
	
	public Cord(String cordIcon,String cordName,String cordCreator,String cordUtilities) {
		 this.cordIcon = cordIcon;
		 this.cordName = cordName;
		 this.cordCreator = cordCreator;
		this.cordUtilities = cordUtilities;
		
	}
	

}

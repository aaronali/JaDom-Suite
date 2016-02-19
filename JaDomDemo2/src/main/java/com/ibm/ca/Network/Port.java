package com.ibm.ca.Network;

public class Port {
 
	private int number;
	
	
	public Port(int address){
		if(address<0)
			throw new RuntimeException("Invalid Port Assignment"); 
		this.number = address;
	}
	
	public int getPort(){
		return this.number;
	}
	
	public void setPort(int address){
		if(address>0)
			this.number =address;
		else
			throw new RuntimeException("Invalid port Assignmet");
	}
	
	@Override
	public String toString(){
		return String.valueOf(number);
	}
}

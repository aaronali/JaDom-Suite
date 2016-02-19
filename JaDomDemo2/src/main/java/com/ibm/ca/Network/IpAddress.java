package com.ibm.ca.Network;

public class IpAddress {

	String[] ipAddress = new String[4];
	Port port =null;
	
	public IpAddress(String address){
		String[] vals = new String[4];
		vals = address.split("\\."); 
		for(int i=0; i<4; i++){
			String s=vals[i]; 
			if(s.length()!=3 || !isInteger(s.trim()))
				throw new RuntimeException("Invalid ip address  (xxx.xxx.xxx.xxx) : "+address);
			if(Integer.valueOf(s)<0||Integer.valueOf(s)>255){
				throw new RuntimeException("Invalid ip address range detected");
			}
			ipAddress[i] = s;
		}
	}
	
	public IpAddress(String address, int portNumber){
		this(address);
		port = new Port(portNumber);
	}
	
	
	public static boolean isInteger(String s) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),10) < 0) return false;
	    }
	    return true;
	}
	
	@Override
	public String toString(){
		return String.valueOf(ipAddress[0]).concat(".").concat(String.valueOf(ipAddress[1])).concat(".").concat(String.valueOf(ipAddress[2])
				+((port!=null)? ":".concat(port.toString()):""));
	}
}

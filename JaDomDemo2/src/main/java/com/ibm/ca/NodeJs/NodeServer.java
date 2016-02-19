package com.ibm.ca.NodeJs;

import com.ibm.ca.Network.IpAddress;
import com.ibm.ca.Network.Port;

public class NodeServer {

	private String serverName;
	private Port port;
	private IpAddress ipEndPoint;
	
	private String severCreate ="var http = require('http');\n"+
				"      var %s =http.createServer(function handler(req, res) {"+
				"           res.writeHead(200, {'Content-Type': 'text/plain'});"+
				"           res.end('Hello World\n');"+
				"      }).listen(%s, %s);";
	
	public NodeServer(String servername,  String ipEndPoint, int portNumber){
		this.serverName = servername; 
		this.ipEndPoint = new IpAddress(ipEndPoint, portNumber);
	}
	
	
	public String creationScript(){
		return this.severCreate = String.format(this.severCreate, this.serverName, this.ipEndPoint, this.port.toString());
	}
	
	public String startScript(){
		 
	}
}
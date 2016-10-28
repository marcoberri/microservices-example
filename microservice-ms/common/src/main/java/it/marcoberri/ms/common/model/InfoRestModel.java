package it.marcoberri.ms.common.model;

import java.util.Date;

public class InfoRestModel {

	private int port;
	private String serviceName;
	private Date ts = new Date();
	
	public InfoRestModel( String serviceName,int port) {
		super();
		this.port = port;
		this.serviceName = serviceName;
	
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	
}

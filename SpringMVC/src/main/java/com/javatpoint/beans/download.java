package com.javatpoint.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class download {
	private int id;
	private String yt_link, user_ip;
	private Date dat = new Date();
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	private String date = dateFormat.format(dat);
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYt_link() {
		return yt_link;
	}
	public void setYt_link(String yt_link) {
		this.yt_link = yt_link;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	
}

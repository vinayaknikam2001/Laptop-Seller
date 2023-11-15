package com.laptop.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String ramAvailable;
	private String osName;
	private String webcam;
	private int price;
	
	public Laptop() {
		
	}

	
	public Laptop(String name, String ramAvailable, String osName, String webcam, int price) {
		
		this.name = name;
		this.ramAvailable = ramAvailable;
		this.osName = osName;
		this.webcam = webcam;
		this.price = price;
	}

	public Laptop(int id, String name, String ramAvailable, String osName, String webcam, int price) {
		
		this.id = id;
		this.name = name;
		this.ramAvailable = ramAvailable;
		this.osName = osName;
		this.webcam = webcam;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRamAvailable() {
		return ramAvailable;
	}

	public void setRamAvailable(String ramAvailable) {
		this.ramAvailable = ramAvailable;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getWebcam() {
		return webcam;
	}

	public void setWebcam(String webcam) {
		this.webcam = webcam;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

package com.laptop.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

public class LaptopDto {

	
	@NotEmpty(message = "Name should not be Empty")
	private String name;
	
	private String ramAvailable;
	
	@NotEmpty(message = "Name should not be Empty")
	private String osName;
	
	
	private String webcam;
	
	@Min(20000)
	private int price;
	
	public LaptopDto() {

	}

	

	public LaptopDto(String name, String ramAvailable, String osName, String webcam, int price) {
		
		this.name = name;
		this.ramAvailable = ramAvailable;
		this.osName = osName;
		this.webcam = webcam;
		this.price = price;
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
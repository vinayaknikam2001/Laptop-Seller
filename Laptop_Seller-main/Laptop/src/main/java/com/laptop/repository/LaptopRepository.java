package com.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptop.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{
	
	List<Laptop> findByName(String name);
	
	List<Laptop> findByRamAvailable(String ramAvaliable);
	
	List<Laptop> findByOsName(String osName);
	
	List<Laptop> findByWebcam(String webCam);
	
	List<Laptop> findByPrice(int price);
	
	List<Laptop> findByPriceGreaterThan(int price);
	
	List<Laptop> findByNameAndPrice(String name , int price);
	
	List<Laptop> findByRamAvailableAndOsNameAndPrice(String ramAvailable,String osName,int price);
	
	List<Laptop> findByNameStartsWith(String name);
	
	List<Laptop> findByNameLike(String name);
	
	List<Laptop> findByNameEndsWith(String name);
}

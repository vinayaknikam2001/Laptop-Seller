package com.laptop.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.dto.LaptopDto;
import com.laptop.entity.Laptop;
import com.laptop.exception.LaptopNotFoundException;
import com.laptop.repository.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;
	
//	public Laptop addLaptop(Laptop laptop) {
//		return laptopRepository.save(laptop);
//	}
	
	public Laptop addLaptop(LaptopDto laptopDto) {
		Laptop laptopSave =  new Laptop();
		laptopSave.setName(laptopDto.getName());
		laptopSave.setOsName(laptopDto.getOsName());
		laptopSave.setPrice(laptopDto.getPrice());
		laptopSave.setRamAvailable(laptopDto.getRamAvailable());
		laptopSave.setWebcam(laptopDto.getWebcam());
		
		return laptopRepository.save(laptopSave);
	}
	
	

	public Laptop updateLaptop(LaptopDto laptopDto,int id) {
			
		Laptop laptopSave =  laptopRepository.findById(id).get();
		laptopSave.setName(laptopDto.getName());
		laptopSave.setOsName(laptopDto.getOsName());
		laptopSave.setPrice(laptopDto.getPrice());
		laptopSave.setRamAvailable(laptopDto.getRamAvailable());
		laptopSave.setWebcam(laptopDto.getWebcam());
		
		return laptopRepository.save(laptopSave);
	}
	
	
	public String deleteLaptop(int id) {
		
		laptopRepository.deleteById(id);
		
		return id+"is Deleted";
	}
	
	
	public Laptop getLaptop(int id) throws LaptopNotFoundException{
		
//		Optional<Laptop> laptop = laptopRepository.findById(id).ifPresentOrElse(()->{return },());; 
		try {
			return laptopRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new LaptopNotFoundException("This laptop is not present");
		}

	}
	
	public List<Laptop> getAllLaptop() {
		return laptopRepository.findAll();
	}
	

	public List<Laptop> getLaptopByName(String name) throws LaptopNotFoundException {
		if(laptopRepository.findByName(name)==null || laptopRepository.findByName(name).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByName(name);
		}
		
	}
	

	public List<Laptop> getLaptopByOsName(String osName) throws LaptopNotFoundException{
		
		if(laptopRepository.findByOsName(osName)==null || laptopRepository.findByOsName(osName).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByOsName(osName);
		}
	}
	

	public List<Laptop> getLaptopByWebcam(String webCam) throws LaptopNotFoundException{
		
		if(laptopRepository.findByWebcam(webCam)==null || laptopRepository.findByWebcam(webCam).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByWebcam(webCam);
		}
	}

	public List<Laptop> getLaptopByRamAvaliable(String ramAvaliable) throws LaptopNotFoundException{
		
		if(laptopRepository.findByRamAvailable(ramAvaliable)==null || laptopRepository.findByRamAvailable(ramAvaliable).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByRamAvailable(ramAvaliable);
		}
	}
	
	public List<Laptop> getLaptopByPrice(int price) throws LaptopNotFoundException{
		
		if(laptopRepository.findByPrice(price)==null || laptopRepository.findByPrice(price).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByPrice(price);
		}
	}
	
	public List<Laptop> getLaptopByPriceGreater(int price) throws LaptopNotFoundException{
		
		if(laptopRepository.findByPriceGreaterThan(price)==null || laptopRepository.findByPriceGreaterThan(price).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByPriceGreaterThan(price);
		}
	}
	
	public List<Laptop> getLaptopByNameAndPrice(String name,int price) throws LaptopNotFoundException{
		
		if(laptopRepository.findByNameAndPrice(name,price).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByNameAndPrice(name,price);
		}
	}
	
	public List<Laptop> getLaptopByRamAvailableAndOsNameAndPrice(String ramAvaliable,String osName,int price) throws LaptopNotFoundException{
		
		if(laptopRepository.findByRamAvailableAndOsNameAndPrice(ramAvaliable,osName,price).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByRamAvailableAndOsNameAndPrice(ramAvaliable,osName,price);
		}
	}
	
	public List<Laptop> getLaptopByNameStartsWith(String name) throws LaptopNotFoundException{
		
		if(laptopRepository.findByNameStartsWith(name).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByNameStartsWith(name);
		}
	}
	
	public List<Laptop> getLaptopByNameEndsWith(String name) throws LaptopNotFoundException{
		
		if(laptopRepository.findByNameEndsWith(name).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByNameEndsWith(name);
		}
	}
	
	public List<Laptop> getLaptopByNameBetween(String name) throws LaptopNotFoundException{
		name = "%"+name+"%";
		if(laptopRepository.findByNameLike(name).isEmpty()){
			throw new LaptopNotFoundException("This laptop is not present");
		}else {
			return laptopRepository.findByNameLike(name);
		}
	}
}

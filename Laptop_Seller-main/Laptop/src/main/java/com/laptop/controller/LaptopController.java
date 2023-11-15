package com.laptop.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.dto.LaptopDto;
import com.laptop.entity.Laptop;
import com.laptop.exception.LaptopNotFoundException;
import com.laptop.services.LaptopService;

@CrossOrigin
@RestController
@RequestMapping("/laptop")
public class LaptopController {

	@Autowired
	LaptopService laptopService;
	

//	@PostMapping
//	public ResponseEntity<Laptop>  addLaptop(@RequestBody Laptop laptop) {
//		return new ResponseEntity<>(laptopService.addLaptop(laptop),HttpStatus.CREATED);
//	}
//	
	@PostMapping
	public ResponseEntity<Laptop>  addLaptop(@RequestBody @Valid LaptopDto laptop) {
		return new ResponseEntity<>(laptopService.addLaptop(laptop),HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Laptop> updateLaptop(@RequestBody @Valid LaptopDto laptop,@PathVariable int  id )  throws EmptyResultDataAccessException{
//		return laptopService.updateLaptop(laptop,id);
		return new ResponseEntity<>(laptopService.updateLaptop(laptop,id),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLaptop(@PathVariable int id) throws EmptyResultDataAccessException {
		return new ResponseEntity<>(laptopService.deleteLaptop(id),HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Laptop>> getAllLaptop() {
		return new ResponseEntity<>(laptopService.getAllLaptop(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable int id) throws LaptopNotFoundException{
		  return ResponseEntity.ok(laptopService.getLaptop(id));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Laptop>>   getLaptopByName(@PathVariable String name) throws LaptopNotFoundException {
//		return laptopService.getLaptopByName(name);
		return new ResponseEntity<>(laptopService.getLaptopByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/startWithname/{name}")
	public ResponseEntity<List<Laptop>>   getLaptopByNameStartsWith(@PathVariable String name) throws LaptopNotFoundException {
//		return laptopService.getLaptopByName(name);
		return new ResponseEntity<>(laptopService.getLaptopByNameStartsWith(name),HttpStatus.OK);
	}
	
	@GetMapping("/betweenname/{name}")
	public ResponseEntity<List<Laptop>>   getLaptopByNameBetween(@PathVariable String name) throws LaptopNotFoundException {
//		return laptopService.getLaptopByName(name);
		return new ResponseEntity<>(laptopService.getLaptopByNameBetween(name),HttpStatus.OK);
	}
	
	
	@GetMapping("/endWithname/{name}")
	public ResponseEntity<List<Laptop>>   getLaptopByNameEndsWith(@PathVariable String name) throws LaptopNotFoundException {
//		return laptopService.getLaptopByName(name);
		return new ResponseEntity<>(laptopService.getLaptopByNameEndsWith(name),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/ramAvailable/{ramAvailable}")
	public ResponseEntity<List<Laptop>> getLaptopByRam(@PathVariable String ramAvailable) throws LaptopNotFoundException{
//		return laptopService.getLaptopByRamAvaliable(ramAvailable);
		return new ResponseEntity<>(laptopService.getLaptopByRamAvaliable(ramAvailable),HttpStatus.OK);
	}
	
	@GetMapping("/webcam/{webcam}")
	public ResponseEntity<List<Laptop>> getLaptopByWebCam(@PathVariable String webcam) throws LaptopNotFoundException{
//		return laptopService.getLaptopByWebcam(webcam);
		return new ResponseEntity<>(laptopService.getLaptopByWebcam(webcam),HttpStatus.OK);
	}
	
	@GetMapping("/price/{price}")
	public ResponseEntity<List<Laptop>> getLaptopByPrice(@PathVariable int price) throws LaptopNotFoundException {
//		return laptopService.getLaptopByPrice(price);
		return new ResponseEntity<>( laptopService.getLaptopByPrice(price),HttpStatus.OK);
	}
	
	@GetMapping("/osName/{osName}")
	public ResponseEntity<List<Laptop>> getLaptopByPrice(@PathVariable String osName) throws LaptopNotFoundException {
//		return laptopService.getLaptopByOsName(osName);
		return new ResponseEntity<>( laptopService.getLaptopByOsName(osName),HttpStatus.OK);
	}
	
	@GetMapping("/price/custom/{price}")
	public ResponseEntity<List<Laptop>> getLaptopByPriceGreater(@PathVariable int price) throws LaptopNotFoundException {
//		return laptopService.getLaptopByPriceGreater(price);
		return new ResponseEntity<>( laptopService.getLaptopByPriceGreater(price),HttpStatus.OK);
	}

	@GetMapping("/name/price/{name}/{price}")
	public ResponseEntity<List<Laptop>> getLaptopByNameAndPrice(@PathVariable String name,@PathVariable int price) throws LaptopNotFoundException {
//		return laptopService.getLaptopByPriceGreater(price);
		return new ResponseEntity<>( laptopService.getLaptopByNameAndPrice(name,price),HttpStatus.OK);
	}
	
	@GetMapping("/ramAvailable/osName/price/{ramAvailable}/{osName}/{price}")
	public ResponseEntity<List<Laptop>> getLaptopByRamAvailableAndOsNameAndPrice(@PathVariable String ramAvailable,@PathVariable String osName,@PathVariable int price) throws LaptopNotFoundException {
//		return laptopService.getLaptopByPriceGreater(price);
		return new ResponseEntity<>( laptopService.getLaptopByRamAvailableAndOsNameAndPrice(ramAvailable,osName,price),HttpStatus.OK);
	}
	
	
}

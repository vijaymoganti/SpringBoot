package com.vijay.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.vijay.boot.model.Shipwreck;
import com.vijay.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckRepository.saveAndFlush(shipwreck);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		return shipwreckRepository.findOne(id);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){
		Shipwreck exitingRepository = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, exitingRepository);
		return shipwreckRepository.saveAndFlush(exitingRepository);
		
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		Shipwreck exitingRepository = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(exitingRepository);
		return exitingRepository;
	}
	
	

}

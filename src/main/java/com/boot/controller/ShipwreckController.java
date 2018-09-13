package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.service.CounterService;
import com.boot.repository.ShipwreckRepository;


@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepository shipwreckRepository ;
	
	@Autowired
	private CounterService counterService ;
	
    
	@RequestMapping(value = "shipwrecks" ,method = RequestMethod.GET)
	public List<Shipwreck> list()
	{
		return shipwreckRepository.findAll();
		
	}
	
	@RequestMapping(value = "shipwrecks" ,method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck)
	{  
		
		shipwreck.setid(counterService.getNextSequence("ship_count"));
		return shipwreckRepository.save(shipwreck);
				
	} 
	
	@RequestMapping(value = "shipwrecks/{id}" ,method = RequestMethod.GET)
	public Shipwreck get(@PathVariable long id)
	{
		return shipwreckRepository.findBy_id(id);
	}
	
	@RequestMapping(value = "shipwrecks/{id}" ,method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable long id,  @RequestBody Shipwreck shipwreck)
	{
		Shipwreck existingShipwreck = shipwreckRepository.findBy_id(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckRepository.save(existingShipwreck);
	}
	
	
	
}

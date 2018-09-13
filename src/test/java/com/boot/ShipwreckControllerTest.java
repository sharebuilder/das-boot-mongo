package com.boot;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShipwreckControllerTest {
	
	// This is what we test.
	@InjectMocks
	private ShipwreckController sc;
	
	//This is the dependency to what we are testing.
	@Mock
	private ShipwreckRepository  shipwreckRepository ;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void shipwreckGet()
	{
		Shipwreck sw = new Shipwreck();
		sw.setid(1l);
		
		when(shipwreckRepository.findBy_id(1l)).thenReturn(sw);
		
		Shipwreck ship = sc.get(1L);
		
		verify(shipwreckRepository).findBy_id(1l);
		//assertEquals(1l, ship.getId().longValue());
		
		assertThat(ship.getid(),is(1L));
	
	}

}

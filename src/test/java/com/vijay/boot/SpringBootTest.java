package com.vijay.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vijay.boot.controller.ShipwreckController;
import com.vijay.boot.model.Shipwreck;
import com.vijay.boot.repository.ShipwreckRepository;

public class SpringBootTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository sr;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet(){
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		when(sr.findOne(1l)).thenReturn(sw);
		
		Shipwreck w = sc.get(1l);
		verify(sr).findOne(1l);
		//assertEquals(1l, w.getId().longValue());
		assertThat(w.getId(), is(1l));
	}

}

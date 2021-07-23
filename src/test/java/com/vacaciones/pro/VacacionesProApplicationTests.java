package com.vacaciones.pro;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.vacaciones.pro.dl.dto.RequestDTO;

@SpringBootTest
class VacacionesProApplicationTests {

	@Test
	void shouldReturn2() {
		
		RequestDTO solicitud = new RequestDTO();
		Date begin = new Date(2021,7,22);
		Date end = new Date(2021,7,24);
		solicitud.setRequestDayBegin(begin);
		solicitud.setRequestDayEnd(end);
		
		Assertions.assertEquals(2,solicitud.getQtyDias());
	}
	
	@Test
	void shouldNotReturn2() {
		
		RequestDTO solicitud = new RequestDTO();
		Date begin = new Date(2021,7,22);
		Date end = new Date(2021,8,24);
		solicitud.setRequestDayBegin(begin);
		solicitud.setRequestDayEnd(end);
		
		Assertions.assertNotEquals(2,solicitud.getQtyDias());
	}

}

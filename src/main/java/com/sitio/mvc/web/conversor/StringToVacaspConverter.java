package com.sitio.mvc.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sitio.mvc.domain.Vacasp;
import com.sitio.mvc.service.VacaspService;

@Component
public class StringToVacaspConverter implements Converter<String, Vacasp> {
	
	@Autowired
	private VacaspService service;

	@Override
	public Vacasp convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}

package com.sitio.mvc.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sitio.mvc.domain.Gado;
import com.sitio.mvc.service.GadoService;

@Component
public class StringToGadoConversor implements Converter<String, Gado> {

	@Autowired
	private GadoService service;
	
	@Override
	public Gado convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}

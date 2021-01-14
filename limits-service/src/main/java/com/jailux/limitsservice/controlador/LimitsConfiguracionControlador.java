package com.jailux.limitsservice.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jailux.limitsservice.bean.Limite;
import com.jailux.limitsservice.configuracion.Configuracion;

@RestController
public class LimitsConfiguracionControlador {

	@Autowired
	private Configuracion configuracion;
	
	@GetMapping("/limits")
	public Limite recuperarLimitesDeConfiguracion() {
		return new Limite(configuracion.getMinimo(), configuracion.getMaximo());
	}
}

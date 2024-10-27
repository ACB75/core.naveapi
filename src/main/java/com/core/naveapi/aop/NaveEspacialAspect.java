package com.core.naveapi.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NaveEspacialAspect {

	private static final Logger logger = LoggerFactory.getLogger(NaveEspacialAspect.class);

	@Before("execution(* com.core.controller.NaveEspacialController.getNaveEspacialById(..)) && args(id)")
	public void logNegativeId(Long id) {
		if (id < 0) {
			logger.warn("Se ha solicitado una nave con un ID negativo: {}", id);
		}
	}
}

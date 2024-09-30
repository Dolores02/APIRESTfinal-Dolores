package com.example.inicial1;
import java.util.List;

import com.example.inicial1.entities.Localidad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import com.example.inicial1.repositories.LocalidadRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication

public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("FUNCIONANDO.....");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, LocalidadRepository localidadRepository) {
		return args -> {
			Localidad localidad1 = Localidad.builder().denominacion("Guaymallen").build();
			Localidad localidad2 = Localidad.builder().denominacion("Ciudad").build();
			localidadRepository.save(localidad1);
			localidadRepository.save(localidad2);

			Domicilio dom1 = Domicilio.builder().calle("A").numero(200).build();
			Domicilio dom2 = Domicilio.builder().calle("B").numero(100).build();

			Persona persona1 = Persona.builder().apellido("Videla").nombre("Dolores").build();
			Persona persona2 = Persona.builder().apellido("Derrache").nombre("Carolina").build();
			personaRepository.save(persona1);
			personaRepository.save(persona2);

			dom1.setLocalidad(localidad1);
			dom2.setLocalidad(localidad2);


			persona1.setDomicilio(dom1);
			persona2.setDomicilio(dom2);


		};
	}
}
package com.classes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classes.dao.PersonaDao;
import com.classes.model.Persona;

@RestController
@RequestMapping("personas")

public class PersonaRest {
	
	@Autowired
	private PersonaDao PERSONADAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona PersonaRest) {
		PERSONADAO.save(PersonaRest);
	}
	
	@GetMapping("/listarpersonajes")
	public List<Persona> listar(){
		return PERSONADAO.findAll();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		PERSONADAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona PersonaRest) {
		PERSONADAO.save(PersonaRest);
		
	}
}

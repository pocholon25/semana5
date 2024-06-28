package com.idat.semana5.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.idat.semana5.model.Persona;
import com.idat.semana5.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Persona buscar(@PathVariable("id") Long id) {
		return service.buscar(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona>registrar(@RequestBody Persona pN){
		Persona _P = service.registrar(pN);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(_P.getIdPersona()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona modificar(@RequestBody Persona pM) {
		return service.modificar(pM);
	}
	
	@DeleteMapping("/{id}")
	public boolean eliminar (@PathVariable ("id")Long id) {
		return service.elimninar(id);
	}
	
	@GetMapping("/listarPagina")
	public Page<Persona> listarPagina(Pageable pag){
		return service.listarPagina(pag);
	}
}

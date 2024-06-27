package com.idat.semana5.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.semana5.model.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{

}

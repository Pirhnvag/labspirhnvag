package com.classes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classes.model.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer> {

}

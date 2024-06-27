package com.idat.semana5.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.semana5.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long>{

}

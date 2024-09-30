package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
//METODOS QUE NECESITAMOS PARA TODAS LAS ENTIDADES
public interface BaseServices<E extends Base, ID extends Serializable>{
    public List<E> findAll() throws Exception; //lista de todas las E  en base de datos
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception; //buscar por ID
    public E save(E entity) throws Exception; //crear nueva entidad
    public E update(ID id, E entity) throws Exception; //actualizar entidad
    public boolean delete(ID id) throws Exception; //eliminar registro de la base de datos
}

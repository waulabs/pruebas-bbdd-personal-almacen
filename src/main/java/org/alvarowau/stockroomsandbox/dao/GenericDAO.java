package org.alvarowau.stockroomsandbox.dao;

import java.util.List;

public interface GenericDAO <T, ID extends Integer>{
    // Método para guardar una entidad
    T save(T entity);
    // Método para actualizar una entidad
    boolean update(T entity);
    // Método para eliminar una entidad
    boolean delete(ID id);
    // Método para buscar una entidad por su ID
    T findById(ID id);
    // Método para obtener todas las entidades
    List<T> findAll();
}

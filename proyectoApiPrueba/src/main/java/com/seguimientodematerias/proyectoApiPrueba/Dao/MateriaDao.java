package com.seguimientodematerias.proyectoApiPrueba.Dao;

import com.seguimientodematerias.proyectoApiPrueba.models.Materia;


import java.util.List;

// Accede a la base de datos
public interface MateriaDao {

    public List<Materia> getMaterias(String anioMateria);
    public void modificarMateria(Materia materiaMod);
}

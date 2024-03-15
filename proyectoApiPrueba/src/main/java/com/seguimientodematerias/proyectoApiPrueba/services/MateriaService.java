package com.seguimientodematerias.proyectoApiPrueba.services;

import com.seguimientodematerias.proyectoApiPrueba.Dao.MateriaDao;
import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {
    // Funciona como intermediario de los controllers con los Dao
    @Autowired
    private MateriaDao materiaDao;
    public List<Materia> getMaterias(String anioMateria) {
        try {
            return materiaDao.getMaterias(anioMateria);
        }catch (Exception e){
            System.out.println("Error al ejecutar getMaterias");
        }
        return null;
    }

    public void modificarMateria(Materia materia) {
        try {
            materiaDao.modificarMateria(materia);
        }catch (Exception e){
            System.out.println("Error al ejecutar modificarMateria controller");
        }
    }
}

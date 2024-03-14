package com.seguimientodematerias.proyectoApiPrueba.controllers;

import com.seguimientodematerias.proyectoApiPrueba.Dao.MateriaDao;
import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// Recibe las solicitudes del usuario por medio de las url
// Intercambia datos con el Dao (Modelo)
@RestController
public class MateriaController {
    @Autowired
    private MateriaDao materiaDao;

    @RequestMapping(value = "materias", method = RequestMethod.GET)
    public List<Materia> getMaterias(@RequestParam("anioMateria") String anioMateria){
        try {
            return materiaDao.getMaterias(anioMateria);
        }catch (Exception e){
            System.out.println("Error al ejecutar getMaterias");
        }
        return null;
    }


    @RequestMapping(value = "cargar-notas", method = RequestMethod.POST)
    public void modificarMateria(@RequestBody Materia materia){
        try {
            materiaDao.modificarMateria(materia);
        }catch (Exception e){
            System.out.println("Error al ejecutar modificarMateria controller");
        }
    }
}

package com.seguimientodematerias.proyectoApiPrueba.controllers;

import com.seguimientodematerias.proyectoApiPrueba.Dao.MateriaDao;
import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import com.seguimientodematerias.proyectoApiPrueba.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class MateriaController {
    // Recibe las solicitudes del usuario por medio de las url
    @Autowired
    private MateriaService service;

    @RequestMapping(value = "materias", method = RequestMethod.GET)
    public List<Materia> getMaterias(@RequestParam("anioMateria") String anioMateria){
        return service.getMaterias(anioMateria);
    }


    @RequestMapping(value = "cargar-notas", method = RequestMethod.PUT)
    public void modificarMateria(@RequestBody Materia materia){
        service.modificarMateria(materia);
    }
}






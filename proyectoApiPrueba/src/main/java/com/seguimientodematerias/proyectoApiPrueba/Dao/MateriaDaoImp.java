package com.seguimientodematerias.proyectoApiPrueba.Dao;


import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MateriaDaoImp implements MateriaDao{
   // Se encarga de la conexion con la base de datos
    // Con EntityManager se realizan las consultas y solititudes a la base de datos
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public List<Materia> getMaterias(String anioMateria) {
        String query = "FROM Materia WHERE anioMateria = :anioMateria";
        try {
            return entityManager.createQuery(query, Materia.class)
                    .setParameter("anioMateria", anioMateria)
                    .getResultList();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al crear la query");
            return null;
        }
    }

    @Override
    public void modificarMateria(Materia materiaMod) {
        try {
            Materia materia = entityManager.find(Materia.class, materiaMod.getId());
            materia.setNotaFinal(materiaMod.getNotaFinal());
            materia.setPromocion(materiaMod.isPromocion());
            materia.setNotaCursada(materiaMod.getNotaCursada());
            materia.setAnioCursada(materiaMod.getAnioCursada());
        } catch (Exception e) {
            System.out.println("Error al modificar la materia");
            throw e;
        }
    }
}

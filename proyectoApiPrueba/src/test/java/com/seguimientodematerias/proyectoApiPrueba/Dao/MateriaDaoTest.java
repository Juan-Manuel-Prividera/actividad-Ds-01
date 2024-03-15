package com.seguimientodematerias.proyectoApiPrueba.Dao;

import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import jakarta.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MateriaDaoTest {

    @InjectMocks
    private MateriaDao materiaDao;

    @Mock
    private EntityManager entityManager;

    private Materia materia;

    @Before
    public void setUp() {
        materia = new Materia();
        materia.setNombre("Hola");
        materia.setAnioMateria("1");
        materia.setId(99L);
        materia.setAnioCursada("2030");
        materia.setPromocion(false);
        materia.setNotaFinal(10);
        materia.setNotaCursada(7);
    }
    @Test
    public void getMateriasTest(){
        List<Materia> materiaList = new ArrayList<>();
        materiaList.add(materia);
        String query = "FROM Materia WHERE anioMateria = :anioMateria";

        when (entityManager.createQuery(query, Materia.class).setParameter("anioMateria", "1").getResultList()).thenReturn(materiaList);

        List<Materia> resultado = materiaDao.getMaterias("1");

        Assert.assertEquals(materiaList,resultado);
    }
}

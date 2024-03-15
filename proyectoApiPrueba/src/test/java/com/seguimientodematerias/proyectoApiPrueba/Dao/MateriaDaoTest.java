package com.seguimientodematerias.proyectoApiPrueba.Dao;

import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MateriaDaoTest {

    @InjectMocks
    private MateriaDaoImp materiaDao;

    @Mock
    private EntityManager entityManager;

    private Materia materia;

    @BeforeEach
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


        TypedQuery<Materia> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery(query, Materia.class)).thenReturn(typedQuery);
        when(typedQuery.setParameter("anioMateria", "1")).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(materiaList);

        List<Materia> resultado = materiaDao.getMaterias("1");

        Assertions.assertEquals(materiaList, resultado);
        verify(entityManager).createQuery(query, Materia.class);
        verify(typedQuery).setParameter("anioMateria", "1");
        verify(typedQuery).getResultList();
    }
}

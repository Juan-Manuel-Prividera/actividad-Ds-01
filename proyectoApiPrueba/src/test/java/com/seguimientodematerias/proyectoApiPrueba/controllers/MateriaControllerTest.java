package com.seguimientodematerias.proyectoApiPrueba.controllers;

import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import com.seguimientodematerias.proyectoApiPrueba.services.MateriaService;
import org.junit.Assert;
import org.junit.Before;
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
public class MateriaControllerTest {
    @InjectMocks
    private MateriaController materiaController;
    @Mock
    private MateriaService service;
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
    public void getMateriasTest() {
        List<Materia> materiaList = new ArrayList<>();
        materiaList.add(materia);
        String query = "FROM Materia WHERE anioMateria = :anioMateria";

        when(service.getMaterias("1")).thenReturn(materiaList);
        List<Materia> resultado = materiaController.getMaterias("1");

        verify(service, times(1)).getMaterias("1");
        Assert.assertEquals(resultado.getFirst(), materia);

    }

    @Test
    public void modificarMateriaTest() {
        materiaController.modificarMateria(materia);
        verify(service, times(1)).modificarMateria(materia);
    }

}
package com.seguimientodematerias.proyectoApiPrueba.service;

import com.seguimientodematerias.proyectoApiPrueba.Dao.MateriaDao;
import com.seguimientodematerias.proyectoApiPrueba.models.Materia;
import com.seguimientodematerias.proyectoApiPrueba.services.MateriaService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class MateriaServiceTest {
    @InjectMocks
    private MateriaService service;
    @Mock
    private MateriaDao materiaDao;
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
        String anioMateria = "1";
        List<Materia> materiaList = new ArrayList<>();
        materiaList.add(materia);

        when(materiaDao.getMaterias(anioMateria)).thenReturn(materiaList);
        List<Materia> resultado = service.getMaterias(anioMateria);

        Assertions.assertEquals(resultado, materiaList);
        verify(materiaDao,times(1)).getMaterias(anioMateria);
    }

    @Test
    public void modificarMateriasTest(){
        service.modificarMateria(materia);
        verify(materiaDao,times(1)).modificarMateria(materia);
    }



}

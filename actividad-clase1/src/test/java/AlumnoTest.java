import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.*;

import java.util.ArrayList;

public class AlumnoTest {
    Alumno alumno;
    Materia am2;
    Materia am1;
    Materia aga;
    Materia f1;
    Materia f2;

    ArrayList<Materia> am2Correlativa = new ArrayList<>();

    ArrayList<Materia> f2Correlativa = new ArrayList<>();

    ArrayList<Materia> materiasAprobadas = new ArrayList<>();



    @BeforeEach
    public void before(){
        // Materias para pruebas
        am1 = new Materia("Analisis Matematico 1", null);
        am2 = new Materia("Analisis Matematico 2",am2Correlativa );
        aga = new Materia("Algebra", null);
        f1 = new Materia("Fisica 1", null);
        f2 = new Materia("Fisica 2",f2Correlativa);

        // Le digo que am2 y f2 tienen correlativas
        am2Correlativa.add(am1);
        f2Correlativa.add(f1);

        // Las materias que tiene el alumno aprobadas
        materiasAprobadas.add(am1);
        materiasAprobadas.add(aga);


        alumno = new Alumno(materiasAprobadas,"123");
    }

    @Test
    public void siCumpleCorrelativas(){
        Assertions.assertTrue(alumno.compleCorrelativas(am2));
    }

    @Test
    public void noCumpleCorrelativa(){
        Assertions.assertFalse(alumno.compleCorrelativas(f2));
    }
}

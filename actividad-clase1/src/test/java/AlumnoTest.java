import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.*;

import java.util.Arrays;

public class AlumnoTest {
    Alumno alumno;
    Materia am2,am1,aga,f1,f2;


    @BeforeEach
    public void before(){
        // Materias para pruebas
        am1 = new Materia("Analisis Matematico 1", null);
        aga = new Materia("Algebra", null);
        am2 = new Materia("Analisis Matematico 2", Arrays.asList(aga,am1));
        f1 = new Materia("Fisica 1", null);
        f2 = new Materia("Fisica 2",Arrays.asList(f1));


        alumno = new Alumno(Arrays.asList(am1,aga),"123");
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

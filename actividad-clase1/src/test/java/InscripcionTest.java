import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import org.example.*;

public class InscripcionTest {

    Inscripcion inscripcion;
    Alumno alumno;
    Materia am2,am1,aga,f1,f2;


    @BeforeEach
    public void before(){
        // Creo las materias para las pruebas
        am1 = new Materia("Analisis Matematico 1", null);
        aga = new Materia("Algebra", null);
        am2 = new Materia("Analisis Matematico 2", Arrays.asList(aga,am1));
        f1 = new Materia("Fisica 1", null);
        f2 = new Materia("Fisica 2",Arrays.asList(f1));
    }

    // Alumno que no tiene materias aprobadas se puede inscribir a materias
    // que no tienen correlativas
    @Test
    public void seApruebaLaInscripcionAMateriasSinCorrelativas(){
        alumno = new Alumno(null,"123");
        inscripcion = new Inscripcion(Arrays.asList(am1,aga),alumno);

        Assertions.assertTrue(inscripcion.aprobada());
    }


    // Si el alumno no tiene las materias correlativas aprobadas se le rechaza la inscripcion
    @Test
    public void seRechazaLaInscripcionAMateriasQueTienenCorrelativasYNoLasCumple() {
        alumno = new Alumno(Arrays.asList(am1,aga),"123");
        inscripcion = new Inscripcion(Arrays.asList(am2,f2),alumno);

        Assertions.assertFalse(inscripcion.aprobada());
    }

    // SI el alumno si cumple con las correlativa de las materias se le acepta la inscripcion
    @Test
    public void seAceptaInscripcionAMateriasConCorrelativas(){
        alumno = new Alumno(Arrays.asList(f1,am1,aga),"123");
        inscripcion = new Inscripcion(Arrays.asList(am2,f2),alumno);

        Assertions.assertTrue(inscripcion.aprobada());
    }

}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import org.example.*;
public class InscripcionTest {

    Inscripcion inscripcion;
    Alumno alumno;
    Materia am2,am1,aga,f1,f2;


    ArrayList<Materia> am2Correlativa = new ArrayList<>();
    ArrayList<Materia> f2Correlativa = new ArrayList<>();
    ArrayList<Materia> solicitud;
    ArrayList<Materia> materiasAprobadas;


    @BeforeEach
    public void before(){
        // Creo las materias para las pruebas
        am1 = new Materia("Analisis Matematico 1", null);
        am2 = new Materia("Analisis Matematico 2",am2Correlativa );
        aga = new Materia("Algebra", null);
        f1 = new Materia("Fisica 1", null);
        f2 = new Materia("Fisica 2",f2Correlativa);

        am2Correlativa.add(am1);
        f2Correlativa.add(f1);

    }

    // Alumno que no tiene materias aprobadas se puede inscribir a materias
    // que no tienen correlativas
    @Test
    public void seApruebaLaInscripcionAMateriasSinCorrelativas(){
        solicitud = new ArrayList<>();
        solicitud.add(am1);
        solicitud.add(aga);

        alumno = new Alumno(null,"123");
        inscripcion = new Inscripcion(solicitud,alumno);

        Assertions.assertTrue(inscripcion.aprobada());

    }


    // Si el alumno no tiene las materias correlativas aprobadas se le rechaza la inscripcion
    @Test
    public void seRechazaLaInscripcionAMateriasQueTienenCorrelativasYNoLasCumple() {
        solicitud = new ArrayList<>();
        solicitud.add(am2);
        solicitud.add(f2);

        materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(am1);
        materiasAprobadas.add(aga);

        alumno = new Alumno(materiasAprobadas,"123");
        inscripcion = new Inscripcion(solicitud,alumno);

        Assertions.assertFalse(inscripcion.aprobada());
    }

    // SI el alumno si cumple con las correlativa de las materias se le acepta la inscripcion
    @Test
    public void seAceptaInscripcionAMateriasConCorrelativas(){
        solicitud = new ArrayList<>();
        solicitud.add(am2);
        solicitud.add(f2);

        materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(f1);
        materiasAprobadas.add(am1);
        materiasAprobadas.add(aga);

        alumno = new Alumno(materiasAprobadas,"123");
        inscripcion = new Inscripcion(solicitud,alumno);

        Assertions.assertTrue(inscripcion.aprobada());

    }

}

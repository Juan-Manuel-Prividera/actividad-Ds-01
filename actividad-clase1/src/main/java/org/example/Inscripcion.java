package org.example;

import java.util.List;
public class Inscripcion {
    private final Alumno alumno;
    private final List<Materia> materiasSolicitadas;


    public Inscripcion(List<Materia> materiasSolicitadas, Alumno alumno){
        this.alumno = alumno;
        this.materiasSolicitadas = materiasSolicitadas;
    }
    public boolean aprobada(){
        for (Materia materiasSolicitada : materiasSolicitadas) {
            if (!alumno.compleCorrelativas(materiasSolicitada)) {
                return false;
            }
        }
        return true;
    }

}

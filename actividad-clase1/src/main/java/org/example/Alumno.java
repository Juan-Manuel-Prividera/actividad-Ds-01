package org.example;

import java.util.List;
public class Alumno {
    private final String legajo;
    private final List<Materia> materiasAprobadas;

    public Alumno(List<Materia> materiasAprobadas, String legajo){
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;

    }
    public boolean compleCorrelativas(Materia materia){
        if(materia.getCorrelativas() != null) {
            return materiasAprobadas.containsAll(materia.getCorrelativas());
        }else
            return true;
    }
}

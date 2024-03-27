package org.example;

import java.util.List;

public class Materia {
    private final String nombre;
    private final List<Materia> correlativas;

    public Materia(String nombre, List<Materia> correlativas){
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }


}

package com.seguimientodematerias.proyectoApiPrueba.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@Entity
@Table(name = "materias")
@ToString @EqualsAndHashCode
public class Materia {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nota_cursada")
    private int notaCursada;
    @Column(name = "nota_final")
    private int notaFinal;
    @Column(name = "promocion")
    private boolean promocion;
    @Column(name = "anio_cursada")
    private String anioCursada;
    @Column(name = "anio_materia")
    private String anioMateria;


    public boolean isPromocion() {
        return notaCursada >= 8;
    }

    public int getNotaFinal(){
        if(promocion)
            return -1;
        else
            return notaFinal;
    }

}

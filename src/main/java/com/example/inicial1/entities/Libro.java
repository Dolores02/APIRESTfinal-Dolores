package com.example.inicial1.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Audited
public class Libro extends Base {

    private String titulo;
    private Date fecha;
    private String genero;
    private int paginas;
    private String autor;


    @Builder.Default
    @ManyToMany(cascade = CascadeType.REFRESH) //cambio en autor se actualiza en libro
    private List<Autor> autores = new ArrayList<>();   //muchos

}
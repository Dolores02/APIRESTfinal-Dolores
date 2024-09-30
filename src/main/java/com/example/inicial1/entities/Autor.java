package com.example.inicial1.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Audited
public class Autor extends Base{

    private String nombre;
    private String apellido;
    private String biografia;


}

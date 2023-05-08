package org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter // Genera los getters
@Setter // Genera los setters
@Entity // Indica que es una entidad de la base de datos
@Table(name = "users") // Indica el nombre de la tabla
public class users {
    @Id // Indica que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que es autoincrementable
    private Long id;
    private  String name;
    @Column(unique = true)
    private  String email;
    private  String password;



}

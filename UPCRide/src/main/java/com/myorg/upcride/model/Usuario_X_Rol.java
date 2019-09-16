package com.myorg.upcride.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario_X_Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "rol_id")
    private Integer id;

    @Column (name="descripcion", length = 100, nullable = false)
    private String descripcion;



}

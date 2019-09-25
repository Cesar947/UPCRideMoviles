package com.myorg.upcride.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Table(name = "Usuario_X_Rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario_X_Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Usuario_x_Rol_id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn (name = "rol_id")
    private Rol rol;




}

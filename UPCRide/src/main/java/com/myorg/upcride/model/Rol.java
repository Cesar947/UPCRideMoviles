package com.myorg.upcride.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "rol_id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn (name = "rol_id")
    private Rol rol;
}

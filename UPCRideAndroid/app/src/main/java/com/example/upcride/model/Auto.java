package com.example.upcride.model;

import javax.xml.transform.Source;

public class Auto {

    private int id;
    private String placa;
    private String polizaSoat;
    private String marca;
    private  String modelo;
    private int limitePersonas;
    private Usuario conductor;


    public Auto(int id, String placa, String polizaSoat, String marca, String modelo, int limitePersonas, Usuario conductor) {
        this.id = id;
        this.placa = placa;
        this.polizaSoat = polizaSoat;
        this.marca = marca;
        this.modelo = modelo;
        this.limitePersonas = limitePersonas;
        this.conductor = conductor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPolizaSoat() {
        return polizaSoat;
    }

    public void setPolizaSoat(String polizaSoat) {
        this.polizaSoat = polizaSoat;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getLimitePersonas() {
        return limitePersonas;
    }

    public void setLimitePersonas(int limitePersonas) {
        this.limitePersonas = limitePersonas;
    }

    public Usuario getConductor() {
        return conductor;
    }

    public void setConductor(Usuario conductor) {
        this.conductor = conductor;
    }
}

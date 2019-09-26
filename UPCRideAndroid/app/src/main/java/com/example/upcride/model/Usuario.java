package com.example.upcride.model;

public class Usuario {

    private int id;
    private String codigo;
    private String correoUPC;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private double ubicacionLatitud;
    private double ubicacionLongitud;
    private String facebook_id;
    private String telefono;
    private String distrito;
    private char rol;
    private String licenciaConducir;
    private String sede;

    public Usuario(){

    }

    public Usuario(String codigo, String correoUPC, String contraseña, String nombres, String apellidos, double ubicacionLatitud,
                   double ubicacionLongitud, String facebook_id, String telefono, String distrito, char rol, String licenciaConducir, String sede) {

        this.codigo = codigo;
        this.correoUPC = correoUPC;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ubicacionLatitud = ubicacionLatitud;
        this.ubicacionLongitud = ubicacionLongitud;
        this.facebook_id = facebook_id;
        this.telefono = telefono;
        this.distrito = distrito;
        this.rol = rol;
        this.licenciaConducir = licenciaConducir;
        this.sede = sede;
    }
    //Constructor del pasajero
    public Usuario(String codigo, String correoUPC, String contraseña, String nombres, String apellidos, double ubicacionLatitud,
                   double ubicacionLongitud, String telefono, String distrito, char rol, String sede){
        this.codigo = codigo;
        this.correoUPC = correoUPC;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ubicacionLatitud = ubicacionLatitud;
        this.ubicacionLongitud = ubicacionLongitud;
        this.telefono = telefono;
        this.distrito = distrito;
        this.rol = rol;
        this.sede = sede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreoUPC() {
        return correoUPC;
    }

    public void setCorreoUPC(String correoUPC) {
        this.correoUPC = correoUPC;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getUbicacionLatitud() {
        return ubicacionLatitud;
    }

    public void setUbicacionLatitud(double ubicacionLatitud) {
        this.ubicacionLatitud = ubicacionLatitud;
    }

    public double getUbicacionLongitud() {
        return ubicacionLongitud;
    }

    public void setUbicacionLongitud(double ubicacionLongitud) {
        this.ubicacionLongitud = ubicacionLongitud;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public char getRol() {
        return rol;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_final.controller.model;
/**
 *
 * @author Eddier Lopez
 */
public class Consultas {
    private String Usuario;
    private Double Nombre;
    private String compañia;
    private String rol;
    private String correo;
    private String localizacion;

    public Consultas(String Usuario, Double Nombre, String compañia, String rol, String correo,String localizacion) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.compañia = compañia;
        this.rol = rol;
        this.correo = correo;
        this.localizacion = localizacion;
    }

    Consultas(String textContent, Double valueOf, String textContent0, String textContent1, String textContent2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public Double getNombre() {
        return Nombre;
    }

    public void setNombre(Double Nombre) {
        this.Nombre = Nombre;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    
    
}
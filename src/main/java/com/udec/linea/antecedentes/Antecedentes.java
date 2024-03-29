/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.linea.antecedentes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author  Andrea Orjuela
 * @author  Juan Camilo Santana
 */
public class Antecedentes implements Serializable {

    private String fechaAntecedente;
    private String descripcionAntecedente;
    private String tipoAntecedente;
    private String descripcionTipo;
    private String nombreCaracteristico;
    private String cedula;
    private int id;

    public Antecedentes() {

    }
    
    /**
     * 
     * @param fechaAntecedente variable que contiene fecha del antecedente     
     * @param descripcionAntecedente variable que contiene la descripcion del antecendente
     * @param tipoAntecedente variable que contiene el tipo de antecedente (Positivo / Negativo)
     * @param descripcionTipo variable que contiene la descripcion del tipo de antecedente     
     * @param nombreCaracteristico variable que contiene el nombre caracteristico del antecedente
     * @param cedula variable que contiene la cedula de a quien corresponde el antecedente
     * @param id variable que contiene el identificador del antecedente
     */
    
    public Antecedentes(String fechaAntecedente, String descripcionAntecedente, String tipoAntecedente, String descripcionTipo, String nombreCaracteristico, String cedula, int id) {
        this.fechaAntecedente = fechaAntecedente;
        this.descripcionAntecedente = descripcionAntecedente;
        this.tipoAntecedente = tipoAntecedente;
        this.descripcionTipo = descripcionTipo;
        this.nombreCaracteristico = nombreCaracteristico;
        this.cedula = cedula;
        this.id = id;
    }

    /**
     * Getters y setters
     *
     * @return
     */
    public String getFechaAntecedente() {
        return fechaAntecedente;
    }

    public void setFechaAntecedente(String fechaAntecedente) {
        this.fechaAntecedente = fechaAntecedente;
    }

    public String getDescripcionAntecedente() {
        return descripcionAntecedente;
    }

    public void setDescripcionAntecedente(String descripcionAntecedente) {
        this.descripcionAntecedente = descripcionAntecedente;
    }

    public String getTipoAntecedente() {
        return tipoAntecedente;
    }

    public void setTipoAntecedente(String tipoAntecedente) {
        this.tipoAntecedente = tipoAntecedente;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public String getNombreCaracteristico() {
        return nombreCaracteristico;
    }

    public void setNombreCaracteristico(String nombreCaracteristico) {
        this.nombreCaracteristico = nombreCaracteristico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

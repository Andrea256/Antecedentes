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
 * @author andreaorjuela
 */
public class Antecedentes implements Serializable{
    
    private Date fechaAntecedente;
    private String descripcionAntecedente;
    private String tipoAntecedente;
    private String descripcionTipo;
    private String nombreCaracteristico;

    public Antecedentes() {
        
    }
    
    public Antecedentes(Date fechaAntecedente, String descripcionAntecedente, String tipoAntecedente, String descripcionTipo, String nombreCaracteristico) {
        this.fechaAntecedente = fechaAntecedente;
        this.descripcionAntecedente = descripcionAntecedente;
        this.tipoAntecedente = tipoAntecedente;
        this.descripcionTipo = descripcionTipo;
        this.nombreCaracteristico = nombreCaracteristico;
    }

    
    /**
     * Getters y setters
     * @return 
     */
    
    public Date getFechaAntecedente() {
        return fechaAntecedente;
    }

    public void setFechaAntecedente(Date fechaAntecedente) {
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
    
    
    
}

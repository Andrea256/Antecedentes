/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.linea.antecedentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreaorjuela
 */
public class Persona implements Serializable{
    
    private String nombrePersona;
    private String cedulaPersona;
    private byte edadPersona;
    private String generoPersona;
    private List<Antecedentes> listaAntecedentes;

    public Persona() {
        
    }

    public Persona(String nombrePersona, String cedulaPersona, byte edadPersona, String generoPersona) {
        this.nombrePersona = nombrePersona;
        this.cedulaPersona = cedulaPersona;
        this.edadPersona = edadPersona;
        this.generoPersona = generoPersona;
    }

    public Persona(String nombrePersona, String cedulaPersona, byte edadPersona, String generoPersona, List<Antecedentes> listaAntecedentes) {
        this.nombrePersona = nombrePersona;
        this.cedulaPersona = cedulaPersona;
        this.edadPersona = edadPersona;
        this.generoPersona = generoPersona;
        this.listaAntecedentes = new ArrayList<>();
    }
    
    /**
     * Getters y setters
     * @return 
     */

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public byte getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(byte edadPersona) {
        this.edadPersona = edadPersona;
    }

    public String getGeneroPersona() {
        return generoPersona;
    }

    public void setGeneroPersona(String generoPersona) {
        this.generoPersona = generoPersona;
    }

    public List<Antecedentes> getListaAntecedentes() {
        return listaAntecedentes;
    }

    public void setListaAntecedentes(List<Antecedentes> listaAntecedentes) {
        this.listaAntecedentes = listaAntecedentes;
    }
    
    
    
    
    
}

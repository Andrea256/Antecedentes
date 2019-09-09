/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.linea.antecedentes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreaorjuela
 */
public class Serializar {

    public List<Persona> listaPer;
    public List<Antecedentes> listAnt;

    private final String ruta;

    public Serializar() throws IOException {
        this.ruta = "Antecedente.txt";
        validarArchivos();
    }

    private void validarArchivos() throws IOException {

            try {
            File file = new File(ruta);

            if (!file.exists()) {
                file.createNewFile();
                listaPer = new ArrayList<>();
                listAnt = new ArrayList<>();
                guardarRegistrosPer(listaPer);
                guardarRegistrosAnt(listAnt);
            }
        } catch (IOException e) {
            System.err.println("Error con el archivo");
        }     
    }

    public List<Persona> listaActualesPer() throws FileNotFoundException, IOException, ClassNotFoundException {

        listaPer = new ArrayList<>();

        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));
            listaPer = (ArrayList<Persona>)entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No hay datos en el archivo");
            e.getMessage();
        }

        return listaPer;
    }
    
    public void guardarRegistrosPer(List<Persona> lista) {

        try {
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta))) {
                salida.writeObject(lista);
            }            
        } catch (IOException e) {
            System.err.println("No se ha podido guardar el registro");
            e.getMessage();
        }
    }
    
    public void guardarRegistrosAnt(List<Antecedentes> ant) {

        try {
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta))) {
                salida.writeObject(ant);
            }            
        } catch (IOException e) {
            System.err.println("No se ha podido guardar el registro");
            e.getMessage();
        }
    }


}

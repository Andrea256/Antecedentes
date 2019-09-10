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
 * @author Andrea Orjuela
 * @author  Juan Camilo Santana
 */
public class Serializar {

    public List<Persona> listaPer;
    public List<Antecedentes> listAnt;

    private final String ruta1;
    private final String ruta2;

    public Serializar() throws IOException {
        this.ruta1 = "Personas.txt";
        this.ruta2 = "Archivos.txt";
        validarArchivos();
    }

    private void validarArchivos() throws IOException {

            try {
            File file1 = new File(ruta1);
            File file2 = new File(ruta2);

            if (!file1.exists()&& file2.exists()) {
                file1.createNewFile();
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
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta1));
            listaPer = (ArrayList<Persona>)entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {
            
            e.getMessage();
        }

        return listaPer;
    }
    
    public List<Antecedentes> listaActualesAnt() throws FileNotFoundException, IOException, ClassNotFoundException {

        listAnt = new ArrayList<>();

        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta2));
            listAnt = (ArrayList<Antecedentes>)entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {            
            e.getMessage();
        }

        return listAnt;
    }
    
    public void guardarRegistrosPer(List<Persona> lista) {

        try {
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta1))) {
                salida.writeObject(lista);
            }            
        } catch (IOException e) {
            System.err.println("No se ha podido guardar el registro");
            e.getMessage();
        }
    }
    
    public void guardarRegistrosAnt(List<Antecedentes> ant) {

        try {
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta2))) {
                salida.writeObject(ant);
            }            
        } catch (IOException e) {
            System.err.println("No se ha podido guardar el registro");
            e.getMessage();
        }
    }


}

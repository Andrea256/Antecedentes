/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.linea.antecedentes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andreaorjuela
 */
public class Logica {

    Scanner leer = new Scanner(System.in);
    private List<Persona> listaPersona;
    private List<Antecedentes> listaAntecedentes;

    public Logica() throws IOException, FileNotFoundException, ClassNotFoundException {
        Serializar arch = new Serializar();
        listaPersona = arch.listaActualesPer();        
        this.listaPersona = new ArrayList<>();
        listaAntecedentes = new ArrayList<>();

    }

    public void Menu() {

        while (true) {

            System.out.println("---- MENU ----");
            System.out.println("(1.) Registrar Persona");
            System.out.println("(2.) Editar Persona");
            System.out.println("(3.) Registrar Antecedente");
            System.out.println("(4.) Ver Personas y Antecedente");
            System.out.println("(5.) Salir");

            int opcion = leer.nextInt();

            switch (opcion) {

                case 1: {
                    try {
                        registrarPersona();
                    } catch (IOException ex) {
                        System.out.println("");
                    }
                }
                break;
                case 2:
                    editarPersona();
                    break;
                case 3:
            {
                try {
                    agregarAntecedente();
                } catch (IOException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case 4: {
                    try {
                        verPeryAntec();
                    } catch (IOException ex) {
                        System.out.println("");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("");
                    }
                }
                break;
                default:
                    System.out.println("Opcion invalida");

            }
        }
    }

    public String registrarPersona() throws IOException {

        String nombre, genero;
        String cedula;
        byte edad;
        Serializar seri = new Serializar();

        System.out.println("\n ---- PERSONA ---");
        System.out.println("Nombre: ");
        nombre = leer.next();
        System.out.println("Cédula: ");
        cedula = leer.next();
        System.out.println("Edad: ");
        edad = leer.nextByte();
        System.out.println("Género: ");
        genero = leer.next();

        if (validarPersona(cedula) == true) {
            System.out.println("Persona ya registrada");
        } else {
            Persona per = new Persona(nombre, cedula, edad, genero);
            listaPersona.add(per);
            seri.guardarRegistrosPer(listaPersona);
        }

        Menu();

        return cedula;

    }

    public boolean validarPersona(String cedula) {

        boolean validar;
        validar = validarDocumento(cedula);
        return validar;
    }

    public void editarPersona() {

        String nombre, genero;
        String modifica;
        byte edad;

        System.out.println("\n ---- EDITAR PERSONA ---");
        System.out.println("Cédula de la persona: ");
        modifica = leer.next();

        for (int i = 0; i < listaPersona.size(); i++) {

            if (listaPersona.get(i).getCedulaPersona().equals(modifica)) {

                System.out.println("Nombre actual:  " + listaPersona.get(i).getNombrePersona());
                System.out.println("Modificar por: ");
                nombre = leer.next();
                System.out.println("Cédula:  " + listaPersona.get(i).getCedulaPersona());
                System.out.println("Edad actual:  " + listaPersona.get(i).getEdadPersona());
                System.out.println("Modificar por: ");
                edad = leer.nextByte();
                System.out.println("Género actual:  " + listaPersona.get(i).getGeneroPersona());
                System.out.println("Modificar por: ");
                genero = leer.next();

                Persona per = new Persona(nombre, modifica, edad, genero);
                listaPersona.add(per);

            } else {
                System.out.println("no registrado");
            }
        }

        Menu();

    }

    public boolean validarDocumento(String cedula) {

        boolean per = false;
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getCedulaPersona().equals(cedula)) {
                per = true;
            }
        }
        return per;

    }

    public void agregarAntecedente() throws IOException {

        boolean validar;
        String cedula;
        System.out.println("Cedula: ");
        cedula = leer.next();

        validar = validarDocumento(cedula);
        if (validarPersona(cedula) == true) {
            registrarAntecedente(cedula);
        } else {
            System.out.println("Persona no esta registrada");
        }
    }

    public void registrarAntecedente(String cedula) throws IOException {

        String fechaAnt, descripcionAnt, tipoAnt, descripcionTipo, nombreCarac;
        Serializar seri = new Serializar();

        System.out.println("\n ---- ANTECEDENTE ---");
        System.out.println("Fecha: ");
        fechaAnt = leer.next();
        System.out.println("Descripcion: ");
        descripcionAnt = leer.next();
        System.out.println("Tipo: ");
        tipoAnt = leer.next();
        System.out.println("Descripcion del tipo: ");
        descripcionTipo = leer.next();
        System.out.println("Nombre caracteristico: ");
        nombreCarac = leer.next();

        Antecedentes ant = new Antecedentes(fechaAnt, descripcionAnt, tipoAnt, descripcionTipo, nombreCarac, cedula);

        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getCedulaPersona().equals(cedula)) {                               
                listaAntecedentes.add(ant);
                listaPersona.get(i).setListaAntecedentes(listaAntecedentes);
                seri.guardarRegistrosPer(listaPersona);
            }
        }
        Menu();
    }

    public void verPeryAntec() throws IOException, FileNotFoundException, ClassNotFoundException {

        Serializar seri = new Serializar();
        listaPersona = seri.listaActualesPer();
        
        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("----- Usuario -----");
            System.out.println("Nombre: " + listaPersona.get(i).getNombrePersona());
            System.out.println("Cedula: " + listaPersona.get(i).getCedulaPersona());
            System.out.println("Edad: " + listaPersona.get(i).getEdadPersona());
            System.out.println("Genero: " + listaPersona.get(i).getGeneroPersona());
            System.out.println("Antecesdentes: " + listaPersona.get(i).getListaAntecedentes());
        }
    }

}

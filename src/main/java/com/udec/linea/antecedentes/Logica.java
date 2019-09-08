/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.linea.antecedentes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

    public Logica() throws IOException, FileNotFoundException, ClassNotFoundException {
        Serializar arch = new Serializar();
        listaPersona = arch.listasActuales();
            this.listaPersona = new ArrayList<>();
       
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

                case 1:
            {
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
                    //registrarAntecedente();
                    break;
                case 4:
            {
                try {
                    verPeryAntec();
                } catch (IOException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
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

        validarPersona(cedula);
        if (validarPersona(cedula) == true) {
            System.out.println("Persona ya registrada");
        } else {
            Persona per = new Persona(nombre, cedula, edad, genero);
            listaPersona.add(per);
            seri.guardarRegistros(listaPersona);
        }

        //Persona per = new Persona(nombre, cedula, edad, genero);
        //listaPersona.add(per);
        Menu();

        return cedula;

    }

    public boolean validarPersona(String cedula) {

        boolean per = false;
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getCedulaPersona().equals(cedula)) {
                per = true;
            }
        }
        return per;
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

    public void registrarAntecedente() {

    }

    public void verPeryAntec() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Serializar seri = new Serializar();
        listaPersona = seri.listasActuales();        

        for (Persona persona : listaPersona) {
            System.out.println("--------------------");
            System.out.println("Nombre: " + persona.getNombrePersona());
            System.out.println("Cedula: " + persona.getCedulaPersona());
            System.out.println("Edad: " + persona.getEdadPersona());
            System.out.println("Genero: " + persona.getGeneroPersona());
        }

    }

}

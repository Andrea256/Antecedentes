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

/**
 *
 * @author  Andrea Orjuela
 * @author  Juan Camilo Santana
 */
public class Logica {

    Scanner leer = new Scanner(System.in);
    private List<Persona> listaPersona;
    private List<Antecedentes> listaAntecedentes;

    public Logica() throws IOException, FileNotFoundException, ClassNotFoundException {
        Serializar arch = new Serializar();
        this.listaPersona = arch.listaActualesPer();
        this.listaAntecedentes = arch.listaActualesAnt();
        listaPersona = new ArrayList<>();
        listaAntecedentes = new ArrayList<>();
        imprimir();

    }

    public void Menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        int opcion = 0;
        do {

            System.out.println("------ MENU ------");
            System.out.println("(1.) Registrar Persona");
            System.out.println("(2.) Editar Persona");
            System.out.println("(3.) Registrar Antecedente");
            System.out.println("(4.) Ver Personas y Antecedente");
            System.out.println("(5.) Eliminar Antecedente");
            System.out.println("(6.) Salir");

            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    registrarPersona();
                    break;
                case 2:
                    editarPersona();
                    break;
                case 3:
                    agregarAntecedente();
                    break;
                case 4:
                    imprimir();
                    break;
                case 5:
                    eliminarAntecedente();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion invalida");

            }
        } while (opcion != 6);
    }

    public String registrarPersona() throws IOException, FileNotFoundException, ClassNotFoundException {

        String nombre, genero;
        String cedula;
        byte edad;
        Serializar seri = new Serializar();

        System.out.println("\n ----- PERSONA -----");
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

    public void editarPersona() throws IOException, FileNotFoundException, ClassNotFoundException {

        String nombre, genero, modifica;
        byte edad;
        boolean existencia = false;
        int posicion = 0;
        Serializar seri = new Serializar();
        System.out.println("\n ------ EDITAR PERSONA ------");
        System.out.println("Cédula de la persona: ");
        modifica = leer.next();
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getCedulaPersona().equals(modifica)) {
                existencia = true;
                posicion = i;
            } else {
                existencia = false;
            }
        }
        if (existencia == true) {
            System.out.println("Nombre actual:  " + listaPersona.get(posicion).getNombrePersona());
            System.out.println("Modificar por: ");
            nombre = leer.next();
            System.out.println("Cédula:  " + listaPersona.get(posicion).getCedulaPersona());
            System.out.println("Edad actual:  " + listaPersona.get(posicion).getEdadPersona());
            System.out.println("Modificar por: ");
            edad = leer.nextByte();
            System.out.println("Género actual:  " + listaPersona.get(posicion).getGeneroPersona());
            System.out.println("Modificar por: ");
            genero = leer.next();
            Persona per = new Persona(nombre, modifica, edad, genero);
            listaPersona.remove(posicion);
            listaPersona.add(per);
            seri.guardarRegistrosPer(listaPersona);
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

    public void agregarAntecedente() throws IOException, FileNotFoundException, ClassNotFoundException {

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

    public void eliminarAntecedente() throws IOException {
        String modifica;
        int codigo = 0;
        boolean existencia = false;
        int posicion = 0;
        Serializar seri = new Serializar();
        System.out.println("\n ------ EDITAR PERSONA ------");
        System.out.println("Cédula de la persona: ");
        modifica = leer.next();
        System.out.println("Codigo de actecedente: ");
        codigo = leer.nextInt();
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getCedulaPersona().equals(modifica)) {
                for (int j = 0; j < listaAntecedentes.size(); j++) {
                    if (listaAntecedentes.get(j).getId() == codigo && listaAntecedentes.get(j).getTipoAntecedente().equals("Negativo")) {
                        existencia = true;
                        posicion = j;
                    } else {                        
                        existencia = false;
                    }
                }
            }
        }
        if (existencia == true) {            
            listaAntecedentes.remove(posicion);            
            seri.guardarRegistrosAnt(listaAntecedentes);
            System.out.println("Antecedente eliminado");
        }else{
            System.out.println("No existe antecedente / No puede eliminar antecedestes positivos");
        }

    }

    public void registrarAntecedente(String cedula) throws IOException, FileNotFoundException, ClassNotFoundException {

        String fechaAnt, descripcionAnt, tipoAnt, descripcionTipo, nombreCarac;
        Serializar seri = new Serializar();
        int tipo = 0 , id = 0;
        System.out.println("---- ANTECEDENTE ---");
        System.out.println("Fecha: ");
        fechaAnt = leer.next();
        System.out.println("Descripcion: ");
        descripcionAnt = leer.next();
        System.out.println("Tipo: Positivo (1) / Negativo (2) ");
        tipo = leer.nextInt();
        if (tipo == 1) {
            tipoAnt = "Positivo";
        } else {
            tipoAnt = "Negativo";
        }
        System.out.println("Descripcion del tipo: ");
        descripcionTipo = leer.next();
        System.out.println("Nombre caracteristico: ");
        nombreCarac = leer.next();        
        System.out.println("Codigo: ");
        id = leer.nextInt();
        Antecedentes ant = new Antecedentes(fechaAnt, descripcionAnt, tipoAnt, descripcionTipo, nombreCarac, cedula, id);
        listaAntecedentes.add(ant);
        seri.guardarRegistrosAnt(listaAntecedentes);

        Menu();
    }

    public void imprimir() throws IOException, FileNotFoundException, ClassNotFoundException {

        boolean existencia = true;
        Serializar seri = new Serializar();
        listaPersona = seri.listaActualesPer();
        listaAntecedentes = seri.listaActualesAnt();

        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("\n------- USUARIO -------");
            System.out.println("Nombre: " + listaPersona.get(i).getNombrePersona());
            System.out.println("Cedula: " + listaPersona.get(i).getCedulaPersona());
            System.out.println("Edad: " + listaPersona.get(i).getEdadPersona());
            System.out.println("Genero: " + listaPersona.get(i).getGeneroPersona());                        
            for (int j = 0; j < listaAntecedentes.size(); j++) {
                if (listaPersona.get(i).getCedulaPersona().equals(listaAntecedentes.get(j).getCedula())) {
                    System.out.println("\n**** Antecedente *****");
                    System.out.println("Fecha: " + listaAntecedentes.get(j).getFechaAntecedente());
                    System.out.println("Descripcion: " + listaAntecedentes.get(j).getDescripcionAntecedente());
                    System.out.println("Tipo: " + listaAntecedentes.get(j).getTipoAntecedente());
                    System.out.println("Descripcion de Tipo: " + listaAntecedentes.get(j).getDescripcionTipo());
                    System.out.println("Nombre de Antecedente: " + listaAntecedentes.get(j).getNombreCaracteristico());
                    System.out.println("Codigo de Antecedente: " + listaAntecedentes.get(j).getId());
                    existencia = true;
                }else{
                    existencia = false;
                }
            }
            if (existencia == false) {
                System.out.println("\nNo tengo antecedestes\n");
            }
        }
    }
}

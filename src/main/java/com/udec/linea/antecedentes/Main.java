/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.linea.antecedentes;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author  Andrea Orjuela
 * @author  Juan Camilo Santana
 */
public class Main  {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        Logica log = new Logica();
        log.Menu();
    }
    
}

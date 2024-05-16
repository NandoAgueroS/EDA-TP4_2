/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eda.tp4_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author NandoJ
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ParqueDeDiversiones parque1=new ParqueDeDiversiones(5);
        
        parque1.ingreso();
        parque1.ingreso();
        parque1.ingreso();
        parque1.ingreso();
        parque1.ingreso();
        
        parque1.ingreso();
        
//        parque1.salida(3);
//        parque1.salida(2);
//        parque1.salida();
        
//        parque1.ingreso();
        
        parque1.samba(4);
        parque1.consultaPadre(10);
        
    }
    
}

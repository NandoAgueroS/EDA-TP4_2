
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
        parque1.ingreso();
        parque1.chocadores();
        parque1.samba();
        parque1.montaniaRusa();
        parque1.samba();
        parque1.salida(5);
        parque1.salida(2);
        parque1.salida(1);
        parque1.salida(3);
        parque1.salida(4);
        parque1.ingreso();
        parque1.consultaPadre(6);   
    }
}

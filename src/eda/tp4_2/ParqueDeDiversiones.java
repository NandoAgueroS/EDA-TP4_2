/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda.tp4_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author NandoJ
 */
public class ParqueDeDiversiones {

    private int capacidadMax;
    private Queue<Integer> fila;
    Integer idVisitante = 0;
    Queue<Integer> samba = new LinkedList<>();
    Queue<Integer> montaniaRusa = new LinkedList<>();
    Queue<Integer> chocadores = new LinkedList<>();

    public ParqueDeDiversiones(int capacidadMax) {
        this.capacidadMax = capacidadMax;
        fila = new LinkedList<>();
    }

    public int tamanioFila() {
        Queue<Integer> aux = new LinkedList<>();
        int cont = 1;
        while (!fila.isEmpty()) {
            aux.add(fila.poll());
            cont++;
        }
        while (!aux.isEmpty()) {
            fila.add(aux.poll());
        }
        return cont;
    }

    public void ingreso() {
//        System.out.println(tamanioFila());
        if (tamanioFila() <= capacidadMax) {
            idVisitante++;
            fila.add(idVisitante);
            System.out.println("La persona ingreso al parque" + " id: " + idVisitante);
        } else {
            System.out.println("El parque se encuentra lleno");
        }
    }

    public void salida(Integer idSalida) {
        Queue<Integer> aux = new LinkedList();
        while (!fila.isEmpty()) {
            aux.add(fila.poll());
        }
        while (!aux.isEmpty()) {
            if (aux.peek().equals(idSalida)) {
                aux.poll();
            } else {
                fila.add(aux.poll());
            }
        }
        System.out.println(fila.toString());
    }

    public void samba(Integer idPersona) {
        Queue<Integer> aux = new LinkedList();
        while (!fila.isEmpty()) {
            aux.add(fila.poll());
        }
        while (!aux.isEmpty()) {
            if (aux.peek().equals(idPersona)) {
                samba.add(aux.peek());
                fila.add(aux.poll());
            } else {
                fila.add(aux.poll());
            }
        }
        System.out.println("ID " + idPersona + " ingreso a Samba");
        System.out.println(fila.toString());
        System.out.println(samba.toString());
    }

    public void consultaPadre(Integer idPersona) {
        Queue<Integer> aux = new LinkedList<>();
        boolean bandera = false;
        while (!fila.isEmpty()) {

            if (fila.peek().equals(idPersona)) {
                bandera = true;
            }
            aux.add(fila.poll());
        }
        if (bandera) {
            System.out.println("Su hijo está en el parque");
        }else{
            System.out.println("Su hijo no está en el parque");
        }
        while (!aux.isEmpty()) {
            fila.add(aux.poll());
        }
    }
}

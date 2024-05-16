
package eda.tp4_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author NandoJ
 */
public class ParqueDeDiversiones {

    private int capacidadMax;
    private Queue<Integer> colaGeneral;
    private Integer idVisitante = 0;
    private Queue<Integer> samba;
    private Queue<Integer> montaniaRusa;
    private Queue<Integer> chocadores;

    public ParqueDeDiversiones(int capacidadMax) {
        this.capacidadMax = capacidadMax;
        colaGeneral = new LinkedList<>();
        samba = new LinkedList<>();
        montaniaRusa = new LinkedList<>();
        chocadores = new LinkedList<>();
    }

    public int cantidadDeGente() {
        Queue<Integer> aux = new LinkedList<>();
        int cont = 0;
        //cuenta la gente de la cola general
        while (!colaGeneral.isEmpty()) {
            aux.add(colaGeneral.poll());
            cont++;
        }
        while (!aux.isEmpty()) {
            colaGeneral.add(aux.poll());
        }
        //cuenta la gente en la cola del samba
        while (!samba.isEmpty()) {
            aux.add(samba.poll());
            cont++;
        }
        while (!aux.isEmpty()) {
            samba.add(aux.poll());
        }
        //cuenta la gente en la cola de montaña rusa
        while (!montaniaRusa.isEmpty()) {
            aux.add(montaniaRusa.poll());
            cont++;
        }
        while (!aux.isEmpty()) {
            montaniaRusa.add(aux.poll());
        }
        //cuenta la gente en la cola de los chocadores
        while (!chocadores.isEmpty()) {
            aux.add(chocadores.poll());
            cont++;
        }
        while (!aux.isEmpty()) {
            chocadores.add(aux.poll());
        }
        return cont;
    }

    public void ingreso() {
        /*Consulta el total de gente, y si no excede la capacidad maxima, 
        ingresa a la cola general.
        El id de las personas es autoincremental*/
        int totalGente = cantidadDeGente();
        System.out.println("Total gente " + totalGente);
        if (totalGente < capacidadMax) {
            idVisitante++;
            colaGeneral.add(idVisitante);
            System.out.println("La persona ingreso a la cola general parque" + 
                    " id: " + idVisitante);
        } else {
            System.out.println("El parque se encuentra lleno");
        }
    }

    public void salida(Integer idSalida) {
        /*este metodo recibe el ID de la persona que saldrá, se revisa en 
        que cola se encuentra la persona, cuando se encuentra, la bandera pasa 
        a ser true y no sigue revisando en las otras colas.
        Al encontrar a la persona la saca de la cola, 
        y por lo tanto de parque*/
        
        Queue<Integer> aux = new LinkedList();
        boolean bandera = false;
        
        while (!colaGeneral.isEmpty()) {
            if (colaGeneral.peek().equals(idSalida)) {
                colaGeneral.poll();
                System.out.println("ID " + idSalida + 
                        " salió del parque, estaba en la cola general");
                bandera = true;
            } else {
                aux.add(colaGeneral.poll());
            }
        }
            while (!aux.isEmpty()) {
                colaGeneral.add(aux.poll());
            }
        
        if (!bandera) {
            while (!samba.isEmpty()) {
                if (samba.peek().equals(idSalida)) {
                    bandera = true;
                    samba.poll();
                    System.out.println("ID " + idSalida + 
                            " salio del parque, estaba en samba");
                } else {
                    aux.add(samba.poll());
                }
            }
            while (!aux.isEmpty()) {
                samba.add(aux.poll());
            }
        }
        if (!bandera) {
            while (!montaniaRusa.isEmpty()) {
                if (montaniaRusa.peek().equals(idSalida)) {
                    bandera = true;
                    montaniaRusa.poll();
                    System.out.println("ID " + idSalida + 
                            " salio del parque, estaba en montaña rusa");
                } else {
                    aux.add(montaniaRusa.poll());
                }
            }
            while (!aux.isEmpty()) {
                montaniaRusa.add(aux.poll());
            }
        }
        if (!bandera) {
            while (!chocadores.isEmpty()) {
                if (chocadores.peek().equals(idSalida)) {
                    bandera = true;
                    chocadores.poll();
                    System.out.println("ID " + idSalida + 
                            " salio del parque, estaba en los chocadores");
                } else {
                    aux.add(chocadores.poll());
                }
            }
            while (!aux.isEmpty()) {
                chocadores.add(aux.poll());
            }
        }
        System.out.println("gente en parque: " + cantidadDeGente());
    }
    
    /*METODOS DE JUEGOS*/
    /*se pasa a la persona de la cola general a la cola del juego,
    si la cola general esta vacia, se informa*/

    public void samba() {
        if (!colaGeneral.isEmpty()) {

            System.out.println("ID " + colaGeneral.peek() + 
                    " ingreso a cola de Samba");
            samba.add(colaGeneral.poll());
        } else {
            System.out.println("no hay nadie en la cola general");
        }
    }

    public void chocadores() {
        if (!colaGeneral.isEmpty()) {

            System.out.println("ID " + colaGeneral.peek() + 
                    " ingreso a cola de Chocadores");
            chocadores.add(colaGeneral.poll());
        } else {
            System.out.println("no hay nadie en la cola general");
        }
    }

    public void montaniaRusa() {
        
        if (!colaGeneral.isEmpty()) {

            System.out.println("ID " + colaGeneral.peek() + 
                    " ingreso a cola de Montaña rusa");
            montaniaRusa.add(colaGeneral.poll());
        } else {
            System.out.println("no hay nadie en la cola general");
        }
    }

    public void consultaPadre(Integer idPersona) {
        /*se revisa en que cola se encuentra la persona, cuando se encuentra,
        la bandera pasa a ser true y no sigue revisando en las otras colas.
        Al encontrar a la persona informa en que cola se encuentra*/
        
        Queue<Integer> aux = new LinkedList();
        boolean bandera = false;
        while (!colaGeneral.isEmpty()) {
            if (colaGeneral.peek().equals(idPersona)) {
                System.out.println("Su hijo/a, con ID " + idPersona + 
                        " se encuentra en la cola general del parque");
                bandera = true;
            }
                aux.add(colaGeneral.poll());        
        }
            while (!aux.isEmpty()) {
                colaGeneral.add(aux.poll());
            }
        if (!bandera) {
            while (!samba.isEmpty()) {
                if (samba.peek().equals(idPersona)) {
                    bandera = true;
                    System.out.println("Su hijo/a, con ID " + idPersona + 
                            " se encuentra en la cola del samba");
                }
                aux.add(samba.poll());

            }
            while (!aux.isEmpty()) {
                samba.add(aux.poll());
            }
        }
        if (!bandera) {
            while (!montaniaRusa.isEmpty()) {
                if (montaniaRusa.peek().equals(idPersona)) {
                    bandera = true;
                    System.out.println("Su hijo/a, con ID " + idPersona + 
                            " se encuentra en la cola de la montaña rusa");
                }
                aux.add(montaniaRusa.poll());

            }
            while (!aux.isEmpty()) {
                montaniaRusa.add(aux.poll());
            }
        }
        if (!bandera) {
            while (!chocadores.isEmpty()) {
                if (chocadores.peek().equals(idPersona)) {
                    bandera = true;
                    System.out.println("Su hijo/a, con ID " + idPersona + 
                            " se encuentra en la cola de los chocadores");
                }
                aux.add(chocadores.poll());

            }
            while (!aux.isEmpty()) {
                chocadores.add(aux.poll());
            }
        }
        if (!bandera) {
            System.out.println("Su hijo/a no se encuentra en el parque");
        }
    }
    
}

package es.udc.sistemasinteligentes.ejemplo;

import java.util.List;
import es.udc.sistemasinteligentes.*;
import java.util.Collections;
import java.util.ArrayList;

/* ESTRATEGIA DE BUSQUEDA NORMAL EJERCICIO 1 A*/
public class Estrategia4_2 implements EstrategiaBusqueda {

    public Estrategia4_2() {
    }

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Estado> explorados = new ArrayList<Estado>();
        Estado estadoActual = p.getEstadoInicial();
        explorados.add(estadoActual);

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + estadoActual);
        // Inicializar lista de nodos y agregar el primer nodo con valores nulos
        List<Nodo> nodos = new ArrayList<>();
        Nodo nodoInicial = new Nodo(estadoActual, null, null);
        nodos.add(nodoInicial);
        Nodo nodoPadre = nodoInicial;

        Accion accion = null;
        Estado estado = null;
        while (!p.esMeta(estadoActual)){

            System.out.println((i++) + " - " + estadoActual + " no es meta");
            Accion[] accionesDisponibles = p.acciones(estadoActual);
            boolean modificado = false;
            for (Accion acc: accionesDisponibles) {

                Estado sc = p.result(estadoActual, acc);
                System.out.println((i++) + " - RESULT(" + estadoActual + ","+ acc + ")=" + sc);
                if (!explorados.contains(sc)) {
                    estadoActual = sc;
                    System.out.println((i++) + " - " + sc + " NO explorado");
                    explorados.add(estadoActual);
                    modificado = true;
                    System.out.println((i++) + " - Estado actual cambiado a " + estadoActual);
                    Nodo nuevoNodo = new Nodo(sc, nodoPadre, acc);
                    nodos.add(nuevoNodo);
                    nodoPadre = nuevoNodo;
                    accion = acc;
                    estado = sc;
                    break;
                }
                else
                    System.out.println((i++) + " - " + sc + " ya explorado");
            }
            if (!modificado) throw new Exception("No se ha podido encontrar una solución");
        }
        Nodo meta = new Nodo(estado ,nodoPadre, accion);
        System.out.println((i++) + " - FIN - " + estadoActual);
        Nodo[] lista = new Nodo[nodos.size()];
        lista = nodos.toArray(lista);
        return reconstruye_sol(meta);

    }

    public Nodo[]  reconstruye_sol(Nodo meta){
        List<Nodo> solucion = new ArrayList<>();
        Nodo nodo = meta;
        while(nodo != null){
            solucion.add(nodo);
            nodo = nodo.getPadre();
        }
        Collections.reverse(solucion);
        Nodo[] lista = new Nodo[solucion.size()];
        lista = solucion.toArray(lista);
        return lista;

    }
}

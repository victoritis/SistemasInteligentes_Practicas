package es.udc.sistemasinteligentes.ejemplo;

import java.util.List;
import es.udc.sistemasinteligentes.*;
import java.util.Collections;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Estrategia_BusquedaGrafo implements EstrategiaBusqueda {

    public Estrategia_BusquedaGrafo() {
    }

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception {
        Estado estadoInicial = p.getEstadoInicial();
        Nodo nodoInicial = new Nodo(estadoInicial, null, null);
        ArrayList<Estado> explorados = new ArrayList<Estado>();
        Queue<Nodo> frontera = new LinkedList<>();

        frontera.add(nodoInicial);

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + estadoInicial);

        while (!frontera.isEmpty()) {
            Nodo nodoActual = frontera.remove();
            Estado estadoActual = nodoActual.getEstado();

            if (p.esMeta(estadoActual)) {
                System.out.println((i++) + " - Solución encontrada en " + estadoActual);
                return reconstruye_sol(nodoActual);
            }

            explorados.add(estadoActual);
            Accion[] accionesDisponibles = p.acciones(estadoActual);

            System.out.println((i++) + " - Expandiendo " + estadoActual);

            for (Accion acc : accionesDisponibles) {
                Estado sucesor = p.result(estadoActual, acc);

                if (!explorados.contains(sucesor)) {
                    Nodo nodoSucesor = new Nodo(sucesor, nodoActual, acc);
                    frontera.add(nodoSucesor);
                    System.out.println((i++) + " - Añadido " + sucesor + " a la frontera");
                } else {
                    System.out.println((i++) + " - " + sucesor + " ya explorado");
                }
            }
        }

        throw new Exception("No se ha podido encontrar una solución");
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

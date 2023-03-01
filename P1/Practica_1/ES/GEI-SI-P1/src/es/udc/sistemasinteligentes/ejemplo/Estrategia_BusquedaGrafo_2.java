/*package es.udc.sistemasinteligentes.ejemplo;

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

public class Estrategia_BusquedaGrafo_2 implements EstrategiaBusqueda {

    public Estrategia_BusquedaGrafo_2() {
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

        // Inicializar la frontera y agregar el primer nodo
        Queue<Nodo> frontera = new LinkedList<>();
        frontera.add(nodoInicial);

        Accion accion = null;
        Estado estado = null;

        while (!p.esMeta(estadoActual)){
            System.out.println((i++) + " - " + estadoActual + " no es meta");

            // Si la frontera está vacía, no hay solución
            if (frontera.isEmpty()) {
                throw new Exception("No se ha podido encontrar una solución");
            }

            // Sacar el primer nodo de la frontera y actualizar el estado actual
            Nodo nodoPadre = frontera.poll();
            estadoActual = nodoPadre.getEstado();

            Accion[] accionesDisponibles = p.acciones(estadoActual);

            for (Accion acc: accionesDisponibles) {
                Estado sc = p.result(estadoActual, acc);
                System.out.println((i++) + " - RESULT(" + estadoActual + ","+ acc + ")=" + sc);

                // Si el sucesor no está explorado ni en la frontera, lo agregamos a ambos
                if (!explorados.contains(sc) && !frontera.contains(new Nodo(sc))) {
                    System.out.println((i++) + " - " + sc + " NO explorado ni en la frontera");
                    explorados.add(sc);
                    Nodo nuevoNodo = new Nodo(sc, nodoPadre, acc);
                    nodos.add(nuevoNodo);
                    frontera.add(nuevoNodo);

                    // Si el sucesor es meta, terminamos el bucle
                    if (p.esMeta(sc)) {
                        accion = acc;
                        estado = sc;
                        break;
                    }
                }
                else
                    System.out.println((i++) + " - " + sc + " ya explorado o en la frontera");
            }


        }

        // Crear el nodo meta y reconstruir la solución
        Nodo meta = new Nodo(estado ,nodoPadre, accion);
        System.out.println((i++) + " - FIN - " + estadoActual);
        Nodo[] lista =
                new Nodo[nodos.size()]; lista =
                nodos.toArray(lista); return reconstruye_sol(meta);

    }

    public Nodo[]  reconstruye_sol(Nodo meta){
        List<Nodo> solucion =
                new ArrayList<>();
        Nodo nodo =
                meta; while(nodo != null){
            solucion.add(nodo);
            nodo =
                    nodo.getPadre(); } Collections.reverse(solucion);
        Nodo[] lista =
                new Nodo[solucion.size()]; lista =
                solucion.toArray(lista); return lista;

    }
}
*/

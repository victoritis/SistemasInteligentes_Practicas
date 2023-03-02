package es.udc.sistemasinteligentes.ejemplo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class Busqueda_Profundidad extends Estrategia_BusquedaGrafo {
    @Override
    protected Queue<Nodo> getEstructuraFrontera(){

        return Collections.asLifoQueue(new LinkedList<Nodo>());

    }




}

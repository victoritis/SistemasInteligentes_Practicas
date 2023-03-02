package es.udc.sistemasinteligentes.ejemplo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

//IMPLEMENTACION DE BUSQUEDA PROFUNDIDAD, SE REDEFINE SOLAMENTE EL ARREGLO DE DATOS DONDE SE GURDAN LOS NODOS
public class Busqueda_Profundidad extends Estrategia_BusquedaGrafo {
    @Override
    protected Queue<Nodo> getEstructuraFrontera(){

        return Collections.asLifoQueue(new LinkedList<Nodo>());

    }




}

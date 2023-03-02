package es.udc.sistemasinteligentes.ejemplo;

import java.util.LinkedList;
import java.util.Queue;

//IMPLEMENTACION DE BUSQUEDA ANCHURA, SE REDEFINE SOLAMENTE EL ARREGLO DE DATOS DONDE SE GURDAN LOS NODOS
public class Busqueda_Anchura extends Estrategia_BusquedaGrafo{

    @Override
    protected Queue<Nodo> getEstructuraFrontera(){

        return new LinkedList<>();

    }
}

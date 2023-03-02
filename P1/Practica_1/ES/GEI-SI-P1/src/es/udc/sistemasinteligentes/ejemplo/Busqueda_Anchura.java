package es.udc.sistemasinteligentes.ejemplo;

import java.util.LinkedList;
import java.util.Queue;

public class Busqueda_Anchura extends Estrategia_BusquedaGrafo{

    @Override
    protected Queue<Nodo> getEstructuraFrontera(){

        return new LinkedList<>();

    }
}

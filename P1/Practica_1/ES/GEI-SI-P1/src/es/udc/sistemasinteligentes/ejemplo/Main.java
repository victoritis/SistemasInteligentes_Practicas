package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.ProblemaBusqueda;
import java.util.List;
import es.udc.sistemasinteligentes.*;
public class Main {

    public static void main(String[] args) throws Exception {
        ProblemaAspiradora.EstadoAspiradora estadoInicial = new ProblemaAspiradora.EstadoAspiradora(ProblemaAspiradora.EstadoAspiradora.PosicionRobot.IZQ,
                                                                                                    ProblemaAspiradora.EstadoAspiradora.PosicionBasura.AMBAS);
        ProblemaBusqueda aspiradora = new ProblemaAspiradora(estadoInicial);

        EstrategiaBusqueda buscador = new Busqueda_Profundidad();
        //System.out.println(buscador.soluciona(aspiradora));
        mostrarSolucion(buscador.soluciona(aspiradora));
    }

    public static void mostrarSolucion(Nodo[] solucion) {
        System.out.print("\n" + "IMPRIMIENDO SOLUCION" + "\n");
        String solucionStr = "\n" + 1 + "";
        Nodo nodo = null;
        for (int i = 0; i <= solucion.length - 1; i++) {
            nodo = solucion[i];
            if (nodo.getAccion() != null) {
                solucionStr += (i+1) + nodo.getEstado().toString() + " con " + nodo.getAccion().toString() + "\n";
            } else {
                solucionStr += nodo.getEstado().toString() + "\n";
            }
        }
        System.out.println(solucionStr);
        System.out.print( "EL RESULTADO ES:   " + nodo.getEstado().toString() + "\n\n\n\n");
    }
}

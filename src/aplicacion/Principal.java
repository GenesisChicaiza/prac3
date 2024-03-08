package aplicacion;
import java.util.Scanner;

/**
 * Clase que contiene el metodo principal para calcular una aproximacion de Pi.
 *@author Genesis Chicaiza
 */
public class Principal {
     /**
     * metodo principal que solicita al usuario la cantidad de pasos para la aproximacion de Pi.
     * Utiliza una expresion lambda y el metodo de Monte Carlo para realizar el calculo y muestra el resultado.
     *
     * @param args Argumentos de linea de comandos
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de pasos para la aproximacion de Pi: ");
        long pasos = sc.nextLong();

        AproximadorPi aproximadorPi = (p) -> {
            long puntosDentroCirculo = 0;
            for (long i = 0; i < p; i++) {
                double x = Math.random();
                double y = Math.random();
                if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                    puntosDentroCirculo++;
                }
            }
            return 4.0 * puntosDentroCirculo / p;
        };

        double aproxPi = aproximadorPi.aproximarPi(pasos);

        System.out.println("Aproximacion de Pi: " + aproxPi);
        sc.close();
    }

    /**
     * define un metodo para aproximar el numero Pi utilizando expresiones lambda.
     */
    interface AproximadorPi {
        /**
         * Aproxima el numero Pi utilizando el metodo de Monte Carlo.
         *
         * @param pasos La cantidad de pasos para el calculo.
         * @return La aproximacion de Pi.
         */
        double aproximarPi(long pasos);
    }
}

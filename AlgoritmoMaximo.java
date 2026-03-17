

import java.util.Random;

public class AlgoritmoMaximo {

    // Método que encuentra el número máximo en un arreglo
    public static int encontrarMaximo(int[] arreglo) {
        int max = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        return max;
    }

    // Generar arreglo aleatorio
    public static int[] generarAleatorio(int tamaño) {
        Random random = new Random();
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextInt(100000);
        }
        return arreglo;
    }

    // Generar arreglo creciente
    public static int[] generarCreciente(int tamaño) {
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = i;
        }
        return arreglo;
    }

    // Generar arreglo decreciente
    public static int[] generarDecreciente(int tamaño) {
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = tamaño - i;
        }
        return arreglo;
    }

    public static void main(String[] args) {

        int[] tamaños = { 10, 100, 1000, 10000, 100000 };

        System.out.println("    EVALUACIÓN DEL ALGORITMO DEL MÁXIMO      \n");

        for (int tamaño : tamaños) {

            System.out.println("Tamaño: " + tamaño);

            // Escenario A: Aleatorio
            int[] aleatorio = generarAleatorio(tamaño);
            long inicioA = System.nanoTime();
            encontrarMaximo(aleatorio);
            long finA = System.nanoTime();
            System.out.println("Aleatorio: " + (finA - inicioA) + " ns");

            // Escenario B: Creciente
            int[] creciente = generarCreciente(tamaño);
            long inicioB = System.nanoTime();
            encontrarMaximo(creciente);
            long finB = System.nanoTime();
            System.out.println("Creciente: " + (finB - inicioB) + " ns");

            // Escenario C: Decreciente
            int[] decreciente = generarDecreciente(tamaño);
            long inicioC = System.nanoTime();
            encontrarMaximo(decreciente);
            long finC = System.nanoTime();
            System.out.println("Decreciente: " + (finC - inicioC) + " ns");

            System.out.println("                                     ");
        }
    }
}

package Evaluación;

import java.util.Random;

public class AlgoritmoMaximo {

   
    public static int encontrarMaximo(int[] arreglo) {
        int max = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        return max;
    }


    public static int[] generarAleatorio(int tamaño) {
        Random random = new Random();
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextInt(100000);
        }
        return arreglo;
    }

 
    public static int[] generarCreciente(int tamaño) {
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = i;
        }
        return arreglo;
    }

   
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

            
            int[] aleatorio = generarAleatorio(tamaño);
            long inicioA = System.nanoTime();
            encontrarMaximo(aleatorio);
            long finA = System.nanoTime();
            System.out.println("Aleatorio: " + (finA - inicioA) + " ns");

           
            int[] creciente = generarCreciente(tamaño);
            long inicioB = System.nanoTime();
            encontrarMaximo(creciente);
            long finB = System.nanoTime();
            System.out.println("Creciente: " + (finB - inicioB) + " ns");

          
            int[] decreciente = generarDecreciente(tamaño);
            long inicioC = System.nanoTime();
            encontrarMaximo(decreciente);
            long finC = System.nanoTime();
            System.out.println("Decreciente: " + (finC - inicioC) + " ns");

            System.out.println("                                     ");
        }
    }
}

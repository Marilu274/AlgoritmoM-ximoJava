import java.util.Arrays;
import java.util.Random;

public class BubbleSortComparacion {

    //  Bubble Sort tradicional
    public static void bubbleSortNormal(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    //  Bubble Sort optimizado (marca del último intercambio)
    public static void bubbleSortOptimizado(int[] arreglo) {
        int n = arreglo.length;
        int ultimoIntercambio;

        do {
            ultimoIntercambio = 0;

            for (int i = 1; i < n; i++) {
                if (arreglo[i - 1] > arreglo[i]) {
                    int temp = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = temp;
                    ultimoIntercambio = i;
                }
            }

            n = ultimoIntercambio;

        } while (n > 0);
    }

    //  Generar arreglo aleatorio
    public static int[] generarArregloAleatorio(int tamaño) {
        Random rand = new Random();
        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = rand.nextInt(10000);
        }

        return arreglo;
    }

    // Generar arreglo ordenado (mejor caso)
    public static int[] generarArregloOrdenado(int tamaño) {
        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = i;
        }

        return arreglo;
    }

    //  Generar arreglo inverso (peor caso)
    public static int[] generarArregloInverso(int tamaño) {
        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = tamaño - i;
        }

        return arreglo;
    }

    public static void main(String[] args) {

        int[] tamaños = { 1000, 2000, 3000, 4000, 5000 };

        System.out.println("Tamaño | Escenario | Normal(ns) | Optimizado(ns)");

        for (int tamaño : tamaños) {

            // ==========================
            // ESCENARIO 1: ALEATORIO
            // ==========================
            int[] aleatorio = generarArregloAleatorio(tamaño);
            int[] copia1 = Arrays.copyOf(aleatorio, aleatorio.length);
            int[] copia2 = Arrays.copyOf(aleatorio, aleatorio.length);

            long inicio = System.nanoTime();
            bubbleSortNormal(copia1);
            long fin = System.nanoTime();
            long tiempoNormal = fin - inicio;

            inicio = System.nanoTime();
            bubbleSortOptimizado(copia2);
            fin = System.nanoTime();
            long tiempoOptimizado = fin - inicio;

            System.out.println(tamaño + " | Aleatorio | " + tiempoNormal + " | " + tiempoOptimizado);

            // ==========================
            // ESCENARIO 2: ORDENADO
            // ==========================
            int[] ordenado = generarArregloOrdenado(tamaño);
            copia1 = Arrays.copyOf(ordenado, ordenado.length);
            copia2 = Arrays.copyOf(ordenado, ordenado.length);

            inicio = System.nanoTime();
            bubbleSortNormal(copia1);
            fin = System.nanoTime();
            tiempoNormal = fin - inicio;

            inicio = System.nanoTime();
            bubbleSortOptimizado(copia2);
            fin = System.nanoTime();
            tiempoOptimizado = fin - inicio;

            System.out.println(tamaño + " | Ordenado | " + tiempoNormal + " | " + tiempoOptimizado);

            // ==========================
            // ESCENARIO 3: INVERSO
            // ==========================
            int[] inverso = generarArregloInverso(tamaño);
            copia1 = Arrays.copyOf(inverso, inverso.length);
            copia2 = Arrays.copyOf(inverso, inverso.length);

            inicio = System.nanoTime();
            bubbleSortNormal(copia1);
            fin = System.nanoTime();
            tiempoNormal = fin - inicio;

            inicio = System.nanoTime();
            bubbleSortOptimizado(copia2);
            fin = System.nanoTime();
            tiempoOptimizado = fin - inicio;

            System.out.println(tamaño + " | Inverso | " + tiempoNormal + " | " + tiempoOptimizado);

            System.out.println("--------------------------------------------------");
        }
    }
}



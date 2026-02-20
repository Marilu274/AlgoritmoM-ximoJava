QuickSort
import java.util.Random;

public class QuickSortEvaluacion {

    
    public static void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int pivoteIndex = particion(arreglo, inicio, fin);
            quickSort(arreglo, inicio, pivoteIndex - 1);
            quickSort(arreglo, pivoteIndex + 1, fin);
        }
    }

    private static int particion(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;

        return i + 1;
    }

    
    public static int[] generarAleatorio(int tamaño) {
        Random random = new Random();
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextInt(100000);
        }
        return arreglo;
    }

    public static void main(String[] args) {

        int[] tamaños = {1000, 5000, 10000, 20000, 50000};

        System.out.println("Evaluación QuickSort\n");

        for (int tamaño : tamaños) {
            int[] arreglo = generarAleatorio(tamaño);

            long inicio = System.nanoTime();
            quickSort(arreglo, 0, arreglo.length - 1);
            long fin = System.nanoTime();

            System.out.println("Tamaño: " + tamaño + 
                               " | Tiempo: " + (fin - inicio) + " ns");
        }
    }
}

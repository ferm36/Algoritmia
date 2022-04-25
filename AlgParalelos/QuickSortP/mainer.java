package parallel;

import java.util.Arrays;
import java.util.Random;

public class mainer {
    
    public static void main(String[] args){
        // Prueba con un array pequeño.
        
        Integer arr[] = {0,9,6,2,6,2,8,5,2,4,22,55,7,8,2,7,3};
        // Ordenando con la implementacion en java por default.
        System.out.println("Arreglo desordenado: " + Arrays.deepToString(arr));
        final double singleSortStart = System.currentTimeMillis();
        Integer[] sortedArr = new Integer[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        final double singleSortEnd = System.currentTimeMillis();
        System.out.println("Arreglo ordenado usando un hilo: " + Arrays.deepToString(sortedArr));
        final double timeUsedSingleSort = singleSortEnd - singleSortStart;
        System.out.println("Tiempo de ordenación usando un hilo: " + timeUsedSingleSort);
        System.out.println();
        //Usamos la implementacion multihilo.
        final double parallelSortStart = System.currentTimeMillis();
        quicksort.sort(arr);
        final double parallelSortEnd = System.currentTimeMillis();
        final double timeUsedParallelSort = parallelSortEnd - parallelSortStart;
        int num_threads = quicksort.getThreads();
        System.out.println("Arreglo ordenado usando " + num_threads + " : " + Arrays.deepToString(arr));
        System.out.println("Tiempo de ordenación usando " + num_threads + " hilos: " + timeUsedParallelSort);
        
        //Prueba en un array de 1000000 de elementos.
        
        //Generación del arreglo.
        Random random = new Random(System.currentTimeMillis());
        Integer[] values = new Integer[1000000];
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt();
        }
        
        Integer[] sortedValues = new Integer[1000000];
        System.arraycopy(values, 0, sortedValues, 0, values.length);
        
        //Inicio de la ordenación.
        final long sortStartTime = System.currentTimeMillis();
        //Ordenar usando implementación por defecto en java.
        Arrays.sort(sortedValues);
        final long sortTradeOff = System.currentTimeMillis();
        quicksort.sort(values);
        final long sortEndTime = System.currentTimeMillis();
        
        //Stats
        System.out.println("\nTiempo en 1 millón de registros.\n");
        System.out.println("Usando Java: " + (sortTradeOff - sortStartTime));
        System.out.println("Usando implementación multihilo: " + (sortEndTime - sortTradeOff));
        System.exit(0);
    }
}

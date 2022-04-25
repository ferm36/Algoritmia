package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import static org.junit.Assert.assertArrayEquals;

import sorting.ParallelMergeSort;
import sorting.mergeSort;

public class TestingPMS {

    @Test
    public static void performanceBenchmarking() {
        int[] serial = new Random().ints(100_000_000).toArray();
        int[] parallel = Arrays.copyOf(serial, serial.length);
        
        mergeSort serialSort = new mergeSort();
        long start = System.currentTimeMillis();
        serialSort.mergeSort(serial, 0, serial.length - 1);
        System.out.println("Ordenamiento secuencial realizado en: " + (System.currentTimeMillis() - start));
        
        ParallelMergeSort sorter = new ParallelMergeSort(parallel);
        start = System.currentTimeMillis();
        sorter.sort();
        System.out.println("Ordenamiento paralelo realizado en: " +(System.currentTimeMillis() - start));
        assertArrayEquals(parallel, serial);
    }
    
    public static void main(String[] args){
        performanceBenchmarking();
        System.out.println("Se usaron " + Runtime.getRuntime().availableProcessors() + " hilos.");
    }
}

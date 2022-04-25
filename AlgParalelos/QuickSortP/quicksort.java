package parallel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class quicksort {
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int FALLBACK = 2;
    private static Executor pool = Executors.newFixedThreadPool(NUM_THREADS);
    
    public static int getThreads(){
        return NUM_THREADS;
    }
    
    public static <T extends Comparable<T>> void sort(T[] arr){
        final AtomicInteger count = new AtomicInteger(1);
        pool.execute(new QuicksortRun(arr, 0, arr.length - 1, count));
        
        try {
            synchronized (count) {
                count.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static class QuicksortRun<T extends Comparable<T>> implements Runnable {
        private final T[] values;
        private final int left;
        private final int right;
        private final AtomicInteger numThreads;
        
        public QuicksortRun(T[] values, int left, int right, AtomicInteger count) {
            this.values = values;
            this.left = left;
            this.right = right;
            this.numThreads = count;
        }
        
        @Override
        public void run() {
            quicksort(left, right);
            synchronized (numThreads) {
                if (numThreads.getAndDecrement() == 1)
                    numThreads.notify();
            }
        }
        
        private void quicksort(int pivotL, int pivotR) {
            if (pivotL < pivotR) {
                int storeIndex = partition(pivotL, pivotR);
                if (numThreads.get() >= FALLBACK * NUM_THREADS) {
                    quicksort(pivotL, storeIndex - 1);
                    quicksort(storeIndex + 1, pivotR);
                } else {
                    numThreads.getAndAdd(2);
                    pool.execute(new QuicksortRun(values, pivotL, storeIndex - 1, numThreads));
                    pool.execute(new QuicksortRun(values, storeIndex + 1, pivotR, numThreads));
                }
            }
        }
        
        private int partition(int pivotL, int pivotR) {
            T pivotV = values[pivotR];
            int storeIndex = pivotL;
            for (int i = pivotL; i < pivotR; i++){
                if(values[i].compareTo(pivotV) < 0) {
                    swap(i, storeIndex);
                    storeIndex++;
                }
            }
            swap(storeIndex, pivotR);
            return storeIndex;
        }
        
        private void swap(int left, int right) {
            T temp = values[left];
            values[left] = values[right];
            values[right] = temp;
        }
    }
}
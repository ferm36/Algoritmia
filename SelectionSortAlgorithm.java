/* Autor: Luis Fernando Morales.*/
import java.util.Arrays;

public class SelectionSortAlgorithm {

    public static void SelectionSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[min]) {
                    min = j;
                }
            }
            int alternar = arreglo[i];
            arreglo[i] = arreglo[min];
            arreglo[min] = alternar;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 4, 6, 1, 7, 10};
        SelectionSort(array);
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }
}


import java.util.Arrays;

public class InsertionMethod {

    static int iteraciones = 0;

    public void insertionSort(int array[]) {
        int tamano = array.length;

        for (int i = 1; i < tamano; i++) {
            int aux = array[i];
            int j = i - 1;

            while (j >= 0 && aux < array[j]) {
                array[j + 1] = array[j];
                --j;
                iteraciones++;
                System.out.println(Arrays.toString(array));
            }

            array[j + 1] = aux;
        }
    }

    public static void main(String args[]) {
        int[] numeros = {12, 42, 55, 3, 77, 4, 9};
        InsertionMethod im = new InsertionMethod();
        im.insertionSort(numeros);
        System.out.println();
        System.out.println("Arreglo ordenado: ");
        System.out.println(Arrays.toString(numeros));
        System.out.println();
        System.out.println("Completado en " + iteraciones + " iteraciones.");
    }
}

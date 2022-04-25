
import java.util.Arrays;

public class Heapsort {

    public static void makeMound(int[] a, int nodo, int fin) {
        int izq = 2 * nodo + 1;
        int der = izq + 1;
        int may;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            may = a[izq] > a[der] ? izq : der;
        }
        if (a[nodo] < a[may]) {
            int tmp = a[nodo];
            a[nodo] = a[may];
            a[may] = tmp;
            makeMound(a, may, fin);
        }
    }

    public static void sort(int[] a) {
        final int N = a.length;
        for (int nodo = N / 2; nodo >= 0; nodo--) {
            makeMound(a, nodo, N - 1);
        }
        for (int nodo = N - 1; nodo >= 0; nodo--) {
            int tmp = a[0];
            a[0] = a[nodo];
            a[nodo] = tmp;
            makeMound(a, 0, nodo - 1);
        }
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 6, 8, 4, 7, 84, 4, 3, 6, 76, 5, 43, 6, 7, 7};
        System.out.println("Arreglo desordenado: " + Arrays.toString(arreglo));
        sort(arreglo);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
    }
}

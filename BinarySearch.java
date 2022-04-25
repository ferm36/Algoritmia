
import java.util.Arrays;

public class BinarySearch {

    public static int binSearch(int arr[], int element) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (arr[middleIndex] == element) {
                return middleIndex;
            }
            else if (arr[middleIndex] < element) {
                firstIndex = middleIndex + 1;
            }
            else if (arr[middleIndex] > element) {
                lastIndex = middleIndex - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arreglo[] = {5, 6, 3, 6, 1, 4};
        Arrays.sort(arreglo);
        int index = binSearch(arreglo, 5);
        if (index != -1) {
            System.out.println("Elemento 5 encontrado en el índice " + index);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}


import java.util.Arrays;

public class Matrices {

    public static int[][] sumaMatriz(int[][] a, int[][] b) throws Exception {
        if ((a.length == b.length) && (a[0].length == b[0].length)) {

            int[][] suma = new int[a.length][a[0].length];
            for (int x = 0; x < a.length; x++) {
                for (int y = 0; y < a[x].length; y++) {
                    suma[x][y] = a[x][y] + b[x][y];
                }
            }
            return suma;
        } else {
            throw new Exception();
        }
    }

    public static int[][] restaMatriz(int[][] a, int[][] b) throws Exception {
        if ((a.length == b.length) && (a[0].length == b[0].length)) {

            int[][] resta = new int[a.length][a[0].length];
            for (int x = 0; x < a.length; x++) {
                for (int y = 0; y < a[x].length; y++) {
                    resta[x][y] = a[x][y] - b[x][y];
                }
            }
            return resta;
        } else {
            throw new Exception();
        }
    }

    public static int[][] multiplicarMatriz(int[][] a, int[][] b) throws Exception {
        if (a[0].length != b.length) {
            throw new RuntimeException("No se pueden multiplicar las matrices.");
        } else {
            int[][] producto = new int[b.length][b[0].length];
            for (int x = 0; x < b[0].length; x++) {
                for (int y = 0; y < a.length; y++) {
                    int suma = 0;
                    for (int z = 0; z < a[0].length; z++) {
                        suma += a[y][z] * b[z][x];
                    }
                    producto[y][x] = suma;
                }
            }
            return producto;
        }
    }

    public static void main(String[] args) {
        int[][] matriz1 = {{2, 4, 4}, {6, 6, 9}, {5, 6, 5}};
        int[][] matriz2 = {{2, 4, 4}, {6, 6, 9}, {5, 6, 5}};
        int[][] matriz = new int[3][3];

        try {
            matriz = sumaMatriz(matriz1, matriz2);
            System.out.println(Arrays.deepToString(matriz));
            matriz = restaMatriz(matriz1, matriz2);
            System.out.println(Arrays.deepToString(matriz));
            matriz = multiplicarMatriz(matriz1, matriz2);
            System.out.println(Arrays.deepToString(matriz));
        } catch (Exception e) {
            System.out.println("Matrices de diferente dimensión.");
        }
    }

}

public class BubbleSortEnhanced {

    public static void sortEnhanced(int[] arreglo) {
        int pasadas = 0;
        boolean cambios = true;
        for (int i = 0; cambios; i++) {
            pasadas++;
            cambios = false;
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    trade(arreglo, j, j + 1);
                    cambios = true;
                }
            }
            printArray(arreglo);
        }
        System.out.println("Pasadas: " + pasadas);
    }

    private static void trade(int[] arreglo, int a, int b) {
        int tmp = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = tmp;
    }

    public static void main(String[] args) {
		int[] arreglo = {8, 4, 1, 3, 5, 7, 2, 6, 34, 4323, 23423, 123, 123, 1, 4, 6};
		sortEnhanced(arreglo);
	}
    
        public static void printArray(int[] numeros) {
		System.out.print("[");
		for (int i = 0; i < numeros.length - 1; i++)
			System.out.print(numeros[i] + ", ");
		System.out.print(numeros[numeros.length-1] + "]");
		System.out.println();
	}

}
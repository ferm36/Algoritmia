public class BubbleSort {

	public static void main(String[] args) {
		int[] arreglo = {8, 4, 1, 3, 5, 7, 2, 6, 34, 4323, 23423, 123, 123, 1, 4, 6};
		bubbleSort(arreglo);
		//imprimeArreglo(arreglo);
	}

	public static int[] bubbleSort(int[] arr) {
		int temp;
		int pasadas = 0;
		for (int i = 0; i < arr.length; i++)
			for (int j = 1; j < arr.length; j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
				pasadas++;
				imprimeArreglo(arr);
			}
		System.out.println("Terminado en " + pasadas + " operaciones");
		return (arr);
	}

    public static void imprimeArreglo(int[] numeros) {
		System.out.print("[");
		for (int i = 0; i < numeros.length - 1; i++)
			System.out.print(numeros[i] + ", ");
		System.out.print(numeros[numeros.length-1] + "]");
		System.out.println();
	}
}
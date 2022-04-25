public class InsertionSortMethod{
    static int iteraciones = 1;
    
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for (int i=1; i<n;i++){
            int llave = arr[i];
            int j = i-1;
            
            while(j >=0 && arr[j] > llave){
                arr[j+1] = arr[j];
                j = j-1;
                iteraciones++;
                /* imprimeArreglo(arr); */
            }
            arr[j+1] = llave;
        }
    }
    
    public static void imprimeArreglo(int arr[]){
        int n = arr.length;
        System.out.print("[");
        for(int i =0; i<n; ++i){
            System.out.print(arr[i]+", ");}
        System.out.print(arr[arr.length-1]+"]");
        System.out.println();
    }
    
    public static void main(String args[]){
        int arr[] = {12,42,55,3,77,4,9};
        InsertionSortMethod.insertionSort(arr);
        imprimeArreglo(arr);
        System.out.println("Iteraciones: "+ iteraciones);
    }
}
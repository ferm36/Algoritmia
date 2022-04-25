import java.util.Arrays;
        
public class QuickSearch {
    public static void Quicksort(int numeros[], int izq, int der){
        int pivote = numeros[izq];
        int i = izq;
        int j = der;
        int aux;
        
        while(i<j){
            while(numeros[i]<= pivote && i <j)
                i++;
                
            while (numeros[j] > pivote)
                j--;
            
            if (i<j){
                aux =numeros[i];
                numeros[j]=aux;
            }
        }
        numeros[izq]=numeros[j];
        numeros[j]=pivote;
        if(izq < j-1)
            Quicksort(numeros, izq,j-1);
        if(j+1 < der)
            Quicksort(numeros,j+1,der);
    }
    
    public static void main(String[] args){
        int [] numeros = {10,4,5,2,6,3,6,3,5,8,9,0};
        System.out.print("Arreglo inicial desordenado: ");
        System.out.println(Arrays.toString(numeros));
        Quicksort(numeros, 0, numeros.length-1);
        System.out.print("Arreglo final ordenado: ");
        System.out.println(Arrays.toString(numeros));
    }
}

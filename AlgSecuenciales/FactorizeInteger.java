
/**
 *
 * @author fernando
 */
import java.io.*; //Librería estándar para entrada/salida.

//Inicio de la clase.
public class FactorizeInteger {

    int nums; //Auxiliar para el constructor.

    //Inicio del constructor de la clase.
    public FactorizeInteger(int test) {
        nums = test;
    }

    //Método principal de la clase.
    public static void factorize(int num) {
        //Comprueba si el número es diferente de 1.
        if (num == 1) {
            System.err.println("El número debe ser diferente de 1.");
            System.exit(0);
        } else {
            //Ciclo que descompone el número en factores primos.
            for (int i = 2; i <= num; i++) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                }
            }
        }
    }

    //Inicio del main.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el número a factorizar: ");
        int num = Integer.parseInt(br.readLine());
        FactorizeInteger FI = new FactorizeInteger(num);
        System.out.println("Los factores PRIMOS de este número, son: \n");
        FI.factorize(num);
    }

}

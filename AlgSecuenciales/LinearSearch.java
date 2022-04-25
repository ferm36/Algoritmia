
public class LinearSearch {

    public static int Search(int arr[], int element) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == element){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {89, 58, 19, 38, 55, 34, 399, 3, 4, 2};
        System.out.println("55 se encuentra en el índice " + Search(arr, 55));
    }
}

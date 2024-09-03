import java.util.*;
public class Main{
    public static int result = 0; // Initialize result
    public static int iterator(int[] array){ //Working!!
        int index =  0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > index){
                index = array[i];
            }
        }
        return index;
    }
    public static int recursive(int[] array, int index){
        if(index >= array.length){
            return result; 
        }
        else{
            if (result < array[index]) {
                result = array[index];
            }
            return recursive(array, index+1);
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50) + 1;
        }
        System.out.println("The Array:"+Arrays.toString(array));
        System.out.println("The Highest value using recursion in the array is: "+recursive(array,0));
        System.out.println("The Highest value using Iteration in the array is: "+iterator(array));
        // boolean status =
        String Data = "The Array:"+Arrays.toString(array)+ "\nThe Highest value using recursion in the array is: "+recursive(array,0)
        + "\nThe Highest value using Iteration in the array is: "+iterator(array);
        Filescript writing = new Filescript();
        boolean status = writing.Writer("Data.txt",Data);
        if(status){
            System.out.println("Wrote to the File");
        }
        else{
            System.out.println("There was an error!");
        }
    }
}

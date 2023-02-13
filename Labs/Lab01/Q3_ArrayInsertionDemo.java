public class Q3_ArrayInsertionDemo{

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
        // Your code here
        int i;
        int []afterArray;
        afterArray = new int[beforeArray.length+1];
        for (i = 0; i< (beforeArray.length+1); i++){
            if (i == indexToInsert){
                afterArray[i]= valueToInsert;
            }
            else if (i <= (indexToInsert-1)){
                afterArray[i]=beforeArray[i];
            }

            else {
                afterArray[i] = beforeArray[i-1];
            }
        }
        return afterArray;
        
    }

    public static void main(String[] args){
        int [] valuesArray;
        valuesArray = new int[]{1,5,4,7,9,6};
        int index = 3;
        int value = 15;
        int n;
        int [] returnArray;
        returnArray = insertIntoArray(valuesArray, index, value);
        System.out.println("Array before insertion:");
        
        for (n = 0; n < valuesArray.length; n++){
            System.out.println(valuesArray[n]);
        }
        System.out.println("Array after insertion of "+ value + " at position "+index +":");
        for (n = 0; n< (valuesArray.length+1); n++){
                System.out.println(returnArray[n]);
        }
    }
}
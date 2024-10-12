/*
Take the given array and keep track of:
1. Any duplicate numbers
2. How many times the duplicate numbers appear
3. Print out those duplicate numbers with how many times they appear

 */

public class Array {
    public static void main(String[] args) {
        //Don't let the size of this scare you! no matter how big an array is, it all works the same!
        int[] myArray = {10,3,295,38,20,3,4,267,2445,10,5566,87,93,17,10,2,87,267,3176,3,82};
        for (int I = 0; I<myArray.length; I+=1){
            int numReps = 0;
            int upperNum = myArray[I]; 
            for (int i = I+1; i<myArray.length; i+=1){//May need I+1
                if (upperNum == myArray[i]){
                    numReps += 1;
                }
            }
            if (numReps != 0){
                System.out.println(String.format("%d is repeated %d times", myArray[I], numReps));
            }
        }
        //you cannot use the array util. Do this one by hand :(
    }
}

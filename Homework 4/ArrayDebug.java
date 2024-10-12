import java.util.Arrays;
//Our cheaty array helper file <3
public class ArrayDebug {
    public static void main(String[] args) {
        //Create me an array named "nameArray" that is a string and has 4 values in it, give me 4 names of people or animals you care about
        String[] nameArray = {"Billy", "Bob", "Joe", "Jenkins"};
        //Create me an array without any values, but it's an integer array named "numArray"
        int[] numArray;
        //Create me an int array named "newArray" and set it to have 20 null spaces
        int[] newArray = new int[20];

        
        //Here's our first practice array!
        String[] sortMe = {"Apple","Kiwi","Orange","Banana","Watermelon","Strawberry"};
       //What method is missing here to actually sort our array?
        Arrays.sort(sortMe);
        //And what method is missing here to print out that array?
        System.out.println(Arrays.toString(sortMe));
        //After this, you cannot use the array helper file, gotta go back to the old ways!!

        //another one!
        int addMe[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //How would we add every index together and print out the sum??
        //A small hint:
        int sum = 0;
        for(int i = 0; i<addMe.length;i+=1){
            sum += addMe[i];
        }
        System.out.println(String.format("Sum is: %d", sum));
        
        //thinking one! here's an array
        int maxMe[] = {280, 4892, 134, 23, 1937, 5329, 932, 89};
        //What would you have to do to find the largest number and then print that value?
        int curtMax = maxMe[0];
        for (int i = 0; i<maxMe.length; i+=1){
            if (maxMe[i] > curtMax){
                curtMax = maxMe[i];
            }
        }
        System.out.println(String.format("Largest number in maxMe is: %d", curtMax));

    }
}

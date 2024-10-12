/*
Referencing your homework from https://github.com/melissachodziutko/CMPT220/blob/main/Homework%203/LoopsDebug.java
Can you take problems 2, 3, and 5 and turn them into methods, and then call those methods in main?
Things that may trip you up while working on this:
1. the code works the same whether it's in a method or not, it just needs some minor variable adjustments probably
2. be wary of opening and closing brackets!! 
3. methods can't go inside methods!
4. methods go outside public static main, but inside public class main!
5. do you need to return the value? if so, make sure it isn't void

I give you two fully working method examples with and without parameters and called them for your reference :)
*/

import java.util.Scanner;
public class debugFunctions {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    System.out.println("Enter your first number to be added");
    int firstInput = sc.nextInt();
    System.out.println("Enter your second number to be added");
    int secondInput = sc.nextInt();
    //remember this method is returning, so we need to print it out
    System.out.println(add(firstInput,secondInput));

    System.out.println("im going to print out the word Dog now.");
    printDog();
    System.out.println(problem2(5));
    System.out.println(problem3(10));
    System.out.print(problem5("You"));
      
    }
    public static int add(int zyx, int tuv){
        return(zyx + tuv);
    }
    public static void printDog(){
        System.out.println("Dog");
    }
    public static int problem2(int input){
        int sum = input;
        for (int i = input-1; i > 0; i--){
            sum *= i;
        }
        return(sum);
    }
    public static int problem3(int input){
        int sum = 0;
        //No hint! what do you need to complete this task?
        for (int i = 1; i<input+1; i+=1){
            sum += i;
        }
        return(sum);
    }
    public static String problem5(String input){
        String reverseInpt = "";
        for (int i = input.length(); i>0; i-=1){
            reverseInpt += input.substring(i-1, i);
        }
        return(reverseInpt);
    }

  
}

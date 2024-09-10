import java.util.Scanner;

public class LoopsDebug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //P1: This one only prints 0-9, can you fix it so it prints 1-10?
        System.out.println("Problem 1");
        for (int i = 1; i < 11; i++){
            System.out.println(i);
        }

        //P2: Ask the user for a number. Create a loop to find the factorial of it
        //(factorial = X!, X being the user input, Factorials are every digit before X multiplied together)
        System.out.println("Problem 2");
        System.out.println("Enter a number and I will tell you the fatorial: ");
        int input = Integer.parseInt(sc.nextLine());
        //here's a hint
        int sum = input;
        for (int i = input-1; i > 0; i--){
            sum *= i;
        }
        System.out.print("Factorial is: ");
        System.out.println(sum);

        //P3: Ask the user for a number, and then add together every OTHER digit (starting from 1)
        System.out.println("Problem 3");
        System.out.println("Enter a number and I will tell you the sum of every other number: ");
        int input2 = Integer.parseInt(sc.nextLine());
        int sum2 = 0;
        //No hint! what do you need to complete this task?
        for (int i = 1; i<input2+1; i+=1){
            sum2 += i;
        }
        System.out.print("Sum is: ");
        System.out.println(sum2);
        //P4: Why does this loop never stop!
        // Cause it was set to true
        // Its like telling a child to to run then immedietley yelling at them for running
        //what can you do to break out of the loop after it prints once?
        System.out.println("Problem 4");
        boolean run = true;
        while (run == true){
            System.out.println("I printed once!");
            run = false;
        }

        //P5: Take a string from the user and print them the reverse!
        System.out.println("Problem 5");
        String input3 = sc.nextLine();
       // String input3 = sc.nextLine();
        String reverseInpt = "";
        for (int i = input3.length(); i>0; i-=1){
            reverseInpt += input3.substring(i-1, i);
        }
        System.out.print(reverseInpt);

        //hint     String reverse = "";

    }
}

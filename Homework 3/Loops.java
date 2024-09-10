import java.util.Scanner;
/*
challenge file!
this one isn't too tough but it does require a little bit of writing and some googling
figure out how to take a string from the user
then print back out every individual letter one letter per line
I also am requiring a small write up: explain your discovery to me.
how did you figure out how to do this? can you translate your code into simple terms? 
you need to explain why you picked your for loop conditional and what's doing the work with the string
if you're confused reach out!
 */

public class Loops {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter your string ");
    String input = sc.nextLine();
    for (int i = 0; i<input.length(); i+=1){
        System.out.println(input.substring(i, i+1));
    }

    }
}

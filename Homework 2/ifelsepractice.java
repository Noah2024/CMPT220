import java.util.Scanner;
//always start with importing our scanner so we can use it!


/* our first practice file!
* create a 3 question quiz game (lots of if/else likely)
* requirements: keep track of the user's score, has to have at least 3 questions, use if/else
* can be any topic you pick :) feel free to pick some obscure or niche topics!
* good luck!
* */



public class ifelsepractice {

    public static class question{
        String q = "";
        String a = "";
        int score  = 0;
        public question(String ques, String ans, int point){//String ques, String ans, int point
            q = ques;
            a = ans;
            score  = point;
        }
    }
    
    public static void main(String[] args) {
        int playerScore = 0;
        Scanner sc = new Scanner(System.in);
        question[] questions = new question[3];
        //question[] questions = {new question("test", "test", 1)};
        questions[0] = new question("What is you name?", "Arthur", 2);
        questions[1] = new question("What is your quest?", "To seek the holy grail!", 4);
        questions[2] = new question("What is the average air speed velocity of an unlaid swallow?", "11", 10);
        for (int i = 0; i < questions.length; i+=1){
            question curtQuest = questions[i];
            System.out.print(curtQuest.q);
            String input = sc.nextLine();
            if (input.equals(curtQuest.a)){
                System.out.println("Congrats you got " + Integer.toString(curtQuest.score) + " points!");
                playerScore += curtQuest.score;
            }else{
                System.out.println("Sorry you got it wong :( ");
            }
        }
        System.out.print("Wow you got " + Integer.toString(playerScore) + " point! :)");
        System.out.print("|Game over|");



    }
}



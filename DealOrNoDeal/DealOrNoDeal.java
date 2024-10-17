import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DealOrNoDeal {
    public static boolean gameOn = true;
    public static float[] excludeList = new float[26];
    public static float[] caseNums = new float[26];
    public static Random rand = new Random();
    //public static Map<String, String> caseNums = new HashMap<String, String>();
    public static float[] allNums = {0.1f, 1f, 5f, 10f, 25f, 50f, 75f, 100f, 200f, 300f, 400f,500f,750f, 1000f, 5000f,10000f, 25000f,50000f,75000f, 100000f, 200000f, 300000f, 400000f, 500000f, 750000f, 1000000f};
    public static void main(String[] args){
        //System.out.println(genBankeroffer());
        caseNums = genCases();
        System.out.println("Cases ready");
        beginGameLoop();
    }
    public static float[] genCases(){
        List<Float> avaibleNums = new ArrayList<>(List.of(0.1f, 1f, 5f, 10f, 25f, 50f, 75f, 100f, 200f, 300f, 400f,500f,750f, 1000f, 5000f,10000f, 25000f,50000f,75000f, 100000f, 200000f, 300000f, 400000f, 500000f, 750000f, 1000000f));//new ArrayList<>();
        for (int i = 0; i<caseNums.length; i+=1){
            if (!avaibleNums.isEmpty()) {
                int randIndex = rand.nextInt(0, avaibleNums.size());
                float randVal = avaibleNums.get(randIndex);
                //System.out.println(randVal);
                caseNums[i] = randVal;
                avaibleNums.remove(randVal);
            }
        }
        //System.out.println(caseNums.length);
        //for (int i = 0; i<caseNums.length; i+=1){
        //    System.out.println(caseNums[i]);
        //}
        return caseNums;
    }
    public static void beginGameLoop(){
        Scanner scan = new Scanner(System.in);
        int mainCase = 0;//Integer.parseInt(scan.nextLine());
        while (mainCase == 0){
            System.out.println("Please choose a valid case number");
            int input = validInpt(scan.nextLine(), false); 
            mainCase = input;
        }
        excludeList[mainCase-1] = allNums[mainCase-1];
        int casesSeen = 1; //starts at one to accout for users choice
        while (gameOn){
            System.out.println(Arrays.toString(excludeList));
            if (casesSeen != 25){
                int numToSee = rand.nextInt(1,4);
                //System.out.println(casesSeen);
                //System.out.println(numToSee);
                if ((casesSeen + numToSee) >= 26){
                    numToSee = 26 - casesSeen - 1;

                }
                int[] casesToView = new int[numToSee];
                for (int i = 0; i<casesToView.length; i+=1){//Getting case selections from user 
                    casesSeen +=1;
                    System.out.print("Please Select ");
                    System.out.print(numToSee - i);
                    System.out.println(" more case(s) to View");
                    int input = validInpt(scan.nextLine(), true);
                    if (input != 0){
                        casesToView[i] = input;
                    }else{
                        i-=1;
                        continue;
                    }
                    excludeList[input-1] = allNums[input]; 
                }
                for (int i = 0; i < casesToView.length; i+=1){//Giving the user the values of the case selections
                    System.out.print("Case number ");
                    System.out.print(casesToView[i]);
                    System.out.print(" contains $");
                    System.out.println(caseNums[casesToView[i]-1]);//Subtracting one so index lines up with case numbers
                }
                float bankOffer = genBankeroffer();
                System.out.print("The Banker would like to make you an offer! \nThe Banker: \"Alright Alright, ill offer you ");
                System.out.print(bankOffer);
                System.out.println("\nThe Banker: \"Deal, or No Deal?\"");
                System.out.println("Type 1 to accept the bankers deal, 0 to keep playing");

                String playerChoice = scan.nextLine();
                int playerInt = 0;
                try{
                    playerInt = Integer.parseInt(playerChoice);
                    if (playerInt < 0 || playerInt > 1){
                        System.out.println("Since you decided to enter a number I DIDN'T ASK FOR, you no longer get a choice. You play");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Since you decided to enter bad input, your still playing. Cause I said so.");
                }
                if (playerInt == 1){
                    System.out.print("Horay! You got...");
                    System.out.println(bankOffer);
                    System.out.print("But you did miss out on...");
                    System.out.println(allNums[mainCase-1]);
                    System.out.print("Thanks for playing!");
                    gameOn = false;
                }else{
                    System.out.println("Good luck");
                }
            }else{
                System.out.println("FINAL CASE!");
                System.out.println("The Banker is going to make you one final deal");
                System.out.print("The Banker: \" I tell you what, ill give you ");
                System.out.print(genBankeroffer());
                System.out.println("\" \n Type 1 to accept the bankers deal, or 0 to open your own case");
                
                System.out.println("Deal or no deal");
                String finalChoice = scan.nextLine();
                int finalInt = 0;
                try{
                    finalInt = Integer.parseInt(finalChoice);
                    if (finalInt < 0 || finalInt > 1){
                        System.out.println("Really? On the final choice you enter bad input, honestly fuck you, you lose");
                        System.out.print("GAME OVER! LOSER!");
                        gameOn = false;
                        return;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Really? On the final choice you enter bad input, honestly fuck you, you lose");
                    System.out.print("GAME OVER! LOSER!");
                    gameOn = false;
                    return;
                }
                if (finalInt == 1){
                    int lastCase = 0;
                    for (int i = 0; i<excludeList.length; i+=1){
                        if (excludeList[i] == 0.0f){
                            lastCase = i;
                        }
                    }
                    System.out.print("Congraduations! \n You Won");
                    System.out.println(allNums[lastCase]);
                    System.out.println("Thanks for playing!");
                    gameOn = false;
                }else{
                    System.out.print("Congraduations! \n You Won");
                    System.out.println(allNums[mainCase-1]);
                    System.out.println("Thanks for playing!");
                    gameOn = false; 
                }
            }
            
        }   
    }
    public static int validInpt(String str, boolean displayMsg){
        int num;
        try{
            num = Integer.parseInt(str);
        }catch (NumberFormatException e){
            System.out.println("Please Enter a VALID number. NO text, and NO decimals");
            return 0;
        }

        if (num > 26 || num < 1){
            if (displayMsg) System.out.println("Please select a number between 1 and 26");
            return 0;
        }
        if (excludeList[num-1] != 0.0f){
            if (displayMsg) System.out.println("Please select a number you have not alredy selected");
                return 0;
        }
        return num;
    }
    public static float genBankeroffer(){
        float added = 0;
        int count = 0;
        for (int i = 0; i<allNums.length; i+=1){
            boolean excludedCase = false;
            for (int j = 0; j<excludeList.length; j+=1){
                if (allNums[i] == excludeList[j]){
                    excludedCase = true;
                    break;
                }
            }
            if (!excludedCase) {
                added += allNums[i];
                count += 1;
            }
        }
        return(added/count);
    }
}

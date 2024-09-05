
public class Debug {
    public static void main(String[] args) {

        //for this section: are these all printing the best option? If they aren't, fix it!
        //(However you interpret 'fix' is fine i promise, any way you fix it shows you get the concept to me)
        int var1 = 4;
        String inbetween = (var1 > 4) ? "greater" : "less";
        System.out.println("Var 1 is " + inbetween + " than 4");

        int var2 = 6;
        if (var2 == 5){
            System.out.println("Var2 is 5");
        } else if (var2 == 6){
            System.out.println("Var2 is 6");
        } else{
            String inbetween2 = (var2 > 5) ? "greater" : "less";
            System.out.print("Var2 is " + inbetween2 + " than 5");
        } 

        int var3 = 5;
        String inbetween3 = (var3 > 10) ? "greater" : "less";
        System.out.print("Var 3 is " + inbetween3 + "than 10");

        //for this section: why are we not entering the if statement?
        //This section does not print because it uses '==' instead of '.equals'
        if ("Marist" == "marist"){
            System.out.println("Marist college!");
        } else{
            System.out.println("Not marist college :(!");
        }


    }
}

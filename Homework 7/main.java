// I gave a working example of a student!
import java.util.Random;
public class main {
    public static Random rand = new Random();
    public static void main(String[] args){
            int free  = genFreeLunch();
            student MelC = new student("Melissa","Senior",3.4,1343);
            student MelD = new student("Billy","Junior",3.4,1344);
            student MelE = new student("Bob","Sophmore",3.4,1345);
            student MelF = new student("Joe","Fresmen",3.4,1346);
            student MelG = new student("Francis","Senior",3.4,1347);
            System.out.print(free);

    }
    public static int genFreeLunch(){
        return(1343 + rand.nextInt(5));
    }
}









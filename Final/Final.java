import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Final {//#1234567890
    static String allChar = "1234567890qwertyuiopasdfghjklzxcvbnm!@#$%^&*()[]{}|\\:;\"|'<,>.?/_-+=~`QWERTYUIOPASDFGHJKLZXCVBNM";
    //static String allowedChar = "1234567890" + allChar;
    static String[] itemizedChar;
    static String fileName = "Encrypted.txt";

 
    public static void main(String[] args){
        itemizedChar = itemize(allChar);
        //System.out.println(Arrays.toString(itemizedChar));//This is a test of the new encyption system may infact start to loop around to the back again
        verifyFile();
        String encryptMsg = encrpt("^#U(+", "Hello!");
        writeToFile(encryptMsg);
        String decryptMsg = decrypt("^#U(+", readFromFile());
        System.out.println(encryptMsg);
        System.out.println(decryptMsg);
        }
    public static void verifyFile(){
        File csvFile = new File(fileName);
        //csvFile.
        if (csvFile.exists()){
            System.out.println(String.format("CSV File of name %s exists", fileName));
            System.out.println("Overwriting File");
        }else{
            System.out.println(String.format("CSV File of name %s does not exist", fileName));
            System.out.println("Will create file on write");
        }
    }
    public static void writeToFile(String txt){
        try{
            FileWriter fw = new FileWriter(fileName); //Will Overwite a file with this path if it exists
            fw.write(txt);
            fw.close();
        }catch(IOException e){
                System.out.print("Could not run for some reason");
            }
    }
    public static String readFromFile(){
        File fr = new File(fileName);
        String rtnTxt = "-1";
        try {
            Scanner reader = new Scanner(fr);
            rtnTxt = reader.nextLine();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Somthing bad happened");
        }
        return rtnTxt;
    }
    public static String[] itemize(String str){
        String[] arry = new String[str.length()];
        for (int i = 0; i<arry.length; i+=1){
            arry[i] = str.substring(i, i+1);
        }
        return(arry);
    }
    public static boolean validInput(String input){
        for (int i = 0; i<input.length(); i+=1){
            if (!allChar.contains(input.substring(i, i+1))){
                System.out.print("Input not valid");
                return false;
            }
        }
        return true;
    }
    public static String[] shiftArray(String[] arry, int shiftNum){
        int actualShift = (shiftNum > arry.length)? arry.length%shiftNum : shiftNum;
        String[] staticArry = arry.clone();
        String[] rollingArry = arry.clone();
        for (int i = actualShift; i<arry.length; i+=1){
            rollingArry[i] = staticArry[i-actualShift];
        }
        int begIndex = 0;
        for (int i = arry.length - actualShift; i<arry.length; i+=1){
            rollingArry[begIndex] = staticArry[i];
            begIndex +=1;
        }
        return rollingArry;
    }
    public static int arrayFind(String chr, String[] array){
        for (int i = 0; i<array.length; i+=1){
            if (array[i].equals(chr)){
                return i+1;
            }
        }
        return -1;
    }
    public static int encrptChar(String key, String chr, String[] codex){
        String scodex = Arrays.toString(codex);
        int indexNum = arrayFind(chr, codex);
        int firstVal = arrayFind(key.substring(0,1), codex);
        int secondVal = arrayFind(key.substring(1,2), codex);
        int fourthVal = arrayFind(key.substring(2,3), codex);
        int fithVal = arrayFind(key.substring(3,4), codex);

        int finalNum = (((indexNum * firstVal) + secondVal)+fourthVal)*fithVal;//CONSIDER CHANGING THI LATER
        return finalNum;
    }
    public static String encrpt(String key, String msg){
        String finalStr = "";
        msg = msg.replaceAll(" ", "_");
        if (!validInput(key) || !validInput(msg)){
            return("no");
        }
        String[] rollingChar = itemizedChar.clone();
        for (int i = 0; i<msg.length(); i+=1){
            String encryptLen = Integer.toString(encrptChar(key, msg.substring(i, i+1), rollingChar));
            if (i ==0) System.out.println(encryptLen);
            finalStr += Integer.toString(encryptLen.length()) + encryptLen;
            rollingChar = shiftArray(rollingChar, 1);
        }
        return(finalStr);
    }
    public static int decryptChar(String key, int chr, String[] codex){
        String scodex = Arrays.toString(codex);
        int firstVal = arrayFind(key.substring(0,1), codex);
        int secondVal = arrayFind(key.substring(1,2), codex);
        int fourthVal = arrayFind(key.substring(2,3), codex);
        int fithVal = arrayFind(key.substring(3,4), codex);
        int finalNum = (((chr / fithVal) - fourthVal)-secondVal)/firstVal;//CONSIDER CHANGING THIS LATER
        return finalNum-1;//Subtracting for index cause had to add one earlier so the math didn't break with a vlaue of 0
    }
    public static String decrypt(String key, String msg){
        String finalStr = "";
        if (!validInput(key) || !validInput(msg)){
            return("no");
        }
        String[] rollingChar = itemizedChar.clone();
        
        int loopIndex = 0;
        for (int i = 0; i<msg.length(); i+=0){
            int encLen = Integer.parseInt(msg.substring(i,i+1))+1;
            String nextNum = msg.substring(i+1, i+encLen);
            int letNums = Integer.parseInt(nextNum);
            int tbleNum = decryptChar(key, letNums, rollingChar);
            String let = rollingChar[tbleNum];
            finalStr += let;
            rollingChar = shiftArray(rollingChar, 1);
            i += encLen;

            if (i > 1000){
                return("Overflow");
            }

        }
        return(finalStr);
    }
}

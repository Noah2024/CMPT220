//This is assuming you have your file in the correct directory, i included a reference of where your txt file should be in the brightspace assignment
//based off what we learned in class about files, you need to determine how it's best to read the text file included in the assignment 
//after you've read and kept track of the text, then i need you to figure out:
/*
1. what names had over a 3.5 gpa (using coding, of course, not your eyes)
2. how many names are there total?
*/
//here's the imports you will need to start, and i've left some code with some blanks for you to figure out
import java.io.*;
import java.util.Random;
import java.util.Scanner;

//import java.
//import org.graalvm.faker;

public class filepractice {
    public static String parentDir = "C:\\Users\\ndyur\\OneDrive\\Documents\\GitHub\\CMPT220\\Homework 6\\";
    public static String[] names = {"Billy", "Bob", "Joe", "Fergeson", "Francis", "Dicky", "Matt", "John", "BiggyG", "Michael", "Pat"};
    public static void main(String[] args){
        //const package = require("faker");//I really really tried to get this to work
        //let faker = require('');//I got lazy tho so forget it
        String fileName = "student.csv";
        System.out.println(parentDir + fileName);
        File inputfile = new File(parentDir + fileName);
        createRandCSV();
        System.out.println("Reading New List");
        try {
            Scanner input = new Scanner(inputfile);
            int total = 0;
            while(input.hasNext()){
                String line = input.nextLine();
                String[] rows = line.split(",");
                if (Double.valueOf(rows[1]) > 3.5){
                    System.out.println(rows[0] + " had over a gpa over 3.5 ");
                    total += 1;
                }
            }
            System.out.print(("There are a total of " + String.valueOf(total) + " students with gpa's over 3.5"));
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
      //optional if you want to keep this, just to show what the indices are of the list you created
        //System.out.println(list); 
    }
    public static void createRandCSV(){
        String name = "student.csv";
        String path = parentDir + name;
        int lenList = 10;
        String[] chosenNames = new String[lenList];
        Random rand = new Random();
        
        File csvFile = new File(path);
        //csvFile.
        if (csvFile.exists()){
            System.out.println(String.format("CSV File of name %s exists", name));
            System.out.println("Overwriting File");
        }else{
            System.out.println(String.format("CSV File of name %s does not exist", name));
            System.out.println("Creating File");
        }
        try{       
                FileWriter fw = new FileWriter(path); //Will Overwite a file with this path if it exists
                for (int I = 0; I <chosenNames.length; I+=1){
                    String randName = names[rand.nextInt(names.length)];
                    int nameInt = 0;
                    String finalName = (nameInt == 0) ? randName: randName+Integer.toString(nameInt);
                    if (chosenNames[I] == null){//Unessary check, but i've lazy, so it stays
                        chosenNames[I] = finalName;
                        //float ranadom = min + rand.nextFloat() * (max - min);
                        float randGpa = rand.nextFloat(5);
                        String csvEntry = finalName + "," + String.valueOf(randGpa) + "\n";
                        fw.write(csvEntry);
                        }
                    }
                fw.close();
                System.out.println("New List Generated");
            }catch(IOException e){
                System.out.print("Could not run for some reason");
            }
    } //this will generate info for a single student in the format of one row of a csv file 
   // public String genStudentInfo(){
   //     Random.
    //}
}

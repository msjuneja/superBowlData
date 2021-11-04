import java.util.*;
import java.io.*;

public class SuperBowlAdResearch{

  public static void main (String[] args) throws FileNotFoundException {
    //create a file object for the file being read and scanner to process it
    File f = new File("SuperBowlAds.csv");
    Scanner sc = new Scanner(f);
    String[] currentLine = new String[11];
    ArrayList<String> patriotic = new ArrayList<String>();
    int patrioticIndex = 6;
    //questions to answer:
    //1. are the majority patriotic
    sc.nextLine(); //skip the first line of headers
    while(sc.hasNextLine()){ //loop through all the lines
    currentLine = sc.nextLine().split(",", 0);
    //find the sixth comma and store if true or False
    //fill arrayList with true or false
    if(currentLine[patrioticIndex].equals("true")){
      patriotic.add("true");
    } else {
      patriotic.add("false");
    }
    }
    int trueCount = 0;
    int falseCount =0;
    for(int i=0; i<patriotic.size(); i++){
      if(patriotic.get(i).equals("true")){
        trueCount++;
      } else {
        falseCount++;
      }
    }
      //return results
    if(trueCount > falseCount){
      System.out.println("More ads have been patriotic than not patriotic between 2010-2020");
    } else {
        System.out.println("More ads have been not patriotic than patriotic between 2010-2020");
    }

    //2. are more adds funny before 2010 or after (halfway point in time from where data is given)
      


  }



}

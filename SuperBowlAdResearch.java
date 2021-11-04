import java.util.*;
import java.io.*;

public class SuperBowlAdResearch{
  public static int patrioticIndex = 6;
  public static int funnyIndex = 4;
  public static int yearIndex = 0;
  public static void main (String[] args) throws FileNotFoundException {
    //create a file object for the file being read and scanner to process it
    File f = new File("SuperBowlAds.csv");
    Scanner sc = new Scanner(f);
    // majorityPatriotic(sc);
    funnierMethod(sc);
}

//questions to answer:

    //1. are the majority patriotic
public static void majorityPatriotic(Scanner sc){
    String[] currentLine = new String[11];
    ArrayList<String> patriotic = new ArrayList<String>();
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
}

    //2. are more adds funny before 2010 or after (halfway point in time from where data is given)
    public static void funnierMethod(Scanner sc){
    //create two arrays: only need true or false for are funny
    String[] thisLine = new String[11];
    sc.nextLine();
    ArrayList<String> decadeOne = new ArrayList<String>();
    ArrayList<String> decadeTwo = new ArrayList<String>();
    while(sc.hasNextLine()){
      thisLine = sc.nextLine().split(",", 0);
        //one for ads from before 2010 (inclusive)
      int currentYear = Integer.parseInt(thisLine[yearIndex]);
      if(currentYear >= 2010){
          if(thisLine[funnyIndex].equals("true")){
            decadeOne.add("true");
          } else {
            decadeOne.add("false");
          }
      }
        //one for ads from after 2010 (inclusive)
      if(currentYear >= 2011){
        if(thisLine[funnyIndex].equals("true")){
          decadeTwo.add("true");
        } else {
          decadeTwo.add("false");
        }
      }

    } //end of while loop

    //calc what percentage of ads in decadeOne are true - and save to variable
  int onePercentTrue = 0;
  for(int i=0; i<decadeOne.size(); i++){
    if(decadeOne.get(i).equals("true")){
      onePercentTrue++;
    }
  }
  int percentOne = (onePercentTrue / decadeOne.size()) * 100;
    //calc what percentage fo ads in decadeTwo are true - and save to variable
   int twoPercentTrue = 0;
   for(int j=0; j<decadeTwo.size(); j++){
     if(decadeTwo.get(j).equals("true")){
       twoPercentTrue++;
     }
   }
   int percentTwo = (twoPercentTrue / decadeTwo.size()) * 100;

    //determine which percentage is larger
    if(percentOne > percentTwo){
      System.out.println("Ads from 2000-2010 are more funny than ads from 2010-2020");
    } else if(percentTwo > percentOne){
      System.out.println("Ads from 2010-2020 are more funny than ads from 2000-2010");
    } else {
      System.out.println("Ads from the time frame of 2000-2010 and 2010-2020 are equally funny");
    }

  } //end of funnier method

} //end of class

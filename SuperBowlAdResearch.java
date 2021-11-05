import java.util.*;
import java.io.*;

public class SuperBowlAdResearch{
  public static int patrioticIndex = 6;
  public static int funnyIndex = 4;
  public static int yearIndex = 0;
  public static void main (String[] args) throws FileNotFoundException {
    //create a file object for the file being read and scanner to process it
    File f = new File("SuperBowlAds.csv");
    Scanner sc = new Scanner(f); //creates scanner to be used in the methods
    majorityPatriotic(sc); //running first method
    Scanner sc2 = new Scanner(f); //creates a new scanner to use for the second method
    funnierMethod(sc2); //running second method
}

//questions to answer:

    //1. are the majority patriotic
public static void majorityPatriotic(Scanner sc){
    String[] currentLine = new String[11]; //creates array to hold the current row
    ArrayList<String> patriotic = new ArrayList<String>(); //arrayList to hold true/false values
    sc.nextLine(); //skip the first line of headers
    while(sc.hasNextLine()){ //loop through all the lines
    currentLine = sc.nextLine().split(",", 0); //takes current line and makes it an array of strings
    //find the sixth comma and store if true or False
    //fill arrayList with true or false
    if(currentLine[patrioticIndex].equals("true")){ //if the ad is found to be patriotic
      patriotic.add("true"); //add a true string to the arrayList
    } else {
      patriotic.add("false"); //add a false string to the arrayList
    }
    }
    int trueCount = 0;
    int falseCount =0;
    for(int i=0; i<patriotic.size(); i++){ //count the amount of trues and falses
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
    String[] thisLine = new String[11]; //creates an array to hold the current row
    ArrayList<String> decadeOne = new ArrayList<String>(); //will hold true/false based on if the ad is funny - btw 2000-2010
    ArrayList<String> decadeTwo = new ArrayList<String>(); //will hold true/false based on if the ad is funny - btw 2011-2020
    sc.nextLine(); //skips the lines of the headers
    while(sc.hasNextLine()){ //loops through the data looking at each row
      thisLine = sc.nextLine().split(",", 0); //takes the current row and makes it an array
        //one for ads from before 2010 (inclusive)
      int currentYear = Integer.parseInt(thisLine[yearIndex]); //takes the year of the ad and makes it an it
      if(currentYear <= 2010){ //if the int is before 2010
          if(thisLine[funnyIndex].equals("true")){ //if the ad is funny
            decadeOne.add("true"); //add true to the arrayList
          } else {
            decadeOne.add("false"); //if the add isn't funny add false to the arrayList
          }
      }
        //one for ads from after 2010 (inclusive)
      if(currentYear >= 2011){ //if the add is from after 2010
        if(thisLine[funnyIndex].equals("true")){ //if the ad is funny
          decadeTwo.add("true"); //add true to the arrayList
        } else {
          decadeTwo.add("false"); //if the ad isn't funny add false to the arrayList
        }
      }

    } //end of while loop

    //calc what percentage of ads in decadeOne are true - and save to variable
  int onePercentTrue = 0;
  for(int i=0; i<decadeOne.size(); i++){ //loops thru the arrayList for the first decade
    if(decadeOne.get(i).equals("true")){
      onePercentTrue++; //increases counter for each true
    }
  }
  int percentOne = (onePercentTrue / decadeOne.size()) * 100; //turns number into a perent: true/total
    //calc what percentage fo ads in decadeTwo are true - and save to variable
   int twoPercentTrue = 0;
   for(int j=0; j<decadeTwo.size(); j++){ //same except for the second decade
     if(decadeTwo.get(j).equals("true")){
       twoPercentTrue++;
     }
   }
   int percentTwo = (twoPercentTrue / decadeTwo.size()) * 100;

    //determine which percentage is larger and print results
    if(percentOne > percentTwo){
      System.out.println("Ads from 2000-2010 are more funny than ads from 2010-2020");
    } else if(percentTwo > percentOne){
      System.out.println("Ads from 2010-2020 are more funny than ads from 2000-2010");
    } else {
      System.out.println("Ads from the time frame of 2000-2010 and 2010-2020 are equally funny");
    }

  } //end of funnier method

} //end of class

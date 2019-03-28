//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Math Game
// Files: UTF-8
// Course: CS 300, Fall 18
//
// Author: Gerrard Kim
// Email: hkim624@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Random;
import java.util.Scanner;
/**
 * This class represents the application of how this game is demonstrated
 * @author Gerrard Kim
 */
public class GameApplication {

  /**
   * This main method organizes the outlook of the Math game and demonstrates it to the players
   * @param args
   * @exception NullPointerException
   * if the list is empty or null
   * @exception NumberFormatException
   * if user does not enter a number
   * @exception IllegalStateException
   * if user does not enter proper operator
   */
  public static void main(String[] args) {
    Random rng = new Random();
    Scanner scnr = new Scanner(System.in);
    String userInput = "";
    char operator;
    int number;
    int numMoves = 0;
    GameList newList = new GameList(); // make a new GameList
    GameNode newNode1 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode newNode2 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode newNode3 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode newNode4 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode newNode5 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode newNode6 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode newNode7 = new GameNode(rng); // make a new GameNode with random number between 1-9
    newList.addNode(newNode1);
    newList.addNode(newNode2);
    newList.addNode(newNode3);
    newList.addNode(newNode4);
    newList.addNode(newNode5);
    newList.addNode(newNode6);
    newList.addNode(newNode7);
    // make 7 GameNodes and add them to the list
    
    int goal = rng.nextInt(90) + 10; // A single target number between 10-99
    boolean isBoolean = true;
    
    do {
        
      String gameOperator = GameOperator.ALL_OPERATORS.get(0).toString();
      
      for (int i = 1; i < GameOperator.ALL_OPERATORS.size(); ++i) {  
        gameOperator = gameOperator + ", " + GameOperator.ALL_OPERATORS.get(i).toString();         
      } // shows gameOperator that contains all the lists of operator   
      
      System.out.println("Goal: " + goal + " Moves Taken: " + numMoves);
      System.out.println("Puzzle: " + newList);
      System.out.println("Number and Operation [" + gameOperator + "] to Apply: ");
      
      try {
        userInput = scnr.nextLine().trim();                       
        userInput = userInput.toLowerCase();
        
        if (userInput.equals("quit")) {
          isBoolean = false;
          break;
        } // if user enters "quit", end the program
        
        operator = userInput.charAt(userInput.length()-1); // user's operator input
        number = Integer.parseInt(userInput.substring(0, userInput.length()-1));
        // user's number input
        
        System.out.println("");
        
        GameNode newNode8 = new GameNode(rng);
        newList.addNode(newNode8); // adds a new GameNode after user enters a number
        newList.applyOperatorToNumber(number, GameOperator.getFromChar(operator));
        // update the list according to player's specification
        numMoves++; // tracks if a player has taken a turn
              
        if (newList.contains(goal)) {
          System.out.println("Congratulations, you won in " + numMoves + " moves.");
          System.out.println("Solution: " + newList);
          break;
        } // if the user reaches the target goal number, print out the message
        
            
      } catch (NullPointerException e) {
        System.out.println("NullPointerException..");
        numMoves--; // bad input not counted as moves
      } catch (NumberFormatException e) {
        System.out.println("NumberFormatException..");
        numMoves--; // bad input not counted as moves
      } catch (IllegalStateException e) {
        System.out.println("WARNING: " + e.getMessage());
        numMoves--; // bad input not counted as moves
      }
          
      } while (isBoolean);
        
      if (userInput.equals("quit")) {
        System.out.println("Goodbye");
      } // if the user enters "quit", print out the goodbye message
      
      scnr.close();
  }

}

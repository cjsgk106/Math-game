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
/**
 * This class represents a test to check if GameNode and GameList classes are working
 * @author Gerrard Kim
 */
public class GameTests {

  /**
   * This method checks whether setNext and getNext methods in GameNode class are working properly.
   * It also checks the node is between 1-9 value.
   * @return true if testNode1's nest node is testNode2 and these nodes are between 1-9,
   * false otherwise.
   */
  public static boolean testGameNode1() {
    Random rng = new Random();
    GameNode testNode1 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode2 = new GameNode(rng); // make a new GameNode with random number between 1-9
        
    testNode1.setNext(testNode2);
    if (testNode1.getNext().equals(testNode2)) {
      if (((testNode1.getNumber() >= 1) && (testNode1.getNumber() <= 9)) 
          && ((testNode2.getNumber() >= 1) && (testNode2.getNumber() <= 9))) {
        return true;
      }
    }
    
    return false;
  }
  
  /**
   * This method checks whether applyOperator method in GameNode class is working properly.
   * @return true if testNode1's next node is testNode3, false otherwise
   */
  public static boolean testGameNode2() {
    Random rng = new Random();
    GameNode testNode1 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode2 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode3 = new GameNode(rng); // make a new GameNode with random number bewteen 1-9
    testNode1.setNext(testNode2);
    testNode2.setNext(testNode3);
    testNode1.applyOperator(GameOperator.getFromChar('+')); // do addition with testNode1 and 2 
    
    if (testNode1.getNext().equals(testNode3)) {
      return true;
    }
    return false;
  }
  
  /**
   * This method checks whether addNode and contains methods are working properly.
   * @return true if testList contains testNode1, testNode2, and testNode3, false otherwise
   */
  public static boolean testGameList1() {
    Random rng = new Random();
    GameNode testNode1 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode2 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode3 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameList testList = new GameList(); // make a new GameList
    testList.addNode(testNode1);
    testList.addNode(testNode2);
    testList.addNode(testNode3);
        
    if ((testList.contains(testNode1.getNumber())) && (testList.contains(testNode2.getNumber()))
        && (testList.contains(testNode3.getNumber()))) { // checks if contains method is working
      return true;           
    }
       
    return false;
  }
  
  /**
   * This method checks whether applyOperatorToNumber method in GameList class is working properly
   * @return true if the addition of testNode2 and testNode3 becomes new testNode2, false otherwise
   */
  public static boolean testGameList2() {
    Random rng = new Random();
    GameNode testNode1 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode2 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode3 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameNode testNode4 = new GameNode(rng); // make a new GameNode with random number between 1-9
    GameList testList = new GameList(); // make a new GameList
    testList.addNode(testNode1);
    testList.addNode(testNode2);
    testList.addNode(testNode3);
    testList.addNode(testNode4);
    int a = testNode2.getNumber();
    int b = testNode3.getNumber();
    testList.applyOperatorToNumber(testNode2.getNumber(), GameOperator.getFromChar('x'));   
    // do multiplication with testNode2 and its next node
    
    if (testNode2.getNumber() == (a * b)) {
      return true;
    }
         
    return false;
  }
   
  /**
   * This main method calls the test methods to see if they are working
   * @param args
   */
  public static void main(String[] args) {
    int fails = 0;
        
    if (!testGameNode1()) {
      System.out.println("testGameNode1 failed");
      fails++;
    }
    if (!testGameNode2()) {
      System.out.println("testGameNode2 failed");
      fails++;
    }
    if (!testGameList1()) {
      System.out.println("testGameList1 failed");
      fails++;
    }
    if (!testGameList2()) {
      System.out.println("testGameList2 failed");
      fails++;
    }
    if (fails == 0) {
      System.out.println("All tests passed!");
    }
  }

}

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
 * This class represents a list of numbers a player is presented with
 * @author Gerrard Kim
 */
public class GameList {
  private GameNode list; // reference to the first GameNode in this list
  
  /**
   * Constructor that creates a GameList that can be used in Math Game
   */
  public GameList() {
    list = null;
  } // initializes list to start out empty
  
  /**
   * Adds a new node to the list 
   * @param new GameNode that can be added to the list
   */
  public void addNode(GameNode newNode) {
    if (list == null) { // adds a new node to make it the first GameNode if the list is null
      list = newNode;
      return;
    }
    
    GameNode current = list; // make a new GameNode 
     
    while (current.getNext() != null) { // if the node is not the last one in this list,
      current = current.getNext();      // make current the next node
    }
    
    if (current.getNext() == null) { // if the node is the last one in this list,
      current.setNext(newNode);      // set newNode to be the next node
    }                
  } // adds the new node to the end of this list
    
  /**
   * Checks if a provided number is within this list
   * @param a number to be checked if it is within this list
   * @return true if the number is whitn this list, false otherwise
   */
  public boolean contains(int number) {
    GameNode current = list; // make a new GameNode
    
    while (current != null) {               // as long as there is at least one node within
      if (current.getNumber() == number) {  // this list, check the node is the provided number
        return true;
      }
      current = current.getNext();
    }
    
    return false;
  } // only returns true when this list contains a node with the specified number
  
  /**
   * Overrides toString method
   * Provides a readable string to a player
   */
  @Override
  public String toString() {
    String str = "";       
    GameNode current = list; // make a new GameNode
      
    while (current.getNext() != null) {
      str = str + current.getNumber() + " -> ";
      current = current.getNext();
    }
    
    str = str + current.getNumber() + " -> END";
    return str;       
  } // returns a string with each number in the list separated by " -> "s, and ending with " -> END"
    
  /**
   * Scans through this list searching for the first occurrence of a node with the specified number
   * @param a number that is used to check if there is one within this list
   * @param GameOperator object that performs specific operation 
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {
    GameNode current = list; // make a new GameNode
        
    while (current != null) {
      if (current.getNumber() == number) {
        current.applyOperator(operator); // if the specified number is within this list,
        break;                           // call applyOperator method to do the calculation
      }                                  // with the provided operator
      current = current.getNext();
    }
  }

}

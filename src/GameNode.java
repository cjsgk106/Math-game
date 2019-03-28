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
 * This class represents a single number within the linked list
 * @author Gerrard Kim
 */
public class GameNode {

  private int number;    // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node
  
  /**
   * Constructor that creates a random number node of 1-9 value.
   * @param random rng that is between 1-9
   */
  public GameNode(Random rng) {
    number = rng.nextInt(9) + 1; 
    next = null;
  } // initializes number to random 1-9 value, and next to null
  
  /**
   * Access the number held within node
   * @return the number held within node
   */
  public int getNumber() {
    return number;
  } // accessor for the number field
  
  /**
   * Access the next GameNode in the list
   * @return the next GameNode in the list
   */
  public GameNode getNext() {
    return next;
  } // accessor for the next field
    
  /**
   * Set the next GameNode in the list
   * @param the next GameNode in the list
   */
  public void setNext(GameNode next) {
    this.next = next;
  } // mutator for the next field
    
  /**
   * Changes that nodes number and next fields
   * @param GameOperator object that performs specific operation
   * @exception NullPointerException
   * if the node is at the end of the list
   */
  public void applyOperator(GameOperator operator) {
    number = operator.apply(number, next.getNumber());
    
    try {
      setNext(next.getNext());
    } catch (NullPointerException e) { // checks if the next node is null
      System.out.println("The node is at the end of the list.");
    }
        
  } // A new number is calculated by using the provided operator to 
    // this node's number and the next number
    
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testIsEmpty()
    {
    	//test an empty list
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertTrue("Checking if the boolean returns true for an empty list", testDLL.isEmpty());
    	
    	//test a non empty list
    	testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0, 5);
    	assertFalse("Checking if the boolean returns false for a non empty list", testDLL.isEmpty());
    	
    }
    
  @Test
  public void get () 
  {
	 
	  DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	  //test empty list
	  assertNull("Checking get to an empty list - expected null", testDLL.get(0));
	  
	  testDLL.insertBefore(0, 1);
	  testDLL.insertBefore(1, 2);
	  testDLL.insertBefore(2, 3);
	  
	  //test pos out of bounds
	  assertNull("Checking get to a list of 3 elements- expected null", testDLL.get(3));
	  //test pos less than 0
	  assertNull("Checking get to a list of 3 elements- expected null", testDLL.get(-3));
	  
	  //test a list of 3 elements
	  int expectedResult =3;
	  assertEquals("Checking get to a list of 3 elements - expected element", expectedResult, (int) testDLL.get(2) );
	  expectedResult =1;
	  assertEquals("Checking get to a list of 3 elements - expected element", expectedResult,(int) testDLL.get(0) );
	  expectedResult=2;
	  assertEquals("Checking to get a list of 3 elements - expected element", expectedResult,(int) testDLL.get(1));
	  
  }
  
  @Test
  public void deleteAt()
  {
	  DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	  
	  assertFalse("Checking delete at on an empty list at pos 1, head being null", testDLL.deleteAt(0));
	  
	  testDLL.insertBefore(0, 1);
	  testDLL.insertBefore(1, 2);
	  testDLL.insertBefore(2, 3);
	  testDLL.insertBefore(3, 4);
	  
	  assertFalse("Checking deleteAt on a list at pos greater than the linked list size" , testDLL.deleteAt(4));
	  assertFalse("Checking deleteAt on a list less than the linked list size" , testDLL.deleteAt(-1));
	  assertTrue("Checking deleteAt to a list of 3 elements, deleting position 2 - expected list 1,3,4",  testDLL.deleteAt(1));
  }
  
  @Test
  public void deleteAt2()
  {
	  DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	  
	  assertFalse("Checking deleteAt on an empty list at pos 0, head being null", testDLL.deleteAt(0));
	  
	  testDLL.insertBefore(0,1);
	  
	  assertTrue("Checking deleteAt on a list of 1 elements", testDLL.deleteAt(0));
	  
	  testDLL.insertBefore(0,1);
	  
	  assertTrue("Checking deleteAt on a list of 1 elements at pos 0", testDLL.deleteAt(0));
	  
	  
	  
	  
  }
  
  @Test
  public void push()
  {
	  DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	
	  testDLL.push(4);
	  assertEquals("Checking push to a list , pushing on the 1st element the 4 int", "4", testDLL.toString() );
	  testDLL.push(2);
	  assertEquals("Checking push to a list , pushing on the 2nd element the 2 int", "4,2", testDLL.toString() );
	  
  }
  
  @Test
  public void pop()
  {
	  DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
	  
	  testDLL.push(2);
	  testDLL.push(4);
	  
	  testDLL.pop();
	  
	  assertEquals("Checking pop to a list, popping off the last element pushed on", "2", testDLL.toString() );
	  
	  assertEquals("Checking pop to a list of 1 element ", 2,(int) testDLL.pop());
	  
	 
	  assertNull("Checking pop on an empty list",  testDLL.pop());
  }
  
  
  @Test
  public void reverse()
  {
	   DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
	   
	   
	   testDLL.insertBefore(0, 1);
	   testDLL.insertBefore(1, 2);
	   testDLL.insertBefore(2, 3);
	   testDLL.insertBefore(3, 4);
		  
	   testDLL.reverse();
	   assertEquals("Checking reverse onto a list of 4 elements", "4,3,2,1", testDLL.toString());
	   
  }
  
 
  
  @Test
  public void enqueue()
  {
	  DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
	  
	  testDLL.enqueue(4);
	  assertEquals("Checking enqueue onto a list, allocating 3 integers", "4", testDLL.toString());
	  
  }
  
  @Test
  public void dequeue()
  {
	  DoublyLinkedList<Integer>testDLL = new DoublyLinkedList<Integer>();
	  
	  testDLL.enqueue(4);
	  testDLL.enqueue(5);
	  
	  testDLL.dequeue();
	  assertEquals("Checking dequeue on a list, of 2 integers removing the first on", "5", testDLL.toString());
	  
	  int expectedResult = 5;
	  assertEquals("Checking dequeue on a list, of 1 integer removing the first on", expectedResult,(int) testDLL.dequeue());
	  
	  assertNull("Checking dequeue on a list, of no integers removing null", testDLL.dequeue());
	  
  }
  
  

}

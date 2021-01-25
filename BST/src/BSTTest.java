import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Ciara Lynch
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.
	
	@Test
	public void testPut()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(0, 2);
		bst.put(1, 4);
		bst.put(2, 3);
		bst.put(3, 1);
		bst.put(4, 5);
		bst.put(5, 9);
		bst.put(6, 7);
		bst.put(7, 8);
		bst.put(8, 6);
		bst.put(9, 0);
		
		//bst.put(4, null);
		//assertEquals("Checking put function with a null value","(((()1())3())6((()7())8(()9())))", bst.printKeysInOrder());
		
	}
	
	@Test
	public void testContains()
	{
		BST<Integer,Integer> bst = new BST<Integer, Integer>();
		//test empty BST
		assertEquals("Checking function contains on an empty BST", false, bst.contains(3));
		//test BST with set integers
		bst.put(6, 6);
		bst.put(3, 3);
		bst.put(8, 8);
		bst.put(1, 1);
		bst.put(4, 4);
		assertEquals("Checking if BST contains key/integer not present", false, bst.contains(2));
		assertEquals("Checking if BST contains key/integer that is present", true, bst.contains(4));
	}
	
	@Test
	public void testDeleteMax()
	{
		BST<Integer, Integer> bst = new BST<Integer,Integer>();
		bst.put(6, 6);
		bst.put(3, 3);
		bst.put(8, 8);
		bst.deleteMax();
		assertEquals("Testing delete root max","((()3())6())" ,bst.printKeysInOrder());
	}
	
	@Test
	public void testMax()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Testing empty binary search tree", null, bst.max(null));
		
	}
	
	
	@Test
	public void testMedian()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Testing to get the median of an empty tree-expect null", null, bst.median());
		
		//testing a non empty bst
		bst.put(1, 1); // 6
		bst.put(3, 3); // / \
		bst.put(4, 4); // 3 8
		bst.put(6, 6);// / \ / \
		bst.put(7, 7);// 1 4 7 9
		bst.put(8, 8);
		bst.put(9, 9);//
		
		assertEquals("Testing the median of a tree, result should be 6", bst.get(6), bst.median());
		
		BST<Integer, Integer> bst1 = new BST<Integer, Integer>();
		
		bst1.put(8, 8);
		bst1.put(6, 6);
		bst1.put(9, 9);
		bst1.put(2,2);
		bst1.put(4, 4);
		assertEquals("Checking median where median is in left tree and is 6", bst1.get(6), bst1.median());
	}
		
	

	@Test
	public void testHeight() 
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking height of empty tree-expect -1", -1, bst.height());
	
		// test list with key elements
		bst.put(7, 7); // _7_
		bst.put(8, 8); // / \
		bst.put(3, 3); // _3_ 8
		bst.put(1, 1); // / \
		bst.put(2, 2); // 1 6
		bst.put(6, 6); // \ /
		bst.put(4, 4); // 2 4
		bst.put(5, 5); // \
						// 5
		assertEquals("Checking height of tree", 4, bst.height());
		
		BST<Integer, Integer> bst1 = new BST<Integer, Integer>();
		bst1.put(1, 1); // _7_
		System.out.println(bst1.height());
		assertEquals("Checking height of a tree with a null left branch", 0, bst1.height());
		
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		bst2.put(7, 7);//
		bst2.put(7,8);//
		
		
	
	}
  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
         
         //Checking the left branch of the bst where its null
         BST<Integer,Integer> bst1 = new BST <Integer, Integer>();
     	 bst1.put(6,6);
		 bst1.put(3,3);
		 bst1.put(8, 8);
		 bst1.put(9,9);
		 bst1.delete(8);
		assertEquals("Deleting key 3 where left branch is null","((()3())6(()9()))", bst1.printKeysInOrder());
     }
     
}

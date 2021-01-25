import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  Ciara Lynch
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <Type> This is a type parameter. Type is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, Type should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.`
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<Type extends Comparable<Type>>
{

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode
	{
		public final Type data; // this field should never be updated. It gets its
		// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * @param theData : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(Type theData, DLLNode prevNode, DLLNode nextNode) 
		{
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;


	/**
	 * Constructor of an empty DLL
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() 
	{
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * @return true if list is empty, and false otherwise
	 *
	 * Worst-case asymptotic running time cost: O1 (Theta1)
	 *
	 * Justification:
	 *  There is no for or while loops in this function resulting in the elements of the DLL not all being ran to  
	 */
	public boolean isEmpty()
	{
		if (head == null)
		{
			return true;
		}
		return false;
	}

	/*
	 * Finds the length of the Doubly Linked List so to be able to use it in other 
	 * functions for comparison
	 * @return length of doubly linked list an int
	 * Worst-case asymptotic running time cost: Theta(n)
	 *
	 * Justification:
	 *  With the use of a while loop, all elements in the DLL are ran through , meaning the function itself is Theta 1 * (times) 
	 *  all the elements present in the DLL n
	 *  Bringing it to Theta(n)
	 */
	public int doublyLinkedListSize ()
	{
		DLLNode linkedList = head;
		int length = 0;
		while ( linkedList!= null)
		{
			length++;
			linkedList = linkedList.next;
		}
		return length;
	}

	/**
	 * Inserts an element in the doubly linked list
	 * @param pos : The integer location at which the new data should be
	 *      inserted in the list. We assume that the first position in the list
	 *      is 0 (zero). If pos is less than 0 then add to the head of the list.
	 *      If pos is greater or equal to the size of the list then add the
	 *      element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 * 
	 */
	public void insertBefore( int pos, Type data ) 
	{
		DLLNode insertNode = new DLLNode (data, null, null); //allocate new node to be inserted
		DLLNode pointerTempNode = head;

		if (head == null)
		{
			head = tail = insertNode;// reallocate head and tail to new inserted node as previously empty
		}
		else if (pos<= 0)
		{
			insertNode.prev = null; 
			head.prev = insertNode; 
			insertNode.next = head; 
			head = insertNode;
			return;
		}
		else if (pos >= doublyLinkedListSize())
		{
			insertNode.prev = tail; // inserting to end of list so tail set
			tail.next = insertNode; // placing new node
			tail = insertNode; // 
			return;
		}
		else
		{
			for (int count =0; count < pos-1; count++)
			{
				pointerTempNode = pointerTempNode.next; // move node down the list
			}
			insertNode.next = pointerTempNode.next; 
			insertNode.prev = pointerTempNode;
			pointerTempNode.next = insertNode;
			pointerTempNode.next.prev = insertNode;

		}


	}


	/**
	 * Returns the data stored at a particular position
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
	 *
	 */
	public Type get(int pos) 
	{
		DLLNode nodePosition = head;
		if (isEmpty() == true)
		{
			return null;
		}
		else if ((pos < 0) || (pos >= doublyLinkedListSize()))
		{
			return null;
		}
		else if (pos == 0)
		{
			return head.data;
		}
		else 
		{	for (int count =0; count < pos ; count++)
		{
			nodePosition = nodePosition.next;
		}
		}
		return nodePosition.data;
	}

	/**
	 * Deletes the element of the list at position pos.
	 * First element in the list has position 0. If pos points outside the
	 * elements of the list then no modification happens to the list.
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified. 
	 *
	 */
	public boolean deleteAt(int pos) 
	{
		boolean tempBoolean = false;
		if ((head == null) || (pos < 0) || (pos >= doublyLinkedListSize()))
		{
			return false;
		}
		else
		{
			DLLNode tempNode = head;
			if (doublyLinkedListSize()==1)
			{
				tail = head = null;
				return true;
			}
			else if (pos == 0)
			{
				tempNode = head.next;
				head = tempNode;
				head.prev = null;
				return true;
			}

			else if (pos == (doublyLinkedListSize()-1))
			{
				while (tempNode.next.next != null)
				{
					tempNode = tempNode.next;
				}
				tail = tempNode;
				tempNode.next = null;
				return true;
			}
			else
			{
				int count =0;
				while(tempNode!=null)
				{
					if (count == pos)
					{
						head.next = tempNode.next;
						tempNode.next.prev = head;
						tempNode = null;
						tempBoolean = true;
					}
					else 
					{
						count++;
						tempNode = tempNode.next;
					}
				}
				return tempBoolean;
			}
		}
	}

	/**
	 * Reverses the list.
	 * If the list contains "A", "B", "C", "D" before the method is called
	 * Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 */
	public void reverse()
	{
		DLLNode temporaryNode = null;
		DLLNode currentPointNode = head;
		while(currentPointNode!=null) //moving the specific pointers down a node each loop
		{
			temporaryNode = currentPointNode.prev;
			currentPointNode.prev = currentPointNode.next;
			currentPointNode.next = temporaryNode;
			currentPointNode = currentPointNode.prev;
		}
		if (temporaryNode !=null)
		{
			head = temporaryNode.prev;
		}

	}

	/**
	 * Removes all duplicate elements from the list.
	 * The method should remove the _least_number_ of elements to make all elements unique.
	 * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
	 * Then it should contain "A", "B", "C", "D" after it returns.
	 * The relative order of elements in the resulting list should be the same as the starting list.
	 */
	public void makeUnique()
	{
				DLLNode compareNode1 = head;
				DLLNode compareNode2; 
				DLLNode compareNode3 = head;
				int tempCount =0;
				for (int count = 0; count < doublyLinkedListSize()-2; count++)
				{
					tempCount =0;
					compareNode2 = head;
					for (int count2 =0; count2 < doublyLinkedListSize()-2; count2++)
					{
						System.out.println(count2);
						if (compareNode1.data == compareNode2.data)
						{
							if(tempCount !=0)
							{
								if (count != (doublyLinkedListSize()-1))
								{
		
									//compareNode3 = compareNode2.next;
									compareNode2.next.prev = compareNode2.prev;
									compareNode2.prev.next = compareNode2.next;
									//compareNode2 = compareNode3;
									count2 =-1;
									compareNode1 = compareNode3;
									compareNode2 = head;
		
								}
								else
								{
									tail = tail.prev;
									tail.next = null;
								}
		
							}
							else tempCount++;
						}
						
						else compareNode2 = compareNode2.next;
						doublyLinkedListSize();
					}
					compareNode3 = compareNode3.next;
					compareNode1 = compareNode3;
			}
	}


	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to push on the stack
	 */
	public void push(Type item) 
	{

		if (doublyLinkedListSize() == 0)
		{
			DLLNode newPushedNode = new DLLNode (item, null, null); //allocate a new node
			tail = head = newPushedNode;
		}
		else
		{
			DLLNode newPushedNode = new DLLNode (item, tail, null); //allocate a new node
			tail.next = newPushedNode;
			tail = newPushedNode; //reallocate tail pointer node to end 
		}

	}

	/**
	 * This method returns and removes the element that was most recently added by the push method.
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 */
	public Type pop() 
	{
		//DLLNode tempNode;
		//		if(doublyLinkedListSize() == 1)
		//		{
		//			Type dataInfo = tail.data;
		//			tail = head = null;
		//			return dataInfo;
		//
		//		}
		if (!isEmpty())
		{
			if(doublyLinkedListSize() == 1)
			{
				Type dataInfo = tail.data;
				tail = head = null;
				return dataInfo;

			}

			Type dataInfo = tail.data;
			tail = tail.prev;
			tail.next = null;
			return dataInfo;
		}
		else
			return null;


	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to be enqueued to the stack
	 *
	 */
	public void enqueue(Type item) 
	{
		DLLNode newNode = new DLLNode (item, null, null); // allocate new node
		//DLLNode pointerNode = head; //set pointer at head node
		if (isEmpty()==true)
		{
			head = newNode; // set head node to new node
			tail = newNode; // set tail node to new node
			return;
		}
		else
		{
			head.prev = newNode; // allocate new node to start of DLL
			newNode.next = head; // space to left of head reallocated
			head = newNode;
		}
	}

	/**
	 * This method returns and removes the element that was least recently added by the enqueue method.
	 * @return the earliest item inserted with an equeue; or null when the list is empty.
	 *
	 */
	public Type dequeue() 
	{
		if (isEmpty() == true)
		{
			return null;
		}
		else
		{
			DLLNode removedNode = tail; // allocate new node
			if (tail.prev != null)
			{
				tail = tail.prev; // move head pointer down the DLL 
				tail.next = null;
				return removedNode.data;
			}
			else
			{
				head = null; // either DLL is full or null based on whether head and tail is full or null at the same time 
				tail = null;
				return removedNode.data;
			}
		}

	}


	/**
	 * @return a string with the elements of the list as a comma-separated
	 * list, from beginning to end
	 *
	 */
	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		boolean isFirst = true; 

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next)
		{
			if (!isFirst)
			{
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}

}


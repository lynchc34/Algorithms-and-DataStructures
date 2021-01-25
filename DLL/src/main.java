
public class main {

	public static void main(String[] args) {
		
		DoublyLinkedList<Integer>testDLL = new DoublyLinkedList();
		
		testDLL.push(1);
		testDLL.push(1);
		testDLL.push(1);
		testDLL.push(2);
		testDLL.push(2);
		testDLL.push(3);
		testDLL.push(3);
		testDLL.push(3);
		testDLL.push(3);
		testDLL.push(3);
		testDLL.push(3);
		testDLL.push(3);
		testDLL.push(4);
		testDLL.push(5);
		testDLL.push(5);
		
		
		testDLL.makeUnique();
		System.out.println(testDLL);
	}

}

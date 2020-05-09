
public class Node {
	String data = null;
	Node next = null;
	
	public Node(String data) {
		this.data = data;
	}
	
	
	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public Node getNext() {
		return next;
	}



	public void setNext(Node next) {
		this.next = next;
	}



	public static void main(String[] args) {
		Node root = new Node("头结点");
		Node node01 = new Node("子节点01");
		Node node02 = new Node("子节点02");
		root.setNext(node01); //将节点连接起来
		node01.setNext(node02);
		System.out.println("使用while循环遍历链表");
		getDataByLoop(root);
		System.out.println("使用递归遍历链表");
		getDataByRecursion(root);
	}
	
	public static void getDataByLoop(Node node){
	  while(node != null) {
		System.out.println(node.getData());
		node = node.getNext();
	  }
	}
	
	public static void getDataByRecursion(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.getData());
		getDataByRecursion(node.getNext());
	}
}

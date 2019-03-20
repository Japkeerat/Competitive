import java.io.*;

/*Program to delete all occurrences of a key K from a linked list.*/
public class KeyDeleteLL {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    public void insertToList(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public Node deleteAllOccurrences(Node headNode, int toDelete) {
        Node temp = headNode;
        Node newnode = new Node(0);
        Node newhead = newnode;
        while(temp!=null) {
            if(temp.data != toDelete) {
                Node n = new Node(temp.data);
                newnode.next=n;
                newnode = newnode.next;
            }
            temp=temp.next;
        }
        return newhead.next;
    }

    public void printList(Node headNode) {
        while(headNode!=null) {
            System.out.print(headNode.data+" ");
            headNode = headNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        KeyDeleteLL del = new KeyDeleteLL();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String listItem = br.readLine().trim();
            try {
                del.insertToList(Integer.parseInt(listItem));
            }
            catch(Exception ex) {
                break;
            }
        }
        int toDelete = -1;
        try {
            toDelete = Integer.parseInt(br.readLine().trim());
        }
        catch(Exception ex) {
            System.out.println("Required a number. Got some other characters.");
        }
        del.head = del.deleteAllOccurrences(del.head, toDelete);
        del.printList(del.head);
    }
}

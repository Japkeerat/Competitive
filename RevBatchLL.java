import java.io.*;

/** Program to reverse a linked list in batches of any arbitrary size k. */
public class RevBatchLL {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    private void insertToList(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private Node reverseInBatch(Node headNode, int batchSize) {
        Node prevNode = null;
        Node currNode = headNode;
        Node nextNode = null;
        int count = 0;
        while(count<batchSize && currNode!=null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            count++;
        }
        if(nextNode!=null) {
            headNode.next = reverseInBatch(nextNode, batchSize);
        }
        return prevNode;
    }

    private void printList(Node headNode) {
        while(headNode!=null) {
            System.out.print(headNode.data + " ");
            headNode = headNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        RevBatchLL ll = new RevBatchLL();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                String s = br.readLine().trim();
                ll.insertToList(Integer.parseInt(s));
            }
            catch(Exception ex) {
                ll.printList(ll.head);
                break;
            }
        }
        int batchSize = Integer.parseInt(br.readLine().trim());
        ll.head = ll.reverseInBatch(ll.head, batchSize);
        ll.printList(ll.head);
    }
}

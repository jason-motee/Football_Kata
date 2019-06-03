public class JasonLinkedList {

    private Node head;

    static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(Object data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }

    }

    public void printList(JasonLinkedList jasonLinkedList) {
        Node currentNode = jasonLinkedList.head;

        while(currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }


    public static void main(String[] args) {
        JasonLinkedList jasonLinkedList = new JasonLinkedList();
        jasonLinkedList.insert(1);
        jasonLinkedList.insert("asda");
        jasonLinkedList.insert(2);
        jasonLinkedList.insert(3);
        jasonLinkedList.insert(4);
        jasonLinkedList.insert(true);

        jasonLinkedList.printList(jasonLinkedList);
    }
}

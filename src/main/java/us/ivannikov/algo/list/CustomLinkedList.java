package us.ivannikov.algo.list;

public class CustomLinkedList<T> {

    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();


        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);


    }

    class Node {
        int index;
        Node next;
        T element;

        @Override
        public String toString() {
            return "" + element;
        }
    }

    Node next;
    Node root;

    public void add(T element) {
        // TODO
        //root is null
        //we initialize our structure
        if (root == null) {
            Node node = new Node();
            node.index = 0;
            node.element = element;
            root = node;
            return;
        }

        if (next == null) {
            Node newNode = new Node();
            newNode.index = 1;
            newNode.element = element;
            next = newNode;
            root.next = next;
            return;
        }

        //if the root is not null
        //we add to the last node as a next element
        Node temp = next;
        Node prev = null;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
            if (temp == null) {
                Node newNode = new Node();
                int newIndex = prev.index + 1;
                newNode.index = newIndex;
                newNode.element = element;
                prev.next = newNode;
            }
        }
    }

    public T get(int index) {
        // TODO
        Node temp = root;

        while (temp != null) {

            if (temp.index == index) {
                return (T) temp;
            }

            temp = temp.next;
        }

        return null;
    }

}


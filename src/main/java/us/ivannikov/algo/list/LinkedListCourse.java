package us.ivannikov.algo.list;

class Node {

    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkedListCourse {

    Node root;
    Node lastOne;
    int length = 0;

    public LinkedListCourse() {
    }

    public LinkedListCourse(int value) {
        Node node = new Node(value);
        root = node;
        lastOne = node;
    }

    public void add(int value) {
        Node node = new Node(value);

        if (length == 0) {
            root = node;
            lastOne = node;
            return;
        }

        lastOne.next = node;
        lastOne = node;
    }

    public Node getByIndex(int value) {
        if (length == 0) {
            return null;
        }
        if (length < value || value < 0) {
            return null;
        }
        int index = 0;
        Node temp = root;
        while (temp != null) {
            if (index == value) {
                return temp;
            }
            temp = temp.next;
            index++;
        }

        return null;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (length == 0) {
            root = node;
            lastOne = node;
            return;
        }
        node.next = root;
        root = node;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (length == 0) {
            root = node;
            lastOne = node;
            return;
        }
        node.next = lastOne;
        lastOne = node;
    }

    public Node replaceByIndex(int index, Node node) {
        if (length < index || index < 0) {
            return null;
        }

        Node temp = root;
        Node prev = null;
        int i = 0;
        while (temp != null) {
            if (index == 0) {
                prev = root;
                root = node;
                lastOne = node;
                return prev;
            }
            if (index == i) {
                node.next = temp.next;
                prev.next = node;
                return temp;
            }

            prev = temp;
            temp = temp.next;
            i++;
        }

        return null;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        node.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;

        Node print = node;
        while (print != null) {
            System.out.println("node: " + print.value);
            print = print.next;
        }

        Node print1 = new LinkedListCourse().reverse(node);
        while (print1 != null) {
            System.out.println("node after reverse: " + print1.value);
            print1 = print1.next;
        }
    }

    public Node reverse(Node node) {
        Node cur = node;
        Node prev = null;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}

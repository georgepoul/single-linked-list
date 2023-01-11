/***
 * created by gp
 */
public class MyList {

    private Node head;

    private int length;

    public MyList() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    /***
     * prints the nodes address
     */
    public void node_print(Node node) {

        System.out.println(node.getData());
    }

    public void printHead() {

        if (this.head == null) {
            System.out.println("The head is: null");
        } else {
            System.out.println("The head is: " + head.getData());
        }
    }

    /***
     * prints the hole list
     */
    public void printList() {

        Node current = head;

        while (current != null) {

            node_print(current);

            current = current.getNext();
        }
    }

    /***
     * add a node in the first place of my list
     * @param in data that I want to add to my list
     */
    public void addFirst(int in) {

        Node tmp = new Node(in);

        if (this.head != null) {
            tmp.setNext(this.head);
        }

        setHead(tmp);

        length++;
    }

    /***
     * add a node in the last place of my list
     * @param in data that I want to add to my list
     */
    public void addLast(int in) {

        Node tmp = new Node(in);

        if (head != null) {

            Node pos = this.head;

            while (pos.getNext() != null) {

                pos = pos.getNext();
            }
            pos.setNext(tmp);

        } else
            setHead(tmp);

        this.length++;

    }

    /***
     * remove the last node of the list
     * @return -1 if the list is empty or the data of the node I removed
     */
    public int removeLast() {

        Node current = head;

        int result = -1;

        if (current == null) {

            System.out.println("List is empty");

        } else if (current.getNext() == null) {

            result = current.getData();

            setHead(null);

            this.length--;

        } else {

            while (current.getNext().getNext() != null) {

                current = current.getNext();
            }

            result = current.getNext().getData();

            current.setNext(null);

            this.length--;

        }


        return result;
    }

    /***
     * Adds a value in a specific position
     * if the position is in upper out of the list then adds zero data nudes and the value in the position we want
     * if the position is not valid print a message
     * @param position the position for the value to be added
     * @param value the value to be added
     */
    public void addInPlace(int position, int value) {

        Node current = head;

        int isInplace = 0;

        if (position >= 0 && position < this.length) {

            while (isInplace != position -1) {

                current = current.getNext();

                isInplace ++;
            }

            Node newNode = new Node(value);

            Node tmp = current.getNext();

            current.setNext(newNode);

            newNode.setNext(tmp);

            System.out.println("The value: " + value + " added in position: " + isInplace);

        }else if (position > this.length - 1){

            for (int i = this.length - 1; i < position - 1; i ++){

                addLast(0);
            }

            addLast(value);

            System.out.println("The value: " + value + " added in position: " + position);

        }else{

            System.out.println("The position you have insert is not valid. Please try again");

        }


    }


}

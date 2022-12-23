import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.AbstractDocument;

import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    MyList list = new MyList();

    @Test
    void getHead() {

        //given
        int head = 10;
        list.addFirst(head);

        //when

        //then
        assertEquals(list.getHead().getData(),head);
    }

    @Test
    void setHead() {

        //given
        Node head = new Node(100);

        //when

        //then
        assertEquals(head.getData(), 100);
    }

    @Test
    void getLength() {


        //given
        list.addFirst(10);
        list.addFirst(20);

        //when

        //then
        assertEquals(list.getLength(),2);
    }

    @Test
    void addFirst() {

        //given
        list.addFirst(100);
        list.addFirst(200);

        //when

        //then
        assertEquals(list.getHead().getData(),200);
    }

    @Test
    void addLast() {

        //given
        list.addLast(100);
        list.addLast(200);

        //when

        //then
        assertEquals(list.getHead().getNext().getData(),200);
    }

    @Test
    void removeLast() {
        //given
        list.addLast(100);
        list.removeLast();

        //when

        //then
        assertNull(list.getHead());

    }

    @Test
    void addInPlace() {

        //given
        list.addFirst(100);


        list.addInPlace(0,1);
        list.addInPlace(1,100);
        list.addInPlace(3,500);

        //when

        //then

        assertEquals(list.getHead().getData(),1);
        assertEquals(list.getHead().getNext().getData(),100);
        assertEquals(list.getHead().getNext().getNext().getData(),0);
        assertEquals(list.getHead().getNext().getNext().getNext().getData(),500);

    }
}
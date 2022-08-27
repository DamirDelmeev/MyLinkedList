import intensive.task.list.MyLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MyLinkedListImplTest {
    private MyLinkedListImpl<Integer> myLinkedList;

    @BeforeEach
    public void beforeEach() {
        myLinkedList = new MyLinkedListImpl<>();
    }

    @Test()
    public void testAddInteger() {
        myLinkedList.add(1);
        Assertions.assertEquals(Optional.of(1).get(), myLinkedList.getSize());
    }

    @Test()
    public void testDeleteInteger() {
        myLinkedList.add(1);
        myLinkedList.delete(1);
        Assertions.assertEquals(0, (Object) myLinkedList.getSize());
    }

    @Test()
    public void testSort() {
        myLinkedList.add(5);
        myLinkedList.add(3);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(1);
        myLinkedList.sort();
        Assertions.assertEquals(" 1 2 3 4 5", myLinkedList.toString(5));
    }
}

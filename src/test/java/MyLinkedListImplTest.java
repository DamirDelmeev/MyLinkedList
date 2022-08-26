import intensive.task.list.MyLinkedListImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class MyLinkedListImplTest {
    MyLinkedListImpl<Integer> myLinkedList = new MyLinkedListImpl<>();

    @Test(timeout = 1)
    public void testAddInteger() {
        myLinkedList.add(1);
        Assert.assertEquals(Optional.of(1).get(), myLinkedList.getSize());
    }

    @Test(timeout = 1)
    public void testDeleteInteger() {
        myLinkedList.delete(1);
        Assert.assertEquals(0, (Object) myLinkedList.getSize());
    }

    @Test()
    public void testSort() {
        myLinkedList.add(5);
        myLinkedList.add(3);
        myLinkedList.add(2);
        myLinkedList.add(4);
        myLinkedList.add(1);
        myLinkedList.sort();
        Assert.assertEquals(" 1 2 3 4 5", myLinkedList.toString(5));
    }
}

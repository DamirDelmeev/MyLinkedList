package intensive.task.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node<T> implements Comparable<Node<T>> {
    Node<T> leftNode;
    Node<T> rightNode;
    T value;

    @Override
    public int compareTo(Node<T> nodeForCompare) {
        return ((Integer) this.getValue()).compareTo((Integer) nodeForCompare.getValue());
    }
}

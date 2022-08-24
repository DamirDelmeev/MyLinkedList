package intensive.task.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node<T> {
    Node<T> leftNode;
    Node<T> rightNode;
    T value;
}

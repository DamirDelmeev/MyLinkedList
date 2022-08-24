package intensive.task.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private Integer size = 0;
}

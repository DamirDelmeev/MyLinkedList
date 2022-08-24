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

    public void add(T t) {
        if (size == 0) {
            size++;
            firstNode = new Node<>(firstNode, firstNode, t);
            lastNode = firstNode;
        } else {
            Node<T> newNode = lastNode;
            lastNode = new Node<>(newNode, null, t);
            newNode.setRightNode(lastNode);
            size++;
        }
    }

    public boolean delete(T t) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < size; i++) {
            swapLinkOnNode(t, currentNode);
            currentNode = getNextNode(currentNode);
        }
        return false;
    }

    public T deleteFirst() {
        T value = firstNode.getValue();
        firstNode = firstNode.getRightNode() != null ? firstNode.getRightNode() : null;
        size--;
        return value;
    }

    public T deleteLast() {
        T value = lastNode.getValue();
        lastNode = lastNode.getLeftNode() != null ? lastNode.getLeftNode() : null;
        size--;
        return value;
    }

    private void swapLinkOnNode(T t, Node<T> currentNode) {
        if (currentNode.getValue().equals(t)) {
            changeLinkIfItsNotLastOrFirstNode(currentNode,
                    currentNode.getRightNode() == null ? null : currentNode.getRightNode(),
                    currentNode.getLeftNode() == null ? null : currentNode.getLeftNode());
            if (currentNode.getRightNode() == null) {
                lastNode = currentNode.getLeftNode() == null ? null : currentNode.getLeftNode();
            }
            if (currentNode.getLeftNode() == null) {
                firstNode = currentNode.getRightNode() == null ? null : currentNode.getRightNode();
            }
            size--;
        }
    }

    private Node<T> getNextNode(Node<T> firstNode) {
        return firstNode.getRightNode();
    }

    private void changeLinkIfItsNotLastOrFirstNode(Node<T> currentNode, Node<T> currentNode1, Node<T> currentNode2) {
        if (currentNode.getLeftNode() != null) {
            currentNode.getLeftNode().setRightNode(currentNode1);
        }
        if (currentNode.getRightNode() != null) {
            currentNode.getRightNode().setLeftNode(currentNode2);
        }
    }

}

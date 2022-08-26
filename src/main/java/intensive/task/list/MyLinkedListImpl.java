package intensive.task.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyLinkedListImpl<T> implements MyLinkedList<T> {
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

    public void sort() {
        quickSortInLinkedList(this.firstNode, this.lastNode, this.getSize());
    }

    private void quickSortInLinkedList(Node<T> firstNode, Node<T> lastNode, int size) {
        Node<T> pivotNode = lastNode;
        Node<T> currentNode = firstNode;
        for (int i = 0; i < size - 1; i++) {
            Node<T> temporaryNode = getNextNode(currentNode);
            if (pivotNode.compareTo(currentNode) <= 0) {
                if (lastNode.getRightNode() != null) {
                    changeLinkIfItsNotLastOrFirstNode(currentNode, currentNode.getRightNode(), currentNode.getLeftNode());
                    currentNode.setRightNode(lastNode.getRightNode());
                    lastNode.getRightNode().setLeftNode(currentNode);
                    lastNode.setRightNode(currentNode);
                    currentNode.setLeftNode(lastNode);
                } else {
                    changeLinkIfItsNotLastOrFirstNode(currentNode, currentNode.getRightNode(), currentNode.getLeftNode());
                    currentNode.setRightNode(null);
                    lastNode.setRightNode(currentNode);
                    currentNode.setLeftNode(lastNode);
                }
                lastNode = currentNode;
                currentNode = temporaryNode;
                continue;
            }
            currentNode = getNextNode(currentNode);
        }
        firstNode = getFirstNode(firstNode);
        if (firstNode.compareTo(pivotNode) != 0) {
            quickSortInLinkedList(firstNode, pivotNode.getLeftNode(), getSizeBetweenTwoNodes(firstNode, pivotNode.getLeftNode()));
        }
        if (pivotNode.compareTo(lastNode) != 0) {
            quickSortInLinkedList(pivotNode.getRightNode(), lastNode, getSizeBetweenTwoNodes(pivotNode.getRightNode(), lastNode));
        }
        this.firstNode = getFirstNode(firstNode);
        this.lastNode = getLastNode(lastNode);
    }

    private Node<T> getFirstNode(Node<T> firstNode) {
        Node<T> node = firstNode;
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node;
    }

    private Node<T> getLastNode(Node<T> lastNode) {
        Node<T> node = lastNode;
        while (node.getRightNode() != null) {
            node = node.getRightNode();
        }
        return node;
    }

    private int getSizeBetweenTwoNodes(Node<T> firstNode, Node<T> leftNode) {
        int result = 1;
        Node<T> currentNode = firstNode;
        while (!currentNode.equals(leftNode)) {
            result++;
            currentNode = getNextNode(currentNode);
        }
        return result;
    }
}

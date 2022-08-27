package intensive.task.list;

public interface MyLinkedList<T> {
    void add(T t);

    boolean delete(T t);

    T deleteFirst();

    T deleteLast();

    void sort();
}

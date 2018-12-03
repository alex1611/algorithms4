package priorityHeap;

public interface PriorityQueueMy<Item extends Comparable<Item>> {

    void insert(Item item);
    Item poll();
    Item take();
    boolean isEmpty();
    int size();
}

package priorityHeap;

public class PriorityQueueMyImpl<Item extends Comparable<Item>>  implements PriorityQueueMy<Item>{

    private Item[] pq;
    private int size;

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void swap(int i, int j){
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    public PriorityQueueMyImpl(int size) {
        pq =(Item[]) new Comparable[size + 1];
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            swap(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && less(j, j+1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    @Override
    public void insert(Item item) {
        pq[++size] = item;
        swim(size);
    }

    @Override
    public Item poll() {
        return pq[1];
    }

    @Override
    public Item take() {
        Item out = pq[1];
        swap(1, size--);
        pq[size+1] = null;
        sink(1);
        return out;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public int size() {
        return size;
    }
}

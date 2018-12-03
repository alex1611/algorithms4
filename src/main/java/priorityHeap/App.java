package priorityHeap;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int N = 15;
        PriorityQueueMy<Integer> queue = new PriorityQueueMyImpl<>(N);
        Random random = new Random();
        for (int i = 0; i< N; i++) {
            queue.insert(random.nextInt(100));
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.take());
        }
    }
}

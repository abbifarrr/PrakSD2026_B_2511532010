package pekan4_2511532010;

public class QueueArray_2511532010 {
    int front_2010;
    int rear_2010;
    int size_2010;
    int Capacity_2010;
    int array_2010[];

    public QueueArray_2511532010(int Capacity_2010) {
        this.Capacity_2010 = Capacity_2010;
        front_2010 = this.size_2010 = 0;
        rear_2010 = Capacity_2010 - 1;
        array_2010 = new int[this.Capacity_2010];
    }

    boolean isFull_2010(QueueArray_2511532010 queue) {
        return (queue.size_2010 == queue.Capacity_2010);
    }

    boolean isEmpty_2010(QueueArray_2511532010 queue) {
        return (queue.size_2010 == 0);
    }

    void enqueue_2010(int item_2010) {
        if (isFull_2010(this)) return;
        this.rear_2010 = (this.rear_2010 + 1) % this.Capacity_2010;
        this.array_2010[this.rear_2010] = item_2010; 
        this.size_2010 = this.size_2010 + 1;
        System.out.println(item_2010 + " enqueued to queue");
    }

    int dequeue_2010() {
        if (isEmpty_2010(this)) return Integer.MIN_VALUE;
        int item_2010 = this.array_2010[this.front_2010];
        this.front_2010 = (this.front_2010 + 1) % this.Capacity_2010;
        this.size_2010 = this.size_2010 - 1;
        return item_2010;
    }

    int getFront_2010() {
        if (isEmpty_2010(this)) return Integer.MIN_VALUE;
        return this.array_2010[this.front_2010];
    }

    int getRear_2010() {
        if (isEmpty_2010(this)) return Integer.MIN_VALUE;
        return this.array_2010[this.rear_2010];
    }

    void display_2010() {
        if (isEmpty_2010(this)) return;
        int current = front_2010;
        // KUNCI: i < size_2010 - 1 supaya elemen terakhir (40) tidak diprint
        for (int i = 0; i < size_2010 - 1; i++) {
            System.out.print(array_2010[current] + " <-- ");
            current = (current + 1) % Capacity_2010;
        }
        System.out.println();
    }
}
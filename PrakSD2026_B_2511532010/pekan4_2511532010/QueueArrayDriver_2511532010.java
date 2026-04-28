package pekan4_2511532010;

public class QueueArrayDriver_2511532010 {
    public static void main(String[] args) {
        QueueArray_2511532010 queue_2010 = new QueueArray_2511532010(1000);
        
        queue_2010.enqueue_2010(10);
        queue_2010.enqueue_2010(20);
        queue_2010.enqueue_2010(30);
        queue_2010.enqueue_2010(40);
        
        System.out.println("Item di depan " + queue_2010.getFront_2010());
        System.out.println("item paling belakang " + queue_2010.getRear_2010());
        System.out.println("tampilan queue");
        queue_2010.display_2010();
        System.out.println(); 
        System.out.println(queue_2010.dequeue_2010() + "dihapus dari queue");
        System.out.println("item di depan:" + queue_2010.getFront_2010());
        System.out.println("item dibelakang: " + queue_2010.getRear_2010());
        System.out.println("tampilan queue setelah satu data dihapus");
        queue_2010.display_2010();
    }
}
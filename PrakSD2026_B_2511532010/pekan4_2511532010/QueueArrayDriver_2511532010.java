package pekan4_2511532010;

public class QueueArrayDriver_2511532010 {

	public static void main(String[] args) {
		QueueArray_2511532010 queue = new QueueArray_2511532010(1000);
		queue.enqueue_2010(10);
		queue.enqueue_2010(20);
		queue.enqueue_2010(30);
		queue.enqueue_2010(40);
		System.out.println ("Item di depan " + queue.front_2010());
		System.out.println ("Item paling belakang "+ queue.rear_2010());
		System.out.println ("Tampilkan Queue");
		queue.display_2010();
		System.out.println();
		System.out.println (queue.dequeue_2010() + " dihapus dari queue");
		System.out.println ("Item di depan: " + queue.front_2010());
		System.out.println ("Item di belakang :" +queue.rear_2010());
		System.out.println ("Tampilan queue setelah satu data dihapus");
		queue.display_2010();
	}

}

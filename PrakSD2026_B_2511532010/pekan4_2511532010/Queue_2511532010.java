package pekan4_2511532010;

import java.util.Stack;

public class Queue_2511532010 {
    // Variabel sesuai standar dengan akhiran _2010
    private int front_2010;
    private int rear_2010;
    private int max_2010;
    private String[] queue_2010;
    private int size_2010;

    // Konstruktor
    public Queue_2511532010(int kapasitas) {
        max_2010 = kapasitas;
        queue_2010 = new String[max_2010];
        front_2010 = 0;
        rear_2010 = -1;
        size_2010 = 0;
    }

    // Method mengecek apakah antrian kosong
    public boolean isEmpty_2010() {
        return size_2010 == 0;
    }

    // Method mengecek apakah antrian penuh
    public boolean isFull_2010() {
        return size_2010 == max_2010;
    }

    // Method enqueue: menambah data ke belakang
    public void enqueue_2010(String data) {
        if (isFull_2010()) {
            System.out.println("Antrian penuh! Tidak dapat menambahkan pelanggan.");
        } else {
            // Menggunakan sistem circular queue agar memori efisien
            rear_2010 = (rear_2010 + 1) % max_2010;
            queue_2010[rear_2010] = data;
            size_2010++;
            System.out.println("Data berhasil ditambahkan ke antrian");
        }
    }

    // Method dequeue: menghapus data dari depan
    public void dequeue_2010() {
        if (isEmpty_2010()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang bisa dihapus.");
        } else {
            String temp = queue_2010[front_2010];
            front_2010 = (front_2010 + 1) % max_2010;
            size_2010--;
            System.out.println(temp + " telah dilayani");
        }
    }

    // Method display: menampilkan seluruh isi antrian
    public void display_2010() {
        if (isEmpty_2010()) {
            System.out.println("Antrian Kosong.");
        } else {
            System.out.println("Isi antrian:");
            for (int i = 0; i < size_2010; i++) {
                int index = (front_2010 + i) % max_2010;
                System.out.println((i + 1) + ". " + queue_2010[index]);
            }
        }
    }

    // Method reverse: membalik urutan antrian menggunakan Stack
    public void reverse_2010() {
        if (isEmpty_2010()) {
            System.out.println("Antrian kosong, tidak ada yang bisa di-reverse.");
            return;
        }

        Stack<String> stack_2010 = new Stack<>();
        
        // Pindahkan semua elemen dari queue ke stack
        while (!isEmpty_2010()) {
            String data = queue_2010[front_2010];
            stack_2010.push(data);
            front_2010 = (front_2010 + 1) % max_2010;
            size_2010--;
        }

        // Masukkan kembali dari stack ke queue (urutan otomatis terbalik)
        while (!stack_2010.isEmpty()) {
            enqueue_2010(stack_2010.pop());
        }
    }
}
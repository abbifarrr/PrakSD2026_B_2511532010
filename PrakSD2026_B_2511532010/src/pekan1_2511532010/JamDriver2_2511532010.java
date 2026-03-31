package pekan1_2511532010;
import java.util.Scanner;

public class JamDriver2_2511532010 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Program Driver Objek Jam ===");

        // 1. Input Jam Pertama
        System.out.println("\n--- Input Jam 1 ---");
        Jam_2511532010 j1 = buatJamDariInput(input);

        // 2. Input Jam Kedua
        System.out.println("\n--- Input Jam 2 ---");
        Jam_2511532010 j2 = buatJamDariInput(input);

        // 3. Menampilkan Data
        System.out.println("\n--- Hasil Operasi ---");
        System.out.println("Jam 1 (String)\t\t: " + j1);
        System.out.println("Jam 2 (String)\t\t: " + j2);
        System.out.println("Jam 1 dalam detik\t: " + j1.toSeconds());
        System.out.println("Jam 2 dalam detik\t: " + j2.toSeconds());

        // 4. Perbandingan
        int perbandingan = j1.compareTo(j2);
        if (perbandingan > 0) {
            System.out.println("Status\t\t\t: Jam 1 lebih lambat (setelah) Jam 2");
        } else if (perbandingan < 0) {
            System.out.println("Status\t\t\t: Jam 1 lebih awal (sebelum) Jam 2");
        } else {
            System.out.println("Status\t\t\t: Jam 1 dan Jam 2 sama persis");
        }

        // 5. Operasi Aritmatika
        System.out.println("Durasi (J1 ke J2)\t: " +
                Jam_2511532010.durasiDetik(j1, j2) + " detik");

        Jam_2511532010 jnext = j1.nextSecond();
        System.out.println("Jam 1 Detik Berikutnya: " + jnext);

        Jam_2511532010 jPrev = j1.prevSecond();
        System.out.println("Jam 1 Detik Sebelumnya: " + jPrev);

        // 6. Penjumlahan
        Jam_2511532010 jHasilPlus = j1.plus(j2);
        System.out.println("Hasil J1 + J2\t\t: " + jHasilPlus);

        input.close();
        System.out.println("\nProgram Selesai.");
    }

    private static Jam_2511532010 buatJamDariInput(Scanner sc) {
        int h, m, s;

        while (true) {
            System.out.print("Masukkan Jam (0-23)\t: ");
            h = sc.nextInt();

            System.out.print("Masukkan Menit (0-59)\t: ");
            m = sc.nextInt();

            System.out.print("Masukkan Detik (0-59)\t: ");
            s = sc.nextInt();

            if (Jam_2511532010.isValid(h, m, s)) {
                return new Jam_2511532010(h, m, s);
            } else {
                System.out.println("[Error] Input tidak valid! Silakan ulangi.\n");
            }
        }
    }
}

package pekan7_2511532010;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MahasiswaGUI_2511532010 extends JFrame {
    // Komponen GUI Input
    private JTextField txtNama_2010;
    private JTextField txtNim_2010;
    private JTextField txtProdi_2010;
    
    // Komponen GUI Aksi & Pilihan
    private JButton btnTambah_2010;
    private JButton btnHapus_2010;
    private JButton btnSort_2010;
    private JComboBox<String> cbAlgoritma_2010;
    
    // Komponen GUI Output Display
    private JTable tabelMahasiswa_2010;
    private DefaultTableModel modelTabel_2010;
    private JTextArea txtLogVisualisasi_2010;
    
    // Struktur Data Penampung Object Mahasiswa
    private ArrayList<Mahasiswa_2511532010> listMahasiswa_2010;

    // Constructor GUI
    public MahasiswaGUI_2511532010() {
        listMahasiswa_2010 = new ArrayList<>();
        inisialisasiKomponen_2010();
    }

    private void inisialisasiKomponen_2010() {
        setTitle("Program Pengurutan Nama Mahasiswa _2010");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. PANEL INPUT DATA (Bagian Atas)
        JPanel panelInput_2010 = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput_2010.setBorder(BorderFactory.createTitledBorder("Form Input Mahasiswa"));

        panelInput_2010.add(new JLabel(" Nama Mahasiswa:"));
        txtNama_2010 = new JTextField();
        panelInput_2010.add(txtNama_2010);

        panelInput_2010.add(new JLabel(" NIM Mahasiswa:"));
        txtNim_2010 = new JTextField();
        panelInput_2010.add(txtNim_2010);

        panelInput_2010.add(new JLabel(" Program Studi:"));
        txtProdi_2010 = new JTextField();
        panelInput_2010.add(txtProdi_2010);

        btnTambah_2010 = new JButton("Tambah Data");
        btnHapus_2010 = new JButton("Hapus Data Terpilih");
        panelInput_2010.add(btnTambah_2010);
        panelInput_2010.add(btnHapus_2010);

        // 2. PANEL KONTROL SORTING & TABEL DATA (Bagian Tengah)
        JPanel panelTengah_2010 = new JPanel(new BorderLayout(5, 5));
        
        // Sub-panel Kontrol Sorting
        JPanel panelKontrol_2010 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelKontrol_2010.add(new JLabel("Pilih Algoritma: "));
        String[] pilihanAlgoritma_2010 = {"Insertion Sort", "Selection Sort", "Bubble Sort"};
        cbAlgoritma_2010 = new JComboBox<>(pilihanAlgoritma_2010);
        panelKontrol_2010.add(cbAlgoritma_2010);
        
        btnSort_2010 = new JButton("Mulai Sorting");
        panelKontrol_2010.add(btnSort_2010);
        panelTengah_2010.add(panelKontrol_2010, BorderLayout.NORTH);

        // Tabel Data Mahasiswa
        String[] kolomTabel_2010 = {"Nama", "NIM", "Prodi"};
        modelTabel_2010 = new DefaultTableModel(kolomTabel_2010, 0);
        tabelMahasiswa_2010 = new JTable(modelTabel_2010);
        JScrollPane scrollTabel_2010 = new JScrollPane(tabelMahasiswa_2010);
        scrollTabel_2010.setPreferredSize(new Dimension(400, 200));
        panelTengah_2010.add(scrollTabel_2010, BorderLayout.CENTER);

        // 3. PANEL VISUALISASI LOG LOGIKA (Bagian Kanan/Bawah)
        txtLogVisualisasi_2010 = new JTextArea();
        txtLogVisualisasi_2010.setEditable(false);
        txtLogVisualisasi_2010.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollLog_2010 = new JScrollPane(txtLogVisualisasi_2010);
        scrollLog_2010.setBorder(BorderFactory.createTitledBorder("Visualisasi Proses Sorting Langkah-demi-Langkah"));
        scrollLog_2010.setPreferredSize(new Dimension(400, 200));

        // Menggabungkan Semua Panel ke Frame Utama
        add(panelInput_2010, BorderLayout.NORTH);
        add(panelTengah_2010, BorderLayout.CENTER);
        add(scrollLog_2010, BorderLayout.SOUTH);

        // --- REGISTRASI EVENT LISTENER / ACTION _2010 ---

        // Aksi Tombol Tambah Data
        btnTambah_2010.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahDataMahasiswa_2010();
            }
        });

        // Aksi Tombol Hapus Data Terpilih
        btnHapus_2010.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusDataMahasiswa_2010();
            }
        });

        // Aksi Tombol Mulai Sorting
        btnSort_2010.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jalankanProsesSorting_2010();
            }
        });
    }

    // Method untuk menambah data ke ArrayList dan memperbarui Tabel
    private void tambahDataMahasiswa_2010() {
        String nama_2010 = txtNama_2010.getText().trim();
        String nim_2010 = txtNim_2010.getText().trim();
        String prodi_2010 = txtProdi_2010.getText().trim();

        if (nama_2010.isEmpty() || nim_2010.isEmpty() || prodi_2010.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua data input harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Membuat objek baru ADT Mahasiswa
        Mahasiswa_2511532010 mhs_2010 = new Mahasiswa_2511532010(nama_2010, nim_2010, prodi_2010);
        listMahasiswa_2010.add(mhs_2010);

        // Update Tampilan Tabel
        modelTabel_2010.addRow(new Object[]{mhs_2010.getNama_2010(), mhs_2010.getNim_2010(), mhs_2010.getProdi_2010()});

        // Bersihkan Field Input kembali
        txtNama_2010.setText("");
        txtNim_2010.setText("");
        txtProdi_2010.setText("");
        txtNama_2010.requestFocus();
    }

    // Method untuk menghapus baris data mahasiswa terpilih
    private void hapusDataMahasiswa_2010() {
        int barisTerpilih_2010 = tabelMahasiswa_2010.getSelectedRow();
        if (barisTerpilih_2010 >= 0) {
            listMahasiswa_2010.remove(barisTerpilih_2010);
            modelTabel_2010.removeRow(barisTerpilih_2010);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih baris data pada tabel yang ingin dihapus!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method pemicu sorting berdasarkan pilihan ComboBox
    private void jalankanProsesSorting_2010() {
        if (listMahasiswa_2010.size() < 2) {
            JOptionPane.showMessageDialog(this, "Data minimal harus berjumlah 2 untuk diurutkan!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        txtLogVisualisasi_2010.setText(""); // Reset log visualisasi teks
        String algoTerpilih_2010 = (String) cbAlgoritma_2010.getSelectedItem();

        if (algoTerpilih_2010.equals("Insertion Sort")) {
            insertionSort_2010();
        } else if (algoTerpilih_2010.equals("Selection Sort")) {
            selectionSort_2010();
        } else if (algoTerpilih_2010.equals("Bubble Sort")) {
            bubbleSort_2010();
        }

        refreshTampilanTabel_2010();
    }

    // Helper untuk mengambil representasi deretan nama mahasiswa saat ini (untuk visualisasi)
    private String dapatkanSnapshotNama_2010() {
        StringBuilder sb_2010 = new StringBuilder("[");
        for (int i = 0; i < listMahasiswa_2010.size(); i++) {
            sb_2010.append(listMahasiswa_2010.get(i).getNama_2010());
            if (i < listMahasiswa_2010.size() - 1) {
                sb_2010.append(", ");
            }
        }
        sb_2010.append("]");
        return sb_2010.toString();
    }

    // Menyinkronkan susunan di ArrayList ke GUI JTable setelah disorting
    private void refreshTampilanTabel_2010() {
        modelTabel_2010.setRowCount(0); // Kosongkan tabel lama
        for (Mahasiswa_2511532010 mhs_2010 : listMahasiswa_2010) {
            modelTabel_2010.addRow(new Object[]{mhs_2010.getNama_2010(), mhs_2010.getNim_2010(), mhs_2010.getProdi_2010()});
        }
    }

    // ================= METHOD ALGORITMA SORTING _2010 =================

    // 1. Algoritma Insertion Sort
    private void insertionSort_2010() {
        txtLogVisualisasi_2010.append("=== INSERTION SORT ===\n");
        txtLogVisualisasi_2010.append("Data Awal : " + dapatkanSnapshotNama_2010() + "\n");
        
        int n_2010 = listMahasiswa_2010.size();
        for (int i_2010 = 1; i_2010 < n_2010; i_2010++) {
            Mahasiswa_2511532010 kunciMhs_2010 = listMahasiswa_2010.get(i_2010);
            String kunciNama_2010 = kunciMhs_2010.getNama_2010();
            int j_2010 = i_2010 - 1;

            // Menggunakan compareToIgnoreCase() untuk pengurutan Ascending (A-Z) tanpa sensitivitas huruf kapital
            while (j_2010 >= 0 && listMahasiswa_2010.get(j_2010).getNama_2010().compareToIgnoreCase(kunciNama_2010) > 0) {
                listMahasiswa_2010.set(j_2010 + 1, listMahasiswa_2010.get(j_2010));
                j_2010--;
            }
            listMahasiswa_2010.set(j_2010 + 1, kunciMhs_2010);
            
            // Log Visualisasi per langkah luar loop
            txtLogVisualisasi_2010.append("Langkah " + i_2010 + " : " + dapatkanSnapshotNama_2010() + "\n");
        }
    }

    // 2. Algoritma Selection Sort
    private void selectionSort_2010() {
        txtLogVisualisasi_2010.append("=== SELECTION SORT ===\n");
        txtLogVisualisasi_2010.append("Data Awal : " + dapatkanSnapshotNama_2010() + "\n");

        int n_2010 = listMahasiswa_2010.size();
        for (int i_2010 = 0; i_2010 < n_2010 - 1; i_2010++) {
            int indeksMin_2010 = i_2010;
            for (int j_2010 = i_2010 + 1; j_2010 < n_2010; j_2010++) {
                if (listMahasiswa_2010.get(j_2010).getNama_2010().compareToIgnoreCase(listMahasiswa_2010.get(indeksMin_2010).getNama_2010()) < 0) {
                    indeksMin_2010 = j_2010;
                }
            }
            // Swap / Tukar posisi objek data mahasiswa
            Mahasiswa_2511532010 tempMhs_2010 = listMahasiswa_2010.get(indeksMin_2010);
            listMahasiswa_2010.set(indeksMin_2010, listMahasiswa_2010.get(i_2010));
            listMahasiswa_2010.set(i_2010, tempMhs_2010);

            // Log Visualisasi per tahapan (Pass)
            txtLogVisualisasi_2010.append("Pass " + (i_2010 + 1) + " : " + dapatkanSnapshotNama_2010() + "\n");
        }
    }

    // 3. Algoritma Bubble Sort
    private void bubbleSort_2010() {
        txtLogVisualisasi_2010.append("=== BUBBLE SORT ===\n");
        txtLogVisualisasi_2010.append("Data Awal : " + dapatkanSnapshotNama_2010() + "\n");

        int n_2010 = listMahasiswa_2010.size();
        for (int i_2010 = 0; i_2010 < n_2010 - 1; i_2010++) {
            for (int j_2010 = 0; j_2010 < n_2010 - i_2010 - 1; j_2010++) {
                if (listMahasiswa_2010.get(j_2010).getNama_2010().compareToIgnoreCase(listMahasiswa_2010.get(j_2010 + 1).getNama_2010()) > 0) {
                    // Swap / Tukar elemen
                    Mahasiswa_2511532010 tempMhs_2010 = listMahasiswa_2010.get(j_2010);
                    listMahasiswa_2010.set(j_2010, listMahasiswa_2010.get(j_2010 + 1));
                    listMahasiswa_2010.set(j_2010 + 1, tempMhs_2010);
                }
            }
            // Log Visualisasi per tahapan (Pass) luar loop
            txtLogVisualisasi_2010.append("Pass " + (i_2010 + 1) + " : " + dapatkanSnapshotNama_2010() + "\n");
        }
    }

    // Main Method untuk menjalankan GUI Program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MahasiswaGUI_2511532010().setVisible(true);
            }
        });
    }
}
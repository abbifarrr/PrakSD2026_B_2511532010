package pekan9_2511532010;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PetaRelKereta_2511532010 extends JFrame {

    // Semua variabel menggunakan akhiran _2010 sesuai aturan
    private Map<String, List<String>> graph_2010;
    private Map<String, Point> koordinat_2010;
    private List<String> nodes_2010;
    
    private JComboBox<String> cbAwal_2010;
    private JComboBox<String> cbTujuan_2010;
    private JTextArea txtHasil_2010;
    private PanelVisual_2010 panelGraph_2010;

    private List<String> path_2010;
    private List<String> visitedNodes_2010;
    private int jumlahEksplorasi_2010;

    public PetaRelKereta_2511532010() {
        // Inisialisasi variabel koleksi
        graph_2010 = new LinkedHashMap<>();
        koordinat_2010 = new HashMap<>();
        nodes_2010 = new ArrayList<>();
        path_2010 = new ArrayList<>();
        visitedNodes_2010 = new ArrayList<>();
        jumlahEksplorasi_2010 = 0;

        // Membangun data graf (10 Node, 15 Edge)
        inisialisasiData_2010();

        // Pengaturan JFrame
        setTitle("Pencarian Jalur Kereta Api (BFS & DFS) - 2511532010");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // --- PANEL ATAS (Kontrol Input) ---
        JPanel panelKontrol_2010 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelKontrol_2010.setBackground(new Color(30, 60, 100)); // Warna biru gelap

        JLabel lblAwal_2010 = new JLabel("Stasiun Awal: ");
        lblAwal_2010.setForeground(Color.WHITE);
        cbAwal_2010 = new JComboBox<>(nodes_2010.toArray(new String[0]));

        JLabel lblTujuan_2010 = new JLabel("Stasiun Tujuan: ");
        lblTujuan_2010.setForeground(Color.WHITE);
        cbTujuan_2010 = new JComboBox<>(nodes_2010.toArray(new String[0]));

        JButton btnBfs_2010 = new JButton("[ BFS ]");
        btnBfs_2010.setBackground(new Color(100, 200, 100)); // Hijau
        
        JButton btnDfs_2010 = new JButton("[ DFS ]");
        btnDfs_2010.setBackground(new Color(250, 180, 50)); // Oranye
        
        JButton btnReset_2010 = new JButton("[ RESET ]");
        btnReset_2010.setBackground(new Color(220, 80, 80)); // Merah

        panelKontrol_2010.add(lblAwal_2010);
        panelKontrol_2010.add(cbAwal_2010);
        panelKontrol_2010.add(lblTujuan_2010);
        panelKontrol_2010.add(cbTujuan_2010);
        panelKontrol_2010.add(btnBfs_2010);
        panelKontrol_2010.add(btnDfs_2010);
        panelKontrol_2010.add(btnReset_2010);

        // --- PANEL TENGAH (Visualisasi Graph) ---
        panelGraph_2010 = new PanelVisual_2010();
        panelGraph_2010.setBorder(BorderFactory.createTitledBorder("VISUALISASI GRAPH REL KERETA"));
        panelGraph_2010.setBackground(new Color(240, 240, 245));

        // --- PANEL BAWAH (Hasil Pencarian) ---
        JPanel panelBawah_2010 = new JPanel(new BorderLayout());
        panelBawah_2010.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtHasil_2010 = new JTextArea(6, 50);
        txtHasil_2010.setEditable(false);
        txtHasil_2010.setFont(new Font("Monospaced", Font.BOLD, 14));
        txtHasil_2010.setText("Hasil Pencarian :\nJalur :\nNode Dikunjungi :\nJumlah Node Dikunjungi : 0");
        panelBawah_2010.add(new JScrollPane(txtHasil_2010), BorderLayout.CENTER);

        // Menambahkan panel ke Frame
        add(panelKontrol_2010, BorderLayout.NORTH);
        add(panelGraph_2010, BorderLayout.CENTER);
        add(panelBawah_2010, BorderLayout.SOUTH);

        // --- ACTION LISTENERS ---
        btnBfs_2010.addActionListener(e -> BFS());
        btnDfs_2010.addActionListener(e -> DFS());
        btnReset_2010.addActionListener(e -> resetGraph());
    }

    private void inisialisasiData_2010() {
        // 1. Menambahkan 10 Node (Stasiun) beserta koordinat untuk GUI
        tambahNode_2010("Jakarta", 300, 50);
        tambahNode_2010("Tangerang", 100, 120);
        tambahNode_2010("Bekasi", 500, 120);
        tambahNode_2010("Depok", 300, 150);
        tambahNode_2010("Bogor", 300, 280);
        tambahNode_2010("Cikarang", 650, 120);
        tambahNode_2010("Karawang", 650, 220);
        tambahNode_2010("Purwakarta", 500, 280);
        tambahNode_2010("Cimahi", 400, 400);
        tambahNode_2010("Bandung", 600, 400);

        // 2. Menambahkan 15 Edge (Jalur Kereta)
        tambahEdge_2010("Jakarta", "Tangerang");
        tambahEdge_2010("Jakarta", "Bekasi");
        tambahEdge_2010("Jakarta", "Depok");
        tambahEdge_2010("Tangerang", "Depok");
        tambahEdge_2010("Bekasi", "Depok");
        
        tambahEdge_2010("Bekasi", "Cikarang");
        tambahEdge_2010("Depok", "Bogor");
        tambahEdge_2010("Bogor", "Purwakarta");
        tambahEdge_2010("Cikarang", "Karawang");
        tambahEdge_2010("Karawang", "Purwakarta");
        
        tambahEdge_2010("Purwakarta", "Cimahi");
        tambahEdge_2010("Purwakarta", "Bandung");
        tambahEdge_2010("Cimahi", "Bandung");
        tambahEdge_2010("Cikarang", "Purwakarta");
        tambahEdge_2010("Karawang", "Bandung");
    }

    private void tambahNode_2010(String nama_2010, int x_2010, int y_2010) {
        nodes_2010.add(nama_2010);
        graph_2010.put(nama_2010, new ArrayList<>());
        koordinat_2010.put(nama_2010, new Point(x_2010, y_2010));
    }

    private void tambahEdge_2010(String asal_2010, String tujuan_2010) {
        graph_2010.get(asal_2010).add(tujuan_2010);
        graph_2010.get(tujuan_2010).add(asal_2010); // Undirected graph
    }

    // --- METHOD WAJIB 1: BFS() ---
    public void BFS() {
        String start_2010 = (String) cbAwal_2010.getSelectedItem();
        String goal_2010 = (String) cbTujuan_2010.getSelectedItem();

        Queue<String> queue_2010 = new LinkedList<>();
        Map<String, String> parent_2010 = new HashMap<>();
        
        resetDataPencarian_2010();

        queue_2010.add(start_2010);
        visitedNodes_2010.add(start_2010);

        boolean found_2010 = false;

        while (!queue_2010.isEmpty()) {
            String curr_2010 = queue_2010.poll();
            jumlahEksplorasi_2010++;

            if (curr_2010.equals(goal_2010)) {
                found_2010 = true;
                break;
            }

            for (String neighbor_2010 : graph_2010.get(curr_2010)) {
                if (!visitedNodes_2010.contains(neighbor_2010)) {
                    visitedNodes_2010.add(neighbor_2010);
                    parent_2010.put(neighbor_2010, curr_2010);
                    queue_2010.add(neighbor_2010);
                }
            }
        }

        if (found_2010) susunJalur_2010(parent_2010, start_2010, goal_2010);
        displayPath();
        displayGraph();
    }

    // --- METHOD WAJIB 2: DFS() ---
    public void DFS() {
        String start_2010 = (String) cbAwal_2010.getSelectedItem();
        String goal_2010 = (String) cbTujuan_2010.getSelectedItem();

        resetDataPencarian_2010();
        Map<String, String> parent_2010 = new HashMap<>();

        boolean found_2010 = dfsRekursif_2010(start_2010, goal_2010, parent_2010);

        if (found_2010) susunJalur_2010(parent_2010, start_2010, goal_2010);
        displayPath();
        displayGraph();
    }

    private boolean dfsRekursif_2010(String curr_2010, String goal_2010, Map<String, String> parent_2010) {
        visitedNodes_2010.add(curr_2010);
        jumlahEksplorasi_2010++;

        if (curr_2010.equals(goal_2010)) {
            return true;
        }

        for (String neighbor_2010 : graph_2010.get(curr_2010)) {
            if (!visitedNodes_2010.contains(neighbor_2010)) {
                parent_2010.put(neighbor_2010, curr_2010);
                if (dfsRekursif_2010(neighbor_2010, goal_2010, parent_2010)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper untuk merangkai jalur setelah target ditemukan
    private void susunJalur_2010(Map<String, String> parent_2010, String start_2010, String goal_2010) {
        String curr_2010 = goal_2010;
        while (curr_2010 != null) {
            path_2010.add(0, curr_2010); // Insert di awal
            curr_2010 = parent_2010.get(curr_2010);
        }
    }

    // --- METHOD WAJIB 3: displayGraph() ---
    public void displayGraph() {
        panelGraph_2010.repaint(); // Memperbarui UI untuk mewarnai node
    }

    // --- METHOD WAJIB 4: displayPath() ---
    public void displayPath() {
        StringBuilder sb_2010 = new StringBuilder();
        sb_2010.append("Hasil Pencarian :\n");
        
        sb_2010.append("Jalur : ");
        if (path_2010.isEmpty()) {
            sb_2010.append("Jalur tidak ditemukan!\n");
        } else {
            sb_2010.append(String.join(" -> ", path_2010)).append("\n");
        }

        sb_2010.append("Node Dikunjungi : ").append(visitedNodes_2010.toString()).append("\n");
        sb_2010.append("Jumlah Node Dikunjungi : ").append(jumlahEksplorasi_2010);

        txtHasil_2010.setText(sb_2010.toString());
    }

    // --- METHOD WAJIB 5: resetGraph() ---
    public void resetGraph() {
        cbAwal_2010.setSelectedIndex(0);
        cbTujuan_2010.setSelectedIndex(0);
        resetDataPencarian_2010();
        txtHasil_2010.setText("Hasil Pencarian :\nJalur :\nNode Dikunjungi :\nJumlah Node Dikunjungi : 0");
        displayGraph();
    }

    private void resetDataPencarian_2010() {
        visitedNodes_2010.clear();
        path_2010.clear();
        jumlahEksplorasi_2010 = 0;
    }

    // --- INNER CLASS UNTUK MENGGAMBAR GRAPH (Visualisasi Visual & Warna) ---
    private class PanelVisual_2010 extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d_2010 = (Graphics2D) g;
            g2d_2010.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 1. Gambar Garis (Edge)
            g2d_2010.setStroke(new BasicStroke(2));
            g2d_2010.setColor(Color.GRAY);
            
            // Track edges drawn untuk menghindari gambar dua kali
            Set<String> drawnEdges_2010 = new HashSet<>(); 

            for (String asal_2010 : graph_2010.keySet()) {
                Point p1_2010 = koordinat_2010.get(asal_2010);
                for (String tujuan_2010 : graph_2010.get(asal_2010)) {
                    String edgeId1_2010 = asal_2010 + "-" + tujuan_2010;
                    String edgeId2_2010 = tujuan_2010 + "-" + asal_2010;
                    
                    if (!drawnEdges_2010.contains(edgeId1_2010) && !drawnEdges_2010.contains(edgeId2_2010)) {
                        Point p2_2010 = koordinat_2010.get(tujuan_2010);
                        
                        // Cek apakah garis ini adalah rute terpilih (jalur akhir)
                        if (path_2010.contains(asal_2010) && path_2010.contains(tujuan_2010) &&
                           Math.abs(path_2010.indexOf(asal_2010) - path_2010.indexOf(tujuan_2010)) == 1) {
                            g2d_2010.setColor(new Color(50, 200, 50)); // Hijau untuk jalur
                            g2d_2010.setStroke(new BasicStroke(4));
                        } else {
                            g2d_2010.setColor(Color.LIGHT_GRAY);
                            g2d_2010.setStroke(new BasicStroke(2));
                        }
                        
                        g2d_2010.drawLine(p1_2010.x, p1_2010.y, p2_2010.x, p2_2010.y);
                        drawnEdges_2010.add(edgeId1_2010);
                    }
                }
            }

            // 2. Gambar Titik (Node/Stasiun)
            for (String node_2010 : nodes_2010) {
                Point p_2010 = koordinat_2010.get(node_2010);
                
                // Pewarnaan Berdasarkan Status (Sesuai Syarat)
                if (path_2010.contains(node_2010)) {
                    g2d_2010.setColor(new Color(50, 200, 50)); // Hijau (Jalur Akhir)
                } else if (visitedNodes_2010.contains(node_2010)) {
                    g2d_2010.setColor(new Color(255, 180, 50)); // Oranye (Telah dieksplorasi)
                } else {
                    g2d_2010.setColor(new Color(150, 150, 150)); // Abu-abu (Belum dikunjungi)
                }
                
                g2d_2010.fillOval(p_2010.x - 15, p_2010.y - 15, 30, 30);
                
                // Border Hitam pada Node
                g2d_2010.setColor(Color.BLACK);
                g2d_2010.drawOval(p_2010.x - 15, p_2010.y - 15, 30, 30);
                
                // Teks Nama Stasiun
                g2d_2010.setFont(new Font("Arial", Font.BOLD, 12));
                g2d_2010.drawString(node_2010, p_2010.x - 20, p_2010.y - 20);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetaRelKereta_2511532010().setVisible(true);
        });
    }
}
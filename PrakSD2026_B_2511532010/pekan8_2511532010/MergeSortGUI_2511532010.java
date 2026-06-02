package pekan8_2511532010;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class MergeSortGUI_2511532010 extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] array_2010;
    private JLabel[] labelArray_2010;
    private JButton stepButton_2010, resetButton_2010, setButton_2010;
    private JTextField inputField_2010;
    private JPanel panelArray_2010;
    private JTextArea stepArea_2010;
    
    // Variabel spesifik untuk state Merge Sort
    private Queue<int[]> mergeQueue_2010 = new LinkedList<>();
    private boolean isMerging_2010 = false;
    private boolean copying_2010 = false;
    private int stepCount_2010 = 1;
    
    private int left_2010, mid_2010, right_2010;
    private int[] temp_2010;
    private int i_2010, j_2010, k_2010;

    public MergeSortGUI_2511532010() {
        // Mengubah judul frame agar sesuai dengan Merge Sort
        setTitle("Merge Sort Langkah per Langkah"); 
        setSize(1000, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        inputField_2010 = new JTextField();
        setButton_2010 = new JButton("Set Array");
        
        inputPanel.add(new JLabel("Masukkan angka (pisahkan dengan koma) : "), BorderLayout.WEST); 
        inputPanel.add(inputField_2010, BorderLayout.CENTER); 
        inputPanel.add(setButton_2010, BorderLayout.EAST);
        
        // Panel array visual
        panelArray_2010 = new JPanel();
        panelArray_2010.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 50));
        
        // Panel kontrol
        JPanel controlPanel = new JPanel();
        stepButton_2010 = new JButton("Langkah Selanjutnya");
        resetButton_2010 = new JButton("Reset");
        
        stepButton_2010.setEnabled(false); 
        controlPanel.add(stepButton_2010); 
        controlPanel.add(resetButton_2010);

        // Area teks untuk log langkah-langkah
        stepArea_2010 = new JTextArea(8, 50);
        stepArea_2010.setEditable(false);
        stepArea_2010.setFont(new Font("Monospaced", Font.PLAIN, 14)); 

        JScrollPane scrollPane_2010 = new JScrollPane(stepArea_2010);
        scrollPane_2010.setBorder(BorderFactory.createTitledBorder("Log Proses Sorting"));

        add(inputPanel, BorderLayout.NORTH); 
        add(panelArray_2010, BorderLayout.CENTER); 
        add(controlPanel, BorderLayout.SOUTH); 
        add(scrollPane_2010, BorderLayout.EAST);

        // Event Listeners
        setButton_2010.addActionListener(e -> setArrayFromInput_2010());
        stepButton_2010.addActionListener(e -> performStep_2010());
        resetButton_2010.addActionListener(e -> reset_2010());
    }

    private void setArrayFromInput_2010() {
        String text_2010 = inputField_2010.getText().trim();
        if (text_2010.isEmpty()) return;

        String[] parts_2010 = text_2010.split(",");
        array_2010 = new int[parts_2010.length];

        try {
            for (int i = 0; i < parts_2010.length; i++) {
                array_2010[i] = Integer.parseInt(parts_2010[i].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Masukkan hanya angka yang dipisahkan dengan koma!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelArray_2010 = new JLabel[array_2010.length];
        panelArray_2010.removeAll();

        for (int i = 0; i < array_2010.length; i++) {
            labelArray_2010[i] = new JLabel(String.valueOf(array_2010[i]));
            labelArray_2010[i].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2010[i].setOpaque(true);
            labelArray_2010[i].setBackground(Color.WHITE);
            labelArray_2010[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2010[i].setPreferredSize(new Dimension(50, 50));
            labelArray_2010[i].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2010.add(labelArray_2010[i]);
        }

        mergeQueue_2010.clear();
        generateMergeSteps_2010(0, array_2010.length - 1);
        
        stepButton_2010.setEnabled(true);
        stepArea_2010.setText("");
        stepCount_2010 = 1;
        isMerging_2010 = false;
        copying_2010 = false;
        
        panelArray_2010.revalidate();
        panelArray_2010.repaint();
    }

    // Fungsi rekursif untuk menghasilkan urutan penggabungan (merge)
    private void generateMergeSteps_2010(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            generateMergeSteps_2010(l, m);
            generateMergeSteps_2010(m + 1, r);
            mergeQueue_2010.add(new int[]{l, m, r});
        }
    }

    private void performStep_2010() {
        resetHighlights_2010();

        if (!isMerging_2010 && mergeQueue_2010.isEmpty()) {
            stepArea_2010.append("Selesai.\n");
            stepButton_2010.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
            return;
        }

        if (!isMerging_2010) {
            int[] range = mergeQueue_2010.poll();
            left_2010 = range[0];
            mid_2010 = range[1];
            right_2010 = range[2];
            
            temp_2010 = new int[right_2010 - left_2010 + 1];
            i_2010 = left_2010;
            j_2010 = mid_2010 + 1;
            k_2010 = 0;
            
            copying_2010 = false;
            isMerging_2010 = true;
            
            stepArea_2010.append("Langkah " + stepCount_2010++ + ": Mulai merge dari indeks " + left_2010 + " ke " + right_2010 + "\n");
            return;
        }

        if (isMerging_2010 && !copying_2010) {
            if (i_2010 <= mid_2010 && j_2010 <= right_2010) {
                labelArray_2010[i_2010].setBackground(Color.CYAN);
                labelArray_2010[j_2010].setBackground(Color.CYAN);
                
                if (array_2010[i_2010] <= array_2010[j_2010]) {
                    temp_2010[k_2010++] = array_2010[i_2010++];
                } else {
                    temp_2010[k_2010++] = array_2010[j_2010++];
                }
                stepArea_2010.append("Langkah " + stepCount_2010++ + ": Bandingkan dan salin elemen\n");
                return;
            } else if (i_2010 <= mid_2010) {
                labelArray_2010[i_2010].setBackground(Color.CYAN);
                temp_2010[k_2010++] = array_2010[i_2010++];
                stepArea_2010.append("Langkah " + stepCount_2010++ + ": Salin sisa kiri\n");
                return;
            } else if (j_2010 <= right_2010) {
                labelArray_2010[j_2010].setBackground(Color.CYAN);
                temp_2010[k_2010++] = array_2010[j_2010++];
                stepArea_2010.append("Langkah " + stepCount_2010++ + ": Salin sisa kanan\n");
                return;
            } else {
                copying_2010 = true;
                k_2010 = 0;
                return;
            }
        }

        if (copying_2010 && k_2010 < temp_2010.length) {
            array_2010[left_2010 + k_2010] = temp_2010[k_2010];
            labelArray_2010[left_2010 + k_2010].setText(String.valueOf(temp_2010[k_2010]));
            labelArray_2010[left_2010 + k_2010].setBackground(Color.GREEN);
            k_2010++;
            stepArea_2010.append("Langkah " + stepCount_2010++ + ": Tempelkan ke array utama\n");
            return;
        }

        if (copying_2010 && k_2010 == temp_2010.length) {
            isMerging_2010 = false;
            copying_2010 = false;
            resetHighlights_2010();
            
            if (mergeQueue_2010.isEmpty()) {
                stepArea_2010.append("Selesai.\n");
                stepButton_2010.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
            }
        }
    }

    private void resetHighlights_2010() {
        if (labelArray_2010 == null) return;
        for (JLabel label : labelArray_2010) {
            label.setBackground(Color.WHITE);
        }
    }

    private void reset_2010() {
        inputField_2010.setText("");
        panelArray_2010.removeAll();
        panelArray_2010.revalidate();
        panelArray_2010.repaint();
        stepArea_2010.setText("");
        stepButton_2010.setEnabled(false);
        
        mergeQueue_2010.clear();
        isMerging_2010 = false;
        copying_2010 = false;
        stepCount_2010 = 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGUI_2511532010 gui_2010 = new MergeSortGUI_2511532010();
            gui_2010.setVisible(true);
        });
    }
}
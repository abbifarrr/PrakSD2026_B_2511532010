package pekan7_2511532010;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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

public class InsertionSortGUI_2511532010 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_2010;
	private JLabel[] labelArray_2010;
	private JButton stepButton_2010, resetButton_2010, setButton_2010;
	private JTextField inputField_2010;
	private JPanel panelArray_2010;
	private JTextArea stepArea_2010;
	
	private int i_2010 = 1, j_2010;
	private boolean sorting_2010 = false;
	private int stepCount_2010 = 1;

	/**
	 * Create the frame.
	 */
	public InsertionSortGUI_2511532010() {
	    setTitle("Insertion Sort Langkah per Langkah"); 
	    setSize(1000, 450); // Diperbesar agar muat dengan JTextArea(60 kolom)
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    setLocationRelativeTo(null); 
	    setLayout(new BorderLayout());
	    
	    // PERBAIKAN: Menggunakan BorderLayout agar komponen input rapi dalam satu baris
	    JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
	    inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Memberi jarak margin
	    
	    inputField_2010 = new JTextField(); // Lebar kolom otomatis mengikuti area CENTER
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
	    stepArea_2010 = new JTextArea(8, 50); // Sedikit dikurangi agar seimbang
	    stepArea_2010.setEditable(false);
	    stepArea_2010.setFont(new Font("Monospaced", Font.PLAIN, 14)); 

	    JScrollPane scrollPane_2010 = new JScrollPane(stepArea_2010);
	    scrollPane_2010.setBorder(BorderFactory.createTitledBorder("Log Proses Sorting"));

	    add(inputPanel, BorderLayout.NORTH); 
	    add(panelArray_2010, BorderLayout.CENTER); 
	    add(controlPanel, BorderLayout.SOUTH); 
	    add(scrollPane_2010, BorderLayout.EAST);

	    // Event Set Array
	    setButton_2010.addActionListener(e -> setArrayFromInput_2010());

	    // Event Langkah Selanjutnya
	    stepButton_2010.addActionListener(e -> performStep_2010());

	    // Event Reset
	    resetButton_2010.addActionListener(e -> reset_2010());
	}

	private void setArrayFromInput_2010() {
	    String text_2010 = inputField_2010.getText().trim();

	    if (text_2010.isEmpty())
	        return;

	    String[] parts_2010 = text_2010.split(",");

	    array_2010 = new int[parts_2010.length];

	    try {
	        for (int k_2010 = 0; k_2010 < parts_2010.length; k_2010++) {
	            array_2010[k_2010] = Integer.parseInt(parts_2010[k_2010].trim());
	        }
	    } catch (NumberFormatException e_2010) {
	        JOptionPane.showMessageDialog(
	            this,
	            "Masukkan hanya angka yang dipisahkan dengan koma!",
	            "Error",
	            JOptionPane.ERROR_MESSAGE
	        );
	        return;
	    }

	    i_2010 = 1;
	    stepCount_2010 = 1;
	    sorting_2010 = true;

	    stepButton_2010.setEnabled(true);
	    stepArea_2010.setText("");
	    panelArray_2010.removeAll();

	    labelArray_2010 = new JLabel[array_2010.length];

	    for (int k_2010 = 0; k_2010 < array_2010.length; k_2010++) {
	        labelArray_2010[k_2010] = new JLabel(String.valueOf(array_2010[k_2010]));
	        labelArray_2010[k_2010].setFont(new Font("Arial", Font.BOLD, 24));
	        labelArray_2010[k_2010].setBorder(
	            BorderFactory.createLineBorder(Color.BLACK)
	        );
	        labelArray_2010[k_2010].setPreferredSize(
	            new Dimension(50, 50)
	        );
	        labelArray_2010[k_2010].setHorizontalAlignment(
	            SwingConstants.CENTER
	        );
	        panelArray_2010.add(labelArray_2010[k_2010]);
	    }

	    panelArray_2010.revalidate();
	    panelArray_2010.repaint();
	}

	private void performStep_2010() {
	    if (i_2010 < array_2010.length && sorting_2010) {
	        int key_2010 = array_2010[i_2010];
	        j_2010 = i_2010 - 1;

	        StringBuilder stepLog_2010 = new StringBuilder();
	        stepLog_2010.append("Langkah ")
	                    .append(stepCount_2010)
	                    .append(": Memasukkan ")
	                    .append(key_2010)
	                    .append("\n");

	        while (j_2010 >= 0 && array_2010[j_2010] > key_2010) {
	            array_2010[j_2010 + 1] = array_2010[j_2010];
	            j_2010--;
	        }

	        array_2010[j_2010 + 1] = key_2010;

	        updateLabels_2010();

	        stepLog_2010.append("Hasil: ")
	                    .append(arrayToString_2010(array_2010))
	                    .append("\n\n");

	        stepArea_2010.append(stepLog_2010.toString());

	        i_2010++;
	        stepCount_2010++;

	        if (i_2010 == array_2010.length) {
	            sorting_2010 = false;
	            stepButton_2010.setEnabled(false);
	            JOptionPane.showMessageDialog(this, "Sorting selesai!");
	        }
	    }
	}

	private void updateLabels_2010() {
	    for (int k_2010 = 0; k_2010 < array_2010.length; k_2010++) {
	        labelArray_2010[k_2010].setText(String.valueOf(array_2010[k_2010]));
	    }
	}

	private void reset_2010() {
	    inputField_2010.setText("");
	    panelArray_2010.removeAll();
	    panelArray_2010.revalidate();
	    panelArray_2010.repaint();

	    stepArea_2010.setText("");
	    stepButton_2010.setEnabled(false);

	    sorting_2010 = false;
	    i_2010 = 1;
	    stepCount_2010 = 1;
	}

	private String arrayToString_2010(int[] arr_2010) {
	    StringBuilder sb_2010 = new StringBuilder();

	    for (int k_2010 = 0; k_2010 < arr_2010.length; k_2010++) {
	        sb_2010.append(arr_2010[k_2010]);

	        if (k_2010 < arr_2010.length - 1) {
	            sb_2010.append(", ");
	        }
	    }

	    return sb_2010.toString();
	}

	public static void main(String[] args_2010) {
	    SwingUtilities.invokeLater(() -> {
	        InsertionSortGUI_2511532010 gui_2010 = new InsertionSortGUI_2511532010();
	        gui_2010.setVisible(true);
	    });
	}
}
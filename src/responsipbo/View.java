/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsipbo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class View extends JFrame{
       String Ubah;
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","NAMA BARANG","NAMA KASIR","JUMLAH BARANG","HARGA PER-SATUAN", "DISKON", "HARGA TOTAL"};
    final JTextField fID = new JTextField();
    final JTextField fNamaBarang = new JTextField();
    final JTextField fNamaKasir = new JTextField();
    final JTextField fJumlah = new JTextField();
    final JTextField fHarga = new JTextField();
    final JTextField fDiskon = new JTextField();
    
    JLabel lID= new JLabel("Masukkan ID Barang :");
    JLabel lNamaBarang = new JLabel("Nama Barang :");
    JLabel lNamaKasir = new JLabel("Nama Kasir : ");
    JLabel lJumlah = new JLabel("Jumlah Barang : ");
    JLabel lHarga = new JLabel("Harga Per-satuan : ");
    JLabel lDiskon = new JLabel("Diskon : ");
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    
    public View(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(1100,600);
        setVisible(true);
        setResizable(false);
        setTitle("MENU TRANSAKSI");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lID);
        add(fID);
        add(lNamaBarang);
        add(fNamaBarang);
        add(lNamaKasir);
        add(fNamaKasir);
        add(lJumlah);
        add(fJumlah);
        add(lHarga);
        add(fHarga);
        add(lDiskon);
        add(fDiskon);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);


        scrollPane.setBounds(20, 35, 700, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lID.setBounds(750, 35, 120, 20);
        fID.setBounds(750, 60, 170, 20);
        lNamaBarang.setBounds(750, 90, 120, 20);
        fNamaBarang.setBounds(750, 115, 170, 20);
        lNamaKasir.setBounds(750, 145, 120, 20);
        fNamaKasir.setBounds(750, 170, 170, 20);
        lJumlah.setBounds(750, 200, 120, 20);
        fJumlah.setBounds(750, 225, 170, 20);
        lHarga.setBounds(750, 255, 120, 20);
        fHarga.setBounds(750, 280, 170, 20);
        lDiskon.setBounds(750, 310, 120, 20);
        fDiskon.setBounds(750, 335, 170, 20);
        btnTambah.setBounds(750, 400, 80, 20);
        btnUpdate.setBounds(750, 430, 80, 20);
        btnDelete.setBounds(850, 400, 80, 20);
        btnClear.setBounds(850, 430, 80, 20);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
        
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                Ubah =tabel.getValueAt(baris, 0).toString();
                fID.setText(tabel.getValueAt(baris, 0).toString());
                fNamaBarang.setText(tabel.getValueAt(baris, 1).toString());
                fNamaKasir.setText( tabel.getValueAt(baris, 2).toString());
                fJumlah.setText(tabel.getValueAt(baris, 3).toString());
                fHarga.setText(tabel.getValueAt(baris, 4).toString());
                fDiskon.setText(tabel.getValueAt(baris, 5).toString());          
            }
        });       
    }
    public JTextField getFID() {
        return fID;
    }

    public JTextField getFNamaBarang() {
        return fNamaBarang;
    }

    public JTextField getFNamaKasir() {
        return fNamaKasir;
    }

    public JTextField getFJumlah() {
        return fJumlah;
    }
    
    public JTextField getFHarga() {
        return fHarga;
    }
    
    public JTextField getFDiskon() {
        return fDiskon;
    }
}

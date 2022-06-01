/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsipbo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author ASUS
 */
public class Controller {
    Model model;
    View view;
    
    public Controller(View view, Model model) {
        this.model = model;
        this.view = view;

        if(model.getBanyakData() != 0){
            String data[][] = model.readData();
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Transaksi Kosong");
        }
    
        //aksi ketika menekan tombol tambah
        view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String ID = view.getFID().getText();
                String NamaBarang = view.getFNamaBarang().getText();
                String NamaKasir = view.getFNamaKasir().getText();
                int Jumlah = Integer.parseInt(view.getFJumlah().getText());
                int Harga = Integer.parseInt(view.getFHarga().getText());
                int Diskon = Integer.parseInt(view.getFDiskon().getText());
                double Total = (Jumlah*Harga)-(Jumlah*Harga*(Diskon*0.01));
                if (ID.equals("")||NamaBarang.equals("")||NamaKasir.equals("")||Jumlah==0||Harga==0||Diskon==0) {
                    JOptionPane.showMessageDialog(view, "Isi Kolom Kosong Terlebih Dahulu !");
                }else{
                    model.tambahData(ID,NamaBarang,NamaKasir,Jumlah,Harga,Diskon,Total);
                    view.dispose();
                    MVC mvc = new MVC();
                    mvc.menu();
                }
            }
        });

        //aksi ketika menekan tombol update
        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String Ubah = view.Ubah;
                String ID = view.getFID().getText();
                String NamaBarang = view.getFNamaBarang().getText();
                String NamaKasir = view.getFNamaKasir().getText();
                int Jumlah = Integer.parseInt(view.getFJumlah().getText());
                int Harga = Integer.parseInt(view.getFHarga().getText());
                int Diskon = Integer.parseInt(view.getFDiskon().getText());
                double Total = (Jumlah*Harga)-(Jumlah*Harga*(Diskon*0.01));
                if (ID.equals("")||NamaBarang.equals("")||NamaKasir.equals("")||Jumlah==0||Harga==0||Diskon==0) {
                    JOptionPane.showMessageDialog(view, "Isi Kolom Kosong Terlebih Dahulu !");
                }else {
                    model.updateData(Ubah,ID,NamaBarang,NamaKasir,Jumlah,Harga,Diskon,Total);
                    view.dispose();
                    MVC mvc = new MVC();
                    mvc.menu();
                }
            }
        });

        //aksi ketika menekan tombol delete
        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String ID = view.getFID().getText();

                if (ID.equals("")) {
                    JOptionPane.showMessageDialog(view, "Isi ID Transaksi Yang Akan Dihapus");
                }else {
                    model.deleteData(ID);
                    view.dispose();
                    MVC mvc = new MVC();
                    mvc.menu();
                }
            }
        });

        //aksi ketika menekan tombol clear
        view.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.fID.setText("");
                view.fNamaBarang.setText("");
                view.fNamaKasir.setText("");
                view.fJumlah.setText("");
                view.fHarga.setText("");
                view.fDiskon.setText("");
            }
        });  
    }
    
}

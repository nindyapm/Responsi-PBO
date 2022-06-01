/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsipbo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class Model {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from transactions"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        return jmlData;
    }
    
    public String[][] readData(){ 
        try{
            int jmlData = 0; 
            String data[][] = new String[getBanyakData()][7];
            String query = "Select * from `transactions`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id_trans"); 
                data[jmlData][1] = resultSet.getString("nama_barang");
                data[jmlData][2] = resultSet.getString("nama_kasir"); 
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++;       
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahData(String ID, String NamaBarang, String NamaKasir, int Jumlah, int Harga, int Diskon, double Total){
        
        try{
            String query = "INSERT INTO transactions VALUES ('"+ ID +"','"+ NamaBarang +"','"+ NamaKasir +"','"+ Jumlah +"','"+ Harga +"','"+ Diskon +"','"+ Total +"')";  
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Data Transaksi Berhasil Ditambahkan!!");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Id Transaksi Sudah Ada di Database!!");
        }
    }
    
    public void updateData(String pindah, String ID, String NamaBarang, String NamaKasir, int Jumlah, int Harga, int Diskon, double Total){
            
        try {
            String query = "update transactions set id_trans=?, "
                    + "nama_barang=?, nama_kasir=?, qty=?, price_per_qty=?, discount=?, price_total=? where id_trans=?";
            PreparedStatement preparedStmt = connector.koneksi.prepareStatement(query);
            preparedStmt.setString(1, ID);
            preparedStmt.setString(2, NamaBarang);
            preparedStmt.setString(3, NamaKasir);
            preparedStmt.setInt(4, Jumlah);
            preparedStmt.setInt(5, Harga);
            preparedStmt.setInt(6, Diskon);
            preparedStmt.setDouble(7, Total);
            preparedStmt.setString(8, pindah);
            preparedStmt.execute();
            
           if(pindah.compareTo(ID)==0)
            JOptionPane.showMessageDialog(null,"Update Data Transaksi Berhasil !!");
            else
                JOptionPane.showMessageDialog(null,"Data Transaksi Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String ID){
        try{
            String query = "DELETE from transactions WHERE id_trans = '"+ ID +"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Transaksi berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

}

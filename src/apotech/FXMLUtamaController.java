/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import koneksi.koneksi;


/**
 * FXML Controller class
 *
 * @author Evolved
 */
public class FXMLUtamaController implements Initializable {
      int hagatotal1,hagatotal2,hagatotal3,hagatotal4;
      int jumlahobat;
      int harga, kembali;
      String menu="";
      int totalbayar,byr;
      String tampilTotalBayar,tampilkembalian;
      String namaobate;
      
      Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
      
      
     @FXML
      Label total;
    @FXML
    private JFXButton batuk;
     @FXML
    private JFXButton clear;
    @FXML
    private JFXButton demam;
    @FXML
    private JFXButton nyeri;
    @FXML
    private JFXButton maag;
    @FXML
    private JFXButton jumlahtotal;
    @FXML
    private JFXCheckBox cbbatuk;
    @FXML
    private JFXTextField jmlbtk;
    @FXML
    private JFXCheckBox cbdemam;
    @FXML
    private JFXTextField jmldemam;
    @FXML
    private JFXCheckBox cbnyeri;
    @FXML
    private JFXTextField jmlnyeri;
    @FXML
    private JFXCheckBox cbmaag;
    @FXML
    private JFXTextField jmlmaag;
    @FXML
    private JFXButton bayar;
    @FXML
    private JFXButton cetak;

    @FXML
    private JFXTextField bayaran;

    @FXML
    private JFXTextField kembalian;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm; 
    }    
    
    @FXML
    public void batukbtn(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"\nObat :Obat Batuk dan Pilek \nCara Pemakaian : Minum 3x Sehari");
    }

    @FXML
    public void demambtn(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"\nObat :Obat Demam \nCara Pemakaian : Minum 3x Sehari");
    }
    @FXML
    public void jumlahbtn(ActionEvent event) throws IOException {
        
        
        if(cbbatuk.isSelected()){     
            harga = 20000;
            menu += cbbatuk.getText()+", ";
            jumlahobat=Integer.parseInt(jmlbtk.getText());
            hagatotal1=harga*jumlahobat;
            System.out.println(hagatotal1);
             }
       
        if(cbdemam.isSelected()){     
            harga = 15000;
            menu += cbdemam.getText()+", ";
            jumlahobat=Integer.parseInt(jmldemam.getText());
            hagatotal2=harga*jumlahobat;
            System.out.println(hagatotal2);
            }
        if(cbnyeri.isSelected()){     
            harga = 12500;
            menu += cbnyeri.getText()+", ";
            jumlahobat=Integer.parseInt(jmlnyeri.getText());
            hagatotal3=harga*jumlahobat;
            System.out.println(hagatotal3);
                    }
        if(cbmaag.isSelected()){     
            harga = 5000;
            menu += cbmaag.getText()+", ";
            jumlahobat=Integer.parseInt(jmlmaag.getText());
            hagatotal4=harga*jumlahobat;
            System.out.println(hagatotal4);
            
            }
         totalbayar = hagatotal1+hagatotal2+hagatotal3+hagatotal4;
        tampilTotalBayar=String.valueOf(totalbayar);
        total.setText(tampilTotalBayar);
        
    }
    @FXML
    void bayarbtn(ActionEvent event) {
         byr = Integer.parseInt(bayaran.getText());
         if(byr > totalbayar){
        kembali = byr - totalbayar;
        tampilkembalian = String.valueOf(kembali);
        
        kembalian.setText(tampilkembalian);
         }else{
             JOptionPane.showMessageDialog(null,"Uangmu tidak cukup untuk membeli");
         }
    }
   @FXML
    void cetakbtn(ActionEvent event) {
        if(byr > totalbayar){
        JOptionPane.showMessageDialog(null,"Total : "+tampilTotalBayar+
                "\nBayar : "+byr+"\nKembalian : "+kembali+"\n\n\n\nTerimakasih telah\nmempercayai kami\nsebagai tempat anda\nmembeli :)");
        }else {
        
        JOptionPane.showMessageDialog(null,"Anda belum membayar!");
        
        }
    }

    @FXML
    public void lambungbtn(ActionEvent event) {
         JOptionPane.showMessageDialog(null,"\nObat :Obat Lambung / Maag \nCara Pemakaian : Minum 3x Sehari");
    }
    
     @FXML
    public void clearbtn(ActionEvent event) {
        cbbatuk.setSelected(false);
          cbdemam.setSelected(false);
          cbnyeri.setSelected(false);
          cbmaag.setSelected(false);
          jmlbtk.setText("");
          jmldemam.setText("");
          jmlnyeri.setText("");
          jmlmaag.setText("");
          bayaran.setText("");
          kembalian.setText("");
          
          byr = 0;
          kembali=0;
          totalbayar=0;
          total.setText("Rp.0");
         
    }

    @FXML
    public void nyeribtn(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"\nObat :Obat Nyeri \nCara Pemakaian : Oleskan 2x Sehari secara rutin pada bagian yang sakit");
    }

    
}

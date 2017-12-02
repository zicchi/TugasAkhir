/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotech;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 * FXML Controller class
 *
 * @author Evolved
 */
public class FXMLAdminOnlyController implements Initializable {
    
     Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
@FXML
    private JFXButton logout;
    @FXML
    private JFXButton tambah;
    @FXML
    private JFXButton clear;
    @FXML
    private JFXButton hapus;
    @FXML
    private JFXButton update;
    @FXML
    private JFXTextField nm_obat;
    @FXML
    private JFXTextField harga;
    @FXML
    private JFXTextField stok;
    @FXML
    private TableView<tableadmin> tableview;
    @FXML
    private TableColumn<tableadmin, String> id;

    @FXML
    private TableColumn<tableadmin, String> nabar;

    @FXML
    private TableColumn<tableadmin, String> hrgtbl;

    @FXML
    private TableColumn<tableadmin, String> stoktabel;
    private ObservableList<tableadmin> data;


    

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
        
        tableview.setOnMousePressed(new EventHandler<MouseEvent>(){
       
        public void handle(MouseEvent event) {
        String namabarang = tableview.getSelectionModel().getSelectedItem().getNama_barang();
        String hargatmp = tableview.getSelectionModel().getSelectedItem().getHarga();
        String stoktmp = tableview.getSelectionModel().getSelectedItem().getStok();
        
        nm_obat.setText(namabarang);
        harga.setText(hargatmp);
        stok.setText(stoktmp);
        
        }
    });  
    } 
    

    @FXML
    private void tambah(ActionEvent event) {
        try {
            String sql = "INSERT INTO obat(nama_barang,harga,stok) VALUES ('"+nm_obat.getText()+"',"+harga.getText()+","+stok.getText()+")";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Kolom Kosong");
        }
    }

    @FXML
    private void clear(ActionEvent event) {
        nm_obat.setText("");
        harga.setText("");
        stok.setText(""); 
    }

    @FXML
    private void hapus(ActionEvent event) {
         try {
            String sql = "DELETE from obat where nama_barang='"+nm_obat.getText()+"'";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     @FXML
    void logout(ActionEvent event) throws IOException {
        
// Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml8
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Apotech");
                stage.show();
            
                    }


    @FXML
    private void update(ActionEvent event) {
         try {
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            rs = stat.executeQuery("SELECT * FROM obat");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new tableadmin(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        id.setCellValueFactory(new PropertyValueFactory<>("id_barang"));
        nabar.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
        hrgtbl.setCellValueFactory(new PropertyValueFactory<>("harga"));
        stoktabel.setCellValueFactory(new PropertyValueFactory<>("stok"));
        
        tableview.setItems(null);
        tableview.setItems(data);
    }
    
}

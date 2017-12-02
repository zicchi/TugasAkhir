package apotech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 * FXML Controller class
 *
 * @author Evolved
 */



public class FXMLDocumentController implements Initializable {

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    ResultSet rs1;
    String sql1;
   
    @FXML
    private JFXButton admin;
    @FXML
    private JFXTextField user;

    @FXML
    private JFXPasswordField pass;


    
    @FXML
    private JFXButton login;
    

    @FXML
    void login(ActionEvent event) {
        try {
            sql = "SELECT * FROM kasir WHERE user='"+user.getText()+"' AND password='"+pass.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
            if(user.getText().equals(rs.getString("user")) && pass.getText().equals(rs.getString("password"))){
                JOptionPane.showMessageDialog(null, "berhasil login");
// Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml8
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLUtama.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Apotech");
                stage.show();
            
            
            
            
            
}
}else{
JOptionPane.showMessageDialog(null, "username atau password salah");
}
}
        catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
            
       
        
        }
     @FXML
    void admin(ActionEvent event) {
            try {
            sql = "SELECT * FROM admin WHERE username='"+user.getText()+"' AND password='"+pass.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
            if(user.getText().equals(rs.getString("username")) && pass.getText().equals(rs.getString("password"))){
                JOptionPane.showMessageDialog(null, "berhasil login");
// Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml8
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLAdminOnly.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Apotech");
                stage.show();
            
            
            
            
            
}
}else{
JOptionPane.showMessageDialog(null, "username atau password salah");
}
}
        catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;    
    }
    }
        
   


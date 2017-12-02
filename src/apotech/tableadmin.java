/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotech;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Evolved
 */
public class tableadmin {
    
    private final StringProperty nama_barang;
    private final StringProperty id_barang;
    private final StringProperty harga;
    private final StringProperty stok;

    //Default constructor
    public tableadmin(String id_barang, String nama_barang, String harga, String stok) {
        this.nama_barang = new SimpleStringProperty(nama_barang);
        this.id_barang = new SimpleStringProperty(id_barang);
        this.harga = new SimpleStringProperty(harga);
        this.stok = new SimpleStringProperty(stok);
    }

    //Getters
    public String getId_barang() {
        return id_barang.get();
    }

    public String getNama_barang() {
        return nama_barang.get();
    }

    public String getHarga() {
        return harga.get();
    }
    public String getStok() {
        return stok.get();
    }

    //Setters
    public void setId_barang(String value) {
        id_barang.set(value);
    }

    public void setNama_barang(String value) {
        nama_barang.set(value);
    }

    public void setHarga(String value) {
        harga.set(value);
    }
    public void setStok(String value) {
        stok.set(value);
    }

    //Property values
    public StringProperty id_barangProperty() {
        return id_barang;
    }

    public StringProperty nama_barangProperty() {
        return nama_barang;
    }

    public StringProperty hargaProperty() {
        return harga;
    }
    public StringProperty stokProperty() {
        return stok;
    }
    
}

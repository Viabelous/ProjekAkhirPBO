package ProjekAkhir;

import java.util.ArrayList;

/**
 *
 * @author Viabel
 */
public class Toko {
    int ID;
    String Nama;
    int IDPenjual;
    ArrayList<Produk> DaftarProduk = new ArrayList<>();
    
    Toko(int ID, String NamaToko, int IDPenjual){
        this.ID = ID;
        this.Nama = NamaToko;
        this.IDPenjual = IDPenjual;
    }
    
    public void TampilDeskripsi(){
        System.out.println("ID Toko   : " + this.ID);
        System.out.println("Nama Toko : " + this.Nama);
        System.out.println("ID Penjual: " + this.IDPenjual);
    }
    
    public void TambahProduk(Produk Item){
        this.DaftarProduk.add(Item);
    }
    
    public void TampilProduk(){
        System.out.println("Produk Dijual:");
        for (Produk Dagangan : DaftarProduk) {
            System.out.println("- " + Dagangan.ID + " // " + Dagangan.Nama);
        }
    }
    
}

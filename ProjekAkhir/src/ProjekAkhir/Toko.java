package ProjekAkhir;

import java.util.ArrayList;
import java.util.HashMap;

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
    
    public static void TampilSemuaToko(){
        int i  = 1;
        HashMap<Integer, Integer> MenuPick = new HashMap<Integer, Integer>(); 
        
        for (Toko namaToko : Main.DaftarToko){
            MenuPick.put(i, namaToko.ID);
            System.out.println("(" + i + ") " + namaToko.Nama);
        }
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
        int i  = 1;
        HashMap<Integer, Integer> MenuPick = new HashMap<Integer, Integer>(); 
        
        System.out.println("Produk Dijual:");
        for (Produk Dagangan : DaftarProduk) {
            
            MenuPick.put(i, Dagangan.ID);
            System.out.println("(" + i + ") " + Dagangan.Nama);
        }
    }
    
    static public void ManajemenToko(){
        
    }
    
}

package ProjekAkhir;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Viabel
 */
public class Toko {
    int ID;
    String Nama;
    ArrayList<Integer> IDSeller = new ArrayList<>();
    ArrayList<Produk> DaftarProduk = new ArrayList<>();
    
    Toko(int ID, String NamaToko){
        this.ID = ID;
        this.Nama = NamaToko;
    }
    
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
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
        //System.out.println("ID Penjual: " + this.IDPenjual);
        // Tampilkan semua penjual (lengkap dengan nama ygy)
    }
    
    //2 Void di bawah ini akan diubah nti
    public void TambahProduk(Produk Item){
        this.DaftarProduk.add(Item);
    }
    
    public void TambahSeller(int IDPenjual){
        this.IDSeller.add(IDPenjual);
    }
    
    public void TampilProduk(){
        HashMap<Integer, Integer> MenuPick = new HashMap<Integer, Integer>(); 
        while(true){
            int i  = 1;
            MenuPick.clear();

            if(Main.Menu.equals("Seller") || Main.Menu.equals("Admin"))
                System.out.println("\n[99] Manajemen Toko");
            System.out.println("[0] Kembali");

            System.out.println("\nProduk Dijual:");
            for (Produk Dagangan : DaftarProduk) {

                MenuPick.put(i, Dagangan.getID());
                System.out.println("\t(" + i + ") " + Dagangan.getNama());

                i++;
            }

            int Opsi = Main.CheckInt();
            if(Opsi == 0) return;
            if(Opsi != -1){
                switch(Main.Menu){
                    case "Customer" -> {

                    }
                    case "Seller", "Admin" -> {
                        // Opsi 99 untuk Manajemen Toko
                        if(Opsi == 99){
                            ManajemenToko();
                        }
                    }

                }
            }
        }
        
    }
    
    public void ManajemenToko(){
        this.TampilDeskripsi();
    }
    
}

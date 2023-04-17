package ProjekAkhir;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;


/**
 *
 * @author Viabel
 */
public class Toko {
    int ID;
    String Nama;
    String Kota;
    
    ArrayList<Integer> IDSeller = new ArrayList<>();
    ArrayList<Produk> DaftarProduk = new ArrayList<>();
    
    Toko(int ID, String NamaToko){
        this.ID = ID;
        this.Nama = NamaToko;
    }
    
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    
    
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
    
    
    void TambahProduk(Produk Item){
        if(Item == null) return;
        this.DaftarProduk.add(Item);
        Main.capIDProduk += 1;
        DaftarProduk.add(Item);
    }
    
    //Void di bawah ini akan diubah nti
    public void TambahSeller(int IDPenjual){
        IDSeller.add(IDPenjual);
    }
    
    public void TampilProduk() throws IOException{
        HashMap<Integer, Integer> MenuPick = new HashMap<Integer, Integer>(); 
        while(true){
            int i  = 1;
            MenuPick.clear();

            if(Main.Menu.equals("Seller") || Main.Menu.equals("Admin"))
                System.out.println("\n[99] Manajemen Toko");
            System.out.println("[0] Kembali");

            System.out.println("\nProduk Dijual:");
            for (Produk Dagangan : DaftarProduk) {

                MenuPick.put(i, Dagangan.ID);
                System.out.println("\t(" + i + ") " + Dagangan.NamaProduk);

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
    
    public void ManajemenToko() throws IOException{
        this.TampilDeskripsi();
        this.MenuTambahProduk();
        
    }
    
    
    void MenuTambahProduk() throws IOException{
        System.out.println("""
		| ------------------------------------------ |
		|   //     Create Produk Toko          \\\\  |	
		|  ||                                     || |
                            Menu Manajemen Produk
                            (1) Album
                            (2) Lightstick 
                            (3) Poster 
                            (4) Postcard
                            (5) Photocard
                            (6) Keyring
                            (7) Lanyard
		|  ||                                     || |
		|   \\\\                                   //  |
		| ------------------------------------------ |
                            """);

        System.out.print(" :>> ");
        int pilihan = Integer.parseInt(br.readLine());

        switch (pilihan) {
            case 1 -> {
                Album AlbumBaru = null;
                this.TambahProduk(AlbumBaru.TambahProduk());
            }
            
            case 2 -> {
                LightStick LightStickBaru = null;
                this.TambahProduk(LightStickBaru.TambahProduk());
            }
            
            case 3 -> {
                Poster PosterBaru = null;
                this.TambahProduk(PosterBaru.TambahProduk());
            }
            
            case 4 -> {
                Postcard PostcardBaru = null;
                this.TambahProduk(PostcardBaru.TambahProduk());
            }
            
            case 5 -> {
                Photocard PhotocardBaru = null;
                this.TambahProduk(PhotocardBaru.TambahProduk());
            }
            
            case 6 -> {
                Keyring KeyringkBaru = null;
                this.TambahProduk(KeyringkBaru.TambahProduk());
            }
            
            case 7 -> {
                Lanyard LanyardBaru = null;
                this.TambahProduk(LanyardBaru.TambahProduk());
            }
            
        }
    }
    
    
    public void TambahToko() throws IOException {
        String NamaToko, KotaToko;
        
        System.out.println(" Masukkan nama toko     :");
        NamaToko = br.readLine();
        System.out.println(" Masukkan kota toko     :");
        KotaToko = br.readLine();
        
        this.ID = Main.capIDToko;
        this.Nama = NamaToko;
        this.Kota = KotaToko;
    }
     
    
    public void UbahToko() throws IOException {
        
    }
    
    
    public void HapusToko() throws IOException {
        
    }
}

    

    
    






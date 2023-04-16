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
    ArrayList<Integer> IDSeller = new ArrayList<>();
    ArrayList<Produk> DaftarProduk = new ArrayList<>();
    
    Toko(int ID, String NamaToko){
        this.ID = ID;
        this.Nama = NamaToko;
    }
    
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static ArrayList<Album> Album = new ArrayList<> ();
    static ArrayList<LightStick> LightStick = new ArrayList<> ();
    static ArrayList<Poster> Poster = new ArrayList<> ();
    static ArrayList<Postcard> Postcard = new ArrayList<> ();
    static ArrayList<Photocard> Photocard = new ArrayList<> ();
    static ArrayList<Keyring> Keyring = new ArrayList<> ();
    static ArrayList<Lanyard> Lanyard = new ArrayList<> ();


    
    
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
    static protected void TambahProduk(Toko NamaToko, Produk Item){
        if(Item == null) return;
        NamaToko.DaftarProduk.add(Item);
    }
    
    public void TambahSeller(int IDPenjual){
        IDSeller.add(IDPenjual);
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
    
    public void ManajemenToko() throws IOException{
        this.TampilDeskripsi();
        // Menu tambah produk nti dsni
        
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
                TambahProduk(this, AlbumBaru.TambahProduk());
            }
            
            case 2 -> {
                System.out.println("Masukan Id LightStick : ");
                int ID =  Integer.parseInt(br.readLine());
                System.out.println("Masukkan Nama Produk : ");
                String Nama = br.readLine();
                System.out.println("Masukkan Nama Grup : ");
                String Grup = br.readLine();
                System.out.println("Berisikan Baterai (Y/N)?");
                boolean DilengkapiBaterai = ((br.readLine().equals("Y")));
                System.out.println("Masukkan Versi LightStick: ");
                String VersiLightstick = br.readLine();
                System.out.println("Masukkan Harga Lightstick :Rp. ");
                int Harga =  Integer.parseInt(br.readLine());           
                
     
                LightStick.add(new LightStick(ID, Nama, Grup, DilengkapiBaterai, VersiLightstick, Harga));  
                
           
                break;
            }
            case 3 -> {
                System.out.println("Masukan Id Poster : ");
                int ID =  Integer.parseInt(br.readLine());
                System.out.println("Masukkan Nama Produk : ");
                String NamaProduk = br.readLine();
                System.out.println("Masukkan Nama Grup : ");
                String Grup = br.readLine();
                System.out.println("Masukkan Versi Poster: ");
                String VersiPoster = br.readLine();
                System.out.println("Masukkan Harga Poster :Rp. ");
                int Harga =  Integer.parseInt(br.readLine());           
                
     
                Poster.add(new Poster(ID, NamaProduk, Grup, VersiPoster, Harga));  
                
           
                break;
            }
            case 4 -> {
                System.out.println("Masukan Id Postcard : ");
                int ID =  Integer.parseInt(br.readLine());
                System.out.println("Masukkan Nama Produk : ");
                String NamaProduk = br.readLine();
                System.out.println("Masukkan Nama Grup : ");
                String Grup = br.readLine();
                System.out.println("Masukkan Size Postcard : ");
                String Size = br.readLine();
                System.out.println("Masukkan Versi Postcard: ");
                String VersiPostcard = br.readLine();
                System.out.println("Masukkan Versi Member: ");
                String VersiMember = br.readLine();
                System.out.println("Masukkan Harga Poster :Rp. ");
                int Harga =  Integer.parseInt(br.readLine());           
                
                Postcard ptd = new Postcard(ID, NamaProduk, Grup, Size, VersiPostcard, VersiMember, Harga);
     
                Postcard.add(ptd);  
                
           
                break;
            }
            case 5 -> {
                System.out.println("Masukan Id Photocard : ");
                int ID =  Integer.parseInt(br.readLine());
                System.out.println("Masukkan Nama Produk : ");
                String NamaProduk = br.readLine();
                System.out.println("Masukkan Nama Grup : ");
                String Grup = br.readLine();
                System.out.println("Masukkan Size Photocard : ");
                String Size = br.readLine();
                System.out.println("Masukkan Versi Photocard: ");
                String VersiPhotocard = br.readLine();
                System.out.println("Masukkan Versi Member: ");
                String VersiMember = br.readLine();
                System.out.println("Masukkan Harga Photocard :Rp. ");
                int Harga =  Integer.parseInt(br.readLine());           
                
     
                Photocard.add( new Photocard(ID, NamaProduk, Grup, Size, VersiPhotocard, VersiMember, Harga));  
                
           
                break;
            }
            case 6 -> {
                System.out.println("Masukan Id Keyring : ");
                int ID =  Integer.parseInt(br.readLine());
                System.out.println("Masukkan Nama Produk : ");
                String Nama = br.readLine();
                System.out.println("Masukkan Nama Grup : ");
                String Grup = br.readLine();
                System.out.println("Masukkan Size Keyring : ");
                String Size = br.readLine();
                System.out.println("Masukkan Versi Member: ");
                String VersiMember = br.readLine();
                System.out.println("Masukkan Harga Keyring :Rp. ");
                int Harga =  Integer.parseInt(br.readLine());                        
     
                Keyring.add(new Keyring(ID, Nama, Grup, Size, VersiMember, Harga));  
                
           
                break;
            }
            case 7 -> {
                System.out.println("Masukan Id Lanyard : ");
                int ID =  Integer.parseInt(br.readLine());
                System.out.println("Masukkan Nama Produk : ");
                String Nama = br.readLine();
                System.out.println("Masukkan Nama Grup : ");
                String Grup = br.readLine();
                System.out.println("Masukkan Bahan Lanyard : ");
                String Bahan = br.readLine();
                System.out.println("Masukkan Harga Keyring :Rp. ");
                int Harga =  Integer.parseInt(br.readLine());           
                
                Lanyard lyr = new Lanyard(ID, Nama, Grup, Bahan, Harga);
     
                Lanyard.add(lyr);  
                
           
                break;
            }
        }
    }
}

    
    
    
    






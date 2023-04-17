package ProjekAkhir;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    
    Toko(int ID, String NamaToko, String LetakKota){
        this.ID = ID;
        this.Nama = NamaToko;
        this.Kota = LetakKota;
    }
    
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    
    
    public static void TampilSemuaToko(){
        int i  = 1;
        
        for (Toko namaToko : Main.DaftarToko){
            System.out.println("(" + i + ") " + namaToko.Nama);
            i++;
        }
    }
    
    public void TampilDeskripsi(){
        System.out.println("ID Toko    : " + this.ID);
        System.out.println("Nama Toko  : " + this.Nama);
        System.out.println("Letak Toko : " + this.Kota);
        System.out.println("Penjual: ");
        for (int Seller : IDSeller){
            int index = Main.IDSequential(Seller) ;
            System.out.print(" -. ");
            System.out.print(" [" + Seller + "] ");
            Main.DaftarAkun.get(index).getNama();
            System.out.println("");
            
        }
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
        while(true){
            int i  = 1;

            if(Main.Menu.equals("Seller") || Main.Menu.equals("Admin"))
                System.out.println("\n[99] Manajemen Toko");
            System.out.println("[0] Kembali");

            System.out.println("\nProduk Dijual:");
            for (Produk Dagangan : DaftarProduk) {
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
                        if(Opsi == 99) ManajemenToko();
                        ManajemenProduk(this.DaftarProduk.get(Opsi+1));
                    }

                }
            }
        }
        
    }
    
    public void ManajemenProduk(Produk Prod) throws IOException{
        while(true){
            Prod.TampilProduk();
            System.out.println(" [1] Ubah Produk");
            System.out.println(" [2] Hapus Produk");
            System.out.println(" [3] Kembali");
            int Jawab = Main.CheckInt();
            switch(Jawab){
                case 1 -> Prod.UbahProduk();
                case 2 -> HapusProduk(Prod);
            }
        }
    }
    
    // Akan dikembangkan Nanti
    public void HapusProduk(Produk Prod) throws IOException{
        System.out.println(" Yakin Hapus Produk (Y/N)? ");
        System.out.print(" :>> ");
        String Jawab = br.readLine();
        if(!Jawab.equals("Y")) return;
        Prod = null;
        this.DaftarProduk.remove(Prod);
        System.out.println(" Produk berhasil dihapus.");
        
    }
    
    
    public void ManajemenToko() throws IOException{
        this.TampilDeskripsi();
        // Tambahkan menu di bawah ini
        System.out.println(" Menu");
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
                Keyring KeyringBaru = null;
                this.TambahProduk(KeyringBaru.TambahProduk());
            }
            
            case 7 -> {
                Lanyard LanyardBaru = null;
                this.TambahProduk(LanyardBaru.TambahProduk());
            }
            
        }
    }
    
    
    // Error handling dungz
    static public Toko TambahToko() throws IOException {
        String NamaToko, KotaToko;
        
        System.out.println(" Masukkan nama toko     :");
        NamaToko = br.readLine();
        System.out.println(" Masukkan kota toko     :");
        KotaToko = br.readLine();
        Main.capIDToko++;
        
        return new Toko(Main.capIDToko-1, NamaToko, KotaToko);
    }
     
    
    public void UbahToko() throws IOException {
        
    }
    
    
    public void HapusToko() throws IOException {
        
    }
}

    

    
    






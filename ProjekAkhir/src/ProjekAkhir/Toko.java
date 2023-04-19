package ProjekAkhir;

import static ProjekAkhir.Main.CheckInt;
import static ProjekAkhir.Main.Opsi;
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
    
    
    // Procedure untuk menampilkan semua toko yang ada
    public static void TampilSemuaToko(){
        int i  = 1;
        
        for (Toko namaToko : Main.DaftarToko){
            System.out.println("(" + i + ") " + namaToko.Nama);
            i++;
        }
    }
    
    
    // Procedure untuk menampilkan deskripsi toko    
    public void TampilDeskripsi(){
        System.out.println("ID Toko    : " + this.ID);
        System.out.println("Nama Toko  : " + this.Nama);
        System.out.println("Letak Toko : " + this.Kota);
        System.out.println("Penjual: ");
        for (int Seller : IDSeller){
            int index = Main.AkunSequential(Seller) ;
            System.out.print(" -. ");
            System.out.print(" [" + Seller + "] ");
            Main.DaftarAkun.get(index).getNama();
            System.out.println("");
            
        }
    }
    
    
    // Procedure untuk tambah produk ke Daftar Produk Toko
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
    
    // Procedure untuk menampilkan semua produk di toko,
    // Respon setelah admin atau customer pilih toko, dan/atau seller pilih Tokoku
    public void TampilProduk() throws IOException, InterruptedException{
        while(true){
            Main.Clear();
            int i  = 1;

            if(Main.Menu.equals("Seller") || Main.Menu.equals("Admin"))
                System.out.println("\n[99] Manajemen Toko");
            System.out.println("[0] Kembali");

            System.out.println("\nProduk Dijual:");
            for (Produk Dagangan : DaftarProduk) {
                System.out.println("\t(" + i + ") " + Dagangan.Nama + " ---- " + Dagangan.Harga);

                i++;
            }

            System.out.println("\n");
            int Opsi = Main.CheckInt();
            if(Opsi == 0) return;
            if(Opsi != -1){
                
                switch(Main.Menu){
                    case "Customer" -> {
                        // Buy
                    }
                    case "Seller", "Admin" -> {
                        // Opsi 99 untuk Manajemen Toko
                        if(Opsi == 99) this.MenuManajemenToko();
                        ManajemenProduk(this.DaftarProduk.get(Opsi+1));
                    }
                }
                
            }
        }
        
    }
    
    // Procedure untuk mengubah info produk,
    // Respon setelah Admin atau Seller memilih produk
    public void ManajemenProduk(Produk Prod) throws IOException, InterruptedException{
        while(true){
            Main.Clear();
            Prod.TampilProduk();
            System.out.println(" [1] Ubah Produk");
            System.out.println(" [2] Hapus Produk");
            System.out.println(" [99] Kembali");
            int Jawab = Main.CheckInt();
            switch(Jawab){
                case 1 -> Prod.UbahProduk();
                case 2 -> HapusProduk(Prod);
                case 99 -> {return;}
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
    
    
    // Procedure untuk Admin dan Customer memilih toko-toko yang ada
    public static void MenuPilihToko() throws IOException, InterruptedException{
        while(true){
            Main.Clear();
            if(Main.Menu.equals("Admin")) System.out.println(" [0] Tambah Toko");
            System.out.println(" [99] Kembali");
            System.out.println("------------------------");
            Toko.TampilSemuaToko();
            System.out.println("\n Pilih Toko");
            System.out.print(" :>> ");
            int index = CheckInt();
            switch (index) {
                case -1 -> {continue;}
                case 0 -> {
                    if(Main.Menu.equals("Customer")) continue;
                    Toko.TambahToko();
                }
                case 99 -> {return;}
            }
            Main.DaftarToko.get(index-1).TampilProduk();
        }
    }
    
    
    // Procedure untuk memanajemen toko SPESIFIK
    public void MenuManajemenToko() throws IOException, InterruptedException {
        Main.Clear();
        
        //Sout dibedakan untuk admin dan untuk seller
        System.out.println("""
            | ---------------------------------------- |
            |  //       Menu Manajemen Toko        \\\\  |
            | ||\t""" + this.Nama + "\t\t\t|| |\n" + """
            | ||                                    || |
            | ||     (1)-. Ubah Informasi Toko      || |
            | ||     (2)-. Manajemen Seller Toko    || |
            | ||     (3)-. Tambah Produk            || |
            | ||     (4)-. Lihat Pesanan            || |
            | ||     (5)-. Hapus Toko               || |
            | ||     (99)-. Kembali                 || |
            |  \\\\                                  //  |
            | ---------------------------------------- |
                            """);

        System.out.print(" :>> ");
        Opsi = CheckInt();

        switch (Opsi){
            case 1:
                //this.TampilDeskripsi();
                this.UbahToko();
                break;
            case 2:
                // Toko.ManajeSeller();
                break;
            case 3:
                this.MenuTambahProduk();
                break;
            case 4:
                // lihatPesanan();
                break;
            case 5:
                this.HapusToko();
                break;
            case 99:
                break;
            default:
                break;

        }
    }
   

    
    // Procedure untuk menambah produk pada toko
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
    
    
    // Procedure untuk menambah toko di daftar toko
    static public Toko TambahToko() throws IOException {
        String NamaToko, KotaToko;
        
        System.out.print(" Masukkan nama toko     :");
        NamaToko = br.readLine();
        if (NamaToko.equals("")) throw new IllegalArgumentException();
        
        System.out.print(" Masukkan kota toko     :");
        KotaToko = br.readLine();
        if (NamaToko.equals("")) throw new IllegalArgumentException();
        
        Main.capIDToko++;
        
        return new Toko(Main.capIDToko-1, NamaToko, KotaToko);
    }
     
    
    // Procedure untuk mengubah informasi toko
    public void UbahToko() throws IOException {
        String NewNamaToko, NewKotaToko;
        
        System.out.print(" Masukkan nama toko     :");
        NewNamaToko = br.readLine();
        if (NewNamaToko.equals("")) throw new IllegalArgumentException();
            
        System.out.print(" Masukkan kota toko     :");
        NewKotaToko = br.readLine();
        if (NewKotaToko.equals("")) throw new IllegalArgumentException();
        
        this.Nama = NewNamaToko;
        this.Kota = NewKotaToko;
    }
    
    
    // Rawan error
    public void HapusToko() throws IOException {
        System.out.println("Yakin hapus toko (Y/N)?");
        System.out.println("(Menghapus toko ini akan sekaligus menghapus Seller)");
        System.out.print(":>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        
        boolean validation = Conf.equals("Y");

        //if (validation)Main.DaftarToko.remove(index-1);
    }
}











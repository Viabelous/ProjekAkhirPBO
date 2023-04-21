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
            int i = 1;

            System.out.println("[99] Kembali");
            if(Main.Menu.equals("Seller") || Main.Menu.equals("Admin"))
                System.out.println("[0] Manajemen Toko");

            System.out.println("\nProduk Dijual:");
            for (Produk Dagangan : DaftarProduk) {
                System.out.println("\t(" + i + ") " + Dagangan.Nama + " ---- " + Dagangan.Harga);

                i++;
            }

            System.out.println("\n");
            int Opsi = Main.CheckInt();
            if(Opsi == 99) return;
            if(Opsi != -1){
                try{
                    switch(Main.Menu){
                        case "Customer" -> {
                            // Buy
                        }
                        case "Seller", "Admin" -> {
                            // Opsi 0 untuk Manajemen Toko
                            if(Opsi == 0) this.MenuManajemenToko();
                            else ManajemenProduk(this.DaftarProduk.get(Opsi-1));
                        }
                    }
                } catch(IndexOutOfBoundsException e){
                    System.out.println(" Produk tersebut tidak ada");
                    br.readLine();
                }
                
            }
        }
        
    }
    
    // Procedure untuk mengubah info produk,
    // Respon setelah Admin atau Seller memilih produk
    public void ManajemenProduk(Produk Prod) throws IOException, InterruptedException{
        boolean del = false;
        
        while(del == false){
            Main.Clear();
            Prod.TampilProduk();
            System.out.println(" [1] Ubah Produk");
            System.out.println(" [2] Hapus Produk");
            System.out.println(" [99] Kembali");
            int Jawab = Main.CheckInt();
            switch(Jawab){
                case 1 -> Prod.UbahProduk();
                case 2 -> del = HapusProduk(Prod);
                case 99 -> {return;}
            }
        }
    }
    
    
    // Akan dikembangkan Nanti
    public boolean HapusProduk(Produk Prod) throws IOException{
        System.out.println(" Yakin Hapus Produk (Y/N)? ");
        System.out.print(" :>> ");
        String Jawab = br.readLine();
        if(!Jawab.equals("Y")) return false;
        this.DaftarProduk.remove(Prod);
        Prod = null;
        System.out.println(" Produk berhasil dihapus.");
        return true;
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
        if (Main.Menu.equals("Admin")){
            System.out.println("""
            | ---------------------------------------- |
            |  //       Menu Manajemen Toko        \\\\  |
            | ||\t""" + this.Nama + "\t\t\t|| |\n" + """
            | ||                                    || |
            | ||     (99)-. Kembali                 || |
            | ||     (1)-. Ubah Informasi Toko      || |
            | ||     (2)-. Manajemen Seller Toko    || |
            | ||     (3)-. Tambah Produk            || |
            | ||     (4)-. Lihat Pesanan            || |
            | ||     (5)-. Hapus Toko               || |
            |  \\\\                                  //  |
            | ---------------------------------------- |
                            """);

            System.out.print(" :>> ");
            Opsi = CheckInt();

            switch (Opsi) {
                case 1 -> {
                    Main.Clear();
                    this.TampilDeskripsi();
                    this.UbahToko();
                }
                case 2 -> {
//             Toko.ManajeSeller();
                }
                case 3 -> {
                    Main.Clear();
                    this.MenuTambahProduk();
                }
                case 4 -> {
            // lihatPesanan();
                }
                case 5 -> this.HapusToko();
                case 99 -> {return;}
            }
        }

        if (Main.Menu.equals("Seller")){ System.out.println("""
            | ---------------------------------------- |
            |  //       Menu Manajemen Toko        \\\\  |
            | ||                                    || |
            | ||     (99)-. Kembali                 || |
            | ||     (1)-. Ubah Informasi Toko      || |
            | ||     (2)-. Tambah Produk            || |
            | ||     (3)-. Lihat Pesanan            || |
            |  \\\\                                  //  |
            | ---------------------------------------- |
                            """);
        
            System.out.print(" :>> ");
            Opsi = CheckInt();

            switch (Opsi){
                case 1 -> {
                    this.TampilDeskripsi();
                    this.UbahToko();
                }
                case 2 -> this.MenuTambahProduk();
                case 3 -> {// lihatPesanan();
                }
                case 99 -> {return;}
            }
        }
    }
   

    
    // Procedure untuk menambah produk pada toko
    void MenuTambahProduk() throws IOException{
        System.out.println("""
		| ------------------------------------------ |
		|   //     Create Produk Toko          \\\\  |	
		|  ||                                     || |
                            Pilih Produk
                            (99) Kembali
                            (1) Album
                            (2) Lightstick 
                            (3) Poster 
                            (4) Postcard
                            (5) Photocard
                            (6) Keyring
                            (7) Lanyard
                            (8) Kimchi
                            (9) Tteokbokki
                            (10) Ramen
		|  ||                                     || |
		|   \\\\                                   //  |
		| ------------------------------------------ |
                            """);

        System.out.print(" :>> ");
        Opsi = CheckInt();

        switch (Opsi) {
            case 1 -> this.TambahProduk((new Album()).TambahProduk());
            case 2 -> this.TambahProduk((new LightStick()).TambahProduk());
            case 3 -> this.TambahProduk((new Poster()).TambahProduk());
            case 4 -> this.TambahProduk((new Postcard()).TambahProduk());
            case 5 -> this.TambahProduk((new Photocard()).TambahProduk());
            case 6 -> this.TambahProduk((new Keyring()).TambahProduk());
            case 7 -> this.TambahProduk((new Lanyard()).TambahProduk());
            case 8 -> this.TambahProduk((new Kimchi()).TambahProduk());
            case 9 -> this.TambahProduk((new Tteokbokki()).TambahProduk());
            case 10 -> this.TambahProduk((new Ramen()).TambahProduk());
            case 99 -> {return;}
        }
    }
        
    // Procedure untuk menambah toko di daftar toko
    static public Toko TambahToko() throws IOException, InterruptedException {
        String NamaToko, KotaToko;
        
        System.out.println("---------------------------------------\n");
        System.out.print(" Masukkan nama toko   : ");
        NamaToko = br.readLine();
        if (NamaToko.equals("")) throw new IllegalArgumentException();
        
        System.out.print(" Masukkan kota toko   : ");
        KotaToko = br.readLine();
        if (NamaToko.equals("")) throw new IllegalArgumentException();
        
        Main.Clear();
        System.out.println("""
                   | ---------------------------------------- |
                   |  //                                  \\\\  |
                   | ||                                    || |
                            Nama Toko    : """ + NamaToko + "\n" +
                   """
                   \t Lokasi Toko""" + "  : " + KotaToko + "\n" +
                   """
                    | ||                                    || |
                    |  \\\\                                  //  |
                    | ---------------------------------------- |
                           """);
        br.readLine();
        
        Main.capIDToko++;
        
        return new Toko(Main.capIDToko-1, NamaToko, KotaToko);
    }
     
    
    // Procedure untuk mengubah informasi toko
    public void UbahToko() throws IOException, InterruptedException {
        String NewNamaToko, NewKotaToko;
        
        System.out.println("---------------------------------------\n");
        System.out.print(" Masukkan nama toko     : ");
        NewNamaToko = br.readLine();
        if (NewNamaToko.equals("")) throw new IllegalArgumentException();
            
        System.out.print(" Masukkan kota toko     : ");
        NewKotaToko = br.readLine();
        if (NewKotaToko.equals("")) throw new IllegalArgumentException();
        
        this.Nama = NewNamaToko;
        this.Kota = NewKotaToko;
        
        Main.Clear();
        System.out.println("""
                   | ---------------------------------------- |
                   |  //                                  \\\\  |
                   | ||                                    || |
                            Nama Toko    : """ + NewNamaToko + "\n" +
                   """
                   \t Lokasi Toko""" + "  : " + NewKotaToko + "\n" +
                   """
                    | ||                                    || |
                    |  \\\\                                  //  |
                    | ---------------------------------------- |
                           """);
        br.readLine();
        
    }
    
    
    // Rawan error
    public boolean HapusToko() throws IOException {
        System.out.println(" Yakin hapus toko (Y/N)?");
        System.out.println(" (Menghapus toko ini akan sekaligus melepas kaitan Seller)");
        System.out.print(" :>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        else{
            if(Conf.equals("Y")){
                // Lepas Kaitan Seller
            }
        }
        
        return Conf.equals("Y");
        
        
    }
}











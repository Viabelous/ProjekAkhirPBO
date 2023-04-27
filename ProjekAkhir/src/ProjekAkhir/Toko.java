package ProjekAkhir;

import static ProjekAkhir.Main.CheckInt;
import static ProjekAkhir.Main.Opsi;
import static ProjekAkhir.Main.br;
import java.util.ArrayList;
import java.io.IOException;
import java.util.HashMap;


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
            System.out.print(" [" + Seller + "] " + Main.DaftarAkun.get(index).getNama());
            System.out.println("");
            
        }
    }
    
    
    // Procedure untuk tambah produk ke Daftar Produk Toko
    void TambahProduk(Produk Item){
        if(Item == null) return;
        this.DaftarProduk.add(Item);
        Main.capIDProduk += 1;
    }
    
    //Prosedur untuk menampilkan semua seller toko
    public HashMap TampilSeller(){
        HashMap<Integer, Seller> SellerMap = new HashMap<>();
        int i = 1;
        
        // Tampilkan user Yang ada di Toko
        for (int AkunSeller : this.IDSeller){
            
            Seller ThisSeller = ((Seller)Main.DaftarAkun
                    .get(Main.AkunSequential(AkunSeller)));
            
            System.out.println("<" + i + "> " + ThisSeller.Nama);
            
            SellerMap.put(i, ThisSeller);
            
            i++;
        
        }
            
        return SellerMap;
    }
    
    
    //Prosedur untuk menghubungkan akun seller ke toko
    public void TambahSeller(int IDPenjual){
        IDSeller.add(IDPenjual);
        ((Seller)Main.DaftarAkun
                .get(Main.AkunSequential(IDPenjual)))
                .setTokoKu(this.ID);
        
    }
    
    
    public void HapusSeller(int Index) throws IOException{
        System.out.println(" Yakin hapus seller dari toko (Y/N)?");
        System.out.print(" :>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        
        if (Conf.toUpperCase().equals("Y")){
            ((Seller)Main.DaftarAkun
                    .get(Main.AkunSequential(IDSeller.get(Index-1))))
                    .setTokoKu(-1);
            IDSeller.remove(Index-1);
        }
    }
    
    
    // Procedure untuk menampilkan semua produk di toko,
    // Respon setelah admin atau customer pilih toko, dan/atau seller pilih Tokoku
    public void TampilProduk() throws IOException, InterruptedException{
        
        HashMap<Integer, Integer> ProdMap = new HashMap<>();
        
        while(true){
            
            ProdMap.clear();
            
            Main.Clear();
            int i = 1;
            int j = 0;

            System.out.println("[99] Kembali");
            if(Main.Menu.equals("Seller") || Main.Menu.equals("Admin"))
                System.out.println("[0] Manajemen Toko");

            System.out.println("\nProduk Dijual:");
            for (Produk Dagangan : DaftarProduk) {
                j++;
                if(Main.Menu.equals("Customer") && Dagangan.Stok <= 0) continue; 
                System.out.println("\t(" + i + ") " + Dagangan.Nama + " ---- " + Dagangan.Harga);
                ProdMap.put(i, j-1);

                i++;
            }
            if(DaftarProduk.isEmpty()){
                System.out.println(" -- Kosong -- ");
            }

            System.out.println("\n");
            int Opsi = Main.CheckInt();
            if(Opsi == 99) return;
            if(Opsi != -1){
                try{
                    if(ProdMap.get(Opsi) == null){
                        if(Main.Menu.equals("Customer"))
                            throw new IndexOutOfBoundsException();
                        else if(Opsi != 0)
                            throw new IndexOutOfBoundsException();
                    }        
                    switch(Main.Menu){
                        case "Customer" -> {
                            BeliProduk(this.DaftarProduk.get(ProdMap.get(Opsi)));
                            if(Main.PortToBag == true) return;
                        }
                        case "Seller", "Admin" -> {
                            // Opsi 0 untuk Manajemen Toko
                            if(Opsi == 0) {
                                if(!this.MenuManajemenToko()) return;
                            }
                            else ManajemenProduk(this.DaftarProduk.get((ProdMap.get(Opsi))));
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
            System.out.println("");
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
    
    
    // Prosedur untuk Costumer membeli produk
    public void BeliProduk(Produk Prod) throws IOException, InterruptedException{
        Main.Clear();
        Prod.TampilProduk();
        
        System.out.println("\nBeli Produk (Y/N)? ");
        System.out.print("    :>> ");
        if(br.readLine().toUpperCase().equals("Y")){
            System.out.println("Masukkan jumlah produk dibeli: ");
            System.out.println("(Jumlah diminta tidak dapat lebih dari stok yang ada)");
            System.out.print("    :>> ");
            int StokBeli = Main.CheckInt();
            if(StokBeli <= 0 || StokBeli > Prod.Stok){
                System.out.println("Gagal masuk Tas Belanja");
                br.readLine();
            }
            else{
                ((Customer)Main.DaftarAkun.get(Main.AkunSequential(Main.IDAktif)))
                        .TasBelanjaAdd(new Belanja(Prod.ID, this.ID, StokBeli));
                System.out.println(" Berhasil dimasukkan ke keranjang!");
                
                System.out.println("\n Langsung menuju keranjang (Y/N)? ");
                System.out.print("    :>> ");
                if(br.readLine().toUpperCase().equals("Y")) Main.PortToBag = true;
            }
        }
    }
    

    public boolean HapusProduk(Produk Prod) throws IOException{
        System.out.println(" Yakin Hapus Produk (Y/N)? ");
        System.out.print(" :>> ");
        String Jawab = br.readLine();
        if(!Jawab.toUpperCase().equals("Y")) return false;
        this.DaftarProduk.remove(Prod);
        System.out.println(" Produk berhasil dihapus.");
        return true;
    }
    
    
    // Procedure untuk Admin dan Customer memilih toko-toko yang ada
    public static void MenuPilihToko() throws IOException, InterruptedException{
        while(true){
            Main.Clear();
            if(Main.PortToBag == true) return;
            System.out.println(" [99] Kembali");
            if(Main.Menu.equals("Admin")) System.out.println(" [0] Tambah Toko");
            System.out.println("------------------------");
            Toko.TampilSemuaToko();
            System.out.println("\n Pilih Toko");
            System.out.print(" :>> ");
            int index = CheckInt();
            switch (index) {
                case -1 -> {continue;}
                case 0 -> {
                    if(Main.Menu.equals("Customer")) continue;
                    Toko TokoBaru = Toko.TambahToko();
                    if(TokoBaru != null){
                        Main.DaftarToko.add(TokoBaru);
                    }
                    continue;
                }
                case 99 -> {return;}
            }
            try{
                Main.DaftarToko.get(index-1).TampilProduk();
            } catch(IndexOutOfBoundsException e){
                System.out.println(" Toko tersebut tidak ada.");
                br.readLine();
            }
        }
    }
    
    
    // Procedure untuk memanajemen toko SPESIFIK
    // Boolean untuk penghapusan
    public boolean MenuManajemenToko() throws IOException, InterruptedException {
        
        while(true){
        
            Main.Clear();

            //Sout dibedakan untuk admin dan untuk seller
            if (Main.Menu.equals("Admin")){
                System.out.println("""
                | ---------------------------------------- |
                |  //       Menu Manajemen Toko        \\\\  |
                \t\t""" + this.Nama + "\n" + """
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
                    case 2 -> this.ManajemenSellerToko();
                    case 3 -> {
                        Main.Clear();
                        this.MenuTambahProduk();
                    }
                    case 4 -> TampilPesanan();
                    case 5 -> {if(this.HapusToko()) return false;}
                    case 99 -> {return true;}
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
                    case 3 -> TampilPesanan();
                    case 99 -> {return true;}
                }
            }
        }
    }
   

    
    // Procedure untuk menambah produk pada toko
    void MenuTambahProduk() throws IOException, InterruptedException{
        Main.Clear();
        while(true){
            System.out.println("""
                    | ----------------------------------------------- |
                    |   //             Create Produk Toko         \\\\  |	
                    |  ||                                          || |
                    |  ||       Pilih Produk                       || |
                    |  ||       (1) Album                          || |
                    |  ||       (2) Lightstick                     || |
                    |  ||       (3) Poster                         || |
                    |  ||       (4) Postcard                       || |
                    |  ||       (5) Photocard                      || |
                    |  ||       (6) Keyring                        || |
                    |  ||       (7) Lanyard                        || |
                    |  ||       (8) Produk KPOP Lainnya            || |
                    |  ||       (9) Tteokbokki                     || |
                    |  ||       (10) Ramyeon                       || |
                    |  ||       (11) Fishcake                      || |
                    |  ||       (12) KoreanSauce                   || |
                    |  ||       (13) KoreanDrink                   || |
                    |  ||       (14) KoreanSnack                   || |
                    |  ||       (15) Makanan/Minuman Lainnya       || |
                    |  ||                                          || |
                    |  ||       (99) Kembali                       || |
                    |   \\\\                                        //  |
                    | ----------------------------------------------- |
                                """);

            System.out.print("  :>> ");
            Opsi = CheckInt();
            Main.Clear();

            switch (Opsi) {
                case 1 -> this.TambahProduk((new Album()).TambahProduk());
                case 2 -> this.TambahProduk((new LightStick()).TambahProduk());
                case 3 -> this.TambahProduk((new Poster()).TambahProduk());
                case 4 -> this.TambahProduk((new Postcard()).TambahProduk());
                case 5 -> this.TambahProduk((new Photocard()).TambahProduk());
                case 6 -> this.TambahProduk((new Keyring()).TambahProduk());
                case 7 -> this.TambahProduk((new Lanyard()).TambahProduk());
                case 8 -> this.TambahProduk((new CustomKPOP()).TambahProduk());
                case 9 -> this.TambahProduk((new Kimchi()).TambahProduk());
                case 10 -> this.TambahProduk((new Tteokbokki()).TambahProduk());
                case 11 -> this.TambahProduk((new Ramyeon()).TambahProduk());
                case 12 -> this.TambahProduk((new Fishcake()).TambahProduk());
                case 13 -> this.TambahProduk((new KoreanSauce()).TambahProduk());
                case 14 -> this.TambahProduk((new KoreanDrink()).TambahProduk());
                case 15 -> this.TambahProduk((new KoreanSnack()).TambahProduk());
                case 16 -> this.TambahProduk((new CustomFood()).TambahProduk()); //

                case 99 -> {return;}
            }
            
        }
    }
    
    // Produce untuk menambah/menghapus seller dari toko
    void ManajemenSellerToko() throws IOException, InterruptedException {
        
        Seller SellerSelect;
        HashMap<Integer, Seller> SellerMap = new HashMap<>();
        
        while(true){
            Main.Clear();
            
            SellerMap.clear();
            
            System.out.println("Daftar Seller:");
            SellerMap = this.TampilSeller();
            System.out.println((!SellerMap.isEmpty())?
                    "Ketik nomor seller untuk mengeluarkan seller dari toko ini.\n" :
                    " -- Belum ada seller di toko ini --\n");

            System.out.println("""
                | ---------------------------------------- |
                |  //    Menu Manajemen Seller Toko    \\\\  |
                | ||                                    || |
                | ||     (99)-. Kembali                 || |
                | ||     (0)-. Tambah Seller Toko       || |
                | ||                                    || |
                |  \\\\                                  //  |
                | ---------------------------------------- |
                                """);

            System.out.print(" :>> ");
            Opsi = CheckInt();

            switch (Opsi) {
                case 99 -> {return;}
                
                case 0 -> {
                    Main.Clear();
                    
                    SellerMap = Main.TampilSeller(true);
                    
                    if(SellerMap.isEmpty()){
                        System.out.println(" -- Tidak ada Seller yang bisa ditambahkan");
                        br.readLine();
                        continue;
                    }
                    
                    System.out.println(" Pilih seller yang ingin ditambahkan");
                    System.out.print(" :>> ");
                    
                    Opsi = CheckInt();
                    
                    SellerSelect = SellerMap.get(Opsi);

                    if (SellerSelect != null){
                        this.TambahSeller(SellerSelect.ID);
                        System.out.println(" Berhasil menambahkan seller ke toko");
                        br.readLine();
                        
                    } else {
                        System.out.println("----------------------------------------\n\t\tSeller tidak ada");
                        br.readLine();
                    }
                }
                    
                default -> {
                    SellerSelect = SellerMap.get(Opsi);
                    
                    if(SellerSelect == null){continue;}

                    Main.Clear();
                    
                    SellerSelect.TampilAkun();

                    this.HapusSeller(Opsi);
                }
            }
        }
    }

        
    // Procedure untuk menambah toko di daftar toko
    static public Toko TambahToko() throws IOException, InterruptedException {
        String NamaToko, KotaToko;
        
        try{
            System.out.println("---------------------------------------\n");
            System.out.print(" Masukkan nama toko   : Toko ");
            NamaToko = br.readLine();
            if (NamaToko.equals("")) throw new IllegalArgumentException();

            System.out.print(" Masukkan kota toko   : ");
            KotaToko = br.readLine();
            if (KotaToko.equals("")) throw new IllegalArgumentException();
        
        } catch(IllegalArgumentException e){
            System.out.println(" Terjadi kesalahan saat menambah toko.");
            br.readLine();
            return null;
        }
        
        Main.Clear();
        System.out.println("""
                   | ---------------------------------------- |
                   |  //                                  \\\\  |
                   | ||                                    || |
                   | ||      Toko Berhasil Ditambahkan!    || |
                   | ||                                    || |
                            Nama Toko    : Toko""" + (" ") + NamaToko + "\n" +
                   """
                   \t Lokasi Toko""" + "  : " + KotaToko + "\n" +
                   """
                    | ||                                    || |
                    |  \\\\                                  //  |
                    | ---------------------------------------- |
                           """);
        br.readLine();
        Main.capIDToko++;
        return new Toko(Main.capIDToko-1, "Toko " + NamaToko, KotaToko);
    }
    
    
    // Procedure untuk mengubah informasi toko
    public void UbahToko() throws IOException, InterruptedException {
        String NewNamaToko, NewKotaToko;
        System.out.println("\n (Ketik '//' untuk menggunakan data lama)");
        System.out.println(" (Ketik '99' untuk kembali");
        
        try{
            System.out.println("---------------------------------------\n");
            System.out.print(" Masukkan nama toko     : Toko ");
            NewNamaToko = "Toko " + br.readLine();
            switch (NewNamaToko) {
                case "" -> throw new IllegalArgumentException();
                case "99" -> {return;}
                case "Toko //" -> NewNamaToko = this.Nama;
            }

            System.out.print(" Masukkan kota toko     : ");
            NewKotaToko = br.readLine();
            switch (NewKotaToko) {
                case "" -> throw new IllegalArgumentException();
                case "99" -> {return;}
                case "//" -> NewKotaToko = this.Kota;
            }
            
        } catch(IllegalArgumentException e ){
            System.out.println(" Terjadi kesalahan saat menginput data");
            br.readLine();
            return;
        }
        
        this.Nama = NewNamaToko;
        this.Kota = NewKotaToko;
        
        Main.Clear();
        System.out.println("""
                   | ---------------------------------------- |
                   |  //                                  \\\\  |
                   | ||                                    || |
                   | ||      Info Toko Berhasil Diubah!    || |        
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
    
    
    // Function untuk hapus toko
    public boolean HapusToko() throws IOException {
        System.out.println(" Yakin hapus toko (Y/N)?");
        System.out.println(" (Menghapus toko ini akan sekaligus melepas kaitan Seller)");
        System.out.print(" :>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        else if(Conf.toUpperCase().equals("Y")){
                for(int IDP : this.IDSeller)
                   ((Seller)Main.DaftarAkun
                   .get(Main.AkunSequential(IDP)))
                   .setTokoKu(-1);
        
                Main.DaftarToko.remove(this);
        }
        
        return Conf.toUpperCase().equals("Y");   
    }
    
    public void TampilPesanan() throws IOException, InterruptedException{
        
        HashMap<Integer, Catatan> CtnMap = new HashMap<>();
        
        while(true){
            Main.Clear();
            CtnMap.clear();
            
            System.out.println("""
                | ---------------------------------------------------------------- |
                |  //                    Menu Lihat Pesanan                    \\\\  |
                | ||                                                            || |
                | ||                       [99] Kembali                         || |
                                """);

            int i = 1;
            
            for(Catatan ctn : Main.DaftarCatatan){
                if(ctn.getIDToko() == this.ID){
                    System.out.println("\n\t   [" + i + "] " + ctn.TampilPreview());
                    CtnMap.put(i, ctn);
                    i++;
                }
            }
            
            System.out.println("""
                | ||                                                            || |
                |  \\\\                                                          //  |
                | ---------------------------------------------------------------- |
                """);
    
            System.out.print(" :>> ");
            Opsi = CheckInt();
            
            switch (Opsi) {
                case 99 -> {return;}
                default -> {
                    if(CtnMap.get(Opsi) == null) return;
                    boolean loop = true;
                    while(loop){
                        Main.Clear();
                        CtnMap.get(Opsi).TampilCatatan();
                        System.out.println(" [99] Kembali");
                        System.out.println(" [1] Kirim Pesanan");
                        System.out.print(" :>> ");
                        int OpsiSec = CheckInt();

                        switch(OpsiSec){
                            case 99 -> {loop = false;}
                            case 1 -> {
                                Main.BarangSequential(CtnMap
                                        .get(Opsi)
                                        .getStruk()
                                        .getIDB()).Stok -= CtnMap.get(Opsi)
                                                                 .getStruk()
                                                                 .getStok();
                                CtnMap.get(Opsi).setStatus("Dikirim");
                                System.out.println(" Berhasil dikirim!");
                                br.readLine();
                                loop = false;
                            }
                        }
                    }
                }
            }
        }
    }
    
    static void ShortCut() throws IOException, InterruptedException{
        Main.Clear();
        while(true){
            if(Main.PortToBag == true) return;
            System.out.println("""
                    | ----------------------------------------------- |
                    |   //                Jalan Pintas            \\\\  |	
                    |  ||                                          || |
                    |  ||       Tampilkan Semua Produk             || |
                    |  ||       (1) Kategori Tertentu              || |
                    |  ||       (2) Idol/Idol Group Tertentu       || |
                    |  ||       (3) Dengan Nama Tertentu           || |
                    |  ||                                          || |
                    |  ||       (99) Kembali                       || |
                    |   \\\\                                        //  |
                    | ----------------------------------------------- |
                                """);

            System.out.print("  :>> ");
            Opsi = CheckInt();
            Main.Clear();
            
            switch(Opsi){
                case 1 -> TampilPerKategori();
                case 2 -> {
                    System.out.println(" Masukkan Nama Idol/Idol Group yang ingin dicari: ");
                    System.out.print(" :>> ");
                    String Cari = br.readLine();
                    TampilShortCut(Cari, 2);
                }
                case 3 -> {
                    System.out.println(" Masukkan Nama Produk yang ingin dicari: ");
                    System.out.print(" :>> ");
                    String Cari = br.readLine();
                    TampilShortCut(Cari, 3);
                }
                case 99 -> {return;}
            }
        }
    }
    
    static void TampilPerKategori() throws IOException, InterruptedException{
        Main.Clear();
        while(true){
            if(Main.PortToBag == true) return;
            System.out.println("""
                    | ----------------------------------------------- |
                    |   //             Pilih Kategori Dicari       \\\\  |	
                    |  ||                                          || |
                    |  ||       (1) Album                          || |
                    |  ||       (2) Lightstick                     || |
                    |  ||       (3) Poster                         || |
                    |  ||       (4) Postcard                       || |
                    |  ||       (5) Photocard                      || |
                    |  ||       (6) Keyring                        || |
                    |  ||       (7) Lanyard                        || |
                    |  ||       (8) Tteokbokki                     || |
                    |  ||       (9) Ramyeon                        || |
                    |  ||       (10) Fishcake                      || |
                    |  ||       (11) KoreanSauce                   || |
                    |  ||       (12) KoreanDrink                   || |
                    |  ||       (13) KoreanSnack                   || |
                    |  ||                                          || |
                    |  ||       (99) Kembali                       || |
                    |   \\\\                                        //  |
                    | ----------------------------------------------- |
                                """);

            System.out.print("  :>> ");
            Opsi = CheckInt();
            Main.Clear();
            
            switch (Opsi) {
                case 1 -> TampilShortCut("Album", 1);
                case 2 -> TampilShortCut("Lightstick", 1);
                case 3 -> TampilShortCut("Poster", 1);
                case 4 -> TampilShortCut("Postcard", 1);
                case 5 -> TampilShortCut("Photocard", 1);
                case 6 -> TampilShortCut("Keyring", 1);
                case 7 -> TampilShortCut("Lanyard", 1);
                case 8 -> TampilShortCut("Kimchi", 1);
                case 9 -> TampilShortCut("Tteokbokki", 1);
                case 10 -> TampilShortCut("Ramyeon", 1);
                case 11 -> TampilShortCut("Fishcake", 1);
                case 12 -> TampilShortCut("KoreanSauce", 1);
                case 13 -> TampilShortCut("KoreanDrink", 1);
                case 14 -> TampilShortCut("KoreanSnack", 1);

                case 99 -> {return;}
            }
        }    
    }
    
    static HashMap<Integer, HashMap<Produk, Toko>> ProdukTertentu(String Cari, int Jalur){
        HashMap<Integer, HashMap<Produk, Toko>> IntoMap = new HashMap<>();
        
        int i = 1;
        
        switch (Jalur) {
            case 1 -> {
                for(Toko TK : Main.DaftarToko)
                    for(Produk PR : TK.DaftarProduk)
                        if(PR.getClass().getSimpleName().equals(Cari)){
                            if(PR.Stok <= 0) continue;
                            System.out.println("\t["+i+"] " + PR.Nama + "  --<"+TK.Nama+">");
                            IntoMap.put(i,new HashMap<>(){{put(PR, TK);}});
                            i++;
                        }
            }
            case 2 -> {
                for(Toko TK : Main.DaftarToko)
                    for(Produk PR : TK.DaftarProduk)
                        if(PR.getClass().getSuperclass() == ProdukKPOP.class)
                            if(((ProdukKPOP)PR).Idol.toLowerCase().contains(Cari.toLowerCase())){
                                if(PR.Stok <= 0) continue;
                                System.out.println("\t["+i+"] " + PR.Nama + "  --<"+TK.Nama+">");
                                IntoMap.put(1,new HashMap<>(){{put(PR, TK);}});
                                i++;
                            }
            }
            default -> {
                for(Toko TK : Main.DaftarToko)
                    for(Produk PR : TK.DaftarProduk)
                        if(PR.Nama.toLowerCase().contains(Cari.toLowerCase())){
                            if(PR.Stok <= 0) continue;
                            System.out.println("\t["+i+"] " + PR.Nama + "  --<"+TK.Nama+">");
                            IntoMap.put(1,new HashMap<>(){{put(PR, TK);}});
                            i++;
                        }
            }
        }
        return IntoMap;
    }
    
    static void TampilShortCut(String Cari, int Jalur) throws IOException, InterruptedException{
        
        HashMap<Integer, HashMap<Produk, Toko>> ProdMap = new HashMap<>();
        
        while(true){
            ProdMap.clear();
            Main.Clear();

            System.out.println("[99] Kembali");
            System.out.println("\nProduk Ditemukan:");
            ProdMap = ProdukTertentu(Cari, Jalur);

            if(ProdMap.isEmpty()){
                System.out.println(" -- Tidak Ditemukan Produk Dicari -- ");
            }

            System.out.println("\n");
            int Opsi = Main.CheckInt();
            if(Opsi == 99) return;
            if(Opsi != -1){
                try{
                    if(ProdMap.get(Opsi) == null) throw new IndexOutOfBoundsException();
                    
                    Produk Prod = (Produk)ProdMap.get(Opsi).keySet().toArray()[0];
                    
                    ((Toko)ProdMap.get(Opsi).values().toArray()[0]).BeliProduk(Prod);
                    if(Main.PortToBag == true) return;
                     
                } catch(IndexOutOfBoundsException e){
                    System.out.println(" Produk tersebut tidak ada");
                    br.readLine();
                }
                
            }
        }
        
    }
}
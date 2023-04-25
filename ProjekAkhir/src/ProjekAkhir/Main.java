package ProjekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Viabel
 */

/*
    Di sini letakkan catatan, apa yang kurang atau semacamnya
    [Belum]
        -. Update Profil Seller
        -. Manajemen Seller (--> admin) butuh error handling indeks out of bounds

    [Butuh Konfirmasi]
        -. Tampilan banyak masih minus keknya

*/

/*
USN DAN PASS AKUN DEFAULT (karena Yafi sering lupa UwU)
< Customer >
    Usn: Viabel
    Pass: Vivin

< Seller >
    Usn: Agus
    Pass: Sun1004

    Usn: HD2e
    Pass: 2Lilies

< Admin> 
    Usn: NTLee
    Pass: SolidSolid
*/

public class Main {
    
    // Deklarasi Variabel "Global"
    static InputStreamReader isr = new InputStreamReader(System.in); //Untuk inputan
    static BufferedReader br = new BufferedReader(isr); //Untuk inputan
    static Admin Adminian = new Admin(0, "Fuad", "NTLee", 
                                   "SolidSolid", "NTLee@gmail.com"); //Untuk object dari class Admin
    static String Menu = "Login"; //Untuk penampil menu terpisah
    static int Opsi; //Untuk menyimpan segala macam pilihan tipe integer, misal: Pilihan Menu
    static int IDAktif; //Untuk menyimpan ID User yang sedang aktif
    static int capIDAkun = 1; //Untuk menyimpan ID terakhir tersimpan di Data Akun
    static int capIDProduk = 0; //Untuk menyimpan ID terakhir tersimpan di Data Produk
    static int capIDToko = 0; //Untuk menyimpan ID terakhir tersimpan di Data Toko
    static int capIDCat = 0;
    static boolean PortToBag = false;
    
    // Deklarasi Variabel Array
    static ArrayList<Akun> DaftarAkun = new ArrayList<>(); //Untuk menyimpan data akun
    static ArrayList<Toko> DaftarToko = new ArrayList<>(); //Untuk menyimpan data toko
    static ArrayList<Catatan> DaftarCatatan = new ArrayList<>(); //Untuk menyimpan data catatan yang ada
    
    public static int CheckInt(){
        try{
            return Integer.parseInt(br.readLine());
        }
        
        catch(IOException | NumberFormatException e){
            return -1;
        }
    }
    
    
    // Fungsi mencari index dari suatu Username
    public static int AkunSequential(String Username){
        int i = 0;
        for (Akun dataAkun : DaftarAkun){
            if(Username.equals(dataAkun.getUsn())) return i;
            i += 1;
        }
        return -1;
    }
    
    // Fungsi mencari index dari suatu ID Akun
    public static int AkunSequential(int ID){
        int i = 0;
        for (Akun dataAkun : DaftarAkun){
            if(ID == dataAkun.getID()) return i;
            i += 1;
        }
        return -1;
    }
    
    public static Produk BarangSequential(int ID){
        for (Toko IsiToko : DaftarToko)
            for (Produk IsiProduk : IsiToko.DaftarProduk)
                if(IsiProduk.ID == ID) return IsiProduk;
        
        return null;
    }
    
    
    public static Akun getActiveUserIndex(){
        return DaftarAkun.get(AkunSequential(IDAktif));
    }
    
    // Prosedur Untuk Clear Screen
    public static void Clear() throws IOException, InterruptedException{
        if (System.console() != null){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            return;
        }
        
        for(int i = 0; i <= 30; i++){
            System.out.print("\n");
        }
    }
    
    
    //Prosedur untuk menampilkan semua seller yang ada
    static public HashMap TampilSeller(boolean NonaffiliatedOnly){
        HashMap<Integer, Seller> SellerMap = new HashMap<>();
        int i = 1;
        
        // Tampil semua Seller
        if(!NonaffiliatedOnly){
            for (Akun AkunAda : DaftarAkun){
                if(AkunAda.Otoritas.equals("Seller")){
                    
                    System.out.println("<" + i + "> " + AkunAda.Nama +
                                        ((((Seller)AkunAda).getTokoKu() == -1)?
                                        " <Tidak Terhubung Dengan Toko>" :
                                        " " + DaftarToko.get(((Seller)AkunAda)
                                                .getTokoKu()).Nama));
                    SellerMap.put(i, (Seller)AkunAda);
                    
                    i++;
                }

            }
        }
        
        // Tampil hanya seller tanpa toko
        else{
            for (Akun AkunAda : DaftarAkun){
                if(AkunAda.getClass() == Seller.class)
                    if(((Seller)AkunAda).getTokoKu() == -1){
                        System.out.println("<" + i + "> " + AkunAda.Nama);
                        SellerMap.put(i, (Seller)AkunAda);
                        
                        i++;
                    }
            }
        }
        
        return SellerMap;
    }
    
    
    
    
    
    // Hapus nanti
    public static Seller DefaultSellerAcc(String UsnA, String PassA, String NamaA, String EmailA, String Nomor, String Addr){
        Seller User = new Seller();
        
        User.setID(capIDAkun);
        User.setUsn(UsnA);
        User.setPass(PassA);
        User.setNama(NamaA);
        User.setEmail(EmailA);
        User.setTokoKu(-1);
        capIDAkun+=1;
        
        return User;
    }

    // Hapus nanti
    public static Customer DefaultCostumerAcc(String UsnA, String PassA, String NamaA, String EmailA, String Nomor, String Kota, String Addr){
       Customer User = new Customer();
        
        User.setID(capIDAkun);
        User.setUsn(UsnA);
        User.setPass(PassA);
        User.setNama(NamaA);
        User.setEmail(EmailA);
        User.setNoHP(Nomor);
        User.setKota(Kota);
        User.setAlamat(Addr);
        
        capIDAkun+=1;
        
        return User;
    }
    
    
    // --------------------------------------- MAIN ZONE ---------------------------------------
    public static void main(String[] args) throws IOException, InterruptedException {
        DaftarAkun.add(Adminian);
        
        // Untuk Uji Coba, Mohon hapus nanti
        DaftarAkun.add(DefaultSellerAcc("Agus", "Sun1004", "Tina", "AgusNumeroUno@Naver.com", "1004", "Bumbum"));
        DaftarAkun.add(DefaultSellerAcc("HD2e", "2Lilies", "Hadie Pratama", "HadiePTM@yahoo.com", "0808", "Pekalongan"));
        DaftarAkun.add(DefaultCostumerAcc("Viabel", "Vivin", "Youvi", "YupiKenyalnya@Naver.com", "08122222", "Samarinda", "BoomBoom"));
        
        DaftarToko.add(new Toko(0, "Toko Sukamiskin", "Samarinda"));
        DaftarToko.add(new Toko(1, "Toko Rajinibadah", "Pontibapak"));
        DaftarToko.get(0).TambahProduk((new Album()).TambahProduk("Birthday (Smini Ver)", "Red Velvet","Smini Ver", 4, 300000));
        DaftarToko.get(0).TambahProduk((new Album()).TambahProduk( "Birthday (Digipack Ver)", "Red Velvet","Digipack Ver", 4, 280000 ));
        DaftarToko.get(0).TambahProduk((new LightStick()).TambahProduk("LightStick EXO", "EXO", true, "Ver 2", 1, 826000));
        DaftarToko.get(0).TambahProduk((new Album()).TambahProduk("Asterum", "PLAVE","", 5, 180000 ));
        DaftarToko.get(1).TambahProduk((new Album()).TambahProduk("Rise Up", "ASTRO","", 10, 320000 ));
        
        capIDToko += 2;
        
        DaftarToko.get(0).TambahSeller(1);
        
        // DaftarToko.get(0).TampilDeskripsi();
        // DaftarToko.get(0).TampilProduk();
        
        // Visual Program Berjalan
        while(true){
            
            
            // --------------------------------------- BAGIAN MENU LOGIN ---------------------------------------
            if(Menu.equals("Login")){
                // Isi Menu Login
                Clear();
                System.out.println(System.currentTimeMillis());
                System.out.println("""
                                    | -------------------------------------------- |
                                    |   //  Selamat Datang di Korean Market :) \\\\  |
                                    |  ||                                       || |
                                    |  ||            (1) Login                  || |
                                    |  ||            (2) Register               || |
                                    |  ||            (3) Keluar                 || |
                                    |   \\\\                                     //  |
                                    | -------------------------------------------- |
                                        """);
                
                System.out.print(":>> ");
                Opsi = CheckInt();
                
                
                // Respon Menu Login
                switch (Opsi) {
                    
                    // Logun
                    case 1 -> {
                        Clear();
                        System.out.println("""
                                    | ------------------------------------------ |
                                    |   //      Silahkan Login, Kawan :)     \\\\  |
                                    |  ||                                     || |
                                    |  ||           Username  :               || |
                                    |  ||           Password  :               || |
                                    |  ||                                     || |
                                    |   \\\\                                   //  |
                                    | ------------------------------------------ |
                                            """);

                        System.out.print("Masukkan Username: ");
                        String Username = br.readLine();
                        if(Username.equals("")) continue;

                        Clear();
                        System.out.println("""
                                   | ------------------------------------------ |
                                   |   //      Silahkan Login, Kawan :)     \\\\  |
                                   |  ||                                     || |
                                               Username  : """ + (" ") + Username + """      

                                    |  ||       Password  :                   || |
                                    |  ||                                     || |
                                    |   \\\\                                   //  |
                                    | ------------------------------------------ |
                                            """);
                        
                        System.out.print("Masukkan Password: ");
                        String Password = br.readLine();
                        if(Password.equals("")) continue;
                        
                        Clear();
                        System.out.println("""
                                    | ------------------------------------------ |
                                    |   //      Silahkan Login, Kawan :)     \\\\  |
                                    |  ||                                     || |
                                               Username  : """ + (" ") + Username + """      

                                               Password  : ********         
                                    |  ||                                     || |
                                    |   \\\\                                   //  |
                                    | ------------------------------------------ |
                                            """);
                        
                        // Cek Username dan Password
                        Opsi = AkunSequential(Username);
                        
                        if(Opsi == -1){
                            System.out.println("\n\tUsername atau Password salah");
                            br.readLine();
                            break;
                        }
                        
                        if(!DaftarAkun.get(Opsi).getPass().equals(Password)){
                            System.out.println("\n\tUsername atau Password salah");
                            br.readLine();
                            break;
                        }

                        IDAktif = DaftarAkun.get(Opsi).ID;
                        Menu = DaftarAkun.get(Opsi).Otoritas;
                        System.out.println("\n\tSelamat Datang, " + Menu + " " +  Username + " !");
                        br.readLine();
                        
                    }
                    
                    // Register Akun Costumer
                    case 2 -> {
                        Customer User = new Customer();
                        User.TambahAkun();
                        if(User.getUsn() == null) break;
                        DaftarAkun.add(User);
                        capIDAkun+=1;
                        System.out.println(" Akun Berhasil Ditambahkan !");
                        br.readLine();
                        }
                    
                    // Exit
                    case 3 -> System.exit(0);
                    default -> {
                        continue;
                    }
                }
                
                
                // Kembali ke Awal jika Menu masih "Login"
                if(Menu.equals("Login")){
                    continue;
                }
                
            }

           
            switch (Menu) {
            // --------------------------------------- BAGIAN MENU CUSTOMER ---------------------------------------
                case "Customer" -> {
                    // Isi Menu Utama Untuk Customer
                    Clear();
                
                    System.out.println("""
                       | ----------------------------------------------- |
                       |   //        Selamat Datang, """ + (" ") + Menu + " :)     \\\\  |" + 
                       """

                        |  ||                                          || |
                        |  ||      (1)-. Menuju Toko                   || |
                        |  ||      (2)-. Menuju Tas Belanjaku          || |
                        |  ||      (3)-. Baca Riwayat Pembelianku      || |
                        |  ||      (4)-. Ubah Profilku                 || |
                        |  ||      (5)-. Log Out                       || |
                        |   \\\\                                        //  |
                        | ----------------------------------------------- |
                                """);
                    
                    System.out.print(" :>> ");
                    Opsi = CheckInt();

                    switch(Opsi) {
                        case 1 -> {
                            Toko.MenuPilihToko();
                            if(PortToBag == true)((Customer)getActiveUserIndex()).FeelMyBag();
                        }
                        case 2 -> ((Customer)getActiveUserIndex()).FeelMyBag();
                        case 3 -> {}
                        case 4 -> ((Customer)getActiveUserIndex()).UbahProfil();
                        case 5 -> Menu = "Login";

                        default -> {continue;}
                    }
                }
                    
            // --------------------------------------- BAGIAN MENU ADMIN ---------------------------------------
                case "Admin" -> {
                    //Isi Menu Utama Untuk Admin
                    Clear();

                    System.out.println("""
                       | ---------------------------------------- |
                       |   //    Selamat Datang, """ + (" ") + Menu + " :)     \\\\  |" + 
                        """

                        |  ||                                   || |
                        |  ||      (1)-. Manajemen Toko         || |
                        |  ||      (2)-. Manajemen Seller       || |
                        |  ||      (3)-. Riwayat Pembelian      || |
                        |  ||      (4)-. Ubah Profil            || |
                        |  ||      (5)-. Log Out                || |
                        |   \\\\                                 //  |
                        | ---------------------------------------- |
                                """);
                    
                    System.out.print(" :>> ");
                    Opsi = CheckInt();
                    
                    switch (Opsi) {
                        case 1 -> Toko.MenuPilihToko();
                        case 2 -> Adminian.manajemenSeller();
                        case 3 -> {//admin.riwayatPembelian();
                    }
                        case 4 -> Adminian.UbahProfilAdmin();
                        case 5 -> Menu = "Login";

                        default -> {continue;}
                    } 
                }
                    
            // --------------------------------------- BAGIAN MENU SELLER ---------------------------------------
                case "Seller" -> {
                    //Isi Menu Utama Untuk Seller
                    Clear();

                    System.out.println("""
                       | -------------------------------------- |
                       |   //   Selamat Datang, """ + (" ") + Menu + " :)   \\\\  |" + 
                        """

                        |  ||                                 || |
                        |  ||        (1)-. Tokoku             || |
                        |  ||        (2)-. Ubah Profil        || |
                        |  ||        (3)-. Log Out            || |
                        |   \\\\                               //  |
                        | -------------------------------------- |
                                """);

                    System.out.print(" :>> ");
                    Opsi = CheckInt();
                    
                    switch (Opsi) {
                        case 1 -> {
                            int IndexToko = ((Seller)getActiveUserIndex()).getTokoKu();
                            if(IndexToko == -1){
                                System.out.println("Datamu belum terhubung dengan toko manapun.");
                                br.readLine();
                            }
                            else DaftarToko.get(IndexToko).TampilProduk();
                        }
                        case 2 -> {}
                        case 3 -> Menu = "Login";
                        default -> {continue;}
                    }
                }
                    
                default -> {continue;}
            }      
        }
    }
}

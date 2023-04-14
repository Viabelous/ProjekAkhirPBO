package ProjekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Viabel
 */
public class Main {
    
    // Deklarasi Variabel "Global"
    static InputStreamReader isr = new InputStreamReader(System.in); //Untuk inputan
    static BufferedReader br = new BufferedReader(isr); //Untuk inputan
    static String Menu = "Login"; //Untuk penampil menu terpisah
    static int Opsi; //Untuk menyimpan segala macam pilihan tipe integer, misal: Pilihan Menu
    
    // Deklarasi Variabel Array
    static ArrayList<Akun> DaftarAkun = new ArrayList<>(); //Untuk menyimpan data toko
    static ArrayList<Toko> DaftarToko = new ArrayList<>(); //Untuk menyimpan data toko
    
    
    public static int CheckInt(){
        try{
            return Integer.parseInt(br.readLine());
        }
        
        catch(IOException | NumberFormatException e){
            return -1;
        }
    }
    
    
    public static int TampilToko(){
        int i = 0;
        
        for (Toko TokoToko : DaftarToko){
            System.out.println("("+i+") "+ TokoToko.Nama);
            
        }
        
        System.out.print(":>> ");
        return CheckInt();
    }
    
    
    // --------------------------------------- MAIN ZONE ---------------------------------------
    public static void main(String[] args) {
        
        DaftarAkun.add(new Admin());
        
        
        DaftarToko.add(new Toko(1, "Toko Sukamiskin", 1));
        
        DaftarToko.get(0).TambahProduk(new Album(1, "Asterium"));
        DaftarToko.get(0).TambahProduk(new Album(2, "Espergo"));
        DaftarToko.get(0).TambahProduk(new LightStick(3, "EXO"));
        
        DaftarToko.get(0).TampilDeskripsi();
        DaftarToko.get(0).TampilProduk();
        
        // Visual Program Berjalan
        while(true){
            
            
            // --------------------------------------- BAGIAN MENU LOGIN ---------------------------------------
            if(Menu.equals("Login")){
                // Isi Menu Login
                System.out.println("""
                                    Selamat Datang atau Semacamnya!
                                    (1) Login
                                    (2) Register
                                    (3) Keluar
                                    """);
                
                System.out.print(" :>> ");
                Opsi = CheckInt();
                
                
                // Respon Menu Login
                switch (Opsi) {
                    
                    // Logun
                    case 1 -> {
                    }
                    
                    // Registus
                    case 2 -> {
                    }
                    
                    // Exto
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
                case "Customer" ->
                    // Isi Menu Utama Untuk Customer
                    System.out.println("""
                                       Adalah Menu Customer
                                       (1)-. Menuju Toko
                                       (2)-. Menuju Tas Belanjaku
                                       (3)-. Baca Riwayat Pembelianku
                                       (4)-. Ubah Profil
                                       (5)-. Log Out
                                       """);
                    
            // --------------------------------------- BAGIAN MENU ADMIN ---------------------------------------
                case "Admin" ->
                    //Isi Menu Utama Untuk Admin
                    System.out.println("""
                                        Adalah Menu Admin
                                        (1) Manajemen Toko
                                        (2) Manajemen Seller
                                        (3) Riwayat Pembelian
                                        (4) Ubah Profil
                                        (5) Log Out
                                        """);
                    
            // --------------------------------------- BAGIAN MENU SELLER ---------------------------------------
                case "Seller" ->
                    //Isi Menu Utama Untuk Seller
                    System.out.println("""
                                        Adalah Menu Seller
                                        (1) Tokoku
                                        (2) Ubah Profil
                                        (3) Log Out
                                        """);
                    
                default -> {
                }
            }
            
            
                    
        }
    }
}
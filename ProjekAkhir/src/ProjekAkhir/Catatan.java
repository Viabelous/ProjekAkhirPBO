
package ProjekAkhir;

import static ProjekAkhir.Main.CheckInt;
import static ProjekAkhir.Main.Opsi;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

/**
 *
 * @author Viabel
 */
public class Catatan {
    private int IDCat;
    private int IDCust;
    private int IDToko;
    private String Waktu;
    private String Isi;
    private String Status;
    
    Catatan(int IDCustomer, int IDToko, String IsiCatatan){
        this.IDCust = IDCustomer;
        this.Isi = IsiCatatan;
        this.IDToko = IDToko;
    }
    
    
    static void TambahCatatan(Belanja Struk, String Alamat, String NomorRekening){
        Produk Prod = Main.BarangSequential(Struk.getIDB());
        
        Toko TokoProd = null;
        
        for(Toko TokoIni : Main.DaftarToko)
            if(TokoIni.ID == Struk.getIDT())
                TokoProd = TokoIni;
        
        String CIsi = "ID Pembeli        : " + Main.IDAktif;
              CIsi += "Nama Pembeli      : " + ((Customer)Main.getActiveUserIndex()).getNama();
              CIsi += "ID Toko           : " + TokoProd.ID;
              CIsi += "Nama Toko         : " + TokoProd.Nama;
              CIsi += "ID Barang dibeli  : " + TokoProd.Nama;
              CIsi += "Nama Barang dibeli: " + Prod.Nama;
              CIsi += "Banyak dibeli     : " + Struk.getStok();
              CIsi += "Harga Total       : " + Struk.getHarga();
              CIsi += "Alamat Penerima   : " + Alamat;
              CIsi += "Nomor Rekening    : " + NomorRekening;
        
        
        new Catatan(Main.IDAktif, Struk.getIDT(), CIsi).TambahCatatan();
    }
    
    
    void TambahCatatan(){
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String WaktuNow = dtf.format(now);
       
       this.IDCat = Main.capIDCat;
       Main.capIDCat += 1;
       this.Waktu = WaktuNow;
       this.Status = "Belum Dikirim";
       
       Main.DaftarCatatan.add(this);
       
    }
    
    public static void TampilCatatan(int IndexPembelian){
        System.out.println(" -- Catatan Pembelian -- ");
        System.out.println("ID     : " + Main.DaftarCatatan.get(IndexPembelian-1).IDCat);
        System.out.println("Tanggal: " + Main.DaftarCatatan.get(IndexPembelian-1).Waktu);
        System.out.println("Status : " + Main.DaftarCatatan.get(IndexPembelian-1).Status);
        System.out.println(" ----------------------- \n");
        System.out.println(Main.DaftarCatatan.get(IndexPembelian-1).Isi);
        System.out.println(" -----------------------");
    }
    
    public static void TampilCatatanPesanan(int IndexPesanan){
        // belum diganti masi binggung
        System.out.println(" -- Catatan Pesanan -- ");
        System.out.println("ID     : " + Main.DaftarCatatan.get(IndexPesanan).IDCat);
        System.out.println("Tanggal: " + Main.DaftarCatatan.get(IndexPesanan).Waktu);
        System.out.println("Status : " + Main.DaftarCatatan.get(IndexPesanan).Status);
        System.out.println(" ----------------------- \n");
        System.out.println(Main.DaftarCatatan.get(IndexPesanan).Isi);
        System.out.println(" -----------------------");
    }
    
    
    public static void TampilPesanan() throws IOException, InterruptedException{
        while(true){
            Main.Clear();

            System.out.println("""
                | ---------------------------------------- |
                |  //        Menu Lihat Pesanan        \\\\  |
                | ||                                    || |
                | ||           [99] Kembali             || |
                | ||                                    || |
                | ||        -. Daftar Pesanan .-        || |
                """);
            
            for (int i = 0; i < Main.DaftarCatatan.size(); i++){
                //mau nampilin id/nama cust
                System.out.println("\n\t   [" + i+1 + "] ID Customer : (" + Main.DaftarCatatan.get(i).IDCat + ")");
            }

            System.out.println("""
                |  ||                                   || |
                |   \\\\                                 //  |
                | ---------------------------------------- |
                """);
                
            System.out.print(" :>> ");
            Opsi = CheckInt();
            
            switch (Opsi) {
                case 99 -> {return;}
                default -> Catatan.TampilCatatanPesanan(Opsi);
            }
        }
    }
    
    
    public static void TampilPembelian() throws IOException, InterruptedException{
        while(true){
            Main.Clear();

            System.out.println("""
                | ---------------------------------------- |
                |  //      Menu Riwayat Pembelian      \\\\  |
                | ||                                    || |
                | ||           [99] Kembali             || |
                               """);
            
            for (int i=0; i < Main.DaftarCatatan.size(); i++){
                //mau nampilin nama toko dri barang yg cust pesan
                System.out.println("\n\t   [" + i+1 + "]" + Main.DaftarCatatan.get(i).IDToko);
            }
            
            System.out.println("""
                |   \\\\                                 //  |
                | ---------------------------------------- |
                """);
                
            System.out.print(" :>> ");
            Opsi = CheckInt();
            
            switch (Opsi) {
                case 99 -> {return;}
                default -> Catatan.TampilCatatan(Opsi);
            }
        }
    }
}

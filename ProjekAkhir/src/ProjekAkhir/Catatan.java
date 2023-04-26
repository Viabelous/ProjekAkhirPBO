
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
    
    void TampilCatatan(){
        System.out.println(" -- Catatan Pembelian -- ");
        System.out.println("ID     : " + this.IDCat);
        System.out.println("Tanggal: " + this.Waktu);
        System.out.println("Status : " + this.Status);
        System.out.println(" ----------------------- \n");
        System.out.println(this.Isi);
        System.out.println(" -----------------------");
    }
    
    void TampilPesanan() throws IOException, InterruptedException{
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
                        System.out.println("\n\t\t" + Main.DaftarCatatan.get(i).IDCust);
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
                default -> {this.TampilCatatan();}
            }
        }
    }
}

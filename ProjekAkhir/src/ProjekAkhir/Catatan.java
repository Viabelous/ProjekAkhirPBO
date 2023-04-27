
package ProjekAkhir;

import static ProjekAkhir.Main.Opsi;
import static ProjekAkhir.Main.CheckInt;
import static ProjekAkhir.Main.br;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.util.HashMap;

/**
 *
 * @author Viabel
 */
public class Catatan {
    private int IDCat;
    private int IDCust;
    private int IDToko;
    private Belanja Struk;
    private String Waktu;
    private String Isi;
    private String Status;
    
    Catatan(int IDCustomer, int IDToko, Belanja Struk, String IsiCatatan){
        this.IDCust = IDCustomer;
        this.Struk = Struk;
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
              CIsi += "\nNama Pembeli      : " + ((Customer)Main.getActiveUserIndex()).getNama();
              CIsi += "\nID Toko           : " + TokoProd.ID;
              CIsi += "\nNama Toko         : " + TokoProd.Nama;
              CIsi += "\nID Barang dibeli  : " + Struk.getIDB();
              CIsi += "\nNama Barang dibeli: " + Prod.Nama;
              CIsi += "\nBanyak dibeli     : " + Struk.getStok();
              CIsi += "\nHarga Total       : " + Struk.getHarga();
              CIsi += "\nAlamat Penerima   : " + Alamat;
              CIsi += "\nNomor Rekening    : " + NomorRekening;
        
        
        new Catatan(Main.IDAktif, Struk.getIDT(), Struk, CIsi).TambahCatatan();
    }
    
    
    void TambahCatatan(){
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String WaktuNow = dtf.format(now);
       
       this.setIDCat(Main.capIDCat);
       Main.capIDCat += 1;
       this.setWaktu(WaktuNow);
       this.setStatus("Belum Dikirim");
       
       Main.DaftarCatatan.add(this);
       
    }
    
    public String TampilPreview(){
        if(Main.Menu.equals("Customer"))
            return "Catatan " + this.getWaktu() + " <" + this.getStatus() + ">";
        else
            return "(" + Main.DaftarAkun
                    .get(Main.AkunSequential(this.getIDCust())).Nama
                    + ") " + this.getWaktu() + "  <" + this.getStatus() + ">";
    }
    
    public void TampilCatatan() throws IOException{
        System.out.println(" -- Catatan Pembelian -- ");
        System.out.println("ID     : " + this.IDCat);
        System.out.println("Tanggal: " + this.Waktu);
        System.out.println("Status : " + this.Status);
        System.out.println(" ----------------------- \n");
        System.out.println(this.Isi);
        System.out.println(" -----------------------");
        if(Main.Menu.equals("Customer")) br.readLine();
    }
    
    static void TampilRiwayatPembelian(int ID) throws IOException, InterruptedException{
        
        HashMap<Integer, Catatan> CtnMap = new HashMap<>();
        
        while(true){
            Main.Clear();
            CtnMap.clear();

            System.out.println("""
                | ---------------------------------------------------------------- |
                |  //                  Menu Riwayat Pembelian                  \\\\  |
                | ||                                                            || |
                | ||                       [99] Kembali                         || |
                               """);
            
            int i = 1;
            
            if(Main.Menu.equals("Customer")){
                Customer Cust = (Customer)Main.DaftarAkun.get(Main.AkunSequential(ID));
                for(Catatan ctn : Main.DaftarCatatan){ 
                    if(ctn.getIDCust() == Cust.getID()){
                        System.out.println("\n\t   [" + i + "] " + ctn.TampilPreview());
                        CtnMap.put(i, ctn);
                        i++;
                    }
                }
            }
            else{
                Toko Tk = null;
                for(Toko tk : Main.DaftarToko){
                    if(tk.ID == ID){
                        Tk = tk;
                        break;
                    }
                }
                
                for(Catatan ctn : Main.DaftarCatatan){ 
                    if(ctn.getIDToko() == Tk.ID && ctn.Status.equals("Dikirim")){
                        System.out.println("\n\t   [" + i + "] " + ctn.TampilPreview());
                        CtnMap.put(i, ctn);
                        i++;
                    }
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
                    CtnMap.get(Opsi).TampilCatatan();
                }
                    
            }
        }
    }
    
    

    public int getIDCat() {
        return IDCat;
    }

    public void setIDCat(int IDCat) {
        this.IDCat = IDCat;
    }

    public int getIDCust() {
        return IDCust;
    }

    public void setIDCust(int IDCust) {
        this.IDCust = IDCust;
    }

    public int getIDToko() {
        return IDToko;
    }

    public void setIDToko(int IDToko) {
        this.IDToko = IDToko;
    }

    public String getWaktu() {
        return Waktu;
    }

    public void setWaktu(String Waktu) {
        this.Waktu = Waktu;
    }

    public String getIsi() {
        return Isi;
    }
    
    public void setIsi(String Isi) {
        this.Isi = Isi;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    
    }

    public Belanja getStruk() {
        return Struk;
    }

    public void setStruk(Belanja Struk) {
        this.Struk = Struk;
    }
}

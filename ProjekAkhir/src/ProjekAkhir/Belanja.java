package ProjekAkhir;

import static ProjekAkhir.Main.CheckInt;
import static ProjekAkhir.Main.Opsi;
import static ProjekAkhir.Main.br;
import static ProjekAkhir.Main.getActiveUserIndex;
import java.io.IOException;


public class Belanja {
    private int IDB;
    private int IDT;
    private int Stok;
    private int Harga;
    
    public Belanja(int IDBarang, int IDToko, int StokDibeli){
        this.IDB = IDBarang;
        this.IDT = IDToko;
        this.Stok = StokDibeli;
    }
    
    public int getIDB() {
        return IDB;
    }
    
    public void setIDB(int IDB) {
        this.IDB = IDB;
    }

    public int getIDT() {
        return IDT;
    }

    public void setIDT(int IDT) {
        this.IDT = IDT;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int Stok) {
        this.Stok = Stok;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
    
    void TampilTas(int i){
        Produk Prod = Main.BarangSequential(this.getIDB());
        
        if (i != -1) System.out.printf("%-" + 5 + "s", i);
        System.out.printf("%-" + 35 + "s", Prod.Nama);
        System.out.printf("%-" + 10 + "s", this.getStok());
        System.out.printf("%-" + 20 + "s", Prod.Harga * this.getStok());
        System.out.printf("%-" + 20 + "s", ((Prod.Stok < this.getStok())? "Invalid" : "--"));
        
        System.out.println();
        for (int j = 0; j < 20 * 5; j++) {
            System.out.print("-");
        }
        System.out.println();  
    }
    
    //Prosedur untuk memesan barang di tas
    void ProsesTas() throws IOException, InterruptedException{
        while(true){
            Main.Clear();
            Produk Prod = Main.BarangSequential(this.getIDB());

            System.out.printf("%-" + 35 + "s", "Nama Barang");
            System.out.printf("%-" + 10 + "s", "Jumlah");
            System.out.printf("%-" + 20 + "s", "Harga");
            System.out.printf("%-" + 20 + "s", "Status Barang");
    
            System.out.println();
                for (int j = 0; j < 20 * 5; j++) {
                    System.out.print("-");
                }
                
            System.out.println("");
                
            this.TampilTas(-1);
            
            System.out.println("");
            System.out.println(" [99] Kembali");
            System.out.println(" [1] Keluarkan dari tas belanja");
            System.out.println(" [2] Ubah banyak pembelian");
            
            if(Prod.Stok < this.getStok()){
                System.out.println(" Dikarenakan stok diminta kurang dari banyak yang diinginkan, ");
                System.out.println(" pembelian tidak memungkinkan.");
                System.out.println(" Stok Tersedia: " + Prod.Stok);
            }
            else{
                System.out.println(" [3] Lakukan Pemesanan");
            }
                
            System.out.print(" :> ");
            Opsi = CheckInt();
            switch(Opsi){
                case 99 -> {return;}
                case 1 -> {
                    Customer Pbl = (Customer)getActiveUserIndex();

                    Pbl.TasBelanjaDel(this);
                    System.out.println("Berhasil dikeluarkan dari tas belanja");
                    return;
                    }

                case 2 -> {
                    System.out.print("\nMasukkan banyak pesanan baru: ");
                    Opsi = CheckInt();
                    if(Opsi <= 0 || Opsi > Prod.Stok)
                        System.out.println("Terjadi kesalahan saat menginput data");
                    else{
                        this.Stok = Opsi;
                        System.out.println("Stok diminta berhasil diubah");
                    }
                    br.readLine();
                }
                
                case 3 -> {
                    if(Prod.Stok < this.getStok()) continue;
                    if (this.ProsesBarang()) return;
                }
            }
                
        }
    }
    
    
    // Fungsi untuk melakukan pemesanan barang
    boolean ProsesBarang() throws IOException{
        String Alamat, NomorRekening;
        
        Customer Pbl = (Customer)getActiveUserIndex();
        
        try{
            System.out.println("(Ketik '//' untuk menggunakan alamat akun ini)");
            System.out.print("Masukkan Alamat penerima: ");
            Alamat = br.readLine();
            if(Alamat.equals("//")) Alamat = Pbl.getAlamat();
            else if (Alamat.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Nomor Rekening: ");
            NomorRekening = br.readLine();

            if (!NomorRekening.equals("")){
                for (char ch : NomorRekening.toCharArray()){
                    if((int)ch < 48 || (int)ch > 57){
                        throw new IllegalArgumentException();
                    }
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        
        } catch(IllegalArgumentException e){
            System.out.println("Terjadi kesalahan saat menginput data.");
            br.readLine();
            return false;
        }
        
        Catatan.TambahCatatan(this, Alamat, NomorRekening);
        System.out.println(" Berhasil dipesan!");
        br.readLine();

        Pbl.TasBelanjaDel(this);
        
        return true;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjekAkhir;

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
    
    void RefreshHarga(){
        for (Toko iToko : Main.DaftarToko)
            for (Produk iProduk : iToko.DaftarProduk)
                if(iProduk.ID == this.IDB){
                    this.Harga =
                    (iProduk.Stok < this.Stok)? -1 : iProduk.Harga * this.Stok;
                    break;
                }
    }
    
    void TampilTas(int i){
        Produk Prod = Main.BarangSequential(this.IDB);
        
        System.out.printf("%-" + 5 + "s", i);
        System.out.printf("%-" + 35 + "s", Prod.Nama);
        System.out.printf("%-" + 10 + "s", this.Stok);
        System.out.printf("%-" + 20 + "s", Prod.Harga * this.Stok);
        System.out.printf("%-" + 20 + "s", ((Prod.Stok >= this.Stok)? "--" : "Invalid"));
        
        System.out.println();
        for (int j = 0; j < 20 * 5; j++) {
            System.out.print("-");
        }
        System.out.println();  
    }
}

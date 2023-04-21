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
    
    void refreshHarga(){
        for (Toko iToko : Main.DaftarToko)
            for (Produk iProduk : iToko.DaftarProduk)
                if(iProduk.ID == this.IDB) this.Harga =
                    (iProduk.Stok < this.Stok)? -1 : iProduk.Harga * this.Stok;
    }


}

package ProjekAkhir;

/**
 *
 * @author Viabel
 */
abstract class Produk {
    int ID;
    String Nama;
}

abstract class ProdukKPOP extends Produk{
    String NamaGrup;
}

class Album extends ProdukKPOP{
    
    Album(int ID, String NamaProduk, String Grup){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
    }
}

class LightStick extends ProdukKPOP{
    Boolean Baterai;
    
    LightStick(int ID, String Nama, String Grup, Boolean DilengkapiBaterai){
        this.ID = ID;
        this.Nama = Nama;
        this.NamaGrup = Grup;
        this.Baterai = DilengkapiBaterai;
    }
}

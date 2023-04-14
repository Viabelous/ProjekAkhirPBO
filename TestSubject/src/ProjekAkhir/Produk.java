package ProjekAkhir;

/**
 *
 * @author Viabel
 */
abstract class Produk {
    int ID;
    String Nama;
}

class Album extends Produk{
    Album(int ID, String NamaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;
    }
}

class LightStick extends Produk{
    final String Jenis = "LightStick";
    
    LightStick(int ID, String Grup){
        this.ID = ID;
        this.Nama = "Lightstick " + Grup;
    }
}

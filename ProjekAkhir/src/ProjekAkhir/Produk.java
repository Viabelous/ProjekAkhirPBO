package ProjekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Viabel
 */
abstract class Produk {
    int ID;
    String Nama;
    int Harga;
    
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    abstract Produk TambahProduk();
    
}

abstract class ProdukKPOP extends Produk{
    String NamaGrup;
}

class Album extends ProdukKPOP{
    
    String VersiAlbum;
     
    Album(int ID, String NamaProduk, String Grup, String VersiAlbum, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.VersiAlbum = VersiAlbum;
        this.Harga = Harga;
    }
        
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Grup : ");
            String Grup = br.readLine();
            if (Grup.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Versi Album: ");
            String VersiAlbumProduk = br.readLine();
            
            System.out.println("Masukkan Harga Album :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new Album(Main.capIDProduk, NamaProduk, Grup, VersiAlbumProduk, HargaProduk);
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}

class LightStick extends ProdukKPOP{
    Boolean Baterai;
    String VersiLightstick;
    
    LightStick(int ID, String Nama, String Grup, Boolean DilengkapiBaterai, String VersiLightstick, int Harga){
        this.ID = ID;
        this.Nama = Nama;
        this.NamaGrup = Grup;
        this.Baterai = DilengkapiBaterai;
        this.VersiLightstick = VersiLightstick;
        this.Harga = Harga;
    }
    
    static void TambahProduk(){
        
    }
}

class Poster extends ProdukKPOP{
    String VersiPoster;

    Poster(int ID, String NamaProduk, String Grup, String VersiPoster, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;        
        this.NamaGrup = Grup;
        this.VersiPoster = VersiPoster;
        this.Harga = Harga;
    }
}

class Postcard extends ProdukKPOP{
    String VersiPostcard;
    String VersiMember;
    String Size;

    Postcard(int ID, String NamaProduk, String Grup, String Size, String VersiPostcard, String VersiMember, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Size = Size;
        this.VersiPostcard = VersiPostcard;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }
}

class Photocard extends ProdukKPOP{
    String VersiPhotocard;
    String VersiMember;
    String Size;

    Photocard(int ID, String NamaProduk, String Grup, String Size, String VersiPhotocard, String VersiMember, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Size = Size;
        this.VersiPhotocard = VersiPhotocard;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }
}

class Keyring extends ProdukKPOP{
    String VersiMember;
    String Size;

    Keyring(int ID, String NamaProduk, String Grup,  String Size, String VersiMember, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Size = Size;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }
}

class Lanyard extends ProdukKPOP{
    String Bahan;

    Lanyard(int ID, String NamaProduk, String Grup, String Bahan, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Bahan = Bahan;
        this.Harga = Harga;
    }
}
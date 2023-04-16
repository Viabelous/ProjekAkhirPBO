package ProjekAkhir;

import static ProjekAkhir.Toko.br;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Viabel
 */
abstract class Produk {
    int ID;
    String NamaProduk;
    int Harga;
    
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    abstract Produk TambahProduk();
    
}

abstract class ProdukKPOP extends Produk{
    String Idol;
}

class Album extends ProdukKPOP{
    
    String VersiAlbum;
     
    Album(int ID, String NamaProduk, String Idol, String VersiAlbum, int Harga){
        this.ID = ID;
        this.NamaProduk = NamaProduk;
        this.Idol = Idol;
        this.VersiAlbum = VersiAlbum;
        this.Harga = Harga;
    }
        
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Idol/Grup : ");
            String Idol = br.readLine();
            if (Idol.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Versi Album: ");
            String VersiAlbum = br.readLine();
            
            System.out.println("Masukkan Harga Album :Rp. ");
            int Harga =  Main.CheckInt();
            if (Harga <= 0) throw new IllegalArgumentException();
            
            return new Album(Main.capIDProduk, NamaProduk, Idol, VersiAlbum, Harga);
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}

class LightStick extends ProdukKPOP{
    Boolean Baterai;
    String VersiLightstick;
    
    LightStick(int ID, String NamaProduk, String Idol, Boolean Baterai, String VersiLightstick, int Harga){
        this.ID = ID;
        this.NamaProduk = NamaProduk;
        this.Idol = Idol;
        this.Baterai = Baterai;
        this.VersiLightstick = VersiLightstick;
        this.Harga = Harga;
    }
    
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Idol/Grup : ");
            String Idol = br.readLine();
            if (Idol.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Berisikan Baterai (Y/N)?");
            boolean Baterai = ((br.readLine().equals("Y")));
            
            System.out.println("Masukkan Versi LightStick: ");
            String VersiLightstick = br.readLine();
    
            System.out.println("Masukkan Harga Album :Rp. ");
            int Harga =  Main.CheckInt();
            if (Harga <= 0) throw new IllegalArgumentException();
            
            return new LightStick(Main.capIDProduk, NamaProduk, Idol, Baterai, VersiLightstick, Harga);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}

class Poster extends ProdukKPOP{
    String VersiPoster;

    Poster(int ID, String NamaProduk, String Idol, String VersiPoster, int Harga){
        this.ID = ID;
        this.NamaProduk = NamaProduk;        
        this.Idol = Idol;
        this.VersiPoster = VersiPoster;
        this.Harga = Harga;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Idol/Grup : ");
            String Idol = br.readLine();
            if (Idol.equals("")) throw new IllegalArgumentException();
            
            
            System.out.println("Masukkan Versi Poster: ");
            String VersiPoster = br.readLine();
    
            System.out.println("Masukkan Harga Album :Rp. ");
            int Harga =  Main.CheckInt();
            if (Harga <= 0) throw new IllegalArgumentException();
            
            return new Poster(Main.capIDProduk, NamaProduk, Idol, VersiPoster, Harga);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}

class Postcard extends ProdukKPOP{
    String VersiPostcard;
    String VersiMember;
    String Size;

    Postcard(int ID, String NamaProduk, String Idol, String Size, String VersiPostcard, String VersiMember, int Harga){
        this.ID = ID;
        this.NamaProduk = NamaProduk;
        this.Idol = Idol;
        this.Size = Size;
        this.VersiPostcard = VersiPostcard;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Idol/Grup : ");
            String Idol = br.readLine();
            if (Idol.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Ukuran Postcard : ");
            String Size = br.readLine();
            if (Size.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Versi Postcard: ");
            String VersiPostcard = br.readLine();
            
            System.out.println("Masukkan Versi Member: ");
            String VersiMember = br.readLine();
    
            System.out.println("Masukkan Harga Album :Rp. ");
            int Harga =  Main.CheckInt();
            if (Harga <= 0) throw new IllegalArgumentException();
            
            return new Postcard(Main.capIDProduk, NamaProduk, Idol, Size, VersiPostcard, VersiMember, Harga);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}

class Photocard extends ProdukKPOP{
    String VersiPhotocard;
    String VersiMember;
    String Size;

    Photocard(int ID, String NamaProduk, String Idol, String Size, String VersiPhotocard, String VersiMember, int Harga){
        this.ID = ID;
        this.NamaProduk = NamaProduk;
        this.Idol = Idol;
        this.Size = Size;
        this.VersiPhotocard = VersiPhotocard;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Idol/Grup : ");
            String Idol = br.readLine();
            if (Idol.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Ukuran Postcard : ");
            String Size = br.readLine();
            if (Size.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Versi Photocard: ");
            String VersiPhotocard = br.readLine();
            
            System.out.println("Masukkan Versi Member: ");
            String VersiMember = br.readLine();
    
            System.out.println("Masukkan Harga Album :Rp. ");
            int Harga =  Main.CheckInt();
            if (Harga <= 0) throw new IllegalArgumentException();
            
            return new Photocard(Main.capIDProduk, NamaProduk, Idol, Size, VersiPhotocard, VersiMember, Harga);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}

class Keyring extends ProdukKPOP{
    String VersiMember;
    String Size;

    Keyring(int ID, String NamaProduk, String Idol,  String Size, String VersiMember, int Harga){
        this.ID = ID;
        this.NamaProduk = NamaProduk;
        this.Idol = Idol;
        this.Size = Size;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Idol/Grup : ");
            String Idol = br.readLine();
            if (Idol.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Ukuran Postcard : ");
            String Size = br.readLine();
            if (Size.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Versi Member: ");
            String VersiMember = br.readLine();
    
            System.out.println("Masukkan Harga Album :Rp. ");
            int Harga =  Main.CheckInt();
            if (Harga <= 0) throw new IllegalArgumentException();
            
            return new Keyring(Main.capIDProduk, NamaProduk, Idol, Size, VersiMember, Harga);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}

class Lanyard extends ProdukKPOP{
    String Bahan;

    Lanyard(int ID, String NamaProduk, String Idol, String Bahan, int Harga){
        this.ID = ID;
        this.NamaProduk = NamaProduk;
        this.Idol = Idol;
        this.Bahan = Bahan;
        this.Harga = Harga;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.println("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Nama Idol/Grup : ");
            String Idol = br.readLine();
            if (Idol.equals("")) throw new IllegalArgumentException();
            
            System.out.println("Masukkan Bahan Lanyard : ");
            String Bahan = br.readLine();
            if (Bahan.equals("")) throw new IllegalArgumentException();
            
    
            System.out.println("Masukkan Harga Album :Rp. ");
            int Harga =  Main.CheckInt();
            if (Harga <= 0) throw new IllegalArgumentException();
            
            return new Lanyard(Main.capIDProduk, NamaProduk, Idol, Bahan, Harga);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
}


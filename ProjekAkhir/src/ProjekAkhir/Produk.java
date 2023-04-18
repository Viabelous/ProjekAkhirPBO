package ProjekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Viabel
 */
abstract class Produk {
    int ID;
    String Nama;
    int Stok;
    int Harga;
    
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    abstract Produk TambahProduk();
    abstract void UbahProduk() throws IOException;
    abstract void TampilProduk();
    
}

abstract class ProdukKPOP extends Produk{
    String Idol;
}

class Album extends ProdukKPOP{
    
    String VersiAlbum;
     
    Album(int ID, String NamaProduk, String NamaIdol, String VersiAlbumProduk, int StokProduk, int HargaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.VersiAlbum = VersiAlbumProduk;
        this.Stok = StokProduk;
        this.Harga = HargaProduk;
    }
        
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Versi Album: ");
            String VersiAlbumProduk = br.readLine();
            
            System.out.print("Masukkan Harga Album :Rp. ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Album :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new Album(Main.capIDProduk, NamaProduk, NamaIdol, VersiAlbumProduk, StokProduk, HargaProduk);
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;

        System.out.println("Versi Album Lama: " + this.VersiAlbum);
        System.out.print("Versi Album Baru: ");
        String VersiAlbumBaru = br.readLine();
        if (VersiAlbumBaru.equals("99")) return;
        else if (VersiAlbumBaru.equals("")) VersiAlbumBaru = this.VersiAlbum;
        
        System.out.println("Masukkan Harga Album Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Album Baru: Rp. ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Harga;

        System.out.println("Masukkan Harga Album Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Album Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.VersiAlbum = VersiAlbumBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){

    // Mendefinisikan ArrayList 2 dimensi
    ArrayList<Album> data = new ArrayList<Album>();

    data.add(new Album(this.ID, this.Nama, 
                this.getClass().getSimpleName(), this.Idol, this.VersiAlbum this.Stok,
                this.Harga));

    // Mendefinisikan lebar kolom
    int ColumnWidth = 10;

    // Mencetak judul kolom
    System.out.printf("%-" + ColumnWidth + "s", "ID");
    System.out.printf("%-" + ColumnWidth + "s", "Jenis Produk");
    System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group");
    System.out.printf("%-" + ColumnWidth + "s", "Versi Album");
    System.out.printf("%-" + ColumnWidth + "s", "Stok Album");
    System.out.printf("%-" + ColumnWidth + "s", "Harga Album");
    System.out.println();

    // Mencetak baris pemisah
    for (int i = 0; i < ColumnWidth * 6; i++) {
        System.out.print("-");
    }
    System.out.println();

    // Mencetak isi tabel
    for (int i = 0; i < data.size(); i++) {
        System.out.printf("%-" + ColumnWidth + "s", data.ID);
        System.out.printf("%-" + ColumnWidth + "d", data.Nama);
        System.out.printf("%-" + ColumnWidth + "s", data.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", data.Idol);
        System.out.printf("%-" + ColumnWidth + "s", data.VersiAlbum);
        System.out.printf("%-" + ColumnWidth + "s", data.Stok);
        System.out.printf("%-" + ColumnWidth + "s", data.Harga);
        System.out.println();
    }


        System.out.println("ID: " + this.ID);
        System.out.println("Nama Produk: " + this.Nama);
        System.out.println("Jenis Produk: " + this.getClass().getSimpleName());
        System.out.println("Idol/IdolGroup: " + this.Idol);
        System.out.println("Versi Album: " + this.VersiAlbum);
        System.out.println("Harga: " + this.Harga);
    }
}

class LightStick extends ProdukKPOP{
    Boolean Baterai;
    String VersiLightstick;
    
    LightStick(int ID, String NamaProduk, String NamaIdol, Boolean DilengkapiBaterai, String VersiLightstickProduk, int HargaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.Baterai = DilengkapiBaterai;
        this.VersiLightstick = VersiLightstickProduk;
        this.Harga = HargaProduk;
    }
    
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Berisikan Baterai (Y/N)?");
            boolean DilengkapiBaterai = ((br.readLine().equals("Y")));
            
            System.out.print("Masukkan Versi LightStick: ");
            String VersiLightstickProduk = br.readLine();
    
            System.out.print("Masukkan Harga Album :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new LightStick(Main.capIDProduk, NamaProduk, NamaIdol, DilengkapiBaterai, VersiLightstickProduk, HargaProduk);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Berisikan Baterai (Y/N)?" + this.Baterai);
        System.out.print("Berisikan Baterai (Y/N)?");
        String DilengkapiBateraiBaru = br.readLine();
        if (DilengkapiBateraiBaru.equals("99")) return;
        else if (!(DilengkapiBateraiBaru.equals("Y") || DilengkapiBateraiBaru.equals("N"))) DilengkapiBateraiBaru = "N";

        System.out.println("Versi Lightstick Lama: " + this.VersiLightstick);
        System.out.print("Versi Lightstick Baru: ");
        String VersiLightstickBaru = br.readLine();
        if (VersiLightstickBaru.equals("99")) return;
        else if (VersiLightstickBaru.equals("")) VersiLightstickBaru = this.VersiLightstick;

        System.out.println("Masukkan Harga Lightstick Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Lightstick Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Baterai = ((DilengkapiBateraiBaru.equals("Y"))? !this.Baterai : this.Baterai);
        this.VersiLightstick = VersiLightstickBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        System.out.println("ID: " + this.ID);
        System.out.println("Nama Produk: " + this.Nama);
        System.out.println("Jenis Produk: " + this.getClass().getSimpleName());
        System.out.println("Idol/IdolGroup: " + this.Idol);
        System.out.println("Berisikan Baterai (Y/N)? " + this.Baterai);
        System.out.println("Versi Lightstick: " + this.VersiLightstick);
        System.out.println("Harga: " + this.Harga);
    }
}

class Poster extends ProdukKPOP{
    String VersiPoster;

    Poster(int ID, String NamaProduk, String NamaIdol, String VerPoster, int HargaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;        
        this.Idol = NamaIdol;
        this.VersiPoster = VerPoster;
        this.Harga = HargaProduk;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            
            System.out.print("Masukkan Versi Poster: ");
            String VersiPoster = br.readLine();
    
            System.out.println("Masukkan Harga Album :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new Poster(Main.capIDProduk, NamaProduk, NamaIdol, VersiPoster, HargaProduk);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;

        System.out.println("Versi Poster Lama: " + this.VersiPoster);
        System.out.print("Versi Poster Baru: ");
        String VerPosterBaru = br.readLine();
        if (VerPosterBaru.equals("99")) return;
        else if (VerPosterBaru.equals("")) VerPosterBaru = this.VersiPoster;

        System.out.println("Masukkan Harga Poster Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Poster Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.VersiPoster = VerPosterBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        System.out.println("ID: " + this.ID);
        System.out.println("Nama Produk: " + this.Nama);
        System.out.println("Jenis Produk: " + this.getClass().getSimpleName());
        System.out.println("Idol/IdolGroup: " + this.Idol);
        System.out.println("Versi Poster: " + this.VersiPoster);
        System.out.println("Harga: " + this.Harga);
    }
}

class Postcard extends ProdukKPOP{
    String VersiPostcard;
    String VersiMember;
    String Size;

    Postcard(int ID, String NamaProduk, String NamaIdol, String SizePostcard, String VerPostcard, String VerMember, int HargaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.Size = SizePostcard;
        this.VersiPostcard = VerPostcard;
        this.VersiMember = VerMember;
        this.Harga = HargaProduk;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Ukuran Postcard : ");
            String SizePostcard = br.readLine();
            if (SizePostcard.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Versi Postcard: ");
            String VerPostcard = br.readLine();
            
            System.out.print("Masukkan Versi Member: ");
            String VerMember = br.readLine();
    
            System.out.print("Masukkan Harga Album :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new Postcard(Main.capIDProduk, NamaProduk, NamaIdol, SizePostcard, VerPostcard, VerMember, HargaProduk);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Size Postcard Lama: " + this.Size);
        System.out.print("Versi Postcard Baru: ");
        String SizePostcardBaru = br.readLine();
        if (SizePostcardBaru.equals("99")) return;
        else if (SizePostcardBaru.equals("")) SizePostcardBaru = this.Size;
        
        System.out.println("Versi Postcard Lama: " + this.VersiPostcard);
        System.out.print("Versi Postcard Baru: ");
        String VerPostcardBaru = br.readLine();
        if (VerPostcardBaru.equals("99")) return;
        else if (VerPostcardBaru.equals("")) VerPostcardBaru = this.VersiPostcard;

        System.out.println("Versi Member Lama: " + this.VersiMember);
        System.out.print("Versi Member Baru: ");
        String VerMemberBaru = br.readLine();
        if (VerMemberBaru.equals("99")) return;
        else if (VerMemberBaru.equals("")) VerMemberBaru = this.VersiMember;

        System.out.println("Masukkan Harga Postcard Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Poster Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Size = SizePostcardBaru;
        this.VersiPostcard = VerPostcardBaru;
        this.VersiMember = VerMemberBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        System.out.println("ID: " + this.ID);
        System.out.println("Nama Produk: " + this.Nama);
        System.out.println("Jenis Produk: " + this.getClass().getSimpleName());
        System.out.println("Idol/IdolGroup: " + this.Idol);
        System.out.println("Size Postcard: " + this.Size);        
        System.out.println("Versi Postcard: " + this.VersiPostcard);
        System.out.println("Versi Member: " + this.VersiMember);
        System.out.println("Harga: " + this.Harga);
    }
}

class Photocard extends ProdukKPOP{
    String VersiPhotocard;
    String VersiMember;
    String Size;

    Photocard(int ID, String NamaProduk, String NamaIdol, String SizePhotocard, String VerPhotocard, String VerMember, int HargaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.Size = SizePhotocard;
        this.VersiPhotocard = VerPhotocard;
        this.VersiMember = VerMember;
        this.Harga = HargaProduk;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Ukuran Postcard : ");
            String SizePhotocard = br.readLine();
            if (SizePhotocard.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Versi Photocard: ");
            String VerPhotocard = br.readLine();
            
            System.out.print("Masukkan Versi Member: ");
            String VerMember = br.readLine();
    
            System.out.print("Masukkan Harga Photocard :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new Photocard(Main.capIDProduk, NamaProduk, NamaIdol, SizePhotocard, VerPhotocard, VerMember, HargaProduk);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Size Postcard Lama: " + this.Size);
        System.out.print("Versi Postcard Baru: ");
        String SizePhotocardBaru = br.readLine();
        if (SizePhotocardBaru.equals("99")) return;
        else if (SizePhotocardBaru.equals("")) SizePhotocardBaru = this.Size;
        
        System.out.println("Versi Photocard Lama: " + this.VersiPhotocard);
        System.out.print("Versi Postcard Baru: ");
        String VerPhotocardBaru = br.readLine();
        if (VerPhotocardBaru.equals("99")) return;
        else if (VerPhotocardBaru.equals("")) VerPhotocardBaru = this.VersiPhotocard;

        System.out.println("Versi Member Lama: " + this.VersiMember);
        System.out.print("Versi Member Baru: ");
        String VerMemberBaru = br.readLine();
        if (VerMemberBaru.equals("99")) return;
        else if (VerMemberBaru.equals("")) VerMemberBaru = this.VersiMember;

        System.out.println("Masukkan Harga Photocard Lama: Rp. " + this.Harga);
        System.out.println("Masukkan Harga Poster Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Size = SizePhotocardBaru;
        this.VersiPhotocard = VerPhotocardBaru;
        this.VersiMember = VerMemberBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        System.out.println("ID: " + this.ID);
        System.out.println("Nama Produk: " + this.Nama);
        System.out.println("Jenis Produk: " + this.getClass().getSimpleName());
        System.out.println("Idol/IdolGroup: " + this.Idol);
        System.out.println("Size Photocard: " + this.Size);        
        System.out.println("Versi Photocard: " + this.VersiPhotocard);
        System.out.println("Versi Member: " + this.VersiMember);
        System.out.println("Harga: " + this.Harga);
    }
}

class Keyring extends ProdukKPOP{
    String VersiMember;
    String Size;

    Keyring(int ID, String NamaProduk, String NamaIdol,  String SizeKeyring, String VerMember, int HargaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.Size = SizeKeyring;
        this.VersiMember = VerMember;
        this.Harga = HargaProduk;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Ukuran Keyring : ");
            String SizeKeyring = br.readLine();
            if (SizeKeyring.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Versi Member: ");
            String VerMember = br.readLine();
    
            System.out.print("Masukkan Harga Keyring :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new Keyring(Main.capIDProduk, NamaProduk, NamaIdol, SizeKeyring, VerMember, HargaProduk);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Size Keyring Lama: " + this.Size);
        System.out.print("Versi Postcard Baru: ");
        String SizeKeyringBaru = br.readLine();
        if (SizeKeyringBaru.equals("99")) return;
        else if (SizeKeyringBaru.equals("")) SizeKeyringBaru = this.Size;
        
        System.out.println("Versi Member Lama: " + this.VersiMember);
        System.out.print("Versi Member Baru: ");
        String VerMemberBaru = br.readLine();
        if (VerMemberBaru.equals("99")) return;
        else if (VerMemberBaru.equals("")) VerMemberBaru = this.VersiMember;

        System.out.println("Masukkan Harga Keyring Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Keyring Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Size = SizeKeyringBaru;
        this.VersiMember = VerMemberBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        System.out.println("ID: " + this.ID);
        System.out.println("Nama Produk: " + this.Nama);
        System.out.println("Jenis Produk: " + this.getClass().getSimpleName());
        System.out.println("Idol/IdolGroup: " + this.Idol);
        System.out.println("Size Keyring: " + this.Size);        
        System.out.println("Versi Member: " + this.VersiMember);
        System.out.println("Harga: " + this.Harga);
    }
}

class Lanyard extends ProdukKPOP{
    String Bahan;

    Lanyard(int ID, String NamaProduk, String NamaIdol, String BahanLanyard, int HargaProduk){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.Bahan = BahanLanyard;
        this.Harga = HargaProduk;
    }
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Lanyard : ");
            String BahanLanyard = br.readLine();
            if (BahanLanyard.equals("")) throw new IllegalArgumentException();
            
    
            System.out.print("Masukkan Harga Lanyard :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            return new Lanyard(Main.capIDProduk, NamaProduk, NamaIdol, BahanLanyard, HargaProduk);
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Versi Bahan Lanyard: " + this.Bahan);
        System.out.print("Versi Member Baru: ");
        String BahanLanyard = br.readLine();
        if (BahanLanyard.equals("99")) return;
        else if (BahanLanyard.equals("")) BahanLanyard = this.Bahan;

        System.out.println("Masukkan Harga Lanyard Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Lanyard Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Bahan = BahanLanyard;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        System.out.println("ID: " + this.ID);
        System.out.println("Nama Produk: " + this.Nama);
        System.out.println("Jenis Produk: " + this.getClass().getSimpleName());
        System.out.println("Idol/IdolGroup: " + this.Idol);
        System.out.println("Bahan Lanyard: " + this.Bahan);        
        System.out.println("Harga: " + this.Harga);
    }
}

package ProjekAkhir;

import static ProjekAkhir.Main.br;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static ProjekAkhir.Main.getActiveUserIndex;

/**
 *
 * @author Viabel
 */
abstract class Produk {
    int ID;
    String Nama;
    int Stok;
    int Harga;

    abstract Produk TambahProduk();
    abstract void UbahProduk() throws IOException;
    abstract void TampilProduk();
    
}

abstract class ProdukKPOP extends Produk{
    String Idol;
}

class Album extends ProdukKPOP{
    
    String VersiAlbum;
    
    // Hapus Nanti
    Produk TambahProduk(String NamaProduk, String NamaIdol, String VersiAlbumProduk, int StokProduk, int HargaProduk){
        this.ID = Main.capIDProduk;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.VersiAlbum = VersiAlbumProduk;
        this.Stok = StokProduk;
        this.Harga = HargaProduk;
        return this;
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
            
            System.out.print("Masukkan Versi Album : ");
            String VersiAlbumProduk = br.readLine();
            
            System.out.print("Masukkan Stok Album : ");
            int StokProduk = Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Album :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.VersiAlbum = VersiAlbumProduk;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;

        System.out.println("Versi Album Lama: " + this.VersiAlbum);
        System.out.print("Masukkan Versi Album Baru: ");
        String VersiAlbumBaru = br.readLine();
        if (VersiAlbumBaru.equals("99")) return;
        else if (VersiAlbumBaru.equals("")) VersiAlbumBaru = this.VersiAlbum;
        
        System.out.println("Stok Album Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Album Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Album Lama: Rp. " + this.Harga);
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
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID ");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk ");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk ");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group ");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Album ");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Album ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Album ");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 6; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
            System.out.printf("%-" + IDWidth + "d", this.ID);
            System.out.printf("%-" + ColumnWidth + "s", this.Nama);
            System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
            System.out.printf("%-" + ColumnWidth + "s", this.Idol);
            System.out.printf("%-" + ColumnWidth + "s", this.VersiAlbum);
            System.out.printf("%-" + ColumnWidth + "d", this.Stok);
            System.out.printf("%-" + ColumnWidth + "d", this.Harga);
            System.out.println();
    }
}

class LightStick extends ProdukKPOP{
    Boolean Baterai;
    String VersiLightstick;
    
    // Hapus Nanti
    Produk TambahProduk(String NamaProduk, String NamaIdol, Boolean DilengkapiBaterai, String VersiLightstickProduk, int StokProduk, int HargaProduk){
        this.ID = Main.capIDProduk;
        this.Nama = NamaProduk;
        this.Idol = NamaIdol;
        this.Baterai = DilengkapiBaterai;
        this.VersiLightstick = VersiLightstickProduk;
        this.Stok = StokProduk;
        this.Harga = HargaProduk;
        return this;
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
            boolean DilengkapiBaterai = br.readLine().equals("Y");
            
            System.out.print("Masukkan Versi LightStick : ");
            String VersiLightstickProduk = br.readLine();
            
            System.out.print("Masukkan Stok LightStick : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
    
            System.out.print("Masukkan Harga LightStick :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.Baterai = DilengkapiBaterai;
            this.VersiLightstick = VersiLightstickProduk;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Kondisi Baterai Lama: " + ((this.Baterai)? "" : "Tidak ") + "Termasuk Baterai");
        System.out.print("Berisikan Baterai (Y/N)?");
        String DilengkapiBateraiBaru = br.readLine();
        if (DilengkapiBateraiBaru.equals("99")) return;
        else if (!(DilengkapiBateraiBaru.equals("Y") || DilengkapiBateraiBaru.equals("N"))) DilengkapiBateraiBaru = "N";

        System.out.println("Versi Lightstick Lama: " + this.VersiLightstick);
        System.out.print("Masukkan Versi Lightstick Baru: ");
        String VersiLightstickBaru = br.readLine();
        if (VersiLightstickBaru.equals("99")) return;
        else if (VersiLightstickBaru.equals("")) VersiLightstickBaru = this.VersiLightstick;
        
        System.out.println("Stok Lightstick Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Lightstick Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Lightstick Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Lightstick Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Baterai = ((DilengkapiBateraiBaru.equals("Y"))? !this.Baterai : this.Baterai);
        this.VersiLightstick = VersiLightstickBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group");
        System.out.printf("%-" + ColumnWidth + "s", "Termasuk Baterai");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Lightstick");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Lightstick ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Lightstick");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 6; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Idol);
        System.out.printf("%-" + ColumnWidth + "b", ((this.Baterai)? "Ya" : "Tidak"));
        System.out.printf("%-" + ColumnWidth + "s", this.VersiLightstick);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Poster extends ProdukKPOP{
    String VersiPoster;
    int Panjang;
    int Lebar;
    
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
            String VerPoster = br.readLine();
            
            System.out.print("Masukkan Panjang Poster : ");
            int PanjangPoster =  Main.CheckInt();
            if (PanjangPoster <= 0) throw new IllegalArgumentException();            
          
            System.out.print("Masukkan Lebar Poster : ");
            int LebarPoster =  Main.CheckInt();
            if (LebarPoster <= 0) throw new IllegalArgumentException(); 
            
            System.out.print("Masukkan Stok Poster : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
    
            System.out.println("Masukkan Harga Poster :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.VersiPoster = VerPoster;
            this.Panjang = PanjangPoster;
            this.Lebar = LebarPoster;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;

        System.out.println("Versi Poster Lama: " + this.VersiPoster);
        System.out.print("Masukkan Versi Poster Baru: ");
        String VerPosterBaru = br.readLine();
        if (VerPosterBaru.equals("99")) return;
        else if (VerPosterBaru.equals("")) VerPosterBaru = this.VersiPoster;
        
        System.out.println("Panjang Poster Lama:  " + this.Panjang);
        System.out.print("Masukkan Panjang Poster Baru:  ");
        int PanjangPosterBaru =  Main.CheckInt();
        if (PanjangPosterBaru == 99) return;
        else if (PanjangPosterBaru <= 0) PanjangPosterBaru = this.Panjang;
        
        System.out.println("Lebar Poster Lama:  " + this.Lebar);
        System.out.print("Masukkan Lebar Poster Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Lebar;

        System.out.println("Stok Poster Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Poster Baru:  ");
        int LebarPosterBaru =  Main.CheckInt();
        if (LebarPosterBaru == 99) return;
        else if (LebarPosterBaru <= 0) LebarPosterBaru = this.Stok;
        
        System.out.println("Harga Poster Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Poster Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.VersiPoster = VerPosterBaru;
        this.Panjang = PanjangPosterBaru;
        this.Lebar = LebarPosterBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Poster");
        System.out.printf("%-" + ColumnWidth + "s", "Panjang Poster ");
        System.out.printf("%-" + ColumnWidth + "s", "Lebar Poster ");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Poster ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Poster");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Idol);
        System.out.printf("%-" + ColumnWidth + "s", this.VersiPoster);
        System.out.printf("%-" + ColumnWidth + "d", this.Panjang);
        System.out.printf("%-" + ColumnWidth + "d", this.Lebar);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Postcard extends ProdukKPOP{
    String VersiPostcard;
    String VersiMember;
    String Size;

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
            
            System.out.print("Masukkan Stok Postcard : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Postcard :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.Size = SizePostcard;
            this.VersiPostcard = VerPostcard;
            this.VersiMember = VerMember;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Size Postcard Lama: " + this.Size);
        System.out.print("Masukkan Size Postcard Baru: ");
        String SizePostcardBaru = br.readLine();
        if (SizePostcardBaru.equals("99")) return;
        else if (SizePostcardBaru.equals("")) SizePostcardBaru = this.Size;
        
        System.out.println("Versi Postcard Lama: " + this.VersiPostcard);
        System.out.print("Masukkan Versi Postcard Baru: ");
        String VerPostcardBaru = br.readLine();
        if (VerPostcardBaru.equals("99")) return;
        else if (VerPostcardBaru.equals("")) VerPostcardBaru = this.VersiPostcard;

        System.out.println("Versi Member Lama: " + this.VersiMember);
        System.out.print("Masukkan Versi Member Baru: ");
        String VerMemberBaru = br.readLine();
        if (VerMemberBaru.equals("99")) return;
        else if (VerMemberBaru.equals("")) VerMemberBaru = this.VersiMember;
        
        System.out.println("Stok Postcard Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Postcard Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Postcard Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Postcard Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Size = SizePostcardBaru;
        this.VersiPostcard = VerPostcardBaru;
        this.VersiMember = VerMemberBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group");
        System.out.printf("%-" + ColumnWidth + "s", "Size Postcard");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Postcard");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Member");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Postcard ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Postcard");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 7; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Idol);
        System.out.printf("%-" + ColumnWidth + "s", this.Size);
        System.out.printf("%-" + ColumnWidth + "s", this.VersiPostcard);
        System.out.printf("%-" + ColumnWidth + "s", this.VersiMember);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Photocard extends ProdukKPOP{
    String VersiPhotocard;
    String VersiMember;
    String Size;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Ukuran Photocard : ");
            String SizePhotocard = br.readLine();
            if (SizePhotocard.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Versi Photocard: ");
            String VerPhotocard = br.readLine();
            
            System.out.print("Masukkan Versi Member: ");
            String VerMember = br.readLine();
            
            System.out.print("Masukkan Stok Photocard : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
    
            System.out.print("Masukkan Harga Photocard :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.Size = SizePhotocard;
            this.VersiPhotocard = VerPhotocard;
            this.VersiMember = VerMember;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Size Photocard Lama: " + this.Size);
        System.out.print("Masukkan Size Photocard Baru: ");
        String SizePhotocardBaru = br.readLine();
        if (SizePhotocardBaru.equals("99")) return;
        else if (SizePhotocardBaru.equals("")) SizePhotocardBaru = this.Size;
        
        System.out.println("Versi Photocard Lama: " + this.VersiPhotocard);
        System.out.print("Masukkan Versi Photocard Baru: ");
        String VerPhotocardBaru = br.readLine();
        if (VerPhotocardBaru.equals("99")) return;
        else if (VerPhotocardBaru.equals("")) VerPhotocardBaru = this.VersiPhotocard;

        System.out.println("Versi Member Lama: " + this.VersiMember);
        System.out.print("Masukkan Versi Member Baru: ");
        String VerMemberBaru = br.readLine();
        if (VerMemberBaru.equals("99")) return;
        else if (VerMemberBaru.equals("")) VerMemberBaru = this.VersiMember;
        
        System.out.println("Stok Photocard Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Photocard Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Photocard Lama: Rp. " + this.Harga);
        System.out.println("Masukkan Harga Photocard Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Size = SizePhotocardBaru;
        this.VersiPhotocard = VerPhotocardBaru;
        this.VersiMember = VerMemberBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group");
        System.out.printf("%-" + ColumnWidth + "s", "Size Photocard");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Photocard");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Member");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Photocard ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Photocard");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 7; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Idol);
        System.out.printf("%-" + ColumnWidth + "s", this.Size);
        System.out.printf("%-" + ColumnWidth + "s", this.VersiPhotocard);
        System.out.printf("%-" + ColumnWidth + "s", this.VersiMember);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Keyring extends ProdukKPOP{
    String VersiMember;
    String Size;

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
            
            System.out.print("Masukkan Stok Keyring : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
    
            System.out.print("Masukkan Harga Keyring :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.Size = SizeKeyring;
            this.VersiMember = VerMember;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Size Keyring Lama: " + this.Size);
        System.out.print("Masukkan Versi Keyring Baru: ");
        String SizeKeyringBaru = br.readLine();
        if (SizeKeyringBaru.equals("99")) return;
        else if (SizeKeyringBaru.equals("")) SizeKeyringBaru = this.Size;
        
        System.out.println("Versi Member Lama: " + this.VersiMember);
        System.out.print("Masukkan Versi Member Baru: ");
        String VerMemberBaru = br.readLine();
        if (VerMemberBaru.equals("99")) return;
        else if (VerMemberBaru.equals("")) VerMemberBaru = this.VersiMember;

        System.out.println("Stok Keyring Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Keyring Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;
        
        System.out.println("Harga Keyring Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Keyring Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Size = SizeKeyringBaru;
        this.VersiMember = VerMemberBaru;
        this.Stok =  StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group");
        System.out.printf("%-" + ColumnWidth + "s", "Size Keyring");
        System.out.printf("%-" + ColumnWidth + "s", "Versi Member");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Keyring ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Keyring");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 6; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Idol);
        System.out.printf("%-" + ColumnWidth + "s", this.Size);
        System.out.printf("%-" + ColumnWidth + "s", this.VersiMember);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Lanyard extends ProdukKPOP{
    String Bahan;

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
            
            System.out.print("Masukkan Stok Lanyard : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Lanyard :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.Bahan = BahanLanyard;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Versi Bahan Lanyard: " + this.Bahan);
        System.out.print("Masukkan Versi Bahan Lanyard Baru: ");
        String BahanLanyard = br.readLine();
        if (BahanLanyard.equals("99")) return;
        else if (BahanLanyard.equals("")) BahanLanyard = this.Bahan;
        
        System.out.println("Stok Lanyard Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Lanyard Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Lanyard Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Lanyard Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Bahan = BahanLanyard;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group");
        System.out.printf("%-" + ColumnWidth + "s", "Bahan Lanyard");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Lanyard ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Lanyard");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Idol);
        System.out.printf("%-" + ColumnWidth + "s", this.Bahan);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Kimchi extends Produk{
    String Bahan;
    int Berat; 

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Kimchi : ");
            String NamaKimchi = br.readLine();
            if (NamaKimchi.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Kimchi : ");
            String BahanKimchi = br.readLine();
            if (BahanKimchi.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Berat Kimchi : ");
            int BeratKimchi =  Main.CheckInt();
            if (BeratKimchi <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Kimchi : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Kimchi :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaKimchi;
            this.Bahan = BahanKimchi;
            this.Berat = BeratKimchi;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Kimchi Lama: " + this.Nama);
        System.out.print("Masukkan Nama Kimchi Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Kimchi Lama: " + this.Bahan);
        System.out.print("Masukkan Bahan Kimchi Baru: ");
        String BahanKimchiBaru = br.readLine();
        if (BahanKimchiBaru.equals("99")) return;
        else if (BahanKimchiBaru.equals("")) BahanKimchiBaru = this.Bahan;
 
        System.out.println("Berat Kimchi Lama:  " + this.Berat);
        System.out.print("Masukkan Berat Kimchi Baru:  ");
        int BeratKimchiBaru =  Main.CheckInt();
        if (BeratKimchiBaru == 99) return;
        else if (BeratKimchiBaru <= 0) BeratKimchiBaru = this.Berat;
        
        System.out.println("Stok Kimchi Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Kimchi Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Kimchi Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Kimchi Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Bahan = BahanKimchiBaru;
        this.Berat = BeratKimchiBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Kimchi");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Bahan Kimchi");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Kimchi ");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Kimchi ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Kimchi");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Bahan);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Tteokbokki extends Produk{
    String Bahan;
    int Berat; 
    
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Tteokbokki : ");
            String BahanTteokbokki = br.readLine();
            if (BahanTteokbokki.equals("")) throw new IllegalArgumentException();

            System.out.print("Masukkan Berat Tteokbokki : ");
            int BeratTteokbokki =  Main.CheckInt();
            if (BeratTteokbokki <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Tteokbokki : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Tteokbokki :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Bahan = BahanTteokbokki;
            this.Berat = BeratTteokbokki;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Tteokbokki Lama: " + this.Bahan);
        System.out.print("Masukkan Bahan Tteokbokki Baru: ");
        String BahanTteokbokkiBaru = br.readLine();
        if (BahanTteokbokkiBaru.equals("99")) return;
        else if (BahanTteokbokkiBaru.equals("")) BahanTteokbokkiBaru = this.Bahan;

        System.out.println("Berat Tteokbokki Lama:  " + this.Berat);
        System.out.print("Masukkan Berat Tteokbokki Baru:  ");
        int BeratTteokbokkiBaru =  Main.CheckInt();
        if (BeratTteokbokkiBaru == 99) return;
        else if (BeratTteokbokkiBaru <= 0) BeratTteokbokkiBaru = this.Berat;
        
        System.out.println("Stok Tteokbokki Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Tteokbokki Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Tteokbokki Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Tteokbokki Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Bahan = BahanTteokbokkiBaru;
        this.Berat = BeratTteokbokkiBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Bahan Tteokbokki");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Tteokbokki");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Tteokbokki ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Tteokbokki");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Bahan);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Ramyeon  extends Produk{
    String Bahan;
    String Jenis;
    int Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Ramyeon : ");
            String BahanRamen = br.readLine();
            if (BahanRamen.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Jenis Ramyeon : ");
            String JenisRamen = br.readLine();
            if (JenisRamen.equals("")) throw new IllegalArgumentException();

            System.out.print("Masukkan Berat Ramyeon : ");
            int BeratRamen =  Main.CheckInt();
            if (BeratRamen <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Ramyeon : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Ramyeon :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Bahan = BahanRamen;
            this.Jenis = JenisRamen;
            this.Berat = BeratRamen;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Ramyeon Lama: " + this.Bahan);
        System.out.print("Masukkan Bahan Ramyeon Baru: ");
        String BahanRamenBaru = br.readLine();
        if (BahanRamenBaru.equals("99")) return;
        else if (BahanRamenBaru.equals("")) BahanRamenBaru = this.Bahan;
        
        System.out.println("Jenis Ramyeon Lama: " + this.Jenis);
        System.out.print("Masukkan Jenis Ramyeon Baru: ");
        String JenisRamenBaru = br.readLine();
        if (JenisRamenBaru.equals("99")) return;
        else if (JenisRamenBaru.equals("")) JenisRamenBaru = this.Jenis;       
        
        System.out.println("Berat Ramyeon Lama:  " + this.Berat);
        System.out.print("Masukkan Berat Ramyeon Baru:  ");
        int BeratRamenBaru =  Main.CheckInt();
        if (BeratRamenBaru == 99) return;
        else if (BeratRamenBaru <= 0) BeratRamenBaru = this.Berat;    
        
        System.out.println("Stok Ramyeon Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Ramyeon Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Ramyeon Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Ramyeon Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Bahan = BahanRamenBaru;
        this.Jenis = JenisRamenBaru;
         this.Berat = BeratRamenBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Bahan Ramyeon");
        System.out.printf("%-" + ColumnWidth + "s", "Jenis Ramyeon");
         System.out.printf("%-" + ColumnWidth + "s", "Berat Ramyeon");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Ramyeon ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Ramyeon");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Bahan);
        System.out.printf("%-" + ColumnWidth + "s", this.Jenis);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Fishcake extends Produk{
    String Bahan;
    int Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Utama Fishcake : ");
            String BahanFishcake = br.readLine();
            if (BahanFishcake.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Fishcake : ");
            int BeratFishcake =  Main.CheckInt();
            if (BeratFishcake <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Fishcake : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Fishcake :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Bahan = BahanFishcake;
            this.Berat = BeratFishcake;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Fishcake Lama: " + this.Bahan);
        System.out.print("Masukkan Bahan Fishcake Baru: ");
        String BahanFishcakeBaru = br.readLine();
        if (BahanFishcakeBaru.equals("99")) return;
        else if (BahanFishcakeBaru.equals("")) BahanFishcakeBaru = this.Bahan;
        
        System.out.println("Berat Fishcake Lama:  " + this.Berat);
        System.out.print("Masukkan Berat Fishcake Baru:  ");
        int BeratFishcakeBaru =  Main.CheckInt();
        if (BeratFishcakeBaru == 99) return;
        else if (BeratFishcakeBaru <= 0) BeratFishcakeBaru = this.Berat;     
        
        System.out.println("Stok Fishcake Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Fishcake Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Fishcake Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Fishcake Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Bahan = BahanFishcakeBaru;
        this.Berat = BeratFishcakeBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Bahan Fishcake");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Fishcake");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Fishcake ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Fishcake");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Bahan);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class KoreanSauce extends Produk{
    String Jenis;
    int Berat;
    
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
                
            System.out.print("Masukkan Jenis Sauce : ");
            String JenisSauce = br.readLine();
            if (JenisSauce.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Isi Bersih Sauce (ml) : ");
            int BeratSauce =  Main.CheckInt();
            if (BeratSauce <= 0) throw new IllegalArgumentException();           
            
            System.out.print("Masukkan Stok Sauce : ");
            int StokSauce =  Main.CheckInt();
            if (StokSauce <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga v :Rp. ");
            int HargaSauce =  Main.CheckInt();
            if (HargaSauce <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Jenis = JenisSauce;
            this.Berat = BeratSauce;
            this.Stok = StokSauce;
            this.Harga = HargaSauce;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaSauceBaru = br.readLine();
        if (NamaSauceBaru.equals("99")) return;
        else if (NamaSauceBaru.equals("")) NamaSauceBaru = this.Nama;
        
        System.out.println("Jenis Sauce Lama: " + this.Jenis);
        System.out.print("Masukkan Jenis Sauce Baru: ");
        String JenisSauceBaru = br.readLine();
        if (JenisSauceBaru.equals("99")) return;
        else if (JenisSauceBaru.equals("")) JenisSauceBaru = this.Jenis;        
        
        System.out.println("Isi Bersih Sauce(ml) Lama: " + this.Berat);
        System.out.print("Masukkan Isi Bersih Sauce(ml) Baru: ");
        int BeratSauceBaru =  Main.CheckInt();
        if (BeratSauceBaru == 99) return;
        else if (BeratSauceBaru <= 0) BeratSauceBaru = this.Berat;        
        
        System.out.println("Stok Sauce Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Sauce Baru:  ");
        int StokSauceBaru =  Main.CheckInt();
        if (StokSauceBaru == 99) return;
        else if (StokSauceBaru <= 0) StokSauceBaru = this.Stok;

        System.out.println("Harga Sauce Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Sauce Baru: Rp. ");
        int HargaSauceBaru =  Main.CheckInt();
        if (HargaSauceBaru == 99) return;
        else if (HargaSauceBaru <= 0) HargaSauceBaru = this.Harga;
        
        this.Nama = NamaSauceBaru;
        this.Jenis = JenisSauceBaru;
        this.Berat = BeratSauceBaru;
        this.Stok = StokSauceBaru;
        this.Harga = HargaSauceBaru;
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Sauce");
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Sauce");
        System.out.printf("%-" + ColumnWidth + "s", "Isi Bersih Sauce");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Sauce");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Sauce");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Jenis);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class KoreanDrink extends Produk{
    String Varian;    
    int Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Varian Minuman: ");            
            String VarianMinuman = br.readLine();
            if (VarianMinuman.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Minuman : ");
            int BeratMinuman =  Main.CheckInt();
            if (BeratMinuman <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Minuman : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Minuman :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Varian = VarianMinuman;
            this.Berat = BeratMinuman;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaMinumanBaru = br.readLine();
        if (NamaMinumanBaru.equals("99")) return;
        else if (NamaMinumanBaru.equals("")) NamaMinumanBaru = this.Nama;
        
        System.out.println("Varian Minuman Lama: " + this.Varian);
        System.out.print("Masukkan Varian Minuman Baru: ");
        String VarianMinumanBaru = br.readLine();
        if (VarianMinumanBaru.equals("99")) return;
        else if (VarianMinumanBaru.equals("")) VarianMinumanBaru = this.Varian;
        
        System.out.println("Berat Minuman Lama: " + this.Berat);
        System.out.print("Masukkan Berat Minuman Baru: ");
        int BeratMinumanBaru =  Main.CheckInt();
        if (BeratMinumanBaru == 99) return;
        else if (BeratMinumanBaru <= 0) BeratMinumanBaru = this.Berat;     
        
        System.out.println("Stok Minuman Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Minuman Baru:  ");
        int StokMinumanBaru =  Main.CheckInt();
        if (StokMinumanBaru == 99) return;
        else if (StokMinumanBaru <= 0) StokMinumanBaru = this.Stok;

        System.out.println("Harga Minuman Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Minuman Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaMinumanBaru;
        this.Varian = VarianMinumanBaru;
        this.Berat = BeratMinumanBaru;
        this.Stok = StokMinumanBaru;
        this.Harga = HargaBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Varian Minuman");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Minuman");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Minuman");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Minuman");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Varian);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class KoreanSnack extends Produk{
    String Varian;    
    int Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Varian Snack: ");            
            String VarianSnack = br.readLine();
            if (VarianSnack.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Snack (mg) : ");
            int BeratSnack =  Main.CheckInt();
            if (BeratSnack <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Snack : ");
            int StokSnack =  Main.CheckInt();
            if (StokSnack <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Snack :Rp. ");
            int HargaSnack =  Main.CheckInt();
            if (HargaSnack <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Varian = VarianSnack;
            this.Berat = BeratSnack;
            this.Stok = StokSnack;
            this.Harga = HargaSnack;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaSnackBaru = br.readLine();
        if (NamaSnackBaru.equals("99")) return;
        else if (NamaSnackBaru.equals("")) NamaSnackBaru = this.Nama;
        
        System.out.println("Varian Snack Lama: " + this.Varian);
        System.out.print("Masukkan Varian Snack Baru: ");
        String VarianSnackBaru = br.readLine();
        if (VarianSnackBaru.equals("99")) return;
        else if (VarianSnackBaru.equals("")) VarianSnackBaru = this.Varian;
        
        System.out.println("Berat Snack Lama (mg): " + this.Berat);
        System.out.print("Masukkan Berat Snack Baru (mg): ");
        int BeratSnackBaru =  Main.CheckInt();
        if (BeratSnackBaru == 99) return;
        else if (BeratSnackBaru <= 0) BeratSnackBaru = this.Berat;       
        
        System.out.println("Stok Snack Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Snack Baru:  ");
        int StokSnackBaru =  Main.CheckInt();
        if (StokSnackBaru == 99) return;
        else if (StokSnackBaru <= 0) StokSnackBaru = this.Stok;

        System.out.println("Harga Snack Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Snack Baru: Rp. ");
        int HargaSnackBaru =  Main.CheckInt();
        if (HargaSnackBaru == 99) return;
        else if (HargaSnackBaru <= 0) HargaSnackBaru = this.Harga;
        
        this.Nama = NamaSnackBaru;
        this.Varian = VarianSnackBaru;
        this.Berat = BeratSnackBaru;
        this.Stok = StokSnackBaru;
        this.Harga = HargaSnackBaru;
        
    }
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int JenisWidth = 15;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk");
        System.out.printf("%-" + JenisWidth + "s", "Jenis Produk");
        System.out.printf("%-" + ColumnWidth + "s", "Varian Snack");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Snack");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Snack");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Snack");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 5; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
        System.out.printf("%-" + IDWidth + "d", this.ID);
        System.out.printf("%-" + ColumnWidth + "s", this.Nama);
        System.out.printf("%-" + JenisWidth + "s", this.getClass().getSimpleName());
        System.out.printf("%-" + ColumnWidth + "s", this.Varian);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}
    
class CustomKPOP extends ProdukKPOP{
    String Kategori;
        
    @Override
    Produk TambahProduk(){
        ArrayList<String> Prod = new ArrayList<>(Arrays.asList(
        "ALBUM", "LIGHTSTICK", "LIGHT STICK", "POSTER",
        "POSTCARD", "POST CARD", "PHOTOCARD", "PHOTO CARD", 
        "KEYRING", "KEY RING","LANYARD", "TTEOKBEOKKI", "TOPOKKI",
        "RAMYEON", "FISHCAKE", "FISH CAKE", "EOMUK", "KOREANSAUCE",
        "KOREAN SAUCE", "KOREANDRINK", "KOREAN DRINK", "KOREANSNACK",
        "KOREAN SNACK"));
        
        try{
            System.out.println("(Kategori nantinya tidak dapat diubah)");
            System.out.print("Masukkan Kategori Produk : ");
            String KategoriProduk = br.readLine();
            if (KategoriProduk.equals("")) throw new IllegalArgumentException();
            
            int check = Prod.indexOf(KategoriProduk.toUpperCase());
            if(check != -1){
                System.out.println("Kategori produk tersebut sudah ada, beralih ke"
                                 + "form penambahan kategori produk tersebut (Y/N)?");
                System.out.println("(Sangat Disarankan)");
                System.out.print(" :>> ");
                String Conf = br.readLine();
                if(Conf.toUpperCase().equals("Y")){
                    switch (check) {
                        case 0 -> {return (new Album()).TambahProduk();}
                        case 1, 2 -> {return (new LightStick()).TambahProduk();}
                        case 3 -> {return (new Poster()).TambahProduk();}
                        case 4, 5 -> {return (new Postcard()).TambahProduk();}
                        case 6, 7 -> {return (new Photocard()).TambahProduk();}
                        case 8, 9 -> {return (new Keyring()).TambahProduk();}
                        case 10 -> {return (new Lanyard()).TambahProduk();}
                        case 11 -> {return (new Kimchi()).TambahProduk();}
                        case 12 -> {return (new Tteokbokki()).TambahProduk();}
                        case 13 -> {return (new Ramyeon()).TambahProduk();}
                        case 14, 15, 16 -> {return (new Fishcake()).TambahProduk();}
                        case 17, 18 -> {return (new KoreanSauce()).TambahProduk();}
                        case 19, 20 -> {return (new KoreanDrink()).TambahProduk();}
                        case 21, 22 -> {return (new KoreanSnack()).TambahProduk();}
                    }
                }
            }
            
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Nama Idol/Grup : ");
            String NamaIdol = br.readLine();
            if (NamaIdol.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok : ");
            int StokProduk = Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga : Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Kategori = KategoriProduk;
            this.Nama = NamaProduk;
            this.Idol = NamaIdol;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;

        System.out.println("Nama Idol/Grup Lama: " + this.Idol);
        System.out.print("Masukkan Nama Idol/Grup Baru: ");
        String IdolBaru = br.readLine();
        if (IdolBaru.equals("99")) return;
        else if (IdolBaru.equals("")) IdolBaru = this.Idol;
        
        System.out.println("Stok Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
    } 
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID ");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk ");
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Produk ");
        System.out.printf("%-" + ColumnWidth + "s", "Idol/Idol Group ");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Produk ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Produk ");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 6; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
            System.out.printf("%-" + IDWidth + "d", this.ID);
            System.out.printf("%-" + ColumnWidth + "s", this.Nama);
            System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
            System.out.printf("%-" + ColumnWidth + "s", this.Idol);
            System.out.printf("%-" + ColumnWidth + "d", this.Stok);
            System.out.printf("%-" + ColumnWidth + "d", this.Harga);
            System.out.println();
    }
}

class CustomFood extends Produk{
    String Kategori;
        
    @Override
    Produk TambahProduk(){
        ArrayList<String> Prod = new ArrayList<>(Arrays.asList(
        "ALBUM", "LIGHTSTICK", "LIGHT STICK", "POSTER",
        "POSTCARD", "POST CARD", "PHOTOCARD", "PHOTO CARD", 
        "KEYRING", "KEY RING","LANYARD", "TTEOKBEOKKI", "TOPOKKI",
        "RAMYEON", "FISHCAKE", "FISH CAKE", "EOMUK", "KOREANSAUCE",
        "KOREAN SAUCE", "KOREANDRINK", "KOREAN DRINK", "KOREANSNACK",
        "KOREAN SNACK"));
        
        try{
            System.out.println("(Kategori nantinya tidak dapat diubah)");
            System.out.print("Masukkan Kategori Produk : ");
            String KategoriProduk = br.readLine();
            if (KategoriProduk.equals("")) throw new IllegalArgumentException();
            
            int check = Prod.indexOf(KategoriProduk.toUpperCase());
            if(check != -1){
                System.out.println("Kategori produk tersebut sudah ada, beralih ke"
                                 + "form penambahan kategori produk tersebut (Y/N)?");
                System.out.println("(Sangat Disarankan)");
                System.out.print(" :>> ");
                String Conf = br.readLine();
                if(Conf.toUpperCase().equals("Y")){
                    switch (check) {
                        case 0 -> {return (new Album()).TambahProduk();}
                        case 1, 2 -> {return (new LightStick()).TambahProduk();}
                        case 3 -> {return (new Poster()).TambahProduk();}
                        case 4, 5 -> {return (new Postcard()).TambahProduk();}
                        case 6, 7 -> {return (new Photocard()).TambahProduk();}
                        case 8, 9 -> {return (new Keyring()).TambahProduk();}
                        case 10 -> {return (new Lanyard()).TambahProduk();}
                        case 11 -> {return (new Kimchi()).TambahProduk();}
                        case 12 -> {return (new Tteokbokki()).TambahProduk();}
                        case 13 -> {return (new Ramyeon()).TambahProduk();}
                        case 14, 15, 16 -> {return (new Fishcake()).TambahProduk();}
                        case 17, 18 -> {return (new KoreanSauce()).TambahProduk();}
                        case 19, 20 -> {return (new KoreanDrink()).TambahProduk();}
                        case 21, 22 -> {return (new KoreanSnack()).TambahProduk();}
                    }
                }
            }
            
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok : ");
            int StokProduk = Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Kategori = KategoriProduk;
            this.Nama = NamaProduk;
            this.Stok = StokProduk;
            this.Harga = HargaProduk;
            
            return this;
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return null;
        }
        
    }
    
    @Override
    void UbahProduk() throws IOException{
        System.out.println(" Kosongkan jika tidak ingin mengubah data.");
        System.out.println(" Isi dengan 99 untuk kembali");

        System.out.println("Nama Produk Lama: " + this.Nama);
        System.out.print("Masukkan Nama Produk Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Stok Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Harga Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Stok = StokProdukBaru;
        this.Harga = HargaBaru;
    } 
    
    @Override
    void TampilProduk(){
        // Mendefinisikan lebar kolom
        int IDWidth = 5;
        int ColumnWidth = 25;

        // Mencetak judul kolom
        System.out.printf("%-" + IDWidth + "s", "ID ");
        System.out.printf("%-" + ColumnWidth + "s", "Nama Produk ");
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Produk ");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Produk ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Produk ");
        System.out.println();

        // Mencetak baris pemisah
        for (int i = 0; i < ColumnWidth * 6; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Mencetak isi tabel
            System.out.printf("%-" + IDWidth + "d", this.ID);
            System.out.printf("%-" + ColumnWidth + "s", this.Nama);
            System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
            System.out.printf("%-" + ColumnWidth + "d", this.Stok);
            System.out.printf("%-" + ColumnWidth + "d", this.Harga);
            System.out.println();
    }
}
package ProjekAkhir;

import static ProjekAkhir.Produk.br;
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
        
        System.out.println("Masukkan Stok Album Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Album Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

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
        
        System.out.println("Masukkan Stok Lightstick Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Lightstick Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Lightstick Lama: Rp. " + this.Harga);
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
        System.out.printf("%-" + ColumnWidth + "s", "Harga Album");
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
        System.out.printf("%-" + ColumnWidth + "b", ((this.Baterai)? "Ya" : "Tidak"));
        System.out.printf("%-" + ColumnWidth + "s", this.VersiLightstick);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Poster extends ProdukKPOP{
    String VersiPoster;
    
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

        System.out.println("Masukkan Stok Poster Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Poster Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;
        
        System.out.println("Masukkan Harga Poster Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Poster Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Idol = IdolBaru;
        this.VersiPoster = VerPosterBaru;
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
        
        System.out.println("Masukkan Stok Postcard Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Postcard Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Postcard Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Ppostcard Baru: Rp. ");
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
        
        System.out.println("Size Photocard Lama: " + this.Size);
        System.out.print("Versi Photocard Baru: ");
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
        
        System.out.println("Masukkan Stok Photocard Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Photocard Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Photocard Lama: Rp. " + this.Harga);
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

        System.out.println("Masukkan Stok Keyring Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Keyring Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;
        
        System.out.println("Masukkan Harga Keyring Lama: Rp. " + this.Harga);
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
        System.out.print("Versi Bahan Baru: ");
        String BahanLanyard = br.readLine();
        if (BahanLanyard.equals("99")) return;
        else if (BahanLanyard.equals("")) BahanLanyard = this.Bahan;
        
        System.out.println("Masukkan Stok Lanyard Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Lanyard Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Lanyard Lama: Rp. " + this.Harga);
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

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Kimchi : ");
            String NamaKimchi = br.readLine();
            if (NamaKimchi.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Kimchi : ");
            String BahanKimchi = br.readLine();
            if (BahanKimchi.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Kimchi : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Kimchi :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaKimchi;
            this.Bahan = BahanKimchi;
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
        System.out.print("Nama Kimchi Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Kimchi Lama: " + this.Bahan);
        System.out.print("Bahan Kimchi Baru: ");
        String BahanKimchiBaru = br.readLine();
        if (BahanKimchiBaru.equals("99")) return;
        else if (BahanKimchiBaru.equals("")) BahanKimchiBaru = this.Bahan;
        
        System.out.println("Masukkan Stok Kimchi Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Kimchi Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Kimchi Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Kimchi Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Bahan = BahanKimchiBaru;
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
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Tteokbokki extends Produk{
    String Bahan;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Tteokbokki : ");
            String BahanTteokbokki = br.readLine();
            if (BahanTteokbokki.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Tteokbokki : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Tteokbokki :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Bahan = BahanTteokbokki;
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

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Versi Bahan Kimchi: " + this.Bahan);
        System.out.print("Versi Bahan Kimchi: ");
        String BahanTteokbokkiBaru = br.readLine();
        if (BahanTteokbokkiBaru.equals("99")) return;
        else if (BahanTteokbokkiBaru.equals("")) BahanTteokbokkiBaru = this.Bahan;
        
        System.out.println("Masukkan Stok Kimchi Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Kimchi Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Kimchi Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Kimchi Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Bahan = BahanTteokbokkiBaru;
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
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Ramen extends Produk{
    String Bahan;
    String Jenis;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Ramen : ");
            String BahanRamen = br.readLine();
            if (BahanRamen.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Jenis Ramen : ");
            String JenisRamen = br.readLine();
            if (BahanRamen.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Ramen : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Ramen :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Bahan = BahanRamen;
            this.Jenis = JenisRamen;
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

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Versi Bahan Ramen: " + this.Bahan);
        System.out.print("Versi Bahan Ramen: ");
        String BahanRamenBaru = br.readLine();
        if (BahanRamenBaru.equals("99")) return;
        else if (BahanRamenBaru.equals("")) BahanRamenBaru = this.Bahan;
        
        System.out.println("Versi Bahan Ramen: " + this.Bahan);
        System.out.print("Versi Bahan Ramen: ");
        String JenisRamenBaru = br.readLine();
        if (JenisRamenBaru.equals("99")) return;
        else if (JenisRamenBaru.equals("")) JenisRamenBaru = this.Bahan;       
        
        System.out.println("Masukkan Stok Ramen Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Ramen Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Ramen Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Ramen Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Bahan = BahanRamenBaru;
        this.Jenis = JenisRamenBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Bahan Ramen");
        System.out.printf("%-" + ColumnWidth + "s", "Jenis Ramen");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Ramen ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Ramen");
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
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}
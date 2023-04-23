package ProjekAkhir;

import static ProjekAkhir.Main.br;
import java.io.IOException;

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
    String Berat; 

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
            String BeratKimchi = br.readLine();
            if (BeratKimchi.equals("")) throw new IllegalArgumentException();
            
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
        System.out.print("Nama Kimchi Baru: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Kimchi Lama: " + this.Bahan);
        System.out.print("Bahan Kimchi Baru: ");
        String BahanKimchiBaru = br.readLine();
        if (BahanKimchiBaru.equals("99")) return;
        else if (BahanKimchiBaru.equals("")) BahanKimchiBaru = this.Bahan;
 
        System.out.println("Berat Kimchi Lama: " + this.Berat);
        System.out.print("Berat Kimchi Baru: ");
        String BeratKimchiBaru = br.readLine();
        if (BeratKimchiBaru.equals("99")) return;
        else if (BeratKimchiBaru.equals("")) BeratKimchiBaru = this.Berat;
        
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
    String Berat; 
    
    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Tteokbokki : ");
            String BahanTteokbokki = br.readLine();
            if (BahanTteokbokki.equals("")) throw new IllegalArgumentException();

            System.out.print("Masukkan Bahan Tteokbokki : ");
            String BeratTteokbokki = br.readLine();
            if (BeratTteokbokki.equals("")) throw new IllegalArgumentException();
            
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

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Tteokbokki Lama: " + this.Bahan);
        System.out.print("Bahan Tteokbokki Baru: ");
        String BahanTteokbokkiBaru = br.readLine();
        if (BahanTteokbokkiBaru.equals("99")) return;
        else if (BahanTteokbokkiBaru.equals("")) BahanTteokbokkiBaru = this.Bahan;

        System.out.println("Berat Tteokbokki Lama: " + this.Berat);
        System.out.print("Berat Tteokbokki Baru: ");
        String BeratTteokbokkiBaru = br.readLine();
        if (BeratTteokbokkiBaru.equals("99")) return;
        else if (BeratTteokbokkiBaru.equals("")) BeratTteokbokkiBaru = this.Berat;
        
        System.out.println("Masukkan Stok Tteokbokki Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Tteokbokki Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Tteokbokki Lama: Rp. " + this.Harga);
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
    String Berat;

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
            String BeratRamen = br.readLine();
            if (BeratRamen.equals("")) throw new IllegalArgumentException();
            
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

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Ramyeon Lama: " + this.Bahan);
        System.out.print("Bahan Ramyeon Baru: ");
        String BahanRamenBaru = br.readLine();
        if (BahanRamenBaru.equals("99")) return;
        else if (BahanRamenBaru.equals("")) BahanRamenBaru = this.Bahan;
        
        System.out.println("Jenis Ramyeon Lama: " + this.Jenis);
        System.out.print("Jenis Ramyeon Baru: ");
        String JenisRamenBaru = br.readLine();
        if (JenisRamenBaru.equals("99")) return;
        else if (JenisRamenBaru.equals("")) JenisRamenBaru = this.Jenis;       
        
        System.out.println("Berat Ramyeon Lama: " + this.Berat);
        System.out.print("Berat Ramyeon Baru: ");
        String BeratRamenBaru = br.readLine();
        if (BeratRamenBaru.equals("99")) return;
        else if (BeratRamenBaru.equals("")) BeratRamenBaru = this.Berat;     
        
        System.out.println("Masukkan Stok Ramyeon Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Ramyeon Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Ramyeon Lama: Rp. " + this.Harga);
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
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Bahan Utama Fishcake : ");
            String BahanFishcake = br.readLine();
            if (BahanFishcake.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Makanan : ");
            String BeratFishcake = br.readLine();
            if (BeratFishcake.equals("")) throw new IllegalArgumentException();
            
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

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Bahan Fishcake Lama: " + this.Bahan);
        System.out.print("Bahan Fishcake Baru: ");
        String BahanFishcakeBaru = br.readLine();
        if (BahanFishcakeBaru.equals("99")) return;
        else if (BahanFishcakeBaru.equals("")) BahanFishcakeBaru = this.Bahan;
        
        System.out.println("Berat Fishcake Lama: " + this.Berat);
        System.out.print("Berat Fishcake Baru: ");
        String BeratFishcakeBaru = br.readLine();
        if (BeratFishcakeBaru.equals("99")) return;
        else if (BeratFishcakeBaru.equals("")) BeratFishcakeBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Fishcake Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Fishcake Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Fishcake Lama: Rp. " + this.Harga);
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

class Gochujang extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriGochujang = br.readLine();
            if (KategoriGochujang.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Gochujang : ");
            String BeratFishcake = br.readLine();
            if (BeratFishcake.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Gochujang : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Gochujang :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriGochujang;
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

        System.out.println("Nama Produk Baru: " + this.Nama);
        System.out.print("Nama Produk Lama: ");
        String NamaBaru = br.readLine();
        if (NamaBaru.equals("99")) return;
        else if (NamaBaru.equals("")) NamaBaru = this.Nama;
        
        System.out.println("Kategori Gochujang Lama: " + this.Kategori);
        System.out.print("Kategori Gochujang Baru: ");
        String KategoriGochujangBaru = br.readLine();
        if (KategoriGochujangBaru.equals("99")) return;
        else if (KategoriGochujangBaru.equals("")) KategoriGochujangBaru = this.Kategori;
        
        System.out.println("Berat Gochujang Lama: " + this.Berat);
        System.out.print("Berat Gochujang Baru: ");
        String BeratGochujangBaru = br.readLine();
        if (BeratGochujangBaru.equals("99")) return;
        else if (BeratGochujangBaru.equals("")) BeratGochujangBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Gochujang Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Gochujang Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Gochujang Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Gochujang Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriGochujangBaru;
        this.Berat = BeratGochujangBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Fishcake");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class SoySauce extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriSoySauce = br.readLine();
            if (KategoriSoySauce.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Soy Sauce : ");
            String BeratSoySauce = br.readLine();
            if (BeratSoySauce.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Soy Sauce : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Soy Sauce :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriSoySauce;
            this.Berat = BeratSoySauce;
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
        
        System.out.println("Kategori Soy Sauce Lama: " + this.Kategori);
        System.out.print("Kategori Soy Sauce Baru: ");
        String KategoriSoySauceBaru = br.readLine();
        if (KategoriSoySauceBaru.equals("99")) return;
        else if (KategoriSoySauceBaru.equals("")) KategoriSoySauceBaru = this.Kategori;
        
        System.out.println("Berat Soy Sauce Lama: " + this.Berat);
        System.out.print("Berat Soy Sauce Baru: ");
        String BeratSoySauceBaru = br.readLine();
        if (BeratSoySauceBaru.equals("99")) return;
        else if (BeratSoySauceBaru.equals("")) BeratSoySauceBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Soy Sauce Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Soy Sauce Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Soy Sauce Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Soy Sauce Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriSoySauceBaru;
        this.Berat = BeratSoySauceBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Soy Sauce");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Soy Sauce");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Soy Sauce ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Soy Sauce");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class SesameSeed extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriSesameSeed = br.readLine();
            if (KategoriSesameSeed.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Sesame Seed : ");
            String BeratSSesameSeed = br.readLine();
            if (BeratSSesameSeed.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Sesame Seed : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Sesame Seed :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriSesameSeed;
            this.Berat = BeratSSesameSeed;
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
        
        System.out.println("Kategori Sesame Seed Lama: " + this.Kategori);
        System.out.print("Kategori Sesame Seed Baru: ");
        String KategoriSesameSeedBaru = br.readLine();
        if (KategoriSesameSeedBaru.equals("99")) return;
        else if (KategoriSesameSeedBaru.equals("")) KategoriSesameSeedBaru = this.Kategori;
        
        System.out.println("Berat Sesame Seed Lama: " + this.Berat);
        System.out.print("Berat Sesame Seed Baru: ");
        String BeratSesameSeedBaru = br.readLine();
        if (BeratSesameSeedBaru.equals("99")) return;
        else if (BeratSesameSeedBaru.equals("")) BeratSesameSeedBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Sesame Seed Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Sesame Seed Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Sesame Seed Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Sesame Seed Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriSesameSeedBaru;
        this.Berat = BeratSesameSeedBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Sesame Seed");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Sesame Seed");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Sesame Seed ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Sesame Seed");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class JinGanjang extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriJinGanjang = br.readLine();
            if (KategoriJinGanjang.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Jin Ganjang : ");
            String BeratJinGanjang = br.readLine();
            if (BeratJinGanjang.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Jin Ganjang : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Jin Ganjang :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriJinGanjang;
            this.Berat = BeratJinGanjang;
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
        
        System.out.println("Kategori Jin Ganjang Lama: " + this.Kategori);
        System.out.print("Kategori Jin Ganjang Baru: ");
        String KategoriJinGanjangBaru = br.readLine();
        if (KategoriJinGanjangBaru.equals("99")) return;
        else if (KategoriJinGanjangBaru.equals("")) KategoriJinGanjangBaru = this.Kategori;
        
        System.out.println("Berat Jin Ganjang Lama: " + this.Berat);
        System.out.print("Berat Jin Ganjang Baru: ");
        String BeratJinGanjangBaru = br.readLine();
        if (BeratJinGanjangBaru.equals("99")) return;
        else if (BeratJinGanjangBaru.equals("")) BeratJinGanjangBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Jin Ganjang Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Jin Ganjang Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Jin Ganjang Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Jin Ganjang Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriJinGanjangBaru;
        this.Berat = BeratJinGanjangBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Jin Ganjang");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Jin Ganjang");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Jin Ganjang ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Jin Ganjang");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Bulgogi extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriBulgogi = br.readLine();
            if (KategoriBulgogi.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Bulgogi : ");
            String BeratBulgogi = br.readLine();
            if (BeratBulgogi.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Bulgogi : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Bulgogi :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriBulgogi;
            this.Berat = BeratBulgogi;
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
        
        System.out.println("Kategori Bulgogi Lama: " + this.Kategori);
        System.out.print("Kategori Bulgogi Baru: ");
        String KategoriBulgogiBaru = br.readLine();
        if (KategoriBulgogiBaru.equals("99")) return;
        else if (KategoriBulgogiBaru.equals("")) KategoriBulgogiBaru = this.Kategori;
        
        System.out.println("Berat Bulgogi Lama: " + this.Berat);
        System.out.print("Berat Bulgogi Baru: ");
        String BeratBulgogiBaru = br.readLine();
        if (BeratBulgogiBaru.equals("99")) return;
        else if (BeratBulgogiBaru.equals("")) BeratBulgogiBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Bulgogi Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Bulgogi Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Bulgogi Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Bulgogi Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriBulgogiBaru;
        this.Berat = BeratBulgogiBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Bulgogi");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Bulgogi");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Bulgogi ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Bulgogi");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Buldak extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriBuldak = br.readLine();
            if (KategoriBuldak.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Buldak : ");
            String BeratBuldak = br.readLine();
            if (BeratBuldak.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Buldak : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Buldak :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriBuldak;
            this.Berat = BeratBuldak;
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
        
        System.out.println("Kategori Buldak Lama: " + this.Kategori);
        System.out.print("Kategori Buldak Baru: ");
        String KategoriBuldakBaru = br.readLine();
        if (KategoriBuldakBaru.equals("99")) return;
        else if (KategoriBuldakBaru.equals("")) KategoriBuldakBaru = this.Kategori;
        
        System.out.println("Berat Buldak Lama: " + this.Berat);
        System.out.print("Berat Buldak Baru: ");
        String BeratBuldakBaru = br.readLine();
        if (BeratBuldakBaru.equals("99")) return;
        else if (BeratBuldakBaru.equals("")) BeratBuldakBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Buldak Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Buldak Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Buldak Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Buldak Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriBuldakBaru;
        this.Berat = BeratBuldakBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Buldak");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Buldak");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Buldak ");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Buldak");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Pepero extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriPepero = br.readLine();
            if (KategoriPepero.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Pepero : ");
            String BeratPepero = br.readLine();
            if (BeratPepero.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Pepero: ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Pepero :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriPepero;
            this.Berat = BeratPepero;
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
        
        System.out.println("Kategori Pepero Lama: " + this.Kategori);
        System.out.print("Kategori Pepero Baru: ");
        String KategoriPeperoBaru = br.readLine();
        if (KategoriPeperoBaru.equals("99")) return;
        else if (KategoriPeperoBaru.equals("")) KategoriPeperoBaru = this.Kategori;
        
        System.out.println("Berat Pepero Lama: " + this.Berat);
        System.out.print("Berat Pepero Baru: ");
        String BeratPeperoBaru = br.readLine();
        if (BeratPeperoBaru.equals("99")) return;
        else if (BeratPeperoBaru.equals("")) BeratPeperoBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Pepero Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Pepero Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Pepero Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Pepero Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriPeperoBaru;
        this.Berat = BeratPeperoBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Pepero");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Pepero");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Pepero");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Pepero");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Crown extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriCrown = br.readLine();
            if (KategoriCrown.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Crown : ");
            String BeratCrown = br.readLine();
            if (BeratCrown.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Crown : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Crown :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriCrown;
            this.Berat = BeratCrown;
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
        
        System.out.println("Kategori Crown Lama: " + this.Kategori);
        System.out.print("Kategori Crown Baru: ");
        String KategoriCrownBaru = br.readLine();
        if (KategoriCrownBaru.equals("99")) return;
        else if (KategoriCrownBaru.equals("")) KategoriCrownBaru = this.Kategori;
        
        System.out.println("Berat Crown Lama: " + this.Berat);
        System.out.print("Berat Crown Baru: ");
        String BeratCrownBaru = br.readLine();
        if (BeratCrownBaru.equals("99")) return;
        else if (BeratCrownBaru.equals("")) BeratCrownBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Crown Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Crown Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Crown Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Crown Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriCrownBaru;
        this.Berat = BeratCrownBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Crown");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Crown");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Crown");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Crown");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Nongshim extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriNongshim = br.readLine();
            if (KategoriNongshim.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Nongshim : ");
            String BeratNongshim = br.readLine();
            if (BeratNongshim.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Nongshim : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Nongshim :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriNongshim;
            this.Berat = BeratNongshim;
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
        
        System.out.println("Kategori Nongshim Lama: " + this.Kategori);
        System.out.print("Kategori Nongshim Baru: ");
        String KategoriNongshimnBaru = br.readLine();
        if (KategoriNongshimnBaru.equals("99")) return;
        else if (KategoriNongshimnBaru.equals("")) KategoriNongshimnBaru = this.Kategori;
        
        System.out.println("Berat Nongshim Lama: " + this.Berat);
        System.out.print("Berat Nongshim Baru: ");
        String BeratNongshimBaru = br.readLine();
        if (BeratNongshimBaru.equals("99")) return;
        else if (BeratNongshimBaru.equals("")) BeratNongshimBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Nongshim Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Nongshim Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Nongshim Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Nongshim Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriNongshimnBaru;
        this.Berat = BeratNongshimBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Nongshim");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Nongshim");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Nongshim");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Nongshim");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}  

class Chungwoo extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriChungwoo = br.readLine();
            if (KategoriChungwoo.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Chungwoo : ");
            String BeratChungwoo = br.readLine();
            if (BeratChungwoo.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Chungwoo : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Chungwoo :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriChungwoo;
            this.Berat = BeratChungwoo;
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
        
        System.out.println("Kategori Chungwoo Lama: " + this.Kategori);
        System.out.print("Kategori Chungwoo Baru: ");
        String KategoriChungwooBaru = br.readLine();
        if (KategoriChungwooBaru.equals("99")) return;
        else if (KategoriChungwooBaru.equals("")) KategoriChungwooBaru = this.Kategori;
        
        System.out.println("Berat Chungwoo Lama: " + this.Berat);
        System.out.print("Berat Chungwoo Baru: ");
        String BeratChungwooBaru = br.readLine();
        if (BeratChungwooBaru.equals("99")) return;
        else if (BeratChungwooBaru.equals("")) BeratChungwooBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Chungwoo Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Chungwoo Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Chungwoo Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Chungwoo Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriChungwooBaru;
        this.Berat = BeratChungwooBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Chungwoo");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Chungwoo");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Chungwoo");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Chungwoo");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}

class Woongjin extends Produk{
    String Kategori;
    String Berat;

    @Override
    Produk TambahProduk(){
        try{
            System.out.print("Masukkan Nama Produk : ");
            String NamaProduk = br.readLine();
            if (NamaProduk.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Kategori Makanan: ");
            String KategoriWoongjin = br.readLine();
            if (KategoriWoongjin.equals("")) throw new IllegalArgumentException();
     
            System.out.print("Masukkan Berat Woongjin : ");
            String BeratWoongjin = br.readLine();
            if (BeratWoongjin.equals("")) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Stok Woongjin : ");
            int StokProduk =  Main.CheckInt();
            if (StokProduk <= 0) throw new IllegalArgumentException();
            
            System.out.print("Masukkan Harga Woongjin :Rp. ");
            int HargaProduk =  Main.CheckInt();
            if (HargaProduk <= 0) throw new IllegalArgumentException();
            
            this.ID = Main.capIDProduk;
            this.Nama = NamaProduk;
            this.Kategori = KategoriWoongjin;
            this.Berat = BeratWoongjin;
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
        
        System.out.println("Kategori Woongjin Lama: " + this.Kategori);
        System.out.print("Kategori Woongjin Baru: ");
        String KategoriWoongjinBaru = br.readLine();
        if (KategoriWoongjinBaru.equals("99")) return;
        else if (KategoriWoongjinBaru.equals("")) KategoriWoongjinBaru = this.Kategori;
        
        System.out.println("Berat Woongjin Lama: " + this.Berat);
        System.out.print("Berat Woongjin Baru: ");
        String BeratWoongjinBaru = br.readLine();
        if (BeratWoongjinBaru.equals("99")) return;
        else if (BeratWoongjinBaru.equals("")) BeratWoongjinBaru = this.Berat;       
        
        System.out.println("Masukkan Stok Woongjin Lama:  " + this.Stok);
        System.out.print("Masukkan Stok Woongjin Baru:  ");
        int StokProdukBaru =  Main.CheckInt();
        if (StokProdukBaru == 99) return;
        else if (StokProdukBaru <= 0) StokProdukBaru = this.Stok;

        System.out.println("Masukkan Harga Woongjin Lama: Rp. " + this.Harga);
        System.out.print("Masukkan Harga Woongjin Baru: Rp. ");
        int HargaBaru =  Main.CheckInt();
        if (HargaBaru == 99) return;
        else if (HargaBaru <= 0) HargaBaru = this.Harga;
        
        this.Nama = NamaBaru;
        this.Kategori = KategoriWoongjinBaru;
        this.Berat = BeratWoongjinBaru;
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
        System.out.printf("%-" + ColumnWidth + "s", "Kategori Woongjin");
        System.out.printf("%-" + ColumnWidth + "s", "Berat Woongjin");
        System.out.printf("%-" + ColumnWidth + "s", "Stok Woongjin");
        System.out.printf("%-" + ColumnWidth + "s", "Harga Woongjin");
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
        System.out.printf("%-" + ColumnWidth + "s", this.Kategori);
        System.out.printf("%-" + ColumnWidth + "s", this.Berat);
        System.out.printf("%-" + ColumnWidth + "d", this.Stok);
        System.out.printf("%-" + ColumnWidth + "d", this.Harga);
        System.out.println();
    }
}
package ProjekAkhir;

/**
 *
 * @author Viabel
 */
abstract class Produk {
    protected int ID;
    protected String Nama;
    protected int Harga;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
}


abstract class ProdukKPOP extends Produk{
    protected String NamaGrup;

    public String getNamaGrup() {
        return NamaGrup;
    }

    public void setNamaGrup(String NamaGrup) {
        this.NamaGrup = NamaGrup;
    }
}

class Album extends ProdukKPOP{
    
    private String VersiAlbum;
     
    Album(int ID, String NamaProduk, String Grup, String VersiAlbum, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.VersiAlbum = VersiAlbum;
        this.Harga = Harga;
    }

    public String getVersiAlbum() {
        return VersiAlbum;
    }

    public void setVersiAlbum(String VersiAlbum) {
        this.VersiAlbum = VersiAlbum;
    }
}

class LightStick extends ProdukKPOP{
    private Boolean Baterai;
    private String VersiLightstick;
    
    LightStick(int ID, String Nama, String Grup, Boolean DilengkapiBaterai, String VersiLightstick, int Harga){
        this.ID = ID;
        this.Nama = Nama;
        this.NamaGrup = Grup;
        this.Baterai = DilengkapiBaterai;
        this.VersiLightstick = VersiLightstick;
        this.Harga = Harga;
    }

    public Boolean getBaterai() {
        return Baterai;
    }

    public void setBaterai(Boolean Baterai) {
        this.Baterai = Baterai;
    }

    public String getVersiLightstick() {
        return VersiLightstick;
    }

    public void setVersiLightstick(String VersiLightstick) {
        this.VersiLightstick = VersiLightstick;
    }
}

class Poster extends ProdukKPOP{
    private String VersiPoster;

    Poster(int ID, String NamaProduk, String Grup, String VersiPoster, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;        
        this.NamaGrup = Grup;
        this.VersiPoster = VersiPoster;
        this.Harga = Harga;
    }

    public String getVersiPoster() {
        return VersiPoster;
    }

    public void setVersiPoster(String VersiPoster) {
        this.VersiPoster = VersiPoster;
    }
}

class Postcard extends ProdukKPOP{
    private String VersiPostcard;
    private String VersiMember;
    private String Size;

    Postcard(int ID, String NamaProduk, String Grup, String Size, String VersiPostcard, String VersiMember, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Size = Size;
        this.VersiPostcard = VersiPostcard;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }

    public String getVersiPostcard() {
        return VersiPostcard;
    }

    public void setVersiPostcard(String VersiPostcard) {
        this.VersiPostcard = VersiPostcard;
    }

    public String getVersiMember() {
        return VersiMember;
    }

    public void setVersiMember(String VersiMember) {
        this.VersiMember = VersiMember;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }
}

class Photocard extends ProdukKPOP{
    private String VersiPhotocard;
    private String VersiMember;
    private String Size;

    Photocard(int ID, String NamaProduk, String Grup, String Size, String VersiPhotocard, String VersiMember, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Size = Size;
        this.VersiPhotocard = VersiPhotocard;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }

    public String getVersiPhotocard() {
        return VersiPhotocard;
    }

    public void setVersiPhotocard(String VersiPhotocard) {
        this.VersiPhotocard = VersiPhotocard;
    }

    public String getVersiMember() {
        return VersiMember;
    }

    public void setVersiMember(String VersiMember) {
        this.VersiMember = VersiMember;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }
}

class Keyring extends ProdukKPOP{
    private String VersiMember;
    private String Size;

    Keyring(int ID, String NamaProduk, String Grup,  String Size, String VersiMember, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Size = Size;
        this.VersiMember = VersiMember;
        this.Harga = Harga;
    }

    public String getVersiMember() {
        return VersiMember;
    }

    public void setVersiMember(String VersiMember) {
        this.VersiMember = VersiMember;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }
}

class Lanyard extends ProdukKPOP{
    private String Bahan;

    Lanyard(int ID, String NamaProduk, String Grup, String Bahan, int Harga){
        this.ID = ID;
        this.Nama = NamaProduk;
        this.NamaGrup = Grup;
        this.Bahan = Bahan;
        this.Harga = Harga;
    }

 
    public String getBahan() {
        return Bahan;
    }

    public void setBahan(String Bahan) {
        this.Bahan = Bahan;
    }
}
package ProjekAkhir;

import static ProjekAkhir.Main.CheckInt;
import static ProjekAkhir.Main.Opsi;
import static ProjekAkhir.Main.br;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Viabel
 */
abstract class Akun {
    protected int ID;
    protected String Nama;
    protected String Usn;
    protected String Pass;
    protected String Email;
    final protected String Otoritas;
    
    abstract void TampilAkun();
    abstract void UbahProfil() throws IOException, InterruptedException;
    
    protected Akun(String Otoritas){
        this.Otoritas = Otoritas;
    }
    
    // abstract void ubah info()

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsn() {
        return Usn;
    }

    public void setUsn(String Usn) {
        this.Usn = Usn;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    public String getOtoritas() {
        return Pass;
    }
}

class Customer extends Akun implements MultiableAcc{
    
    private String NoHP;
    private String Kota;
    private String Alamat;
    private ArrayList<Belanja> TasBelanja = new ArrayList<>();
    
    Customer(){
        super("Customer");
    }
    
    @Override
    public void TambahAkun() throws IOException, InterruptedException{
        String NamaA = "", UsnA = "", PassA = "",
                EmailA = "", KotaA = "", Nomor = "", Addr = "";
        
        int i = 0;
        
        try{
            while(i < 7){
                Main.Clear();
                System.out.println("""
                    | ------------------------------------------ |
                    |  //    Silahkan Registrasi, Kawan :)   \\\\  |
                    | ||                                      || |
                    \t\tUsername  : """ + (" ") + UsnA + "\n" +
                     """
                     \t\tPassword""" + "  : " + PassA + "\n" +
                     """                
                     \t\tNama""" + " \t  : " + NamaA + "\n" +
                     """  
                     \t\tEmail""" + " \t  : " + EmailA + "\n" +
                     """
                     \t\tNomor""" + " \t  : " + Nomor + "\n" +
                     """
                     \t\tKota""" + " \t  : " + KotaA + "\n" +
                     """ 
                     \t\tAlamat""" + "    : " + Addr + "\n" +
                     """  
                    |  ||                                     || |
                    |   \\\\                                   //  |
                    | ------------------------------------------ |
                            """);
                
                switch(i){
                    case 0 -> {
                        System.out.print(" Username : ");
                        UsnA = br.readLine();
                        if (UsnA.equals("")) throw new IllegalArgumentException();

                        for (Akun daftarAkun : Main.DaftarAkun) {
                            if (daftarAkun.getUsn() != null){
                                if(daftarAkun.getUsn().equals(UsnA)){
                                    System.out.println(" Username tersebut sudah ada.");
                                    return;
                                }
                            }
                        }
                    }

                    case 1 -> {
                        System.out.print(" Pass     : ");
                        PassA = br.readLine();
                        if (PassA.equals("")) throw new IllegalArgumentException();
                    }
                    
                    case 2 -> {
                        System.out.print(" Nama     : ");
                        NamaA = br.readLine();
                        if (NamaA.equals("")) throw new IllegalArgumentException();
                    }
                    
                    case 3 -> {
                        System.out.print(" Email    : ");
                        EmailA = br.readLine();
                        if (EmailA.equals("")) throw new IllegalArgumentException();
                    }
                    
                    case 4 -> {
                        System.out.print(" noHP     : ");
                        Nomor = br.readLine();

                        // Check apa ada yang selain integer
                        if (!Nomor.equals("")){
                            for (char ch : Nomor.toCharArray()){
                                if((int)ch < 48 || (int)ch > 57){
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                        else{
                            throw new IllegalArgumentException();
                        }                        
                    }
                    
                    case 5 -> {
                        System.out.print(" Kota   : ");
                        KotaA = br.readLine();
                        if (KotaA.equals("")) throw new IllegalArgumentException();                        
                    }
                    
                    case 6 -> {
                        System.out.print(" Alamat Lengkap: ");
                        Addr = br.readLine();
                        if (Addr.equals("")) throw new IllegalArgumentException();                        
                    }
                }
                
                i++;
                
            }
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                br.readLine();
                return;
        }

        this.ID = Main.capIDAkun;
        this.Usn = UsnA;
        this.Pass = PassA;
        this.Nama = NamaA;
        this.Email = EmailA;
        this.setNoHP(Nomor);
        this.setAlamat(Addr);
        this.setKota(KotaA);
    }
    
    
    @Override
    public boolean HapusAkun() throws IOException{
        System.out.println("Yakin hapus akun (Y/N)?");
        System.out.println(":>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        
        return Conf.equals("Y");
    }
    
    
    @Override
    public void TampilAkun(){
        System.out.println("""
           | ---------------------------------------- |
           |  //                                  \\\\  |
           | ||                                    || |
                    Nama      : """ + (" ") + this.Nama + "\n" +
            """
            \t Username""" + "  : " + this.Usn + "\n" +
            """
            \t Password""" + "  : ************  \n" +
            """
            \t Email""" + "     : "  + this.Email + "\n" +
            """
            \t Nomor""" + "     : "  + this.NoHP + "\n" +
            """
            \t Kota""" + "      : "  + this.Kota + "\n" +
            """
            \t Alamat""" + "    : "  + this.Alamat + "\n" +
            """
            | ||                                    || |
            |  \\\\                                  //  |
            | ---------------------------------------- |
                   """);
    }
    
    

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String NoHP) {
        this.NoHP = NoHP;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
    
    public String getKota() {
        return Kota;
    }

    public void setKota(String Kota) {
        this.Kota = Kota;
    }
    
    public void TasBelanjaAdd(Belanja ProdBelanja){
        this.TasBelanja.add(ProdBelanja);
    }
    
    public void TasBelanjaDel(Belanja ProdBelanja){
        this.TasBelanja.remove(ProdBelanja);
    }
    
    // Prosedur untuk menampilkan isi tas belanja
    public void FeelMyBag() throws IOException, InterruptedException{
        Main.PortToBag = false;
        
        if(this.TasBelanja.isEmpty()){
            System.out.println(" -- Tas Belanjamu Kosong -- ");
            br.readLine();
        }else{
            while(true){
                Main.Clear();
                if(this.TasBelanja.isEmpty()){
                    System.out.println(" -- Tas Belanjamu Kosong -- ");
                    br.readLine();
                    break;
                }
                System.out.println(" (Jika status barang tertulis invalid, maka stok kurang.)");
                System.out.printf("%-" + 5 + "s", "No.");
                System.out.printf("%-" + 35 + "s", "Nama Barang");
                System.out.printf("%-" + 10 + "s", "Jumlah");
                System.out.printf("%-" + 20 + "s", "Harga");
                System.out.printf("%-" + 20 + "s", "Status Barang");

                System.out.println();
                for (int j = 0; j < 20 * 5; j++) {
                    System.out.print("-");
                }
                System.out.println();

                int i = 0;

                for (Belanja BarangBelanja : TasBelanja){
                    i++;
                    BarangBelanja.TampilTas(i);
                }

                System.out.println("[99] Kembali");
                System.out.println("(Pilih barang di tas untuk melakukan pemesanan.)");

                System.out.print(" :>> ");
                Opsi = Main.CheckInt();
                
                if(Opsi == 99) return;
                else if(Opsi > this.TasBelanja.size() || Opsi < 1) continue;
                
                this.TasBelanja.get(Opsi-1).ProsesTas();
                
            }
        }
    }
    
    
    @Override
    void UbahProfil() throws IOException, InterruptedException {
        String NewNama, NewUsn, NewPass, NewEmail, KonfirPass,
               NewKota, NewAlamat, NewNomor;
        
        while(true){
            Main.Clear();

            this.TampilAkun();

            System.out.println("""
                | ---------------------------------------- |   
                |   //         Menu Ubah Profil        \\\\  |
                |  ||                                   || |
                |  ||        (99)-. Kembali             || |
                |  ||        (1)-. Ubah Data Akun       || |
                |  ||                                   || |
                |   \\\\                                 //  |
                | ---------------------------------------- |
                               """);

            System.out.print(" :>> ");
            Opsi = CheckInt();

            switch (Opsi) {
                case 99 -> {return;}
                case 1 -> {
                    Main.Clear();

                    try{
                    
                        System.out.println("\tSilahkan masukkan password\n\t    sebelum ubah data");
                        System.out.println("------------------------------------------\n");
                        System.out.print(" Masukkan Password   : ");
                        KonfirPass = br.readLine();
                        System.out.println("-----------------------------------\n");
                        if (KonfirPass.equals("")) throw new IllegalArgumentException();

                        if(!this.Pass.equals(KonfirPass)){
                            System.out.println("\n\tPassword salah");
                            br.readLine();
                            break;
                        }

                        Main.Clear();

                        System.out.println("Ketik '99' untuk kembali");
                        System.out.println("Ketik '0' untuk menggunakan data lama");
                        System.out.println("\n\tMasukkan Data Akun Baru");
                        System.out.println("---------------------------------------\n");
                        System.out.println("Nama Lama: " + this.Nama);
                        System.out.print("Masukkan Nama Baru: ");
                        NewNama = br.readLine();
                        switch (NewNama) {
                            case "99" -> {continue;}
                            case "0" -> NewNama = this.Nama;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Username Lama: " + this.Usn);
                        System.out.print("Username Baru: ");
                        NewUsn = br.readLine();
                        switch (NewUsn) {
                            case "99" -> {continue;}
                            case "0" -> NewUsn = this.Usn;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Password Lama: *******");
                        System.out.print("Password Baru: ");
                        NewPass = br.readLine();
                        switch (NewPass) {
                            case "99" -> {continue;}
                            case "0" -> NewPass = this.Pass;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Email Lama: " + this.Email);
                        System.out.print("Email Baru: ");
                        NewEmail = br.readLine();
                        switch (NewEmail) {
                            case "99" -> {continue;}
                            case "0" -> NewEmail = this.Email;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("noHP Lama: " + this.NoHP);
                        System.out.print("noHP Baru: ");
                        NewNomor = br.readLine();

                        if (NewNomor.equals("99")) {continue;}
                        if (NewNomor.equals("0")) NewNomor = this.NoHP;
                        if (!NewNomor.equals("")){
                            for (char ch : NewNomor.toCharArray()){
                                if((int)ch < 48 || (int)ch > 57){
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                        else{
                            throw new IllegalArgumentException();
                        }

                        System.out.println("Kota Lama: " + this.Kota);
                        System.out.print("Kota Baru: ");
                        NewKota = br.readLine();
                        switch (NewKota) {
                            case "99" -> {continue;}
                            case "0" -> NewKota = this.Kota;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Alamat Lama: " + this.Alamat);
                        System.out.print("Alamat Baru: ");
                        NewAlamat = br.readLine();
                        switch (NewAlamat) {
                            case "99" -> {continue;}
                            case "0" -> NewAlamat = this.Alamat;
                            case "" -> throw new IllegalArgumentException();
                        }

                        this.Nama = NewNama;
                        this.Usn = NewUsn;
                        this.Pass = NewPass;
                        this.Email = NewEmail;
                        this.NoHP = NewNomor;
                        this.Kota = NewKota;
                        this.Alamat = NewAlamat;


                        Main.Clear();
                        System.out.println("\t     Berhasil ubah akun\n");
                        br.readLine();
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(" Terjadi error saat menginput data.");
                    }
                }
            }
        }
    }
    
}


class Seller extends Akun implements MultiableAcc{
    private int TokoKu;
    
    Seller(){
        super("Seller");
    }
    
    @Override
    public void TambahAkun() throws IOException, InterruptedException{
        String NamaSeller = "", UsnSeller = "", PassSeller = "", EmailSeller = "";
        int i = 0;
        
        try{
            while(i < 5){
                Main.Clear();
                System.out.println("""
                    | ------------------------------------------ |
                    |   //  Silahkan Tambah Akun, Seller :)   \\\\ |
                    | ||                                      || |
                    \tUsername  : """ + (" ") + UsnSeller + "\n" +
                     """
                     \tPassword""" + "  : " + PassSeller + "\n" +
                     """                
                     \tNama""" + " \t  : " + NamaSeller + "\n" +
                     """  
                     \tEmail""" + " \t  : " + EmailSeller + "\n" +
                     """
                    |  ||                                     || |
                    |   \\\\                                   //  |
                    | ------------------------------------------ |
                            """);

                switch(i){

                    case 0 ->{
                        System.out.print(" Username : ");
                        UsnSeller = br.readLine();
                        if (UsnSeller.equals("")) throw new IllegalArgumentException();


                        for (Akun daftarAkun : Main.DaftarAkun) {
                            if (daftarAkun.getUsn() != null){
                                if(daftarAkun.getUsn().equals(UsnSeller)){
                                    System.out.println(" Username tersebut sudah ada.");
                                    return;
                                }
                            }
                        }
                    }
                    case 1 ->{
                        System.out.print(" Pass     : ");
                        PassSeller = br.readLine();
                        if (PassSeller.equals("")) throw new IllegalArgumentException();
                    }
                    case 2 ->{
                        System.out.print(" Nama     : ");
                        NamaSeller = br.readLine();
                        if (NamaSeller.equals("")) throw new IllegalArgumentException();
                    }
                    case 3 ->{
                        System.out.print(" Email    : ");
                        EmailSeller = br.readLine();
                        if (EmailSeller.equals("")) throw new IllegalArgumentException();
                    }
                    case 4 ->{
                        System.out.println(" Akun Berhasil Ditambahkan !");
                        br.readLine();
                    }
                }

                i++;
            }
        } catch (IOException | IllegalArgumentException e){
            System.out.println(" Terjadi error saat menginput data.");
            return;
        }
        
        this.ID = Main.capIDAkun;
        this.Usn = UsnSeller;
        this.Pass = PassSeller;
        this.Nama = NamaSeller;
        this.Email = EmailSeller;
        this.TokoKu = -1;
        
        Main.DaftarAkun.add(this);
    }
    
    
    @Override
    public void TampilAkun(){
        System.out.println("""
           | ---------------------------------------- |
           |  //                                  \\\\  |
           | ||                                    || |
                    Nama      : """ + (" ") + this.Nama + "\n" +
            """
            \t Username""" + "  : " + this.Usn + "\n" +
            """
            \t Password""" + "  : ************  \n" +
            """
            \t Email""" + "     : "  + this.Email + "\n" +
            """
            | ||                                    || |
            |  \\\\                                  //  |
            | ---------------------------------------- |
                   """);
    }
    
    
    
    // Keluarkan dari toko
    @Override
    public boolean HapusAkun() throws IOException{
        System.out.println("Yakin hapus akun (Y/N)?");
        System.out.println("(Menghapus akun ini akan sekaligus mengeluarkannya dari Toko)");
        System.out.println(":>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        
        return Conf.equals("Y");
        
        
    }

    public int getTokoKu() {
        int i = 0;
        
        if (this.TokoKu == -1) return TokoKu;
        
        for(Toko TokoTerhubung : Main.DaftarToko){
            if (TokoTerhubung.ID == this.TokoKu) return i;
            i++;
            }
        
        return -1;
    }

    public void setTokoKu(int TokoKu) {
        this.TokoKu = TokoKu;
    }
    
    @Override
    void UbahProfil() throws IOException, InterruptedException {
        String NewNamaSeller, NewUsnSeller, NewPassSeller, NewEmailSeller, KonfirPassSeller;
        
        while(true){
            Main.Clear();

            this.TampilAkun();

            System.out.println("""
                | ---------------------------------------- |   
                |   //         Menu Ubah Profil        \\\\  |
                |  ||                                   || |
                |  ||     (99)-. Kembali                || |
                |  ||     (1)-. Ubah Data Akun Seller   || |
                |  ||                                   || |
                |   \\                                 //  |
                | ---------------------------------------- |
                               """);

            System.out.print(" :>> ");
            Opsi = CheckInt();

            switch (Opsi) {
                case 99 -> {return;}
                case 1 -> {
                    Main.Clear();

                    try{
                    
                        System.out.println("\tSilahkan Masukkan Password\n\t    Sebelum Ubah Data Akun");
                        System.out.println("------------------------------------------\n");
                        System.out.print(" Masukkan Password   : ");
                        KonfirPassSeller = br.readLine();
                        System.out.println("-----------------------------------\n");
                        if (KonfirPassSeller.equals("")) throw new IllegalArgumentException();

                        if(!this.Pass.equals(KonfirPassSeller)){
                            System.out.println("\n\tMaaf Password Anda Salah");
                            br.readLine();
                            break;
                        }

                        Main.Clear();

                        System.out.println("Ketik '99' untuk kembali");
                        System.out.println("Ketik '0' untuk menggunakan data lama");
                        System.out.println("\n\tMasukkan Data Akun Baru");
                        System.out.println("---------------------------------------\n");
                        System.out.println("Nama Lama: " + this.Nama);
                        System.out.print("Masukkan Nama Baru: ");
                        NewNamaSeller = br.readLine();
                        switch (NewNamaSeller) {
                            case "99" -> {continue;}
                            case "0" -> NewNamaSeller = this.Nama;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Username Lama: " + this.Usn);
                        System.out.print("Username Baru: ");
                        NewUsnSeller = br.readLine();
                        switch (NewUsnSeller) {
                            case "99" -> {continue;}
                            case "0" -> NewUsnSeller = this.Usn;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Password Lama: *******");
                        System.out.print("Password Baru: ");
                        NewPassSeller = br.readLine();
                        switch (NewPassSeller) {
                            case "99" -> {continue;}
                            case "0" -> NewPassSeller = this.Pass;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Email Lama: " + this.Email);
                        System.out.print("Email Baru: ");
                        NewEmailSeller = br.readLine();
                        switch (NewEmailSeller) {
                            case "99" -> {continue;}
                            case "0" -> NewEmailSeller = this.Email;
                            case "" -> throw new IllegalArgumentException();
                        }

                        this.Nama = NewNamaSeller;
                        this.Usn = NewUsnSeller;
                        this.Pass = NewPassSeller;
                        this.Email = NewEmailSeller;


                        Main.Clear();
                        System.out.println("\t     Akun Anda Berhasil Diubah\n");
                        br.readLine();
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(" Maaf Terjadi Kesalahan Saat Menginput Data.");
                    }
                }
            }
        }
    }
    
}



class Admin extends Akun{
    
    Admin(int ID, String NamaAdmin, String Username,
          String Pass, String Email){
        super("Admin");
        this.ID = ID;
        this.Nama = NamaAdmin;
        this.Usn = Username;
        this.Pass = Pass;
        this.Email = Email;
    }
    
    
    @Override
    public void TampilAkun(){
        System.out.println("""
           | ---------------------------------------- |
           |  //                                  \\\\  |
           | ||                                    || |
                    Nama      : """ + (" ") + this.Nama + "\n" +
            """
            \t Username""" + "  : " + this.Usn + "\n" +
            """
            \t Password""" + "  : ************  \n" +
            """
            \t Email""" + "     : "  + this.Email + "\n" +
            """
            | ||                                    || |
            |  \\\\                                  //  |
            | ---------------------------------------- |
                   """);
    }
    
    
    
    void manajemenSeller() throws IOException, InterruptedException {
        while(true){

            Main.Clear();
            System.out.print("""
                | ---------------------------------------- |
                |   //    Menu Utama Manajemen Seller  \\\\  |
                |  ||                                   || |
                |  ||        (99)-. Kembali             || |
                |  ||        (0)-. Tambah Seller        || |
                |  ||                                   || |
                |  ||    -. Manajemen Akun Seller .-    || |
                |  ||                                   || |
                 """);
            
            int i=1;
                    
            HashMap<Integer, Integer> AkunSeller = new HashMap<>();
            
            for (Akun seller : Main.DaftarAkun){
                if (seller.Otoritas.equals("Seller")){
                    System.out.println("\t     (" + i + ") " + seller.Nama + "");
                    AkunSeller.put(i, seller.getID());
                    i++;
                }
            }

            System.out.println("""
                |  ||                                   || |
                |   \\\\                                 //  |
                | ---------------------------------------- |
                """);

            System.out.print(" :>> ");
            Opsi = CheckInt();


            switch (Opsi) {
                case 99 -> {return;}
                case 0 -> (new Seller()).TambahAkun();
                default -> {
                    if (AkunSeller.get(Opsi) == null){
                        Main.Clear();
                        System.out.println("\n\t    Seller tidak ada\n");
                        br.readLine();
                        continue;
                    }
                    this.ManajemenAkunSeller(AkunSeller.get(Opsi));
                }
            }
        }
    }
    
    
    void ManajemenAkunSeller(int IndexSeller) throws IOException, InterruptedException  {        
        Main.Clear();
        System.out.print("""
            | ---------------------------------------- |
            |   //    Menu Manajemen Akun Seller   \\\\  |
            \t\t        """ + Main.DaftarAkun.get(IndexSeller).Nama + "\n" +
            """
            |  ||                                   || |
            |  ||     (99)-. Kembali                || |
            |  ||     (1)-. Ubah Informasi Akun     || |
            |  ||     (2)-. Hapus Akun              || |
            |  ||                                   || |
            |   \\\\                                 //  |
            | ---------------------------------------- |
            """);

        System.out.print(" :>> ");
        Opsi = CheckInt();

        switch (Opsi){
            case 99 -> {return;}
            case 1 -> {UbahProfilSeller(IndexSeller);}
            case 2 -> {
                if ((new Seller()).HapusAkun()){
                    Main.DaftarAkun.remove(IndexSeller);
                }
            }
        }
    }

    
    void UbahProfilSeller(int IndexSeller) throws IOException, InterruptedException {
        String NewUsnA, NewPassA, NewNamaA, NewEmailA, KonfirPass;
        
        Main.Clear();

        System.out.println("""
           | ---------------------------------------- |
           |  //                                  \\\\  |
           | ||                                    || |
                    Nama      : """ + (" ") + Main.DaftarAkun.get(IndexSeller).Nama + "\n" +
            """
            \t Username""" + "  : " + Main.DaftarAkun.get(IndexSeller).Usn + "\n" +
            """
            \t Password""" + "  : ************  \n" +
            """
            \t Email""" + "     : "  + Main.DaftarAkun.get(IndexSeller).Email + "\n" +
            """
            | ||                                    || |
            |  \\\\                                  //  |
            | ---------------------------------------- |
                   """);

        br.readLine();
        Main.Clear();

        try{
            System.out.println("\tSilahkan masukkan password\n\t    sebelum ubah data");
            System.out.println("------------------------------------------\n");
            System.out.print(" Masukkan Password   : ");
            KonfirPass = br.readLine();
            System.out.println("-----------------------------------\n");
            if (KonfirPass.equals("")) throw new IllegalArgumentException();

            if(!this.Pass.equals(KonfirPass)){
                System.out.println("\n\tPassword salah");
                br.readLine();
                return;
            }

            Main.Clear();

            System.out.println("Ketik '99' untuk kembali");
            System.out.println("Ketik '0' untuk menggunakan data lama");
            System.out.println("\n\tMasukkan Data Akun Baru");
            System.out.println("---------------------------------------\n");
            System.out.println("Nama Lama: " + Main.DaftarAkun.get(IndexSeller).Nama);
            System.out.print("Masukkan Nama Baru: ");
            NewNamaA = br.readLine();
            switch (NewNamaA) {
                case "99" -> {return;}
                case "0" -> NewNamaA = Main.DaftarAkun.get(IndexSeller).Nama;
                case "" -> throw new IllegalArgumentException();
            }

            System.out.println("Username Lama: " + Main.DaftarAkun.get(IndexSeller).Usn);
            System.out.print("Username Baru: ");
            NewUsnA = br.readLine();
            switch (NewUsnA) {
                case "99" -> {return;}
                case "0" -> NewUsnA = Main.DaftarAkun.get(IndexSeller).Usn;
                case "" -> throw new IllegalArgumentException();
            }

            System.out.println("Password Lama: *******");
            System.out.print("Password Baru: ");
            NewPassA = br.readLine();
            switch (NewPassA) {
                case "99" -> {return;}
                case "0" -> NewPassA = Main.DaftarAkun.get(IndexSeller).Pass;
                case "" -> throw new IllegalArgumentException();
            }

            System.out.println("Email Lama: " + Main.DaftarAkun.get(IndexSeller).Email);
            System.out.print("Email Baru: ");
            NewEmailA = br.readLine();
            switch (NewEmailA) {
                case "99" -> {return;}
                case "0" -> NewEmailA = Main.DaftarAkun.get(IndexSeller).Email;
                case "" -> throw new IllegalArgumentException();
            }

            Main.DaftarAkun.get(IndexSeller).setNama(NewNamaA);
            Main.DaftarAkun.get(IndexSeller).setUsn(NewUsnA);
            Main.DaftarAkun.get(IndexSeller).setPass(NewPassA);
            Main.DaftarAkun.get(IndexSeller).setEmail(NewEmailA);

            Main.Clear();
            System.out.println("\t     Berhasil ubah akun\n");
            br.readLine();
        }
        catch(IllegalArgumentException e){
            System.out.println(" Terjadi error saat menginput data.");
            br.readLine();
        }
    }
    
    
    @Override
    void UbahProfil() throws IOException, InterruptedException {
        String NewNama, NewUsn, NewPass, NewEmail, KonfirPass;
        
        while(true){
            Main.Clear();

            this.TampilAkun();

            System.out.println("""
                | ---------------------------------------- |   
                |   //         Menu Ubah Profil        \\\\  |
                |  ||                                   || |
                |  ||        (99)-. Kembali             || |
                |  ||        (1)-. Ubah Data Akun       || |
                |  ||                                   || |
                |   \\\\                                 //  |
                | ---------------------------------------- |
                               """);

            System.out.print(" :>> ");
            Opsi = CheckInt();

            switch (Opsi) {
                case 99 -> {return;}
                case 1 -> {
                    Main.Clear();

                    try{
                        System.out.println("\tSilahkan masukkan password\n\t    sebelum ubah data");
                        System.out.println("------------------------------------------\n");
                        System.out.print(" Masukkan Password   : ");
                        KonfirPass = br.readLine();
                        System.out.println("-----------------------------------\n");
                        if (KonfirPass.equals("")) throw new IllegalArgumentException();

                        if(!this.Pass.equals(KonfirPass)){
                            System.out.println("\n\tPassword salah");
                            br.readLine();
                            break;
                        }

                        Main.Clear();

                        System.out.println("Ketik '99' untuk kembali");
                        System.out.println("Ketik '0' untuk menggunakan data lama");
                        System.out.println("\n\tMasukkan Data Akun Baru");
                        System.out.println("---------------------------------------\n");
                        System.out.println("Nama Lama: " + this.Nama);
                        System.out.print("Masukkan Nama Baru: ");
                        NewNama = br.readLine();
                        switch (NewNama) {
                            case "99" -> {continue;}
                            case "0" -> NewNama = this.Nama;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Username Lama: " + this.Usn);
                        System.out.print("Username Baru: ");
                        NewUsn = br.readLine();
                        switch (NewUsn) {
                            case "99" -> {continue;}
                            case "0" -> NewUsn = this.Usn;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Password Lama: *******");
                        System.out.print("Password Baru: ");
                        NewPass = br.readLine();
                        switch (NewPass) {
                            case "99" -> {continue;}
                            case "0" -> NewPass = this.Pass;
                            case "" -> throw new IllegalArgumentException();
                        }

                        System.out.println("Email Lama: " + this.Email);
                        System.out.print("Email Baru: ");
                        NewEmail = br.readLine();
                        switch (NewEmail) {
                            case "99" -> {continue;}
                            case "0" -> NewEmail = this.Email;
                            case "" -> throw new IllegalArgumentException();
                        }

                        this.Nama = NewNama;
                        this.Usn = NewUsn;
                        this.Pass = NewPass;
                        this.Email = NewEmail;

                        Main.Clear();
                        System.out.println("\t     Berhasil ubah akun\n");
                        br.readLine();
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(" Terjadi error saat menginput data.");
                        br.readLine();
                    }
                }
            }
        }
    }
}


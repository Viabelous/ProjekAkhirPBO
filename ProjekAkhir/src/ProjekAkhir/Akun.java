package ProjekAkhir;

import static ProjekAkhir.Main.CheckInt;
import static ProjekAkhir.Main.Opsi;
import static ProjekAkhir.Main.br;
import java.io.IOException;
import java.util.ArrayList;

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
        String NamaA, UsnA, PassA, EmailA, KotaA, Nomor, Addr;

        try{
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |   //   Silahkan Registrasi, Kawan :)   \\\\  |
                |  ||                                     || |
                |  ||           Username  :               || |
                |  ||           Password  :               || |
                |  ||           Nama      :               || |
                |  ||           Email     :               || |
                |  ||           Nomor     :               || |
                |  ||           Kota      :               || |
                |  ||           Alamat    :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);

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
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |  //    Silahkan Registrasi, Kawan :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                |  ||           Password  :               || |
                |  ||           Nama      :               || |
                |  ||           Email     :               || |
                |  ||           Nomor     :               || |
                |  ||           Kota      :               || |
                |  ||           Alamat    :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);

            System.out.print(" Pass     : ");
            PassA = br.readLine();
            if (PassA.equals("")) throw new IllegalArgumentException();
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |  //    Silahkan Registrasi, Kawan :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                 \t\tPassword""" + "  : " + PassA + "\n" +
                 """                
                |  ||           Nama      :               || |
                |  ||           Email     :               || |
                |  ||           Nomor     :               || |
                |  ||           Kota      :               || |
                |  ||           Alamat    :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);

            System.out.print(" Nama     : ");
            NamaA = br.readLine();
            if (NamaA.equals("")) throw new IllegalArgumentException();

            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |  //    Silahkan Registrasi, Kawan :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                 \t\tPassword""" + "  : " + PassA + "\n" +
                 """                
                 \t\tNama""" + " \t  : " + PassA + "\n" +
                 """  
                |  ||           Email     :               || |
                |  ||           Nomor     :               || |
                |  ||           Kota      :               || |
                |  ||           Alamat    :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);

            System.out.print(" Email    : ");
            EmailA = br.readLine();
            if (EmailA.equals("")) throw new IllegalArgumentException();
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |  //    Silahkan Registrasi, Kawan :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                 \t\tPassword""" + "  : " + PassA + "\n" +
                 """                
                 \t\tNama""" + " \t  : " + PassA + "\n" +
                 """  
                 \t\tEmail""" + " \t  : " + EmailA + "\n" +
                 """
                |  ||           Nomor     :               || |
                |  ||           Kota      :               || |
                |  ||           Alamat    :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);
            
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
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |  //    Silahkan Registrasi, Kawan :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                 \t\tPassword""" + "  : " + PassA + "\n" +
                 """                
                 \t\tNama""" + " \t  : " + PassA + "\n" +
                 """  
                 \t\tEmail""" + " \t  : " + EmailA + "\n" +
                 """
                 \t\tNomor""" + " \t  : " + Nomor + "\n" +
                 """
                |  ||           Kota      :               || |
                |  ||           Alamat    :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);
            
            System.out.print(" Kota   : ");
            KotaA = br.readLine();
            if (KotaA.equals("")) throw new IllegalArgumentException();
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |  //    Silahkan Registrasi, Kawan :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                 \t\tPassword""" + "  : " + PassA + "\n" +
                 """                
                 \t\tNama""" + " \t  : " + PassA + "\n" +
                 """  
                 \t\tEmail""" + " \t  : " + EmailA + "\n" +
                 """
                 \t\tNomor""" + " \t  : " + Nomor + "\n" +
                 """
                 \t\tKota""" + " \t  : " + KotaA + "\n" +
                 """ 
                |  ||           Alamat    :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);

            System.out.print(" Alamat Lengkap: ");
            Addr = br.readLine();
            if (Addr.equals("")) throw new IllegalArgumentException();
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                br.readLine();
                return;
        }
        
        Main.Clear();
        System.out.println("""
            | ------------------------------------------ |
            |  //    Silahkan Registrasi, Kawan :)   \\\\  |
            | ||                                      || |
             \t\tUsername""" + "  : " + UsnA + "\n" +
             """
             \t\tPassword""" + "  : " + PassA + "\n" +
             """                
             \t\tNama""" + " \t  : " + PassA + "\n" +
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
    
    // Prosedur untuk menampilkan isi tas belanja
    public void FeelMyBag() throws IOException, InterruptedException{
        Main.PortToBag = false;
        
        if(this.TasBelanja.isEmpty()){
            System.out.println(" -- Tas Belanjamu Kosong -- ");
            br.readLine();
        }else{
            Main.Clear();
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
            br.readLine();
        }
    }
    
    
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
        String NamaA, UsnA, PassA, EmailA;
        
        
        try{
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |   //  Silahkan Tambah Akun, Admin :)   \\\\  |
                |  ||                                     || |
                |  ||           Username  :               || |
                |  ||           Password  :               || |
                |  ||           Nama      :               || |
                |  ||           Email     :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);

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
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |   //  Silahkan Tambah Akun, Admin :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                |  ||           Password  :               || |
                |  ||           Nama      :               || |
                |  ||           Email     :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);
            
            System.out.print(" Pass     : ");
            PassA = br.readLine();
            if (PassA.equals("")) throw new IllegalArgumentException();
            
            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |   //  Silahkan Tambah Akun, Admin :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                 \t\tPassword""" + "  : " + PassA + "\n" +
                 """                
                |  ||           Nama      :               || |
                |  ||           Email     :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);
            
            System.out.print(" Nama     : ");
            NamaA = br.readLine();
            if (NamaA.equals("")) throw new IllegalArgumentException();

            Main.Clear();
            System.out.println("""
                | ------------------------------------------ |
                |   //  Silahkan Tambah Akun, Admin :)   \\\\  |
                | ||                                      || |
                 \t\tUsername""" + "  : " + UsnA + "\n" +
                 """
                 \t\tPassword""" + "  : " + PassA + "\n" +
                 """                
                 \t\tNama""" + " \t  : " + PassA + "\n" +
                 """  
                |  ||           Email     :               || |
                |  ||                                     || |
                |   \\\\                                   //  |
                | ------------------------------------------ |
                        """);
            
            System.out.print(" Email    : ");
            EmailA = br.readLine();
            if (EmailA.equals("")) throw new IllegalArgumentException();
           
            
        } catch (IOException | IllegalArgumentException e){
            System.out.println(" Terjadi error saat menginput data.");
            return;
        }

        Main.Clear();
        System.out.println("""
            | ------------------------------------------ |
            |   //  Silahkan Tambah Akun, Admin :)   \\\\  |
            | ||                                      || |
             \t\tUsername""" + "  : " + UsnA + "\n" +
             """
             \t\tPassword""" + "  : " + PassA + "\n" +
             """                
             \t\tNama""" + " \t  : " + PassA + "\n" +
             """  
             \t\tEmail""" + " \t  : " + EmailA + "\n" +
             """
            |  ||                                     || |
            |   \\\\                                   //  |
            | ------------------------------------------ |
                    """);
        
        this.ID = Main.capIDAkun;
        this.Usn = UsnA;
        this.Pass = PassA;
        this.Nama = NamaA;
        this.Email = EmailA;
        this.TokoKu = -1;

        System.out.println(" Akun Berhasil Ditambahkan !");
        br.readLine();
    }
    
    
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
                 |  ||         -. Hapus Seller .-        || |
                 |  ||                                   || |
                 """);
            
            int i=1;
                    
            for (Akun seller : Main.DaftarAkun){
                if (seller.Otoritas.equals("Seller")){
                    System.out.println("|  ||\t\t (" + i + ") " + seller.Nama + "\t\t|| |");
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
            
            
            // need error handling
            switch (Opsi) {
                case 99 -> {return;}
                case 0 -> (new Seller()).TambahAkun();
                default -> {
                    boolean validation = (new Seller()).HapusAkun();

                    if (validation){
                        Main.DaftarAkun.remove(Opsi-1);
                    }
                }
            }
        }
    }
    
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


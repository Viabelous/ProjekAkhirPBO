package ProjekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    
    protected Akun(String Otoritas){
        this.Otoritas = Otoritas;
    }
    
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
    //abstract void UbahInfo();

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
    private String Alamat;
    
    Customer(){
        super("Customer");
    }
    
    @Override
    public void TambahAkun(){
        String NamaA, UsnA, PassA, EmailA, Nomor, Addr;

        try{
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
            
            
            System.out.print(" Pass     : ");
            PassA = br.readLine();
            if (PassA.equals("")) throw new IllegalArgumentException();
            
            
            System.out.print(" Nama     : ");
            NamaA = br.readLine();
            if (NamaA.equals("")) throw new IllegalArgumentException();

            
            System.out.print(" Email    : ");
            EmailA = br.readLine();
            if (EmailA.equals("")) throw new IllegalArgumentException();
            
            
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
            
            
            System.out.print(" Alamat   : ");
            Addr = br.readLine();
            if (Addr.equals("")) throw new IllegalArgumentException();
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return;
        }
        
        this.ID = Main.capIDAkun;
        this.Usn = UsnA;
        this.Pass = PassA;
        this.Nama = NamaA;
        this.Email = EmailA;
        this.NoHP = Nomor;
        this.Alamat = Addr;
    }
    
    
    public boolean HapusAkun() throws IOException{
        System.out.println("Yakin hapus akun (Y/N)?");
        System.out.println(":>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        
        return Conf.equals("Y");
    }
}

class Seller extends Akun implements MultiableAcc{
    
    Seller(){
        super("Seller");
    }
    
    @Override
    public void TambahAkun() throws IOException{
        String NamaA, UsnA, PassA, EmailA;
        
        
        try{
            
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

            
            
            System.out.print(" Pass     : ");
            PassA = br.readLine();
            if (PassA.equals("")) throw new IllegalArgumentException();
            
            
            System.out.print(" Nama     : ");
            NamaA = br.readLine();
            if (NamaA.equals("")) throw new IllegalArgumentException();

            
            System.out.print(" Email    : ");
            EmailA = br.readLine();
            if (EmailA.equals("")) throw new IllegalArgumentException();
           
            
        } catch (IOException | IllegalArgumentException e){
            System.out.println(" Terjadi error saat menginput data.");
            return;
        }
        
        this.ID = Main.capIDAkun;
        this.Usn = UsnA;
        this.Pass = PassA;
        this.Nama = NamaA;
        this.Email = EmailA;
        
    }
    
    
    @Override
    public boolean HapusAkun() throws IOException{
        System.out.println("Yakin hapus akun (Y/N)?");
        System.out.println("(Menghapus akun ini akan sekaligus menghapus Tokomu)");
        System.out.println(":>> ");
        
        String Conf = br.readLine();
        if(Conf == null) Conf = "N";
        
        return Conf.equals("Y");
        
        
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
}

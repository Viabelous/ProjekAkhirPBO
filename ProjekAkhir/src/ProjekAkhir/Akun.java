package ProjekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Viabel
 */
abstract class Akun {
    private int ID;
    private String Nama;
    private String Usn;
    private String Pass;
    private String Email;
    
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
}

class Customer extends Akun implements MultiableAcc{
    final String Otoritas = "Customer";
    private String NoHP;
    private String Alamat;
    
    
    @Override
    public void TambahAkun(ArrayList <Akun> data){
        String Nama, Usn = null, Pass, Email, Nomor, Addr;

        try{
            System.out.print(" Username : ");
            Usn = br.readLine();
            
            for (Akun daftarAkun : data) {
                if (daftarAkun.getUsn() != null){
                    if(daftarAkun.getUsn().equals(Usn)){
                        System.out.println(" Username tersebut sudah ada.");
                        return;
                    }
                }
            }
            
            
            System.out.print(" Pass     : ");
            Pass = br.readLine();
            if (Pass == null) throw new IllegalArgumentException();
            
            
            System.out.print(" Nama     : ");
            Nama = br.readLine();
            if (Nama == null) throw new IllegalArgumentException();

            
            System.out.print(" Email    : ");
            Email = br.readLine();
            if (Email == null) throw new IllegalArgumentException();
            
            
            System.out.print(" noHP   : ");
            Nomor = br.readLine();
            if (Nomor != null){
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
            if (Addr == null) throw new IllegalArgumentException();
            
        } catch (IOException | IllegalArgumentException e){
                System.out.println(" Terjadi error saat menginput data.");
                return;
        }
        
        setUsn(Usn);
        setPass(Pass);
        setNama(Nama);
        setEmail(Email);
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
    final String Otoritas = "Seller";
    
    
    @Override
    public void TambahAkun(ArrayList <Akun> data) throws IOException{
        String Nama, Usn = null, Pass, Email;
        
        try{
            
            System.out.print(" Username : ");
            Usn = br.readLine();


            for (Akun daftarAkun : data) {
                if (daftarAkun.getUsn() != null){
                    if(daftarAkun.getUsn().equals(Usn)){
                        System.out.println(" Username tersebut sudah ada.");
                        return;
                    }
                }
            }

            
            
            System.out.print(" Pass     : ");
            Pass = br.readLine();
            if (Pass == null) throw new IllegalArgumentException();
            
            
            System.out.print(" Nama     : ");
            Nama = br.readLine();
            if (Nama == null) throw new IllegalArgumentException();

            
            System.out.print(" Email    : ");
            Email = br.readLine();
            if (Email == null) throw new IllegalArgumentException();
           
            
        } catch (IOException | IllegalArgumentException e){
            System.out.println(" Terjadi error saat menginput data.");
            return;
        }
        
        setUsn(Usn);
        setPass(Pass);
        setNama(Nama);
        setEmail(Email);
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
    final String Otoritas = "Admin";
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProjekAkhir;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Viabel
 */
public interface MultiableAcc {
    void TambahAkun(ArrayList <Akun> data, int ID) throws IOException;
    boolean HapusAkun() throws IOException;
}

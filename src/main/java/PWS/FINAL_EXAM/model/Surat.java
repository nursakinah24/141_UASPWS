/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS.FINAL_EXAM.model;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Surat {
    int id;
    String No_Surat, Judul, Tembusan, File;
    Date TimeStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo_Surat() {
        return No_Surat;
    }

    public void setNo_Surat(String No_Surat) {
        this.No_Surat = No_Surat;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public String getTembusan() {
        return Tembusan;
    }

    public void setTembusan(String Tembusan) {
        this.Tembusan = Tembusan;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String File) {
        this.File = File;
    }

    public Date getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Date TimeStamp) {
        this.TimeStamp = TimeStamp;
    }
    
}

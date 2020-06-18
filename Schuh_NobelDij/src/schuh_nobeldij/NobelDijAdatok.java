/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuh_nobeldij;

/**
 *
 * @author Soma
 */
public class NobelDijAdatok 
{
    //év;típus;keresztnév;vezetéknév
    public int Ev;
    public String Tipus;
    public String Keresztnev;
    public String Vezeteknev;
    public String Nev;

    
    NobelDijAdatok(int Ev, String Tipus, String Keresztnev, String Vezeteknev, String Nev) 
    {
       this.Ev=Ev;
       this.Tipus=Tipus;
       this.Keresztnev=Keresztnev;
       this.Vezeteknev=Vezeteknev;
       this.Nev=Nev;
    }

    public int getEv() {
        return Ev;
    }

    public void setEv(int Ev) {
        this.Ev = Ev;
    }

    public String getTipus() {
        return Tipus;
    }

    public void setTipus(String Tipus) {
        this.Tipus = Tipus;
    }

    public String getKeresztnev() {
        return Keresztnev;
    }

    public void setKeresztnev(String Keresztnev) {
        this.Keresztnev = Keresztnev;
    }

    public String getVezeteknev() {
        return Vezeteknev;
    }

    public void setVezeteknev(String Vezeteknev) {
        this.Vezeteknev = Vezeteknev;
    }

    public String getNev() {
        return Nev;
    }

    public void setNev(String Nev) {
        this.Nev = Nev;
    }

   
    
}

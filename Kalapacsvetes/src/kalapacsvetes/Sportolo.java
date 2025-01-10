/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalapacsvetes;

/**
 *
 * @author peter
 */
public class Sportolo {
    private int helyezes;
    private String eredmeny;
    private String nev;
    private String orszagkod;
    private String helyszin;
    private String datum;

    // Konstruktor
    public Sportolo(int helyezes, String eredmeny, String nev, String orszagkod, String helyszin, String datum) {
        this.helyezes = helyezes;
        this.eredmeny = eredmeny;
        this.nev = nev;
        this.orszagkod = orszagkod;
        this.helyszin = helyszin;
        this.datum = datum;
    }

    // Getterek (opcionális, ha szükséges)
    public int getHelyezes() {
        return helyezes;
    }

    public String getEredmeny() {
        return eredmeny;
    }

    public String getNev() {
        return nev;
    }

    public String getOrszagkod() {
        return orszagkod;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public String getDatum() {
        return datum;
    }

    // ToString metódus az adatok kiíratásához
    public String toString() {
        return helyezes + ";" + eredmeny + ";" + nev + ";" + orszagkod + ";" + helyszin + ";" + datum;
    }
}
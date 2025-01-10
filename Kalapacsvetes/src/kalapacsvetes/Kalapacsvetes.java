/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kalapacsvetes;

/**
 *
 * @author peter
 */ 


import java.io.*;
import java.util.*;

public class Kalapacsvetes {

    public static void main(String[] args) {
        List<Sportolo> sportolok = new ArrayList<>();
        double magyarSportolokOsszeg = 0; // Magyar sportolók eredményeinek összege
        int magyarSportolokSzama = 0; // Magyar sportolók száma
        int dobasokSzama = 0; // A dobások száma
        Map<String, Integer> orszagStatisztika = new HashMap<>(); // Ország statisztika tárolására

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\\\\\\\Users\\\\\\\\peter\\\\\\\\Desktop\\\\\\\\meres-2025-01\\\\\\\\kalapacsvetes.txt"))) {
            String line = reader.readLine(); // Fejléc beolvasása, de nem írjuk ki

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                int helyezes = Integer.parseInt(parts[0]);
                String eredmeny = parts[1]; // Eredmény stringként
                String nev = parts[2];
                String orszagkod = parts[3];
                String helyszin = parts[4];
                String datum = parts[5];

                // Növeljük az adott ország dobásainak számát
                orszagStatisztika.put(orszagkod, orszagStatisztika.getOrDefault(orszagkod, 0) + 1);

                // Csak a magyar (HUN) sportolókra vagyunk kíváncsiak
                if (orszagkod.equals("HUN")) {
                    // Eredmény szövegből számba konvertálás
                    double eredmenyErtek = Double.parseDouble(eredmeny.replace(",", "."));

                    // Eredmény összeadása és sportoló számolása
                    magyarSportolokOsszeg += eredmenyErtek;
                    magyarSportolokSzama++;
                }

                // Dobás számolása
                dobasokSzama++;

                // Sportoló hozzáadása a listához
                sportolok.add(new Sportolo(helyezes, eredmeny, nev, orszagkod, helyszin, datum));
            }

            // 4. feladat: Dobások számának kiírása
            System.out.println("4. feladat: " + dobasokSzama + " dobás eredménye található");

            // 5. feladat: A magyar sportolók dobásainak átlaga
            if (magyarSportolokSzama > 0) {
                // Átlag kiszámítása és kiírása két tizedesjegyre kerekítve
                double atlag = magyarSportolokOsszeg / magyarSportolokSzama;
                System.out.printf("5. feladat: A magyar sportolók dobásainak átlaga: %.2f\n", atlag);
            } else {
                System.out.println("5. feladat: Nincs magyar sportoló a listában.");
            }

            // Kérjük be az évszámot
            Scanner scanner = new Scanner(System.in);
            System.out.print("Adjon meg egy évszámot: ");
            int ev = scanner.nextInt();

            // Szűrés: csak az adott évben elért dobások
            List<Sportolo> legjobbak = new ArrayList<>();
            for (Sportolo sportolo : sportolok) {
                String sportoloEv = sportolo.getDatum().substring(0, 4); // Az év a dátum első 4 karakteréből származik
                if (Integer.parseInt(sportoloEv) == ev) {
                    legjobbak.add(sportolo);
                }
            }

            // Kiírás: ha találunk dobásokat az adott évben
            if (legjobbak.isEmpty()) {
                System.out.println("    " + "Egy dobás sem került be ebben az évben.");
            } else {
                // Formázott kiírás az elvárt formában
                System.out.println("Adjon meg egy évszámot: ");
                System.out.println(ev);
                System.out.println("       " + legjobbak.size() + " darab dobás került be ebben az évben.");
                for (Sportolo sportolo : legjobbak) {
                    System.out.println("        " + sportolo.getNev());
                }
            }

            // 7. feladat: Statisztika az országok legjobb dobásainak számáról
            System.out.println("7. feladat: Statisztika az országok legjobb dobásainak számáról:");
            for (Map.Entry<String, Integer> entry : orszagStatisztika.entrySet()) {
                String orszag = entry.getKey();
                int darab = entry.getValue();
                System.out.println("      " + orszag + " - " + darab + " dobás");
            }

        } catch (IOException e) {
            System.out.println("Hiba a fájl beolvasása során: " + e.getMessage());
        }
    }
}




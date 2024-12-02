package de.exxcellent.challenge;

import java.io.*;
import java.util.*;

public class CsvReader {
    /**
     * Liest eine CSV-Datei und gibt die Daten als Liste von String-Arrays zurück.
     * Jede Zeile der CSV-Datei wird in ein Array von Strings umgewandelt, wobei
     * die Spalten durch ein Komma getrennt sind.
     *
     * @param filename Der Pfad zur CSV-Datei
     * @return Eine Liste von String-Arrays, wobei jedes Array einer Zeile der CSV entspricht
     */
    public static List<String[]> readCSV(String filename) {
        // Liste, um die Daten der CSV-Datei zu speichern
        List<String[]> data = new ArrayList<>();
        
        // Versuch, die Datei zu öffnen und zu lesen
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // Liest jede Zeile der Datei, bis keine mehr übrig ist
            while ((line = br.readLine()) != null) {
                // Splittet die Zeile anhand von Kommas und fügt sie der Liste hinzu
                data.add(line.split(","));
            }
        } catch (IOException e) {
            // Falls ein Fehler beim Öffnen oder Lesen der Datei auftritt, gib den Fehler aus
            e.printStackTrace();
        }

        // Gibt die Liste der Zeilen zurück
        return data;
    }
}


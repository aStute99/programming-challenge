package de.exxcellent.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherProcessor {
    // Diese Methode liest die CSV-Datei und berechnet den Tag mit der kleinsten Temperaturdifferenz
    public static int findDayWithSmallestTemperatureSpread(String filePath) {
        List<String[]> data = readCSV(filePath);  // Liest die CSV-Datei ein
        int dayWithSmallestSpread = 0;
        double smallestSpread = Double.MAX_VALUE;

        // Durchlaufe die Daten (außer der ersten Zeile mit den Headern)
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            try {
                int day = Integer.parseInt(row[0]);  // Der Tag (erste Spalte)
                double maxTemp = Double.parseDouble(row[1]);  // Maximaltemperatur (zweite Spalte)
                double minTemp = Double.parseDouble(row[2]);  // Minimaltemperatur (dritte Spalte)
                double spread = maxTemp - minTemp;  // Temperaturdifferenz berechnen

                // Wenn die aktuelle Temperaturdifferenz kleiner ist als die bisher kleinste
                if (spread < smallestSpread) {
                    smallestSpread = spread;
                    dayWithSmallestSpread = day;
                }
            } catch (NumberFormatException e) {
                System.err.println("Ungültige Zahl in den Daten: " + Arrays.toString(data.get(i)));
            }
        }
        return dayWithSmallestSpread;  // Gebe den Tag mit der kleinsten Differenz zurück
    }

    // Diese Methode liest die CSV-Datei und gibt die Daten als Liste von String-Arrays zurück
    private static List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try {
            // CSV-Datei lesen
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] values = line.split(",");  // Splitte die Zeile bei jedem Komma
                data.add(values);  // Füge das Array zur Liste hinzu
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";  // Pfad zur CSV-Datei
        int day = findDayWithSmallestTemperatureSpread(filePath);
        System.out.println("Day with smallest temperature spread: " + day);  // Ausgabe des Ergebnisses
    }
}

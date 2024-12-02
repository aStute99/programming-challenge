package de.exxcellent.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballProcessor {
   // Diese Methode liest die CSV-Datei und berechnet das Team mit der kleinsten Tor-Differenz
    public static String findTeamWithSmallestGoalDifference(String filePath) {
        List<String[]> data = readCSV(filePath);  // Liest die CSV-Datei ein
        String teamWithSmallestDifference = "";
        int smallestDifference = Integer.MAX_VALUE;

        // Durchlaufe die Daten (außer der ersten Zeile mit den Headern)
        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);
            try {
                String team = row[0];  // Teamname (erste Spalte)
                int goals = Integer.parseInt(row[5]);  // Tore (sechste Spalte, "Goals")
                int goalsAllowed = Integer.parseInt(row[6]);  // Gegentore (siebte Spalte, "Goals Allowed")
                int difference = Math.abs(goals - goalsAllowed);  // Berechne die Differenz der Tore

                // Wenn die aktuelle Differenz kleiner ist als die bisher kleinste
                if (difference < smallestDifference) {
                    smallestDifference = difference;
                    teamWithSmallestDifference = team;
                }
            } catch (NumberFormatException e) {
                System.err.println("Ungültige Zahl in den Daten: " + Arrays.toString(data.get(i)));
            }
        }
        return teamWithSmallestDifference;  // Gebe das Team mit der kleinsten Differenz zurück
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
        String filePath = "src/main/resources/de/exxcellent/challenge/football.csv";  // Pfad zur CSV-Datei
        String team = findTeamWithSmallestGoalDifference(filePath);
        System.out.println("Team with smallest goal difference: " + team);  // Ausgabe des Ergebnisses
    }
}

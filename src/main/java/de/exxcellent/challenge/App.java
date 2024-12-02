package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String[] args) {
        // Pfad zu den CSV-Dateien
        String weatherFilePath = "src/main/resources/de/exxcellent/challenge/weather.csv";
        String footballFilePath = "src/main/resources/de/exxcellent/challenge/football.csv"; 

        // Aufruf der Wetteraufgabe
        int dayWithSmallestSpread = WeatherProcessor.findDayWithSmallestTemperatureSpread(weatherFilePath);
        System.out.println("Day with smallest temperature spread: " + dayWithSmallestSpread);

        // Aufruf der Fußballaufgabe
        String teamWithSmallestGoalDifference = FootballProcessor.findTeamWithSmallestGoalDifference(footballFilePath);
        System.out.println("Team with smallest goal difference: " + teamWithSmallestGoalDifference);
    }
}


package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    // Test für die Methode findDayWithSmallestTemperatureSpread
    @Test
    void testFindDayWithSmallestTemperatureSpread() {
        // Arrange: Hier werden die Beispiel-CSV-Datei definiert, die für den Test verwendet wird
        // Die Datei sollte in diesem Fall die Wetterdaten enthalten und im angegebenen Verzeichnis vorhanden sein
        String weatherTestFile = "src/test/java/de/exxcellent/challenge/resources/weatherTest.csv";
        // Erstelle eine Instanz von WeatherProcessor, der die Berechnungen durchführt
        WeatherProcessor weatherProcessor = new WeatherProcessor();

        // Act: Rufe die Methode auf, die den Tag mit der kleinsten Temperaturdifferenz berechnet
        // Das Ergebnis wird in der Variablen 'result' gespeichert
        int result = weatherProcessor.findDayWithSmallestTemperatureSpread(weatherTestFile);

        // Assert: Überprüfe, ob das Ergebnis korrekt ist
        // Der erwartete Wert ist '3', daher wird das Ergebnis mit '3' verglichen
        assertEquals(3, result, "Der Tag mit der kleinsten Temperaturdifferenz sollte 3 sein.");
    }

    // Test für die Methode findTeamWithSmallestGoalDifference
    @Test
    void testFindTeamWithSmallestGoalDifference() {
        // Arrange: Hier wird die Beispiel-CSV-Datei mit den Fußballdaten definiert
        String footballTestFile = "src/test/java/de/exxcellent/challenge/resources/footballTest.csv"; 
        // Erstelle eine Instanz von FootballProcessor, der die Berechnungen zur Tordifferenz durchführt
        FootballProcessor footballProcessor = new FootballProcessor();

        // Act: Rufe die Methode auf, die das Team mit der kleinsten Tordifferenz berechnet
        // Das Ergebnis wird in der Variablen 'result' gespeichert
        String result = footballProcessor.findTeamWithSmallestGoalDifference(footballTestFile);

        // Assert: Überprüfe, ob das Ergebnis korrekt ist
        // Das erwartete Team ist "Aston_Villa", daher wird das Ergebnis mit diesem Namen verglichen
        assertEquals("Aston_Villa", result, "Das Team mit der kleinsten Tordifferenz sollte Aston_Villa sein.");
    }

    // Integrationstest für die Wetteraufgabe in der App
    @Test
    void testAppWeatherIntegration() {
        // Arrange: Definiere die Argumente für die Wetteraufgabe, die an die main-Methode der App übergeben werden
        // Der erste Parameter "--weather" gibt an, dass die Wetterberechnung durchgeführt werden soll
        // Der zweite Parameter ist der Pfad zur Testdatei, die Wetterdaten enthält
        String[] args = {"--weather", "src/test/java/de/exxcellent/challenge/resources/weatherTest"};

        // Act: Führe die Main-Methode der App aus
        // Die App wird mit den angegebenen Argumenten ausgeführt
        App.main(args);
    }

    // Integrationstest für die Fußballaufgabe in der App
    @Test
    void testAppFootballIntegration() {
        // Arrange: Definiere die Argumente für die Fußballaufgabe, die an die main-Methode der App übergeben werden
        // Der erste Parameter "--football" gibt an, dass die Fußballberechnung durchgeführt werden soll
        // Der zweite Parameter ist der Pfad zur Testdatei, die Fußballergebnisse enthält
        String[] args = {"--football", "src/test/java/de/exxcellent/challenge/resources/footballTest.csv"};

        // Act: Führe die Main-Methode der App aus
        // Die App wird mit den angegebenen Argumenten ausgeführt
        App.main(args);
    }
}

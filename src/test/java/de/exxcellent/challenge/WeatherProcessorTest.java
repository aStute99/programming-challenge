package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherProcessorTest {

    // Test für die Methode findDayWithSmallestTemperatureSpread
    @Test
    void testFindDayWithSmallestTemperatureSpread() {
        // Arrange: Testdaten simulieren
        // Der Pfad zur CSV-Datei, die Wetterdaten enthält, die für den Test verwendet werden
        // Diese Datei sollte sich im Verzeichnis src/test/resources befinden
        String weatherTestFile = "src/test/java/de/exxcellent/challenge/resources/weatherTest.csv";

        // Act: Die Methode wird aufgerufen, die den Tag mit der kleinsten Temperaturdifferenz berechnet
        // Das Ergebnis wird in der Variablen 'result' gespeichert
        int result = WeatherProcessor.findDayWithSmallestTemperatureSpread(weatherTestFile);

        // Assert: Überprüfe, ob das Ergebnis korrekt ist
        // Der erwartete Wert ist '3', da der Tag 3 die kleinste Temperaturdifferenz hat
        assertEquals(3, result, "Der Tag mit der kleinsten Temperaturdifferenz sollte 3 sein.");
    }
}

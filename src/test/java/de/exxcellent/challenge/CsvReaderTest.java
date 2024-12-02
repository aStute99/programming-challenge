package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {

    // Test für die Methode readCSV
    @Test
    void testReadCSV() {
        // Arrange: Definiere den Pfad zur Test-CSV-Datei
        // Die Datei enthält Wetterdaten und sollte sich im Verzeichnis src/test/resources befinden
        String weatherTestFile = "src/test/java/de/exxcellent/challenge/resources/weatherTest.csv";

        // Act: Rufe die Methode readCSV auf, um die CSV-Datei zu lesen
        // Die Methode gibt eine Liste von String-Arrays zurück, wobei jedes Array einer Zeile der CSV entspricht
        List<String[]> result = CsvReader.readCSV(weatherTestFile);

        // Assert: Überprüfe die verschiedenen Aspekte der zurückgegebenen Daten
        
        // Überprüfe, dass das Ergebnis nicht null ist
        assertNotNull(result, "CSV-Daten sollten nicht null sein.");
        
        // Überprüfe, dass die Liste nicht leer ist
        assertFalse(result.isEmpty(), "CSV-Daten sollten nicht leer sein.");
        
        // Überprüfe, dass die Datei 4 Zeilen hat (einschließlich der Kopfzeile)
        assertEquals(4, result.size(), "Die Datei sollte 4 Zeilen haben (inkl. Header).");
    }
}

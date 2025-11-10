import java.io.*;
import java.util.*;

public class ErrorLogExtractor {
    public static void main(String[] args) {
        String inputFile = "logs.txt";
        String outputFile = "error_report.txt";
        List<String> errorLines = new ArrayList<>();

        // Read file and collect ERROR lines
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ERROR:")) {
                    errorLines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write to output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            if (errorLines.isEmpty()) {
                writer.write("No critical errors today.");
            } else {
                for (String error : errorLines) {
                    writer.write(error);
                    writer.newLine();
                }
            }
            System.out.println("Error report generated: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

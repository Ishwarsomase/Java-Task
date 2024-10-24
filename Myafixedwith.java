import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Myafixedwith {

     public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length < 3) {
            System.out.println("Usage: java MyFixed2CSV <fixed-width-file> <n-columns> <length1> <length2> ...");
            return;
        }

        // Fixed-width 
        
        String fileName = args[0];
        String inputFile = "D:\\New folder\\" + fileName; // Fixed-width file

        // Number of columns
        int nColumns = Integer.parseInt(args[1]); // Number of columns
        int[] lengths = new int[nColumns]; // Lengths of each column

        // Parse the lengths from the command line arguments
        for (int i = 2; i < args.length; i++) {
            lengths[i - 2] = Integer.parseInt(args[i]); // Fill lengths array 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\New folder\\output.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Create empty StringBuilder object
                StringBuilder csvLine = new StringBuilder();
                int currentIndex = 0;

                for (int i = 0; i < lengths.length; i++) {
                    // Check if currentIndex is within the bounds of the line
                    if (currentIndex + lengths[i] <= line.length()) {
                        String field = line.substring(currentIndex, currentIndex + lengths[i]).trim();

                        // Remove leading zeros only for the second and third fields
                        if (i == 1 || i == 2) 
                        {
                            field = field.replaceFirst("^0+(?!$)", ""); // Remove leading zeros
                        }

                        csvLine.append("\"").append(field).append("\",");
                        currentIndex += lengths[i];
                    } 
                    else 
                    {
                        // If the substring is out of bounds, you can handle it accordingly.
                        System.out.println("Warning: Skipping column " + i + " due to out of bounds.");
                        break; // or continue, based on your logic
                    }
                }

                // Remove the last comma and write the line
                if (csvLine.length() > 0) {
                    csvLine.setLength(csvLine.length() - 1); // Remove last comma
                    writer.write(csvLine.toString());
                    writer.newLine();
                }
            }

            System.out.println("CSV file has been created: output.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

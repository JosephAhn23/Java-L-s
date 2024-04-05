import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SecretMessage {

    public static void encrypt(String inputFile, String outputFile, int key) throws IOException, FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int charValue;
            while ((charValue = reader.read()) != -1) {
                char encryptedChar = (char) (charValue + key);
                writer.write(encryptedChar);
            }
        }
    }

    public static void decrypt(String inputFile, String outputFile, int key) throws IOException, FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int charValue;
            while ((charValue = reader.read()) != -1) {
                char decryptedChar = (char) (charValue - key);
                writer.write(decryptedChar);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
            System.exit(0);
        }

        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];
        int key = Integer.parseInt(args[3]);

        try {
            if (mode.equals("encrypt")) {
                encrypt(inputFile, outputFile, key);
            } else if (mode.equals("decrypt")) {
                decrypt(inputFile, outputFile, key);
            } else {
                System.out.println("Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Cannot read/write file: " + e.getMessage());
        }
    }
}

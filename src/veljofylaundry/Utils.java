/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veljofylaundry;

/**
 *
 * @author FINAFAIZA
 */
import java.util.Scanner;
import java.util.UUID;

public class Utils {
    static Scanner scanner = new Scanner(System.in);

    public static String inputPilihan(String prompt, String[] opsi) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().toLowerCase();
            for (String o : opsi) {
                if (input.equalsIgnoreCase(o)) {
                    return o;
                }
            }
            System.out.println("Pilihan tidak valid. Coba lagi.");
        }
    }

    public static double inputDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public static String generateKodePesanan() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}


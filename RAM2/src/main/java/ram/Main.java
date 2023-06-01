package ram;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Die Hauptklasse, die die Eingabe des Benutzers entgegennimmt und eine Random Access Machine ausführt.
 */
public class Main {

    /**
     * Der Einstiegspunkt des Programms.
     *
     * @param args Die Kommandozeilenargumente (werden in diesem Fall nicht verwendet).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int zahl1 = getInput(scanner, "Bitte geben Sie eine Zahl ein: ");
        int zahl2 = getInput(scanner, "Bitte geben Sie eine zweite Zahl ein: ");
        String operator = getOperator(scanner, "Bitte geben Sie '+', '-' oder '*' ein: ");

        IRandomAccessMachine ram = new RandomAccessMachine(0, zahl1, zahl2, 0, 0, 0, 1);

        String[] addition = {"HLT", "LDA 1", "ADD 2", "STA 4", "JMP 0"};
        String[] subtraktion = {"HLT", "LDA 1", "SUB 2", "STA 4", "JMP 0"};
        String[] multiplikation = {"HLT", "LDA 4", "ADD 1", "STA 4", "LDA 2", "SUB 6", "JMZ 0", "STA 2", "JMP 1"};

        String result;
        if (operator.equals("+")) {
            ram.run(addition);
        } else if (operator.equals("-")) {
            ram.run(subtraktion);
        } else if (operator.equals("*")) {
            ram.run(multiplikation);
        } else {
            result = "Ungültiger Operator";
        }
        scanner.close();
    }

    /**
     * Liest eine Ganzzahl von der Benutzereingabe ein.
     *
     * @param scanner Der Scanner zum Lesen der Eingabe.
     * @param message Die Eingabeaufforderung an den Benutzer.
     * @return Die eingegebene Ganzzahl.
     */
    private static int getInput(Scanner scanner, String message) {
        int input;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine ganze Zahl ein.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return input;
    }

    /**
     * Liest den Operator für die Operation von der Benutzereingabe ein.
     *
     * @param scanner Der Scanner zum Lesen der Eingabe.
     * @param message Die Eingabeaufforderung an den Benutzer.
     * @return Der eingegebene Operator als Zeichenkette.
     */
    private static String getOperator(Scanner scanner, String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.next();
            if (input.equals("+") || input.equals("-") || input.equals("*")) {
                break;
            } else {
                System.out.println("Ungültiger Operator. Bitte geben Sie '+', '-' oder '*' ein.");
            }
        }
        return input;
    }
}

package ram;

/**
 * Die Klasse RandomAccessMachine implementiert eine Random Access Machine (RAM) und erweitert die abstrakte Klasse
 * BaseRandomAccessMachine. Sie stellt Methoden zum Ausführen eines RAM-Programms und zum Beenden des Programms bereit.
 */
public class RandomAccessMachine extends BaseRandomAccessMachine implements IRandomAccessMachine {

    /**
     * Konstruktor für die RandomAccessMachine-Klasse.
     *
     * @param memory Ein Array von Ganzzahlen, das als Speicher für die RAM dient.
     */
    public RandomAccessMachine(int... memory) { //int... ist eine varargs (variable arguments) Ermöglicht der Methode, eine variable Anzahl von Argumenten desselben Typs zu akzeptieren 
        super(memory);
    }

    /**
     * Führt ein RAM-Programm aus, das durch ein Array von RAL-Anweisungen (RAL = Random Access Language) definiert ist.
     *
     * @param ral Ein Array von RAL-Anweisungen, die das RAM-Programm darstellen.
     */
    @Override
    public void run(String[] ral) {
        for (programCounter = 1; programCounter < ral.length; programCounter++) {
            String instruction = ral[programCounter]; //aktuellen Position im Array wird der Variable zugewiesen.
            String[] parts = instruction.split(" "); //Instruktion wird anhand des Leerzeichens aufgeteilt und in parts gespeichert.
            String opCode = parts[0]; //ersten Teil der Instruktion "RAL"
            int operand = 0;
            if (parts.length == 2) { //Falls die Instruktion einen Operanden enthält, wird der Wert des Operanden aus dem String in eine Ganzzahl (int) umgewandelt und in "operand" gespeichert.
                operand = Integer.parseInt(parts[1]); //wandelt string in Int um
            }

            switch (opCode) {
                case "LDA":
                    lda(operand);
                    break;
                case "LDI":
                    ldi(operand);
                    break;
                case "STA":
                    sta(operand);
                    break;
                case "STI":
                    sti(operand);
                    break;
                case "ADD":
                    add(operand);
                    break;
                case "SUB":
                    sub(operand);
                    break;
                case "JMP":
                    jmp(operand);
                    break;
                case "JMZ":
                    jmz(operand);
                    break;
                case "HLT":
                    hlt();
                    break;
                default:
                    // Handle unknown opCode
                    break;
            }
        }
    }

    /**
     * Beendet das RAM-Programm und gibt den aktuellen Zustand des Akkumulators und des Speichers aus.
     * Beendet außerdem das Programm.
     */
    @Override
    public void hlt() {
        System.out.println("Ende des Programms");
        System.out.println("Akkumulator: " + accumulator);
        System.out.println("Speicher:");
        for (int i = 0; i < memory.length; i++) {
            System.out.println(i + ": " + memory[i]); //index : der "i-te" index in memory
        }
        System.exit(0);
    }

    /**
     * Gibt eine Zeichenkette mit dem aktuellen Zustand des Akkumulators und des Speichers zurück.
     *
     * @return Eine Zeichenkette mit dem aktuellen Zustand des Akkumulators und des Speichers.
     */
    @Override
    public String toString() {
        return toStringImpl();
    }
}

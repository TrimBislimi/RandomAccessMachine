package ram;

/**
 * Die abstrakte Klasse BaseRandomAccessMachine definiert eine Basisimplementierung einer Random Access Machine (RAM).
 * Sie enthält den Akkumulator, den Speicher und den Programmzähler. Die Klasse stellt Methoden zum Ausführen von Befehlen,
 * zum Lesen und Schreiben von Werten im Speicher und zur Steuerung des Programmablaufs bereit.
 */
public abstract class BaseRandomAccessMachine {
    protected int accumulator;  // Akkumulator für arithmetische Operationen
    protected int[] memory;  // Speicher für Ganzzahlen
    protected int programCounter;  // Programmzähler für die Befehlsausführung
    
    /**
     * Konstruktor für die BaseRandomAccessMachine-Klasse.
     *
     * @param memory Ein Array von Ganzzahlen, das als Speicher für die RAM dient.
     */
    public BaseRandomAccessMachine(int[] memory) {
        this.memory = memory;
    }
    
    /**
     * Addiert den Wert im Speicher an der angegebenen Position zum Akkumulator.
     *
     * @param i Die Position im Speicher.
     */
    public void add(int i) {
        accumulator += memory[i];
    }

    /**
     * Subtrahiert den Wert im Speicher an der angegebenen Position vom Akkumulator.
     *
     * @param i Die Position im Speicher.
     */
    public void sub(int i) {
        accumulator -= memory[i];
    }

    /**
     * Lädt den Wert aus dem Speicher an der angegebenen Position in den Akkumulator.
     *
     * @param i Die Position im Speicher.
     */
    public void lda(int i) {
        accumulator = memory[i];
    }

    /**
     * Lädt den Wert aus dem Speicher an der Position, die im Speicher an der angegebenen Position gespeichert ist,
     * in den Akkumulator.
     *
     * @param i Die Position im Speicher.
     */
    public void ldi(int i) {
        accumulator = memory[memory[i]];
    }

    /**
     * Speichert den Wert im Akkumulator an der angegebenen Position im Speicher und setzt den Akkumulator auf 0.
     *
     * @param i Die Position im Speicher.
     */
    public void sta(int i) {
        memory[i] = accumulator;
        
    }

    /**
     * Speichert den Wert im Akkumulator an der Position, die im Speicher an der angegebenen Position gespeichert ist,
     * und setzt den Akkumulator auf 0.
     *
     * @param i Die Position im Speicher.
     */
    public void sti(int i) {
        memory[memory[i]] = accumulator;
        
    }

    /**
     * Springt zur angegebenen Position im RAM-Programm.
     *
     * @param i Die Position im RAM-Programm.
     */
    public void jmp(int i) {
        programCounter = i - 1;
    }

    /**
     * Springt zur angegebenen Position im RAM-Programm, wenn der Akkumulator den Wert 0 hat.
     *
     * @param i Die Position im RAM-Programm.
     */
    public void jmz(int i) {
        if (accumulator == 0) {
            programCounter = i - 1;
        }
    }

    /**
     * Abstrakte Methode, die die Ausführung des RAM-Programms beendet und den aktuellen Zustand des Akkumulators
     * und des Speichers ausgibt.
     */
    public abstract void hlt();

    /**
     * Erzeugt eine Zeichenkette mit dem aktuellen Zustand des Akkumulators und des Speichers.
     *
     * @return Eine Zeichenkette mit dem aktuellen Zustand des Akkumulators und des Speichers.
     */
    public String toStringImpl() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Akkumulator: %d\n", accumulator));
        sb.append("Speicher:\n");
        for (int i = 0; i < memory.length; i++) {
            sb.append(String.format("%d: %d\n", i, memory[i]));
        }
        return sb.toString();
    }
    
    /**
     * Gibt den aktuellen Wert des Akkumulators zurück.
     *
     * @return Der aktuelle Wert des Akkumulators.
     */
    public int getAccumulator() {
        return accumulator;
    }

    /**
     * Legt den Wert des Akkumulators fest.
     *
     * @param accumulator Der neue Wert für den Akkumulator.
     */
    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    /**
     * Gibt den aktuellen Speicher der RAM zurück.
     *
     * @return Ein Array von Ganzzahlen, das den aktuellen Speicher der RAM enthält.
     */
    public int[] getMemory() {
        return memory;
    }

    /**
     * Legt den Speicher der RAM fest.
     *
     * @param memory Ein Array von Ganzzahlen, das als neuer Speicher für die RAM verwendet wird.
     */
    public void setMemory(int[] memory) {
        this.memory = memory;
    }

    /**
     * Gibt den aktuellen Wert des Programmzählers zurück.
     *
     * @return Der aktuelle Wert des Programmzählers.
     */
    public int getProgramCounter() {
        return programCounter;
    }

    /**
     * Legt den Wert des Programmzählers fest.
     *
     * @param programCounter Der neue Wert für den Programmzähler.
     */
    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }
}

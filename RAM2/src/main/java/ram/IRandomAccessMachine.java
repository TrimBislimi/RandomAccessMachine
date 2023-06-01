package ram;

/**
 * Die Schnittstelle für eine Random Access Machine.
 */
public interface IRandomAccessMachine {

   
    void run(String[] ral);   
    void add(int i);   
    void sub(int i);    
    void lda(int i);    
    void ldi(int i);    
    void sta(int i);    
    void sti(int i);   
    void jmp(int i);    
    void jmz(int i);   
    void hlt();    
    String toString();
}

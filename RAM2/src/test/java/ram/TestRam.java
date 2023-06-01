package ram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRam {
    private BaseRandomAccessMachine ram;

    @Before
    public void setup() {
        int[] memory = {0, 3, 4, 0, 0, 0, 1};
        ram = new RandomAccessMachine(memory);
    }

    @Test
    public void testLda() {
        ram.lda(1);
        Assert.assertEquals(2, ram.getAccumulator());
    }

    @Test
    public void testLdi() {
        ram.ldi(1);
        Assert.assertEquals(0, ram.getAccumulator());
    }

    @Test
    public void testSta() {
    	ram.lda(1);
        ram.add(2);
        ram.sta(3);
        Assert.assertEquals(7, ram.getMemory()[3]);
        Assert.assertEquals(7, ram.getAccumulator());
    }

    @Test
    public void testSti() {
    	ram.lda(1);
        ram.add(2);
        ram.sti(3);
        Assert.assertEquals(0, ram.getMemory()[3]);
        Assert.assertEquals(7, ram.getAccumulator());
    }

    @Test
    public void testAdd() {
        ram.lda(1);
        ram.add(2);
        Assert.assertEquals(7, ram.getAccumulator());
    }

    @Test
    public void testSub() {
        ram.lda(1);
        ram.sub(2);
        Assert.assertEquals(-1, ram.getAccumulator());
    }

    @Test
    public void testJmp() {
        ram.jmp(6);
        Assert.assertEquals(5, ram.getProgramCounter());
    }

    @Test
    public void testJmz() {
        ram.jmz(1);
        Assert.assertEquals(0, ram.getProgramCounter());

        ram.lda(1);
        ram.jmz(6);
        Assert.assertEquals(0, ram.getProgramCounter());
    }

  
}
package com.teste;

import org.junit.Test;
import static org.junit.Assert.*;



import java.nio.charset.StandardCharsets;

public class AssertTest {

    @Test
    public void testAssertArreyEquals(){
        byte[] esperado = "teste".getBytes();
        byte[] atual = "teste".getBytes();
        assertArrayEquals(esperado, atual);
    }
    @Test
    public void testeAssertEquals(){
        assertEquals("test", "test");
    }
    @Test
    public void teesteAssertFalse(){
        assertFalse(false);
    }
    @Test
    public void testeAssertNotNull(){
        assertNotNull(new object());
    }
    @Test
    public void testAssertNotSame(){
        assertNotSame(new object(), new object());
    }
    @Test
    public void testAssertNull(){
        assertNull(null);
    }
    @Test
    public void testAssertSame(){
        Integer aNumber = Integer.valueOf(768);
        assertSame(aNumber, aNumber);
    }

    private class  object {
    }
}

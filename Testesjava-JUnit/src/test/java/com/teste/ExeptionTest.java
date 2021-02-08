package com.teste;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ExeptionTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty(){
        new ArrayList<Object>().get(0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void shouldTestExceptionMessage() throws IndexOutOfBoundsException{
        List<Object> list = new ArrayList<>();
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0);
    }

}

package com.teste;

import org.junit.Test;
import static org.junit.Assert.*;


public class CalculadoraNovaTestTDD {

    @Test
    public void deveSomarDoisValores(){
        int valoreA = 1;
        int valorB = 2;

        CalculadoraNova calculadoraNova = new CalculadoraNova();
        int soma = calculadoraNova.somar(valoreA, valorB);

        assertEquals(3,soma);
    }

    @Test
    public void deveSomarTresValoresDoisValores(){
        int valoreA = 1;
        int valorB = 2;
        int valorC = 3;

        CalculadoraNova calculadoraNova = new CalculadoraNova();
        int soma = calculadoraNova.somar(valoreA, valorB, valorC);

        assertEquals(6,soma);
    }

}

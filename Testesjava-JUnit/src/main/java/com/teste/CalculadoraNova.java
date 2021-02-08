package com.teste;

public class CalculadoraNova {

    public int somar(int... valors){
        int soma = 0;
        for(int valor : valors){
            soma +=valor;
        }
        return soma;
    }

}

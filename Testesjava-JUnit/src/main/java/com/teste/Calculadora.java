package com.teste;

public class Calculadora {

    public  int somar(String expressao){
        int soma = 0;
        for (String valorSoma : expressao.split("\\+")){
            soma += Integer.valueOf(valorSoma);
        }
        return soma;
    }

}

package Paradgma_Funcional_Lambda_e_Recursividade;

import java.util.function.UnaryOperator;

public class Paradigma {
    public static void main(String[] args) {
        int valor1 = 10;
        int resultado = valor1 * 3;
        System.out.println("O resultado é: "+ resultado);

        ///////Parafigma Funcional///////
        UnaryOperator<Integer> calculoValor = valor2 -> valor2*3;
        int valor = 20;
        System.out.println("O resultado é: "+ calculoValor.apply(valor)); // ao invez de colocar um variavel, poderia coloca diretamente o valor que deseja multiplicar
    }
}

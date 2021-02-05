package Paradgma_Funcional_Lambda_e_Recursividade;

import java.util.function.UnaryOperator;

public class Iutabilidade {
    public static void main(String[] args) {
        int valor = 20;
        UnaryOperator<Integer> retornarDobro = v ->  v * 2;
        System.out.println(retornarDobro.apply(valor)); // retorna o dobro do valor
        System.out.println(valor); // não modifica a variavel valor
    }
}

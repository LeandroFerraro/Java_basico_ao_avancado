package InterfacesFuncionais;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        Function<String,String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String,Integer> converterStringParaInteiro = string -> Integer.valueOf(string);// = Integer::valueOF
        System.out.println(retornarNomeAoContrario.apply("Leandro"));
        System.out.println(converterStringParaInteiro.apply("20"));
    }
}

package InterfacesFuncionais;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"João", "Pedro", "Leandro", "Ferraro", "Java", "Oliveira"};
        Integer[] numeros = {1,2,3,4,5};
        imprimirNomesFiltrados(nomes);
        imprimirTodosNomes(nomes);
        imprimirODobroDeCadaItemDaLista(numeros);

        List<String> lista = new ArrayList<>();
        lista.add("Desenvolvedor");
        lista.add("Testador");
        lista.add("Gerente de projeto");
        lista.add("Gerente de qualidade");

        lista.stream()
                .filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);
    }

    public static void imprimirNomesFiltrados(String... nomes) { //Os tres pontos(...) é a mesma coisa do que colocar []

        String nomesParaImprimirDoFor = "";
        for (int i = 0; i < nomes.length; i++) {
            if(nomes[i].equals("João")){
                nomesParaImprimirDoFor+=" "+nomes[i];
            }
        }

        System.out.println("Nome do for: "+nomesParaImprimirDoFor);

        String nomesParaImprimirDaStream = Stream.of(nomes)
                .filter(nome -> nome.equals("João"))
                .collect(Collectors.joining());

        System.out.println("Nome do Stream: "+nomesParaImprimirDaStream);
    }

    public static void imprimirTodosNomes(String... nomes){
        for(String nome : nomes){
            System.out.println("Executado pelo for: "+nome);
        }

        Stream.of(nomes)
                //.forEach(System.out::println);
                .forEach(nome -> System.out.println("Executado pelo forEach: "+nome));
    }

    public static void imprimirODobroDeCadaItemDaLista(Integer... numeros) {
        for(Integer numero : numeros){
            System.out.println(numero*2);
        }

        Stream.of(numeros)
                .map(numero -> numero*2)
                .forEach(System.out::println);

    }
}

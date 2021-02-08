package Java10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InterfacieExemplo {
    public static void main(String[] args) throws IOException {
        printarNomeCompleto("Leandro", "Ferraro");
        printarSoma(5,2,6,7);
    }

    public static void connectAndPrintURLJava() throws IOException{
        var url = new URL("https://unionmangas.top/");
        var urlConnection = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
    }

    public static void printarNomeCompleto(String nome, String sobreNome){
        var nomeCompleto = String.format("%s %s",nome,sobreNome);
        System.out.println(nomeCompleto);
    }
    public static void printarSoma(int... numeros){
        int soma;
        if(numeros.length > 0){
            soma = 0;
            for (var numero : numeros){
                soma+=numero;
            }
            System.out.println("A some é :: "+ soma);
        }
    }
    //Var não pode ser usado a nivel de classe, apenas em nivel local
    //var não pode ser usado em um parametro de uma método
    //não pode ser utilizada em variaveis locais não inicializadas
}

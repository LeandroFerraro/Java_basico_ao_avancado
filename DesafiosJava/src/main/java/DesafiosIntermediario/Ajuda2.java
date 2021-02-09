package DesafiosIntermediario;

import java.util.*;

public class Ajuda2 {
    public static void main(String[] args) {

        //Vou ter que ler todas as linhas ate vir um . e então eu vou tratar elas

        Scanner scanner = new Scanner(System.in);
        boolean permitir = true;
        while (permitir) {
            String valor1 = scanner.nextLine();

            String[] ponto = valor1.split("a.");
            for (String s : ponto) {
                if (s.equals(".")) {
                    permitir = false;
                }
            }
            if (valor1 == "" || valor1 == " "){
                break;
            }
            if (permitir) {
                List<String> temporario = new ArrayList<>();
                List<String> fraseFinal = new ArrayList<>();
                List<String> maioresPalavras = new ArrayList<>();

                String[] palavrasSoltas = valor1.split(" ");
                for (String s : palavrasSoltas) {
                    temporario.add(s);
                    fraseFinal.add(s);
                    for (int i = 0; i < temporario.size(); i++) {
                        if (temporario.get(i).equals("") || temporario.get(i).equals(" ")){
                            temporario.remove(i);
                        }
                    }
                    for (int i = 0; i < temporario.size(); i++) {
                        if (temporario.get(i).equals("") || temporario.get(i).equals(" ")){
                            temporario.remove(i);
                        }
                    }
                }
                boolean controle = true;
                int index = 0;
                String maiorPavra = "";

                //Pega a lista temporaria e colocar as palavras maiores que 2 para outra lista
                while (controle){
                    for (int i = 0; i < temporario.size(); i++) {
                        int tam = temporario.get(i).length();
                        if (maiorPavra.length() < tam && tam > 2){
                            maiorPavra = temporario.get(i);
                            index = i;
                        }
                    }
                    temporario.remove(index);
                    if(maiorPavra.length() > 2) {
                        maioresPalavras.add(maiorPavra);
                    }
                    maiorPavra = "";
                    if (temporario.size() == 0){
                        controle = false;
                    }
                }
                //saber a primeira letra da maior palavra e se outras palavras não começa com essa mesma letra, caso outra palavra tenha começado com a mesma letra
                //tem que remover ela


                for (int i = 0; i < maioresPalavras.size(); i++) {
                    int cont = i + 1;
                    char letra = maioresPalavras.get(i).charAt(0);
                    while (cont < maioresPalavras.size()) {
                        if (letra == maioresPalavras.get(cont).charAt(0)) {
                            maioresPalavras.remove(1);
                        } else {
                            cont++;
                        }
                    }
                }
                //agora a lista de maioresPalavras tem somente as maiores palavras da frase onde cada letra que começa essas palavras são diferentes umas da outras

                //abreviar as palavras da lista maioresPalavras e substituir as palavras da lista fraseFinal que corresponde as palavras que estão na lista maioresPalavras
                if(controle == false){
                    for (int i = 0; i < maioresPalavras.size(); i++) {
                        for (int j = 0; j < fraseFinal.size(); j++) {
                            if(maioresPalavras.get(i).equals(fraseFinal.get(j))){
                                char pontuar = maioresPalavras.get(i).charAt(0);
                                maioresPalavras.set(i, pontuar + ". = "+ maioresPalavras.get(i));
                                fraseFinal.set(j, pontuar +".");
                            }
                        }
                    }
                }

                String formattedString = fraseFinal.toString()
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")
                        .trim();
                System.out.println(formattedString);
                System.out.println(maioresPalavras.size());
                Collections.sort(maioresPalavras);
                for (int i = 0; i < maioresPalavras.size(); i++) {
                    System.out.println(maioresPalavras.get(i));
                }
            }
        }
    }
}


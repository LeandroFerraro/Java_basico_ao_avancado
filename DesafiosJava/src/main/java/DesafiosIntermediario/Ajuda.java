package DesafiosIntermediario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ajuda {
    public static void main(String[] args) {

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
            if (permitir) {
                String[] palavrasSoltas = valor1.split(" ");
                List<String> palavras = new ArrayList<>();
                List<String> palavrasFinal = new ArrayList<>();
                int cont = 0;
                for (String s : palavrasSoltas) {
                    String guardando = s;
                    if (s.length() > 3) {
                        char primeiraLetra = s.charAt(0);
                        palavrasFinal.add(primeiraLetra + ". = "+guardando);
                        palavras.add((primeiraLetra+"."));
                        cont++;
                    } else {
                        palavras.add(s);
                    }
                }
                String formattedString = palavras.toString()
                        .replace(",", "")  //remove the commas
                        .replace("[", "")  //remove the right bracket
                        .replace("]", "")  //remove the left bracket
                        .trim();
                System.out.println(formattedString);
                System.out.println(cont);
                Collections.sort(palavrasFinal);
                for (int i = 0; i < palavrasFinal.size(); i++) {
                    System.out.println(palavrasFinal.get(i));
                }
            }
        }
    }
}


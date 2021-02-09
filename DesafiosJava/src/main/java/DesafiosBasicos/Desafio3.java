package DesafiosBasicos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int positivo = 0;
        int negativo = 0;
        int par = 0;
        int impar = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer valor1 = Integer.parseInt(st.nextToken());
            if(valor1 >= 1){
                positivo++;
            }else{
                if(valor1 <= -1) {
                    negativo++;
                }
            }
            if(valor1 % 2 == 0){
                par++;
            }else{
                impar++;
            }
        }
        System.out.println(par + " valor(es) par(es)");
        System.out.println(impar + " valor(es) impar(es)");
        System.out.println(positivo + " valor(es) positivo(s)");
        System.out.println(negativo + " valor(es) negativo(s)");
    }
}

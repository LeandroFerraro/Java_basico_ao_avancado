package DesafiosBasicos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double valor1 = Double.parseDouble(st.nextToken());
            if(valor1 > 0){
                p++;
            }
        }
        System.out.println(p + " valores positivos");
    }
}

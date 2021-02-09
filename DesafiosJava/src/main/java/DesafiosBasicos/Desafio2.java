package DesafiosBasicos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer valor1 = Integer.parseInt(st.nextToken());
        if (valor1 % 2 == 0 ){
            int val = 0;
            while (val < valor1) {
                val = val + 2;
                System.out.println(val);
            }
        }else{
            int val2 = 0;
            while (val2 < (valor1 -1)){
                val2 = val2 + 2;
                System.out.println(val2);
            }
        }
    }
}

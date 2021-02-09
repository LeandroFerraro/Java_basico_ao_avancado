package DesafiosBasicos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Desafio5 {
    public static void main(String[] args) throws IOException {

        DecimalFormat formatador = new DecimalFormat("0.000");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double valor1 = Double.parseDouble(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        double valor2 = Double.parseDouble(st1.nextToken());

        double media;
        
        media = valor1/valor2;
        System.out.println(formatador.format(media) + " Km/l");
    }
}
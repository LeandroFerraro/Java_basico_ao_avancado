import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer valor1 = Integer.parseInt(st.nextToken());

        int cem = 0;
        int cinquenta = 0;
        int vinte = 0;
        int dez = 0;
        int cinco = 0;
        int dois = 0;
        int um = 0;

        System.out.println(valor1);

        while (valor1 > 0){
            if (valor1 >= 100){
                valor1 = valor1 - 100;
                cem++;
            }
            if (valor1 < 100 && valor1 >= 50){
                valor1 = valor1 - 50;
                cinquenta++;
            }
            if (valor1 < 50 && valor1 >= 20){
                valor1 = valor1 - 20;
                vinte++;
            }
            if (valor1 < 20 && valor1 >= 10){
                valor1 = valor1 - 10;
                dez++;
            }
            if (valor1 < 10 && valor1 >= 5){
                valor1 = valor1 - 5;
                cinco++;
            }
            if (valor1 < 5 && valor1 >= 2){
                valor1 = valor1 - 2;
                dois++;
            }
            if (valor1 < 2 && valor1 >= 1){
                valor1 = valor1 - 1;
                um++;
            }
        }

        System.out.println(cem + " nota(s) de R$ 100,00");
        System.out.println(cinquenta + " nota(s) de R$ 50,00");
        System.out.println(vinte + " nota(s) de R$ 20,00");
        System.out.println(dez + " nota(s) de R$ 10,00");
        System.out.println(cinco + " nota(s) de R$ 5,00");
        System.out.println(dois + " nota(s) de R$ 2,00");
        System.out.println(um + " nota(s) de R$ 1,00");
    }
}

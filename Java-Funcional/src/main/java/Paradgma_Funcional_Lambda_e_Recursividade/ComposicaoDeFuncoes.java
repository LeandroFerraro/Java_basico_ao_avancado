package Paradgma_Funcional_Lambda_e_Recursividade;

import java.util.Arrays;

public class ComposicaoDeFuncoes {
    public static void main(String[] args) {

        //Paradigma funcional é agele que eu deixo explícito um comportamento que eu quero que ele execute, mas não digo quando, quando necessario eu chamo ele
        int [] valores = {1,2,3,4};
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 2)
                .forEach(nuemro -> System.out.println(nuemro));

        //Os dois fazem a mesma coisa, porém é muito mais facil dar manutenção e intender o código de cime do que o de baixo

        for (int i = 0; i < valores.length; i++) {
            int valor = 0;
            if(valores[i] % 2 == 0){
                valor = valores[i] * 2;

                if(valor != 0){
                    System.out.println(valor);
                }
            }
        }
    }
}

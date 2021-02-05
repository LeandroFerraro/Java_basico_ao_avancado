package Paradgma_Funcional_Lambda_e_Recursividade;

import java.util.function.BiPredicate;

public class FuncoesPuras {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> verificarSeMenor =
                (paremetro, valorComparacoa) -> paremetro > valorComparacoa;

        //retorna um boolean(true or false)
        System.out.println(verificarSeMenor.test(13, 12));
        System.out.println(verificarSeMenor.test(13, 12));
    }
}

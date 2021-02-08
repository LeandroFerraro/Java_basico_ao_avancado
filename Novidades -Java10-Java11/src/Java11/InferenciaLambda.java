package Java11;

import java.util.function.Function;

public class InferenciaLambda {
    public static void main(String[] args) {
        Function<Integer, Double> divisaoPorSois = (var numero) -> numero/2.0;
        System.out.println(divisaoPorSois.apply(15));
    }
}

package InterfacesFuncionais;

import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args) {
        Predicate<String> estaVazio = String::isEmpty; // or valor -> valor.isEmpty() -- São a mesma coisa
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Leandro"));
    }
}

package InterfacesFuncionais;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo soma = (a,b) -> a+b;
        Calculo subtracao = (a,b) -> a-b;
        Calculo divisao = (a,b) -> a/b;
        Calculo mult = (a,b) -> a*b;

        System.out.println(executarOperacao(soma, 1, 3));
        System.out.println(executarOperacao(subtracao, 4, 3));
        System.out.println(executarOperacao(divisao, 4, 2));
        System.out.println(executarOperacao(mult, 1, 3));
    }

    public static int executarOperacao(Calculo calculo, int a, int b){
        return calculo.calculo(a,b);
    }
}

@FunctionalInterface
interface Calculo{
    public int calculo(int a, int b);
}

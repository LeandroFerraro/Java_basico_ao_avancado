package InterfacesFuncionais;

import java.util.function.Supplier;

public class Suppliers {
    public static void main(String[] args) {
        //Supplier<Pessoa> instaciaPessoa = () -> new Pessoa();
        Supplier<Pessoa> instaciaPessoa = Pessoa::new;
        System.out.println(instaciaPessoa.get());
    }
}

class Pessoa{
    private String nome;
    private Integer idade;

    public Pessoa(){
        nome = "Leandro";
        idade = 19;
    }
    @Override
    public String toString(){
        return String.format("nome : %s, idade : %d", nome, idade);
    }
}

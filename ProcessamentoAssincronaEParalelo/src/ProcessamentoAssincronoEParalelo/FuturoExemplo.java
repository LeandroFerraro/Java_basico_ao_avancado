package ProcessamentoAssincronoEParalelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FuturoExemplo {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {

        Casa casa = new Casa(new Quarto());
        List<? extends Future<String>> futuros = new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                .map(atividade -> threadPool.submit(() -> {
                        try {
                            return atividade.realizar();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    })
                )
                .collect(Collectors.toList()));

        while (true){
            int numerosDeAtividadesNaoFinalizadas = 0;
            for(Future<?> futuro : futuros){
                if(futuro.isDone()){
                    try {
                        System.out.println("Parabens voce terminou de "+futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }else{
                    numerosDeAtividadesNaoFinalizadas++;
                }
            }
            if(futuros.stream().allMatch(Future::isDone)){
                break;
            }
            System.out.println("Numero de atividades não finalizadas:  "+numerosDeAtividadesNaoFinalizadas);
            Thread.sleep(500);
        }
        threadPool.shutdown();
    }
}

class Casa{
    private List<Comodo> comodos;

    Casa(Comodo... comodos){
        this.comodos = Arrays.asList(comodos);
    }
    List<Atividade> obterAfazeresDaCasa(){
        return this.comodos.stream().map(Comodo::obterAfazeresDaCasa)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                   pivo.addAll(atividades);
                   return pivo;
                });
    }
}

interface Atividade{
    String realizar() throws InterruptedException;
}

abstract class Comodo{
    abstract List<Atividade> obterAfazeresDaCasa();
}

class Quarto extends Comodo{
    @Override
    List<Atividade> obterAfazeresDaCasa(){

        /*ArrayList<ProcessamentoAssincronoEParalelo.Atividade> objeto = new ArrayList<>();
        objeto.add(this::varrerOQuarto);
        objeto.add(this::getArrumarCama);
        objeto.add(this::arrumarGuardaRoupa);
         */

        //O código de baixo é a mesma coisa que o código de cima, porém éle é mais legivel e mais facil de dar manutenção

        return Arrays.asList(
                this::getArrumarCama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private String arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        String arrumarGuardaRoupa = "arrumar guarda roupa";
        System.out.println(arrumarGuardaRoupa);
        return arrumarGuardaRoupa;
    }
    private String varrerOQuarto() throws InterruptedException {
        Thread.sleep(7000);
        String varrerOQuarto = "varrer o quarto";
        System.out.println(varrerOQuarto);
        return varrerOQuarto;
    }
    private String getArrumarCama() throws InterruptedException {
        Thread.sleep(10000);
        String arrumarACama = "Arrumar a cama";
        System.out.println(arrumarACama);
        return arrumarACama;
    }

}
package ProcessamentoAssincronoEParalelo;

public class ThreadExemplo {
    public static void main(String[] args) {
         BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
         barraDeCarregamento2.start();

        BarraDeCarregamento2 barraDeCarregamento22 = new BarraDeCarregamento2();
        barraDeCarregamento22.start();

        GerarPDF gerarPDF = new GerarPDF();
        BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento(gerarPDF);

        gerarPDF.start();
        barraDeCarregamento.start();


    }
}

    class GerarPDF extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Gerar PDF");
        }
    }

    class BarraDeCarregamento extends Thread{

        private Thread gerarPDF;

        public BarraDeCarregamento(Thread gerarPDF) {
            this.gerarPDF = gerarPDF;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500);
                    if(!gerarPDF.isAlive()){
                        break;
                    }
                    System.out.println("Loading.....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class BarraDeCarregamento2 extends Thread {

        @Override
        public void run() {
            super.run();
            System.out.println("Rodei: " + this.getName());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

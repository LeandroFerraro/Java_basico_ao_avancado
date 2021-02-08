package Java11;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ClienteHttpExemplo {

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable Runnable) {
            Thread thread = new Thread(Runnable);
            System.out.println("Nova thread criada "+(thread.isDaemon() ? "deamon" : "") + " thread Group :: "+thread.getThreadGroup());
            return thread;
        }
    });

    public static void main(String[] args) throws IOException, InterruptedException {
        connectAndPrintURLJava();
        connectAkamaiHttpCliente();
    }

    public static void connectAkamaiHttpCliente() throws IOException, InterruptedException {
        System.out.println("Running HTTP/2 exemple...");
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();
            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code :: "+response.statusCode());
            System.out.println("Response Header :: "+response.headers());
            String responseBody = response.body();
            System.out.println(responseBody);

            List<Future<?>> futures = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgfuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("http://http2.akamia.com" + image))
                                    .build();

                           try {
                               HttpResponse<String> imgResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                               System.out.println("Imagens carregadas :: "+image+" , status code :: " +imgResponse.statusCode());
                           }catch (IOException | InterruptedException e){
                               System.out.println("Mensagem de erro derante requisição para receber a imagem" + image);
                           }
                        });
                        futures.add(imgfuture);
                        System.out.println("Imagens futuras submitidas "+image);
                    });

            futures.forEach(f -> {
                try {
                    f.get();
                }catch (InterruptedException | ExecutionException e){
                    System.out.println("Erro ao esperar carregar a imagem futura");
                }
            });

            long and = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total :: "+ (and - start) + " ms");

        } finally {
            executor.shutdown();
        }
    }

    private static void connectAndPrintURLJava() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://unionmangas.top/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code :: "+response.statusCode());
        System.out.println("Headers response :: "+response.headers());
        System.out.println("Bogy response :: "+response.body());
    }
}

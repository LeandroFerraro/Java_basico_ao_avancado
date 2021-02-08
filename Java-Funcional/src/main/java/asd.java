import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class asd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> par = new ArrayList<>();
        List<Integer> impar = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer valorLinhas = Integer.parseInt(st.nextToken());

        for (int i = 0; i < valorLinhas; i++) {
            st = new StringTokenizer(br.readLine());
            Integer valor = Integer.parseInt(st.nextToken());

            if(valor % 2 == 0 ){
                par.add(valor);
            }else{
                impar.add(valor);
            }
        }
        

        int b = 1;
        for (int i = 0; i < par.size(); i++) {

        }
    }
}

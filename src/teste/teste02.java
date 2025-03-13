package teste;

public class teste02 {
    public static void main(String[] args) {

        System.out.println("soma = " + somar(2, 3));
        System.out.println("soma = " + somar(2, 3, 4));
        System.out.println("soma = " + somar(2, 3, 1, 1, 7));

    }

    // ...x = metodo com quantidade variavel de parametro!!! -> ele para armazenar esses numeros, usa um *vetor*
    public static int somar( int ...x){
        int total=0;

        for (int i : x) {
            total += i;
        }
        return total;
    }
}

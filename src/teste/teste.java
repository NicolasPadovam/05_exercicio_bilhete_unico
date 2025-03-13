package teste;

import java.util.Random;

public class teste {
    public static void main(String[] args) {

        int[] n = new int[5];

        //chamada de métodos
        percorreArray(n);

        System.out.println("---------------");
        imprimirArray(n);


    }

    public static void percorreArray(int[] n) {
        Random r = new Random();

        for (int i = 0; i < n.length; i++) {
            System.out.printf("Escreva o numero do vetor na posição " + (i + 1) + ": \n");
            n[i] = r.nextInt(15);
        }
    }

    public static void imprimirArray(int[] n) {

        for (int i = 0; i < n.length; i++) {
            System.out.println("Posição " + (i + 1) + ": " + n[i]);
        }

        System.out.println("");
        System.out.println("----Usando o for each");

        //for para *percorrer*, não inserir
        for(int i : n){
            System.out.println(i);
        }

    }

}

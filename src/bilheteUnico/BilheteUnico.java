package bilheteUnico;

import java.util.Random;

public class BilheteUnico {

    // static = pertence a classe | final = variável Constante
    static final double TARIFA = 5.20;
    double saldo;
    long numeroBilhete;

    //chamada do construtor
    Usuario usuario;

    public BilheteUnico(String nome, long cpf, String perfil) {
        Random random = new Random();
        numeroBilhete = random.nextLong(1000, 10000);

        usuario = new Usuario(cpf, nome, perfil);
    }

    //método para carregar o bilhete
    public double carregaBilhete(double valor) {
        this.saldo += valor;
        return saldo;
    }

    //método para consultar o saldo do bilhete
    public double consultaBilhete() {
        return saldo;
    }

    //método para passar na catraca
    public String passaCatraca() {
        double debito = TARIFA / 2;

        if (usuario.perfil.equalsIgnoreCase("comum")) {
            debito = TARIFA;
        }

        if (saldo >= debito) {
            saldo -= debito;
            return "Catraca liberada";
        }

        return "Saldo insuficiente";
    }


}

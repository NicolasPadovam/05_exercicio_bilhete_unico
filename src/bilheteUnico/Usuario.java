package bilheteUnico;

public class Usuario {

    String nome;
    long cpf;
    String perfil;

    public Usuario(long cpf, String nome, String perfil) {
        this.cpf = cpf;
        this.nome = nome;
        this.perfil = perfil;
    }
}

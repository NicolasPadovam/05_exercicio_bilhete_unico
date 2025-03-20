package bilheteUnico;

import java.text.DecimalFormat;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Util {

    private BilheteUnico[] bilhete = new BilheteUnico[2];
    private int index = 0;


    public void menuPrincipal() {
        int opcao = 0;
        String menu = "1. Administrador \n2.Usuario\n3.Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));

            switch (opcao) {
                case 1:
                    menuAdm();
                    break;
            }

        } while (opcao != 3);

    }


    private void menuAdm() {
        int opcao;
        String menu = "MENU ADMINISTADOR\n";

        menu += "1. Emitir bilhete\n2.Listar bilhestes\n3.Excluir bilhete\n4.Sair";

        do {
            opcao = parseInt(showInputDialog(menu));

            switch (opcao) {
                case 1:
                    emitirBilhete();
                    break;

                case 2:
                    listarBilhete();
                    break;
            }
        } while (opcao != 4);

    }


    private void emitirBilhete() {
        String nome, perfil;
        long cpf;

        if (index < bilhete.length) {
            nome = showInputDialog("Nome do usuário: ");
            cpf = parseInt(showInputDialog("CPF do usuario: "));
            perfil = showInputDialog("Perfil do usuario: \nEstudante\nProfessor\nComum");

            bilhete[index] = new BilheteUnico(nome, cpf, perfil);
            index++;

            showMessageDialog(null, "Bilhete emitido com sucesso!");
        } else {
            showMessageDialog(null, "Procure um posto de atendimento!");
        }
    }

    private void listarBilhete() {
        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";

        for (int i = 0; i < index; i++) {
            aux += "Número do bilhete: " + bilhete[i].numeroBilhete + "\n";
            aux += "Saldo do bilhete: " + df.format(bilhete[i].saldo) + "\n";
            aux += "Nome do usuário: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil do usuário: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF do usuário: " + bilhete[i].usuario.cpf + "\n";
            aux += "\n";
        }
        showInputDialog(null, aux);
    }
}

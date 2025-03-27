package bilheteUnico;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.*;

public class Util {

    private BilheteUnico[] bilhete = new BilheteUnico[3];
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

                case 2:
                    menuUsuario();
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

                case 3:
                    excluirBilhete();
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

    private void excluirBilhete() {
        int reposta;
        int indice = pesquisar();

        if (indice != -1) {
            reposta = showConfirmDialog(null, "Deseja remover o bilhete?");

            if (reposta == YES_OPTION) {
                bilhete[indice] = bilhete[index - 1];
                index--;
            }
        }


    }

    private void menuUsuario() {
        int opcao;
        String menu = "MENU USUÁRIO\n";

        menu += "1. Carregar bilhete\n2.Consultar bilhetes\n3.Passar na catraca\n4.Sair";

        do {
            opcao = parseInt(showInputDialog(menu));

            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "A opção escolhida é inválida!", "Aviso", WARNING_MESSAGE);
            } else {
                switch (opcao) {
                    case 1:
                        carregarBilhete();
                        break;

                    case 2:
                        consultarSaldo();
                        break;

                    case 3:
                        passarCatraca();
                        break;
                }
            }
        } while (opcao != 4);

    }

    private void carregarBilhete() {
        int indice = pesquisar();
        double valor;

        if (indice != -1) {
            valor = parseDouble(showInputDialog("Valor da Recarga: "));
            bilhete[indice].carregaBilhete(valor);
        }
    }

    private void consultarSaldo() {
        int indice = pesquisar();

        if (indice != -1) {
            showMessageDialog(null, "Saldo = R$" + bilhete[indice].consultaSaldo());
        }

    }

    private void passarCatraca() {
        int indice = pesquisar();

        if (indice != -1) {
            showMessageDialog(null, bilhete[indice].passaCatraca());
        }
    }

    private int pesquisar() {
        long cpf = parseLong(showInputDialog("CPF: "));

        for (int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf == cpf) {
                return i;
            }
        }
        showMessageDialog(null, cpf + " CPF não encontrado", "Aviso", WARNING_MESSAGE);
        return -1;
    }

}

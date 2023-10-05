import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cliente> clienteList = new ArrayList<>();

        String selecao = JOptionPane.showInputDialog(
                "ESCOLHA UMA OPÇÃO \n \n 1-CADASTRAR USUÁRIO  \n 2-REGISTRAR DADOS DO HIGRÔMETRO \n 3-MOSTRAR DADOS DA ESTUFA \n 4-SAIR ");

        while (!selecao.equals("4")) {

            Cliente cliente = new Cliente();

            if (selecao.equals("1")) {

                cliente.cadastrarCliente();
                clienteList.add(cliente);
            }

            else if (selecao.equals("2")) {
                String cpf = JOptionPane.showInputDialog("Digite seu CPF:");
                Cliente clienteEncontrado = procurarClientePorCPF(clienteList, cpf);
                Higrometro higrometro = new Higrometro();
                higrometro.cadastrarHigrometro();
                clienteEncontrado.setHigrometro(higrometro);

            }

            else if (selecao.equals("3")) {
                String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário:");
                Cliente clienteEncontrado = procurarClientePorCPF(clienteList, cpf);

                clienteEncontrado.mostrarInformacoesCultivo();
                clienteEncontrado.getHigrometro(0).imprimir();
            }

            selecao = JOptionPane.showInputDialog(
                    "ESCOLHA UMA OPÇÃO \n \n 1-CADASTRAR USUÁRIO  \n 2-REGISTRAR DADOS DO HIGRÔMETRO \n 3-MOSTRAR DADOS DA ESTUFA \n 4-SAIR ");
        }
    }

    public static Cliente procurarClientePorCPF(ArrayList<Cliente> clienteList, String cpf) {
        for (Cliente cliente : clienteList) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}
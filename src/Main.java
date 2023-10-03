import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        ArrayList<Higrometro> higrometroList = new ArrayList<>();
        ArrayList<Cliente> clienteList = new ArrayList<>();

        String selecao = JOptionPane.showInputDialog(
                "ESCOLHA UMA OPÇÃO \n \n 1-CADASTRAR USUÁRIO  \n 2-REGISTRAR DADOS DO HIGRÔMETRO \n 3-MOSTRAR DADOS DO PLANTIO \n 4-SAIR ");

        while (!selecao.equals("4")) {

            if (selecao.equals("1")) {
                Cliente cliente = new Cliente();
                cliente.cadastrarCliente();
                clienteList.add(cliente);
            }

            else if (selecao.equals("2")) {
                Higrometro higrometro = new Higrometro();
                higrometro.cadastrarHigrometro();
                higrometroList.add(higrometro);
            }

            else if (selecao.equals("3")) {
                String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário:");
                Cliente clienteEncontrado = procurarClientePorCPF(clienteList, cpf);

                if (clienteEncontrado != null) {

                    clienteEncontrado.mostrarInformacoesCultivo();
                    clienteEncontrado.imprimir();
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                }
            }

            selecao = JOptionPane.showInputDialog(
                    "ESCOLHA UMA OPÇÃO \n \n 1-CADASTRAR USUÁRIO  \n 2-REGISTRAR DADOS DO HIGRÔMETRO \n 3-MOSTRAR DADOS DO PLANTIO \n 4-SAIR ");
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
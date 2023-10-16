import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clienteList = new ArrayList<>();
        Cliente clienteLogado = null;

        while (true) {
            String[] opcoes;
            if (clienteLogado == null) {
                opcoes = new String[] {
                        "Cadastrar-se",
                        "Login",
                        "Sair"
                };
            } else {
                opcoes = new String[] {
                        "Adicionar cultivo",
                        "Remover cultivo",
                        "Mostrar dados do cultivo",
                        "Adicionar/Alterar dados do cultivo",
                        "Logout"
                };
            }

            String escolha = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione uma opção:",
                    "Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            if (escolha == null) {
                System.exit(0);
            }

            if (clienteLogado == null) {
                switch (escolha) {
                    case "Cadastrar-se":
                        criarUsuario(clienteList);
                        break;
                    case "Login":
                        clienteLogado = fazerLogin(clienteList);
                        break;
                    case "Sair":
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            } else {
                switch (escolha) {
                    case "Adicionar cultivo":
                        adicionarCultivo(clienteLogado);
                        break;
                    case "Remover cultivo":
                        removerCultivo(clienteLogado);
                        break;
                    case "Mostrar dados do cultivo":
                        mostrarDadosEstufa(clienteLogado);
                        break;
                    case "Adicionar/Alterar dados do cultivo":
                        adicionarOuAlterarDadosPlantio(clienteLogado);
                        break;
                    case "Logout":
                        clienteLogado = null;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            }
        }
    }

    public static void criarUsuario(ArrayList<Cliente> clienteList) {
        Cliente cliente = new Cliente();
        cliente.cadastrarCliente();
        cliente.cadastrarSenha();
        cliente.cadastrarDataNascimento();
        clienteList.add(cliente);
        if (cliente.validarCadastro()) {
            clienteList.add(cliente);
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Dados de cadastro inválidos. Verifique os campos e tente novamente.");
        }
    }

    public static Cliente fazerLogin(ArrayList<Cliente> clienteList) {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário:");
        String senha = JOptionPane.showInputDialog("Digite a senha:");

        Cliente clienteEncontrado = procurarClienteByCPF(clienteList, cpf);

        if (clienteEncontrado != null && clienteEncontrado.verificarSenha(senha)) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            return clienteEncontrado;
        } else {
            JOptionPane.showMessageDialog(null, "CPF ou senha inválidos.");
        }
        return null;
    }

    public static void adicionarCultivo(Cliente clienteLogado) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo de plantio:");
        clienteLogado.adicionarTipoPlanta(tipoPlanta);
        JOptionPane.showMessageDialog(null, "Cultivo adicionado com sucesso!");
    }

    public static void removerCultivo(Cliente clienteLogado) {
        ArrayList<String> tiposPlantio = clienteLogado.getTiposPlantio();
        if (!tiposPlantio.isEmpty()) {
            String tipoPlanta = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha o cultivo para remover:",
                    "Seleção de Cultivo",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    tiposPlantio.toArray(),
                    tiposPlantio.get(0)
            );
            boolean cultivoRemovido = clienteLogado.removerTipoPlanta(tipoPlanta);
            if (cultivoRemovido) {
                JOptionPane.showMessageDialog(null, "Cultivo removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cultivo não encontrado para o cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cultivo registrado para este cliente.");
        }
    }

    public static void mostrarDadosEstufa(Cliente clienteLogado) {
        ArrayList<String> tiposPlantio = clienteLogado.getTiposPlantio();
        if (!tiposPlantio.isEmpty()) {
            String tipoPlanta = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha o cultivo para exibir os dados:",
                    "Seleção de Cultivo",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    tiposPlantio.toArray(),
                    tiposPlantio.get(0)
            );

            Higrometro higrometro = clienteLogado.getHigrometro(tipoPlanta);

            if (higrometro != null) {
                higrometro.imprimir();
            } else {
                JOptionPane.showMessageDialog(null, "Higrômetro não encontrado para o cultivo selecionado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cultivo registrado para este cliente.");
        }
    }

    public static void adicionarOuAlterarDadosPlantio(Cliente clienteLogado) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo de plantio para adicionar/alterar dados:");
        Higrometro higrometro = clienteLogado.getHigrometro(tipoPlanta);

        if (higrometro == null) {
            higrometro = new Higrometro(tipoPlanta);
            clienteLogado.adicionarHigrometro(higrometro);
        }

        higrometro.cadastrarHigrometro();
    }

    public static Cliente procurarClienteByCPF(ArrayList<Cliente> clienteList, String cpf) {
        for (Cliente cliente : clienteList) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}

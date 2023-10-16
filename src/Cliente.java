import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String celular;
    private String senha;
    private Date dataNascimento;
    private ArrayList<String> tiposPlantio;
    private ArrayList<Higrometro> higrometroList;

    public Cliente() {
        tiposPlantio = new ArrayList<>();
        higrometroList = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<String> getTiposPlantio() {
        return this.tiposPlantio;
    }

    public ArrayList<Higrometro> getHigrometroList() {
        return this.higrometroList;
    }

    public void adicionarTipoPlanta(String tipoPlanta) {
        tiposPlantio.add(tipoPlanta);
    }

    public boolean removerTipoPlanta(String tipoPlanta) {
        return tiposPlantio.remove(tipoPlanta);
    }

    public Higrometro getHigrometro(String nomeCultivo) {
        for (Higrometro higrometro : higrometroList) {
            if (higrometro.getNomeCultivo().equals(nomeCultivo)) {
                return higrometro;
            }
        }
        return null;
    }

    public void adicionarHigrometro(Higrometro higrometro) {
        higrometroList.add(higrometro);
    }

    public void cadastrarCliente() {
        nome = JOptionPane.showInputDialog("Digite seu nome");
        cpf = JOptionPane.showInputDialog("Digite seu CPF (Digitar apenas números)");
        email = JOptionPane.showInputDialog("Digite seu email");
        celular = JOptionPane.showInputDialog("Digite seu celular (Digitar apenas números)");
    }

    public void cadastrarSenha() {
        senha = new String(JOptionPane.showInputDialog("Digite a senha:"));
    }

    public void cadastrarDataNascimento() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataNascimento = sdf.parse(JOptionPane.showInputDialog("Digite sua data de nascimento (DIA/MÊS/ANO):"));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida.");
        }
    }

    public void cadastrarEmail() {
        String emailInput;
        do {
            emailInput = JOptionPane.showInputDialog("Digite seu email:");
        } while (!isEmailValid(emailInput));
        email = emailInput;
    }

    public void cadastrarCelular() {
        String celularInput;
        do {
            celularInput = JOptionPane.showInputDialog("Digite seu celular:");
        } while (!isCelularValid(celularInput));
        celular = celularInput;
    }

    private boolean isEmailValid(String email) {
        return email.matches(".+@.+\\..+");
    }

    private boolean isCelularValid(String celular) {
        return celular.matches("\\d+");
    }

    public boolean validarCadastro() {
        return isEmailValid(email) && isCelularValid(celular) && !cpf.isEmpty() && !senha.isEmpty();
    }

    public void mostrarInformacoesCultivo() {
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYY");
        String mensagem = "Informações do cliente:\n";
        mensagem += "Nome: " + nome + "\n";
        mensagem += "CPF: " + cpf + "\n";
        mensagem += "Email: " + email + "\n";
        mensagem += "Celular: " + celular + "\n";
        mensagem += "Data de Nascimento: " + (dataNascimento != null ? sdf.format(dataNascimento) : "Não informada") + "\n";
        mensagem += "Cultivos:\n";
        for (String tipoPlanta : tiposPlantio) {
            mensagem += "- " + tipoPlanta + "\n";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
}

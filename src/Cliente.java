import javax.swing.JOptionPane;

class Cliente extends Higrometro{

    private String nome;
    private String cpf;
    private String tipoPlanta;
    private String email;
    private String celular;
    private String dataNasc;
    private String informacoesCultivo;

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String tipoPlanta, String email, String celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoPlanta = tipoPlanta;
        this.email = email;
        this.celular = celular;
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

    public String getTipoPlanta() {
        return this.tipoPlanta;
    }

    public void setTipoPlanta(String tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getInformacoesCultivo() {
        return this.informacoesCultivo;
    }

    public void setInformacoesCultivo(String informacoesCultivo) {
        this.informacoesCultivo = informacoesCultivo;
    }

    public void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Digite seu nome");
        String cpf = JOptionPane.showInputDialog("Digite seu CPF");
        String email = JOptionPane.showInputDialog("Digite seu email");
        String celular = JOptionPane.showInputDialog("Digite seu celular");
        String tipoPlanta = JOptionPane.showInputDialog("Qual o seu cultivo?");

        if (nome != null && cpf != null && tipoPlanta != null && email != null && celular != null) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.celular = celular;
            this.tipoPlanta = tipoPlanta;

            JOptionPane.showMessageDialog(null, "Cadastro de Cliente realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.", "Erro de Cadastro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarInformacoesCultivo() {
        String mensagem = "Informações de cultivo do cliente:\n";
        mensagem += "Nome: " + nome + "\n";
        mensagem += "Cultivo: " + tipoPlanta + "\n";

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
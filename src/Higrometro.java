import javax.swing.JOptionPane;

public class Higrometro {
    private String nomeCultivo;
    private double temperaturaInterna;
    private double temperaturaExterna;
    private double umidadeAr;
    private double umidadeSolo;

    public Higrometro(String nomeCultivo) {
        this.nomeCultivo = nomeCultivo;
    }

    public String getNomeCultivo() {
        return this.nomeCultivo;
    }

    public double getTemperaturaInterna() {
        return this.temperaturaInterna;
    }

    public void setTemperaturaInterna(double temperaturaInterna) {
        this.temperaturaInterna = temperaturaInterna;
    }

    public double getTemperaturaExterna() {
        return this.temperaturaExterna;
    }

    public void setTemperaturaExterna(double temperaturaExterna) {
        this.temperaturaExterna = temperaturaExterna;
    }

    public double getUmidadeAr() {
        return this.umidadeAr;
    }

    public void setUmidadeAr(double umidadeAr) {
        this.umidadeAr = umidadeAr;
    }

    public double getUmidadeSolo() {
        return this.umidadeSolo;
    }

    public void setUmidadeSolo(double umidadeSolo) {
        this.umidadeSolo = umidadeSolo;
    }

    public void cadastrarHigrometro() {
        temperaturaInterna = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura interna:"));
        temperaturaExterna = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura externa:"));
        umidadeAr = Double.parseDouble(JOptionPane.showInputDialog("Digite a umidade do ar:"));
        umidadeSolo = Double.parseDouble(JOptionPane.showInputDialog("Digite a umidade do solo:"));

        JOptionPane.showMessageDialog(null, "Cadastro de Higrômetro realizado com sucesso!");
    }

    public void imprimir() {
        String mensagem = "Dados do Higrômetro para o cultivo " + nomeCultivo + ":\n";
        mensagem += "Temperatura Interna: " + temperaturaInterna + " °C\n";
        mensagem += "Temperatura Externa: " + temperaturaExterna + " °C\n";
        mensagem += "Umidade do Ar: " + umidadeAr + " %\n";
        mensagem += "Umidade do Solo: " + umidadeSolo + " %\n";

        if (temperaturaInterna >= 26) {
            mensagem += "Temperatura interna muito alta!\n";
        } else if (temperaturaInterna <= 19) {
            mensagem += "Temperatura interna muito baixa!\n";
        } else {
            mensagem += "Temperatura interna ideal!\n";
        }

        if (temperaturaExterna >= 28) {
            mensagem += "Temperatura Externa muito alta!\n";
        } else if (temperaturaExterna <= 18) {
            mensagem += "Temperatura Externa muito baixa!\n";
        } else {
            mensagem += "Temperatura Externa ideal!\n";
        }

        if (umidadeAr >= 81) {
            mensagem += "Umidade do ar muito alta!\n";
        } else if (umidadeAr <= 59) {
            mensagem += "Umidade do ar muito baixa!\n";
        } else {
            mensagem += "Umidade do ar ideal!\n";
        }

        if (umidadeSolo >= 81) {
            mensagem += "Umidade do solo muito alta!\n";
        } else if (umidadeSolo <= 59) {
            mensagem += "Umidade do solo muito baixa! INICIANDO A REGA!\n";
        } else {
            mensagem += "Umidade do solo ideal!\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }
}

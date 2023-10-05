import javax.swing.JOptionPane;

class Higrometro {

    private double temperaturaInterna;
    private double temperaturaExterna;
    private double umidadeAr;
    private double umidadeSolo;

    public Higrometro() {

    }

    public Higrometro(double temperaturaInterna, double temperaturaExterna, double umidadeAr, double umidadeSolo) {
        this.temperaturaInterna = temperaturaInterna;
        this.temperaturaExterna = temperaturaExterna;
        this.umidadeAr = umidadeAr;
        this.umidadeSolo = umidadeSolo;

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
        double temperaturaInterna = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura interna:"));
        double temperaturaExterna = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura externa:"));
        double umidadeAr = Double.parseDouble(JOptionPane.showInputDialog("Digite a umidade do ar:"));
        double umidadeSolo = Double.parseDouble(JOptionPane.showInputDialog("Digite a umidade do solo:"));

        try {
            this.temperaturaInterna = temperaturaInterna;
            this.temperaturaExterna = temperaturaExterna;
            this.umidadeAr = umidadeAr;
            this.umidadeSolo = umidadeSolo;
            JOptionPane.showMessageDialog(null, "Cadastro de Higrômetro realizado com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos com valores válidos.", "Erro de Cadastro",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void imprimir() {

        System.out.println(temperaturaExterna);
        System.out.println(temperaturaInterna);
        System.out.println(umidadeAr);
        System.out.println(umidadeSolo);

        if (temperaturaInterna >= 26) {
            JOptionPane.showMessageDialog(null, "Temperatura interna muito alta!");
        } else if (temperaturaInterna <= 19) {
            JOptionPane.showMessageDialog(null, "Temperatura interna muito baixa!");
        } else {
            JOptionPane.showMessageDialog(null, "Temperatura interna ideal!");
        }

        if (temperaturaExterna >= 28) {
            JOptionPane.showMessageDialog(null, "Temperatura Externa muito alta!");
        } else if (temperaturaExterna <= 18) {
            JOptionPane.showMessageDialog(null, "Temperatura Externa  muito baixa!");
        } else {
            JOptionPane.showMessageDialog(null, "Temperatura Externa  ideal!");
        }

        if (umidadeAr >= 81) {
            JOptionPane.showMessageDialog(null, "Umidade do ar muito  alta!");
        } else if (umidadeAr <= 59) {
            JOptionPane.showMessageDialog(null, "Umidade do ar muito baixa!");
        } else {
            JOptionPane.showMessageDialog(null, "Umidade do ar ideal!");
        }

        if (umidadeSolo >= 81) {
            JOptionPane.showMessageDialog(null, "Umidade do solo muito  alta!");
        } else if (umidadeSolo <= 59) {
            JOptionPane.showMessageDialog(null, "Umidade do solo muito baixa!");
        } else {
            JOptionPane.showMessageDialog(null, "Umidade do solo ideal!");
        }

    }
}

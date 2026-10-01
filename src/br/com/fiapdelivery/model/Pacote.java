package br.com.fiapdelivery.model;

public class Pacote {

    private static final String[] STATUS_VALIDOS = {"Pendente", "Em Transporte", "Entregue", "Cancelado"};

    private String codigoRastreio;
    private double pesoKg;
    private String status;

    public Pacote(String codigoRastreio, double pesoKg) {
        this.setCodigoRastreio(codigoRastreio);
        this.setPesoKg(pesoKg);
        this.status = "Pendente"; // todo pacote nasce pendente
    }

    public String getCodigoRastreio() {
        return this.codigoRastreio;
    }

    public double getPesoKg() {
        return this.pesoKg;
    }

    public String getStatus() {
        return this.status;
    }

    private void setCodigoRastreio(String codigoRastreio) {
        if (codigoRastreio != null && !codigoRastreio.trim().isEmpty()) {
            this.codigoRastreio = codigoRastreio;
        } else {
            System.out.println("Erro: O código de rastreio não pode ser vazio.");
        }
    }

    private void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        } else {
            System.out.println("Erro: O peso do pacote deve ser maior que zero.");
        }
    }

    // Substitui o antigo "muda(String x)" — nome sem sentido e sem nenhuma regra.
    public void atualizarStatus(String novoStatus) {
        for (String statusValido : STATUS_VALIDOS) {
            if (statusValido.equals(novoStatus)) {
                this.status = novoStatus;
                System.out.println("Pacote " + this.codigoRastreio + " atualizado para: " + this.status);
                return;
            }
        }
        System.out.println("Erro: \"" + novoStatus + "\" não é um status válido. Use: Pendente, Em Transporte, Entregue ou Cancelado.");
    }
}

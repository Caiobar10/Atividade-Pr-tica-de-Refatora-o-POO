package br.com.fiapdelivery.model;

public class Rota {

    private Pacote pacote;
    private Veiculo veiculo;

    // Antes, a Rota só aceitava "caminhao" (crime #4). Agora aceita
    // qualquer Veiculo — Caminhao, Moto, ou qualquer outro que a FiapDelivery
    // vier a ter no futuro — sem precisar mudar uma linha aqui dentro.
    public Rota(Pacote pacote, Veiculo veiculo) {
        this.setPacote(pacote);
        this.setVeiculo(veiculo);
    }

    public Pacote getPacote() {
        return this.pacote;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    private void setPacote(Pacote pacote) {
        if (pacote != null) {
            this.pacote = pacote;
        } else {
            System.out.println("Erro: A rota precisa de um pacote válido.");
        }
    }

    private void setVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            this.veiculo = veiculo;
        } else {
            System.out.println("Erro: A rota precisa de um veículo válido.");
        }
    }

    public void iniciarEntrega() {
        System.out.println("Levando pacote " + this.pacote.getCodigoRastreio() + " no veículo: " + this.veiculo.getDescricao());
        this.pacote.atualizarStatus("Em Transporte");
    }
}

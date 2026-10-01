package br.com.fiapdelivery.model;

public class Caminhao extends Veiculo {

    private int numeroEixos;

    public Caminhao(String placa, double capacidadeCargaKg, int numeroEixos) {
        super(placa, capacidadeCargaKg);
        this.setNumeroEixos(numeroEixos);
    }

    public int getNumeroEixos() {
        return this.numeroEixos;
    }

    // Regra de negócio: um caminhão precisa de pelo menos 2 eixos para rodar.
    private void setNumeroEixos(int numeroEixos) {
        if (numeroEixos >= 2) {
            this.numeroEixos = numeroEixos;
        } else {
            System.out.println("Erro: Um caminhão precisa ter pelo menos 2 eixos.");
        }
    }

    @Override
    public String getDescricao() {
        return "Caminhão " + this.getPlaca() + " (capacidade: " + this.getCapacidadeCargaKg() + "kg, " + this.numeroEixos + " eixos)";
    }
}

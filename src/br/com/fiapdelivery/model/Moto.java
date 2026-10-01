package br.com.fiapdelivery.model;

public class Moto extends Veiculo {

    private boolean possuiBau;

    public Moto(String placa, double capacidadeCargaKg, boolean possuiBau) {
        super(placa, capacidadeCargaKg);
        this.possuiBau = possuiBau;
    }

    public boolean isPossuiBau() {
        return this.possuiBau;
    }

    @Override
    public String getDescricao() {
        return "Moto " + this.getPlaca() + " (capacidade: " + this.getCapacidadeCargaKg() + "kg, baú: " + (this.possuiBau ? "sim" : "não") + ")";
    }
}

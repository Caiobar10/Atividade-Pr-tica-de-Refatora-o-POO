package br.com.fiapdelivery.model;

// Superclasse que representa qualquer veículo de entrega do FiapDelivery.
// Caminhao e Moto herdam daqui os dados e regras que são comuns aos dois.
public abstract class Veiculo {

    private String placa;
    private double capacidadeCargaKg;

    protected Veiculo(String placa, double capacidadeCargaKg) {
        this.setPlaca(placa);
        this.setCapacidadeCargaKg(capacidadeCargaKg);
    }

    public String getPlaca() {
        return this.placa;
    }

    public double getCapacidadeCargaKg() {
        return this.capacidadeCargaKg;
    }

    private void setPlaca(String placa) {
        if (placa != null && !placa.trim().isEmpty()) {
            this.placa = placa;
        } else {
            System.out.println("Erro: A placa do veículo não pode ser vazia.");
        }
    }

    // Regra de negócio: a capacidade de carga tem que ser positiva.
    // No código legado, "c.cap = -500.0" era aceito de boa — aqui isso é bloqueado.
    private void setCapacidadeCargaKg(double capacidadeCargaKg) {
        if (capacidadeCargaKg > 0) {
            this.capacidadeCargaKg = capacidadeCargaKg;
        } else {
            System.out.println("Erro de Segurança: Capacidade de carga inválida. Deve ser maior que zero.");
        }
    }

    // Cada tipo de veículo sabe descrever a si mesmo — é isso que permite
    // a Rota trabalhar com qualquer Veiculo sem precisar saber se é Caminhao ou Moto.
    public abstract String getDescricao();
}

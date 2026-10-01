package br.com.fiapdelivery.main;

import br.com.fiapdelivery.model.Caminhao;
import br.com.fiapdelivery.model.Moto;
import br.com.fiapdelivery.model.Pacote;
import br.com.fiapdelivery.model.Rota;
import br.com.fiapdelivery.model.Veiculo;

public class Principal {

    public static void main(String[] args) {

        System.out.println("--- Sistema FiapDelivery ---\n");

        // TESTE 1: forma correta, com Caminhao
        Veiculo caminhao = new Caminhao("ABC-1234", 3000.0, 4);
        Pacote pacote1 = new Pacote("BR999", 10.5);
        Rota rota1 = new Rota(pacote1, caminhao);
        rota1.iniciarEntrega();

        System.out.println();

        // TESTE 2: a mesma Rota, agora com uma Moto — antes isso era IMPOSSÍVEL
        // porque Rota só aceitava "caminhao". Essa é a correção do crime #4.
        Veiculo moto = new Moto("XYZ-5678", 15.0, true);
        Pacote pacote2 = new Pacote("BR888", 2.3);
        Rota rota2 = new Rota(pacote2, moto);
        rota2.iniciarEntrega();

        System.out.println();

        // TESTE 3: tentando repetir o crime do código legado (capacidade negativa).
        // Antes: c.cap = -500.0; era aceito sem nenhum aviso.
        // Agora: o construtor bloqueia e avisa.
        System.out.println("--- Testando a proteção contra dados inválidos ---");
        Veiculo caminhaoInvalido = new Caminhao("DEF-0000", -500.0, 4);
        System.out.println("Capacidade registrada: " + caminhaoInvalido.getCapacidadeCargaKg() + "kg (ficou 0.0 porque o valor foi rejeitado)");

        // TESTE 4: tentando um status de pacote que não existe.
        pacote1.atualizarStatus("Sumiu no caminho"); // inválido -> bloqueado
    }
}

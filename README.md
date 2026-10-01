# FiapDelivery — Refatoração (Check Point 2, POO)

Atividade de refatoração da disciplina de Programação Orientada a Objetos (Prof. Ygor Anjos).
O código original (feito por um "estagiário") compilava, mas cometia 4 crimes contra a
Engenharia de Software. Este repositório é a versão corrigida.

## Os 4 crimes do código legado e a correção

| # | Crime | Correção |
|---|---|---|
| 1 | Nomes sem sentido (`pl`, `cap`, `p1`, `c1`, `muda`) | Nomes claros: `placa`, `capacidadeCargaKg`, `pacote`, `veiculo`, `atualizarStatus` |
| 2 | Todos os atributos `public` | Todos `private`, com getters públicos e setters privados validando regra de negócio |
| 3 | `caminhao` e `moto` duplicavam `pl`/`cap` | Superclasse abstrata `Veiculo` concentra o que é comum; `Caminhao` e `Moto` herdam dela |
| 4 | `Rota` só aceitava `caminhao` | `Rota` agora guarda um `Veiculo` (o tipo abstrato) — aceita `Caminhao`, `Moto` ou qualquer veículo futuro |

## Estrutura

- `br.com.fiapdelivery.model` — `Veiculo` (abstrata), `Caminhao`, `Moto`, `Pacote`, `Rota`
- `br.com.fiapdelivery.main` — `Principal` (ponto de entrada)

## Classes

- **Veiculo** (abstrata) — placa e capacidade de carga (kg), com validação (capacidade tem que ser positiva). Declara `getDescricao()` como abstrato.
- **Caminhao** — herda de `Veiculo`, acrescenta `numeroEixos` (regra: mínimo de 2).
- **Moto** — herda de `Veiculo`, acrescenta `possuiBau`.
- **Pacote** — código de rastreio, peso (kg) e status. Nasce sempre como `"Pendente"`. `atualizarStatus()` só aceita um status de uma lista fixa (Pendente, Em Transporte, Entregue, Cancelado).
- **Rota** — associa um `Pacote` a um `Veiculo` (qualquer um). `iniciarEntrega()` usa `veiculo.getDescricao()` e atualiza o status do pacote.

## Como rodar

```bash
javac -d bin $(find src -name "*.java")
java -cp bin br.com.fiapdelivery.main.Principal
```

## Diagrama de classes

Ver `docs/diagrama-uml.png` (exportado do Astah).

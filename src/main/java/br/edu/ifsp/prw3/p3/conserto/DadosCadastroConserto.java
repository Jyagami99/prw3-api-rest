package br.edu.ifsp.prw3.p3.conserto;

import br.edu.ifsp.prw3.p3.mecanico.DadosCadastroMecanico;
import br.edu.ifsp.prw3.p3.veiculo.DadosCadastroVeiculo;

public record DadosCadastroConserto(String dataEntrada, String dataSaida, DadosCadastroMecanico mecanico, DadosCadastroVeiculo veiculo) {
}

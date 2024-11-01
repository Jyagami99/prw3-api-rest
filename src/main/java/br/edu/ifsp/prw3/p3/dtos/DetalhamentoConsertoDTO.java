package br.edu.ifsp.prw3.p3.dtos;

import br.edu.ifsp.prw3.p3.models.Conserto;
import br.edu.ifsp.prw3.p3.models.Mecanico;
import br.edu.ifsp.prw3.p3.models.Veiculo;

public record DetalhamentoConsertoDTO(Long id, String data_entrada, String data_saida,
                                      Mecanico mecanico, Veiculo veiculo) {

    public DetalhamentoConsertoDTO(Conserto conserto) {
        this(conserto.getId(), conserto.getData_entrada(), conserto.getData_saida(),
                conserto.getMecanico(), conserto.getVeiculo());
    }
}

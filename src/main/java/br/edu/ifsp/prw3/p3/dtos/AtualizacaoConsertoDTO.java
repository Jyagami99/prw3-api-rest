package br.edu.ifsp.prw3.p3.dtos;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoConsertoDTO(@NotNull Long id, String data_saida, MecanicoRecordDTO mecanico) {
}

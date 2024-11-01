package br.edu.ifsp.prw3.p3.dtos;

import br.edu.ifsp.prw3.p3.models.Conserto;

public record ListagemConsertoDTO(Long id, String data_entrada, String data_saida, String nome_mecanico, String marca,
                                  String modelo) {
    public ListagemConsertoDTO(Conserto conserto) {
        this(conserto.getId(), conserto.getData_entrada(), conserto.getData_saida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
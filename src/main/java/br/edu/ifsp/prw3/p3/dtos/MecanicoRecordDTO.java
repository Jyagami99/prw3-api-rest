package br.edu.ifsp.prw3.p3.dtos;

import jakarta.validation.constraints.NotBlank;

public record MecanicoRecordDTO(@NotBlank String nome, int anos_experiencia) {
}
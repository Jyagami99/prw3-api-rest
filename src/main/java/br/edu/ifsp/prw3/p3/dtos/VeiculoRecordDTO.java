package br.edu.ifsp.prw3.p3.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoRecordDTO(@NotBlank String marca, @NotBlank String modelo, String cor,
                               @NotBlank @Pattern(regexp = "^\\d{4}$", message = "Ano inválido. Use o formato yyyy") String ano) {
}

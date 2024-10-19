package br.edu.ifsp.prw3.p3.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoRecordDTO(
        @NotBlank @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de data inválido. Use o formato mm/dd/yyyy") String data_entrada,
        @NotBlank @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de data inválido. Use o formato mm/dd/yyyy") String data_saida,
        @NotNull @Valid MecanicoRecordDTO mecanico,
        @NotNull @Valid VeiculoRecordDTO veiculo) {
}

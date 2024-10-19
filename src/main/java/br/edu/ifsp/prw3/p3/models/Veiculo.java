package br.edu.ifsp.prw3.p3.models;

import br.edu.ifsp.prw3.p3.dtos.VeiculoRecordDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String cor;
    private String ano;

    public Veiculo(VeiculoRecordDTO dados){
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.cor = dados.cor();
        this.ano = dados.ano();
    }
}

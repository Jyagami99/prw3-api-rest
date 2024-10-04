package br.edu.ifsp.prw3.p3.veiculo;

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
    private int ano;

    public Veiculo(DadosCadastroVeiculo dados){
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }
}

package br.edu.ifsp.prw3.p3.conserto;

import br.edu.ifsp.prw3.p3.mecanico.Mecanico;
import br.edu.ifsp.prw3.p3.veiculo.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_entrada")
    private String dataEntrada;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_saida")
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    public Conserto(DadosCadastroConserto dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }
}
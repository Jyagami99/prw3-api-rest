package br.edu.ifsp.prw3.p3.models;

import br.edu.ifsp.prw3.p3.dtos.AtualizacaoConsertoDTO;
import br.edu.ifsp.prw3.p3.dtos.ConsertoRecordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "conserto")
@Entity(name = "conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data_entrada;
    private String data_saida;

    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;
    private Boolean ativo;

    public Conserto(ConsertoRecordDTO dados) {
        this.data_entrada = dados.data_entrada();
        this.data_saida = dados.data_saida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
        this.ativo = true;
    }

    public void atualizarInformacoes(AtualizacaoConsertoDTO dados){
        if(dados.data_saida() != null){
            this.data_saida = dados.data_saida();
        }
        if(dados.mecanico() != null){
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
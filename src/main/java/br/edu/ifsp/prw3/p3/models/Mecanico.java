package br.edu.ifsp.prw3.p3.models;

import br.edu.ifsp.prw3.p3.dtos.MecanicoRecordDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
   private String nome;
   private String anos_experiencia;

   public Mecanico(MecanicoRecordDTO dados) {
      this.nome = dados.nome();
      this.anos_experiencia = dados.anos_experiencia();
   }

   public void atualizarInformacoes(MecanicoRecordDTO dados){
      if(dados.nome() != null){
         this.nome = dados.nome();
      }
      if(dados.anos_experiencia() != null){
         this.anos_experiencia = dados.anos_experiencia();
      }
   }

}
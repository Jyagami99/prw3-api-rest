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
   private int anos_experiencia;

   public Mecanico(MecanicoRecordDTO dados) {
      this.nome = dados.nome();
      this.anos_experiencia = dados.anos_experiencia();
   }
}
package br.edu.ifsp.prw3.p3.mecanico;

import jakarta.persistence.Column;
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
   @Column(name = "anos_experiencia")
   private int anosExperiencia;

   public Mecanico(DadosCadastroMecanico dados) {
      this.nome = dados.nome();
      this.anosExperiencia = dados.anosExperiencia();
   }
}
package br.edu.ifsp.prw3.p3.user;

import jakarta.validation.constraints.NotBlank;

public record dadosAuthentication(@NotBlank String login, @NotBlank String senha) {
}


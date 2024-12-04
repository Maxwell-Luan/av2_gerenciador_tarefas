package com.arquiteturaWeb.provaAv2.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Schema(description = "Representa um usuário do sistema")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome de usuário", example = "johndoe")
    private String username;

    @Schema(description = "Senha do usuário", example = "senha123")
    private String password;
}

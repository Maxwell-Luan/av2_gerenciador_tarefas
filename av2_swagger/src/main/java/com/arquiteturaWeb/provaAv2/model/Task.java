package com.arquiteturaWeb.provaAv2.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Schema(description = "Representa uma tarefa do sistema")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único da tarefa", example = "1")
    private Long id;

    @Schema(description = "Título ou descrição breve da tarefa", example = "Finalizar projeto de arquitetura")
    private String title;

    @ManyToOne
    @Schema(description = "Usuário associado à tarefa")
    private User user;
}

package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HistoricoManutencao {
    private String id;
    private long maquinaID;
    private LocalDate data;
    private String tipo;
    private String pecasTrocadas;
    private long tempoDeParada;
    private String tecnicoID;
    private String observacoes;
}

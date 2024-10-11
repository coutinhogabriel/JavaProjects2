package com.example.controllers;

import java.util.*;
import com.example.api.FalhaAPI;
import com.example.models.Falhas;

public class FalhaController {
    private List<Falhas> falhas;

    public FalhaController() {
        falhas = new ArrayList<>();
    }

    // Método CRUD
    public void createFalha(Falhas falha) {
        this.falhas.add(falha);
    }

    // Método Read
    public List<Falhas> readFalhas() {
        falhas = FalhaAPI.getFalhas();
        return falhas;
    }

    // Método Update
    public void updateFalha(int posicao, Falhas falha) {
        falhas.set(posicao, falha);
    }

    // Método Delete
    public void deleteFalha(int posicao) {
        falhas.remove(posicao);
    }
}

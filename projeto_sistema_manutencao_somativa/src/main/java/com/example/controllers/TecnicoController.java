package com.example.controllers;

import java.util.*;
import com.example.api.TecnicoAPI;
import com.example.models.Tecnicos;

public class TecnicoController {
    private List<Tecnicos> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<>();
    }

    // Método CRUD
    public void createTecnico(Tecnicos tecnico) {
        this.tecnicos.add(tecnico);
    }

    // Método Read
    public List<Tecnicos> readTecnicos() {
        tecnicos = TecnicoAPI.getTecnicos();
        return tecnicos;
    }

    // Método Update
    public void updateTecnico(int posicao, Tecnicos tecnico) {
        tecnicos.set(posicao, tecnico);
    }

    // Método Delete
    public void deleteTecnico(int posicao) {
        tecnicos.remove(posicao);
    }
}

package com.example.controllers;
import java.util.*;

import com.example.api.MaquinaAPI;
import com.example.models.*;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {
        maquinas = new ArrayList<>();
    }
    //método crud
    public void createMaquina(Maquina maquina) {
        this.maquinas.add(maquina);
    }
    //método read
    public List<Maquina> readMaquinas() {
        maquinas = MaquinaAPI.getMaquinas();
        return maquinas;
}
    //método update
    public void updateMaquina(int posicao, Maquina maquina) {
        maquinas.set(posicao, maquina);
    }
    //método delete
    public void deleteMaquina(int posicao) {
        maquinas.remove(posicao);
    }
}
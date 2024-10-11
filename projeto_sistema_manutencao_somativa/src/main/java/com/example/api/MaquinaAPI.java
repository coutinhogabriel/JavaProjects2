package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import java.time.LocalDate;

import com.example.models.Maquina;

import java.util.ArrayList;
import java.util.List;

public class MaquinaAPI {

    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                        jsonObject.getString("id"),
                        jsonObject.getString("codigo"),
                        jsonObject.getString("nome"),
                        jsonObject.getString("modelo"),
                        jsonObject.getString("fabricante"),
                        LocalDate.parse(jsonObject.getString("dataAquisicao")),
                        jsonObject.getInt("tempoVidaEstimado"),
                        jsonObject.getString("localizacao"),
                        jsonObject.getString("detalhes"),
                        jsonObject.getString("manual"));
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    public static void postMaquinas(Maquina maquina) {
        // Criar um Objeto Json
        JSONObject maquinaObject = new JSONObject();
        maquinaObject.put("id", maquina.getId());
        maquinaObject.put("codigo", maquina.getCodigo());
        maquinaObject.put("nome", maquina.getNome());
        maquinaObject.put("modelo", maquina.getModelo());
        maquinaObject.put("dataAquisicao", maquina.getDataAquisicao().toString());
        maquinaObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaObject.put("localizacao", maquina.getLocalizacao());
        maquinaObject.put("detalhes", maquina.getDetalhes());
        maquinaObject.put("manual", maquina.getManual());

        // gravando
        if (!maquinaObject.isEmpty()) {
            ApiConnection.postData("maquinas", maquinaObject.toString());
        }

    }

}

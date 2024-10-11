package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.example.models.Falhas;

public class FalhaAPI {
    public static List<Falhas> getFalhas() {
        String json = ApiConnection.getData("falhas");
        List<Falhas> falhas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                
                Falhas falha = new Falhas(
                    jsonObject.getString("id"),
                    jsonObject.getInt("maquinaId"),
                    LocalDate.parse(jsonObject.getString("data")),
                    jsonObject.getString("problema"),
                    jsonObject.getString("prioridade"),
                    jsonObject.getString("operador")
                );
                falhas.add(falha);
            }
        }
        return falhas;
    }
}

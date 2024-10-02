package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class UsuarioController {
    private List<Usuario> usuarios;
    private URL url;

    public UsuarioController() {
        usuarios = new ArrayList<>();
    }

    public void read() {
        try {
            // estabelecer conexão
            URL url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // verifiar status da conexão
            int status = con.getResponseCode();
            if (status != 200) {// diferente de 200 lanças uma exception
                throw new Exception("Erro de conexão");

            }
            // gravar os dados da api na memoria
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linha;
            // converter em um arquivo de texto (stringbuffer)
            StringBuffer content = new StringBuffer();
            // lê a resposta da api linha por linha
            while ((linha = br.readLine()) != null) {
                content.append(linha);

            }
            br.close();// fecha a conexão
            // converter o arquivo de texto para dados da classe usuario
            JSONArray dadosUsuarios = new JSONArray(content.toString());

            // adiciona os dados na lista
            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                        usuarioJson.getString("id"),
                        usuarioJson.getString("nome"),
                        usuarioJson.getInt("idade"),
                        usuarioJson.getString("endereco")));
                System.out.println(usuarios.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createUser(Usuario usuario) {
        try {
            // estabelecer conexão
            URL url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true); // Para enviar dados no corpo da requisição

            // criar objeto JSON para o novo usuário
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());

            // enviar os dados para API
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(con.getOutputStream(), "UTF-8"))) {
                bw.write(usuarioJson.toString());
                bw.flush();
            }

            // verificar status da resposta
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_CREATED) { // 201 Created
                throw new Exception("Erro ao criar usuário: " + status);
            }

            System.out.println("Usuario Cadastrado com Sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

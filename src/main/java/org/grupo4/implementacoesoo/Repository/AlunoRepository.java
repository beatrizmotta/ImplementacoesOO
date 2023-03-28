package org.grupo4.implementacoesoo.Repository;

import org.grupo4.implementacoesoo.Domain.Aluno;
import org.grupo4.implementacoesoo.Domain.Responsavel;
import org.grupo4.implementacoesoo.Domain.User;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class AlunoRepository implements UserRepository {

    @Override
    public Aluno getInfo(String numeroDeMatricula) {
        Aluno aluno = new Aluno();

        try {
            FileReader fileReader = new FileReader(numeroDeMatricula + ".json");

            try {
                Object alunoObject = new JSONParser().parse(fileReader);

                JSONObject alunoObjectJSON = (JSONObject) alunoObject;

                aluno.setSerie((Long) alunoObjectJSON.get("serie"));
                aluno.setEnsino((String) alunoObjectJSON.get("tipoDeEnsino"));
                aluno.setTurno((String) alunoObjectJSON.get("turno"));
                aluno.setNumeroDeMatricula((Long) alunoObjectJSON.get("numeroMatricula"));
                aluno.setMensalidade((String) alunoObjectJSON.get("valorMensalidade"));
                aluno.setPayDay((Long) alunoObjectJSON.get("dataVencFatura"));
                aluno.setSuspenso((Boolean) alunoObjectJSON.get("suspenso"));
                JSONArray alunoResponsaveisArray = (JSONArray) alunoObjectJSON.get("responsaveis");

                for (Object resp : alunoResponsaveisArray) {
                    JSONObject respJSON = (JSONObject) resp;
                    Responsavel responsavel = new Responsavel((String) respJSON.get("nome"), (String) respJSON.get("telefone"));
                    aluno.addResponsavel(responsavel);
                }

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do aluno.");
            }

        } catch (final IOException e) {
            System.out.println("Não existe aluno com esse número de matrícula!");
       }

        return aluno;
    }

    @Override
    public void saveInfo(User user) {
        Aluno aluno = (Aluno) user;
        JSONObject alunoJSONObject = new JSONObject();

        alunoJSONObject.put("numeroMatricula", aluno.getNumeroDeMatricula());
        alunoJSONObject.put("nome", aluno.getNome());
        alunoJSONObject.put("dataNasc", aluno.getDataNasc());
        alunoJSONObject.put("responsaveis", aluno.getResponsaveisAsJSON());
        alunoJSONObject.put("serie", aluno.getSerie());
        alunoJSONObject.put("tipoDeEnsino", aluno.getEnsino());
        alunoJSONObject.put("turno", aluno.getTurno());
        alunoJSONObject.put("valorMensalidade", aluno.getMensalidade());
        alunoJSONObject.put("dataVencFatura", aluno.getPayDay());
        alunoJSONObject.put("suspenso", aluno.getSuspenso());

        try {
            PrintWriter pw = new PrintWriter(aluno.getNumeroDeMatricula() + ".json");
            pw.write(alunoJSONObject.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os dados do aluno.");
        }

    }
}

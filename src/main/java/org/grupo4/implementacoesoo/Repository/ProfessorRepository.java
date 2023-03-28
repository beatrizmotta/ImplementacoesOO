package org.grupo4.implementacoesoo.Repository;

import org.grupo4.implementacoesoo.Domain.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfessorRepository implements UserRepository {
    @Override
    public Professor getInfo(String cpf) {

        Professor professor = new Professor();

        try {
            FileReader fileReader = new FileReader(cpf + ".json");

            try {
                Object professorObject = new JSONParser().parse(fileReader);

                JSONObject professorObjectJSON = (JSONObject) professorObject;

                professor.setNome((String) professorObjectJSON.get("nome"));
                professor.setCpf((Long) professorObjectJSON.get("cpf"));
                professor.setDataNasc((String) professorObjectJSON.get("dataNasc"));
                professor.setPayDay((Long) professorObjectJSON.get("dataPagamento"));
                professor.setSalarioHora((Double) professorObjectJSON.get("salarioHora"));
                professor.setCargaHoraria((int) professorObjectJSON.get("cargaHoraria"));
                JSONArray professorTurmasArray = (JSONArray) professorObjectJSON.get("turmas");

                for (Object tur : professorTurmasArray) {
                    JSONObject turmaJSON = (JSONObject) tur;
                    Turma turma = new Turma((String) turmaJSON.get("nome"));
                    professor.addTurma(turma);
                }

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do professor.");
            }

        } catch (final IOException e) {
            System.out.println("Não existe professor com esse número de matrícula!");
        }

        return professor;
    }
    @Override
    public void saveInfo(User user) {
        Professor professor = (Professor) user;
        JSONObject professorJSONObject = new JSONObject();

        professorJSONObject.put("nome", professor.getNome());
        professorJSONObject.put("dataNasc", professor.getDataNasc());
        professorJSONObject.put("cpf", professor.getCpf());
        professorJSONObject.put("dataPagamento", professor.getPayDay());
        professorJSONObject.put("salarioHora", professor.getSalarioHora());
        professorJSONObject.put("cargaHoraria", professor.getCargaHoraria());
        professorJSONObject.put("turmas", professor.getTurmasAsJSON());

        try {
            PrintWriter pw = new PrintWriter(professor.getCpf() + ".json");
            pw.write(professorJSONObject.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os dados do professor.");
        }

    }
}

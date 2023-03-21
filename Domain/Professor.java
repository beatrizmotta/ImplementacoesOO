package Domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Professor extends User {
    private double salarioHora;
    private int cargaHoraria;
    private ArrayList<Turma> turmas;

    public Professor() {
        super();
    }
    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList getTurmas() {
        return turmas;
    }

    public JSONArray getTurmasAsJSON() {
        JSONArray arr = new JSONArray();

        for (Turma turma : turmas) {
            JSONObject respJSON = new JSONObject();
            respJSON.put("nome", turma.getNome());
            arr.add(respJSON);
        }

        return arr;
    }
    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }
}

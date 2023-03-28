package org.grupo4.implementacoesoo.Repository;

import org.grupo4.implementacoesoo.Domain.Administrador;
import org.grupo4.implementacoesoo.Domain.Aluno;
import org.grupo4.implementacoesoo.Domain.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class AdministradorRepository implements UserRepository {

    @Override
    public Administrador getInfo(String id) {
        Administrador administrador = new Administrador();

        try {
            FileReader fileReader = new FileReader("../admins.json");
            System.out.println("Consegui passar pelo primeiro try");
            try {
                Object adminObject = new JSONParser().parse(fileReader);

                JSONObject adminObjectJSON = (JSONObject) adminObject;

                administrador.setId((String) adminObjectJSON.get("id"));
                administrador.setSenha((String) adminObjectJSON.get("senha"));

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do admin.");
            }

        } catch (final IOException e) {
            System.out.println(e.getClass().getName());
        }

        return administrador;
    }

    @Override
    public void saveInfo(User user) {

    }


}

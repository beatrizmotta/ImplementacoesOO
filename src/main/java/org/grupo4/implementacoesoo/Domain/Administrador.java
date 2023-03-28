package org.grupo4.implementacoesoo.Domain;

public class Administrador extends User {
    protected String id;
    protected String senha;

    public Administrador() {super();}
    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {return senha;}
}

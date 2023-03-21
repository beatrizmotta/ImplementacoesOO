package Domain;

public class User {
    protected String nome;
    protected long cpf;
    protected String dataNasc;
    protected long payDay;

    public User() {
        this.nome = "DEFAULT";
        this.cpf = 0;
        this.dataNasc = "XX/XX/XXXX";
    }
    public User(String nome, int cpf, String dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    // Getters e setters
    public String getNome() {
        return this.nome;
    }
    public long getCpf() {
        return this.cpf;
    }
    public String getDataNasc() {
        return this.dataNasc;
    }

    public long getPayDay() {
        return this.payDay;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setPayDay(long payDay) {
        this.payDay = payDay;
    }

}
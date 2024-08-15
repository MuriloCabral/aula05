package org.example;

public class Pessoa {
    private String cpf;

    private String nome;
    private String placa;

    public Pessoa(String cpf, String nome, String placa) {
        this.cpf = cpf;
        this.nome = nome;
        this.placa = placa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() { return placa; }

    public void setNome(String nome) { this.placa = nome; }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String nome) {
        this.placa = nome;
    }
}

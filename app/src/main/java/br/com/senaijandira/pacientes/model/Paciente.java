package br.com.senaijandira.pacientes.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Paciente {

    private int id;
    private String nome;
    @SerializedName("data_nascimento")
    private int dataNascimento;
    private String numeroSus;
    private String cpf;
    private List<String> consultas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroSus() {
        return numeroSus;
    }

    public void setNumeroSus(String numeroSus) {
        this.numeroSus = numeroSus;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<String> consultas) {
        this.consultas = consultas;
    }
}

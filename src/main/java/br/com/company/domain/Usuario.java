package br.com.company.domain;

import java.util.Map;
import java.util.Objects;

public class Usuario {

    private Integer id;

    private String nome;

    private String cpf;

    private String email;

    private Double valor;

    private Integer parcelas;

    private Boolean seguro;

    public Usuario(Map<String, String> usuario) {
        this.nome = usuario.get("nome");
        this.cpf = usuario.get("cpf");
        this.email = usuario.get("email");
        this.valor = Double.valueOf(usuario.get("valor"));
        this.parcelas = Integer.valueOf(usuario.get("parcelas"));
        this.seguro = Boolean.valueOf(usuario.get("seguro"));
    }

    public Usuario() {
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) && cpf.equals(usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

    @Override
    public String toString() {

        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", valor=" + valor +
                ", parcelas=" + parcelas +
                ", seguro=" + seguro +
                '}';
    }
}

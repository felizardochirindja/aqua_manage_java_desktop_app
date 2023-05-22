package modulos.usuario;

import java.io.Serializable;

public abstract class UsuarioEntidade implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    protected String codigo;
    protected int idade;
    protected String telefone;
    protected String nome;
    protected String senha;
    protected String endereco;
    protected String nivelDeAcesso;
    protected boolean foiRemovido;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isFoiRemovido() {
        return foiRemovido;
    }

    public void setFoiRemovido(boolean foiRemovido) {
        this.foiRemovido = foiRemovido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }
}

package modulos.cliente;

import java.io.Serializable;

public class ClienteEntidade implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private String codigo;
    private String nome;
    private String residencia;
    private String telefone;
    private ContratoEntidade contrato;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ContratoEntidade getContrato() {
        return contrato;
    }

    public void setContrato(ContratoEntidade contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "ClienteEntidade{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", residencia='" + residencia + '\'' +
                ", telefone='" + telefone + '\'' +
                ", contrato=" + contrato +
                '}';
    }
}

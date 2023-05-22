package modulos.cliente;

import java.io.Serializable;

public class ContratoEntidade implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private String dataInicio;
    private String dataTermino;
    private String tipo; // (residencial, comercial)
    private String formaDePagamento; // (taxa unica, taxa consumo)
    private boolean ativo;

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

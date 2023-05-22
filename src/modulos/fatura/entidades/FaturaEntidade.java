package modulos.fatura.entidades;

import modulos.cliente.ClienteEntidade;
import modulos.fatura.LeituraDoContador;

import java.io.Serializable;
import java.util.List;

public class FaturaEntidade implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private String codigo;
    private double valorPorPgar;
    private double valorPago;
    private double valorRemanescente;
    private String codigoDaFatura;
    private String dataDeEmissao;
    private String dataDeVencimento;
    private String status; // paga, aberta, vencida
    private ClienteEntidade ClienteEntidade;
    private LeituraDoContador leituraDoContador;
    private List<MultaEntidade> multas;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValorPorPgar() {
        return valorPorPgar;
    }

    public void setValorPorPgar(double valorPorPgar) {
        this.valorPorPgar = valorPorPgar;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorRemanescente() {
        return valorRemanescente;
    }

    public void setValorRemanescente(double valorRemanescente) {
        this.valorRemanescente = valorRemanescente;
    }

    public String getCodigoDaFatura() {
        return codigoDaFatura;
    }

    public void setCodigoDaFatura(String codigoDaFatura) {
        this.codigoDaFatura = codigoDaFatura;
    }

    public String getDataDeEmissao() {
        return dataDeEmissao;
    }

    public void setDataDeEmissao(String dataDeEmissao) {
        this.dataDeEmissao = dataDeEmissao;
    }

    public String getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(String dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public modulos.cliente.ClienteEntidade getClienteEntidade() {
        return ClienteEntidade;
    }

    public void setClienteEntidade(modulos.cliente.ClienteEntidade clienteEntidade) {
        ClienteEntidade = clienteEntidade;
    }

    public LeituraDoContador getLeituraDoContador() {
        return leituraDoContador;
    }

    public void setLeituraDoContador(LeituraDoContador leituraDoContador) {
        this.leituraDoContador = leituraDoContador;
    }

    public List<MultaEntidade> getMultas() {
        return multas;
    }

    public void setMultas(List<MultaEntidade> multas) {
        this.multas = multas;
    }

    @Override
    public String toString() {
        return "FaturaEntidade{" +
                "codigo='" + codigo + '\'' +
                ", valorPorPgar=" + valorPorPgar +
                ", valorPago=" + valorPago +
                ", valorRemanescente=" + valorRemanescente +
                ", codigoDaFatura='" + codigoDaFatura + '\'' +
                ", dataDeEmissao='" + dataDeEmissao + '\'' +
                ", dataDeVencimento='" + dataDeVencimento + '\'' +
                ", status='" + status + '\'' +
                ", ClienteEntidade=" + ClienteEntidade.getNome() +
                ", leituraDoContador=" + leituraDoContador +
                '}';
    }
}

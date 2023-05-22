package modulos.fatura;

import java.io.Serializable;

public class LeituraDoContador implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private double quantidade;

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}

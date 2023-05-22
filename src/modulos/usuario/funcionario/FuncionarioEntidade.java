package modulos.usuario.funcionario;

import modulos.usuario.UsuarioEntidade;

import java.io.Serializable;
import java.util.Date;

public class FuncionarioEntidade extends UsuarioEntidade implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    private Date dataDeAdmissao;

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    @Override
    public String toString() {
        return "FuncionarioEntidade{" +
                "codigoDoFuncionario=" + codigo +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", nome='" + nome + '\'' +
                ", dataDeAdmissao=" + dataDeAdmissao +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}

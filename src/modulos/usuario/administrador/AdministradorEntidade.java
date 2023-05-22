package modulos.usuario.administrador;

import modulos.usuario.UsuarioEntidade;

import java.io.Serializable;

public class AdministradorEntidade extends UsuarioEntidade implements Serializable {
    private static final long serialVersionUID = -8577697151743549160L;

    @Override
    public String toString() {
        return "administrador{" +
                "codigo=" + codigo +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", nivel de acesso='" + nivelDeAcesso + '\'' +
                '}';
    }
}

package modulos.autenticacao;

import modulos.usuario.UsuarioEntidade;

public class AutenticacaoServico {
    private AutenticacaoArmazenamento autenticacaoArmazenamento;

    public AutenticacaoServico(AutenticacaoArmazenamento autenticacaoArmazenamento) {
        this.autenticacaoArmazenamento = autenticacaoArmazenamento;
    }

    public UsuarioEntidade iniciarSessao(String nome, String senha) {
        UsuarioEntidade usuario = autenticacaoArmazenamento.iniciarSessao(nome, senha);

        if (usuario == null) return null;

        this.autenticacaoArmazenamento.armazenarUsuarioLogado(usuario);
        return usuario;
    }

    public UsuarioEntidade getUsuarioLogado() {
        return this.autenticacaoArmazenamento.pegarUsuarioLogado();
    }
}

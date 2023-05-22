import modulos.autenticacao.AutenticacaoArmazenamento;
import modulos.autenticacao.AutenticacaoControlador;
import modulos.autenticacao.AutenticacaoServico;
import modulos.autenticacao.telas.TelaIniciarSessao;
import modulos.usuario.administrador.AdministradorArmazenamento;
import modulos.usuario.administrador.AdministradorControlador;
import modulos.usuario.administrador.AdministradorServico;
import modulos.usuario.administrador.telas.TelaCadastrarAdministrador;
import modulos.usuario.funcionario.FuncionarioArmazenamento;

public class Main {
    public static void main(String[] args) {
        AdministradorArmazenamento administradorArmazenamento = new AdministradorArmazenamento();

        if (administradorArmazenamento.listar().isEmpty()) {
            new AdministradorControlador(new AdministradorServico(administradorArmazenamento), new TelaCadastrarAdministrador());
        } else {
            new AutenticacaoControlador(new TelaIniciarSessao(), new AutenticacaoServico(new AutenticacaoArmazenamento(
                    new FuncionarioArmazenamento(), administradorArmazenamento
            )));
        }
    }
}
package modulos.usuario.funcionario;

import java.util.List;

public class FuncionarioServico {
    private FuncionarioArmazenamento funcionarioArmazenamento;

    public FuncionarioServico(FuncionarioArmazenamento funcionarioArmazenamento) {
        this.funcionarioArmazenamento = funcionarioArmazenamento;
    }

    public void criar(FuncionarioEntidade funcionario) {
        List<FuncionarioEntidade> funcionarios = listarFuncionarios();
        funcionario.setNivelDeAcesso("funcionario");
        funcionarios.add(funcionario);

        this.funcionarioArmazenamento.criar(funcionarios);
    }

    public List<FuncionarioEntidade> listarFuncionarios() {
        return funcionarioArmazenamento.listar();
    }
}

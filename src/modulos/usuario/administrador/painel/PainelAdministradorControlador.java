package modulos.usuario.administrador.painel;

import modulos.autenticacao.AutenticacaoArmazenamento;
import modulos.autenticacao.AutenticacaoServico;
import modulos.cliente.ClienteArmazenamento;
import modulos.cliente.ClienteControlador;
import modulos.cliente.ClienteServico;
import modulos.cliente.telas.TelaCadastrarCliente;
import modulos.cliente.telas.TelaListarClientes;
import modulos.fatura.FaturaArmazenamento;
import modulos.usuario.funcionario.FuncionarioArmazenamento;
import modulos.usuario.funcionario.FuncionarioControlador;
import modulos.usuario.funcionario.FuncionarioServico;
import modulos.usuario.funcionario.telas.TelaCadastrarFuncionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelAdministradorControlador {
    private TelaPainelAdminstrador telaPainelAdminstrador;

    public PainelAdministradorControlador(TelaPainelAdminstrador telaPainelAdminstrador) {
        telaPainelAdminstrador.setVisible(true);
        this.telaPainelAdminstrador = telaPainelAdminstrador;

        this.telaPainelAdminstrador.botaoListarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListarClientes telaListarClientes = new TelaListarClientes();
                new ClienteControlador(
                        new ClienteServico(new ClienteArmazenamento(), new FaturaArmazenamento()), new TelaCadastrarCliente(), telaListarClientes, null, new AutenticacaoServico(new AutenticacaoArmazenamento())
                );

                telaListarClientes.setVisible(true);
            }
        });

        this.telaPainelAdminstrador.botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrarCliente telaCadastrarCliente = new TelaCadastrarCliente();
                telaCadastrarCliente.setVisible(true);

                new ClienteControlador(
                        new ClienteServico(new ClienteArmazenamento(), new FaturaArmazenamento()), telaCadastrarCliente, new TelaListarClientes(), null, new AutenticacaoServico(new AutenticacaoArmazenamento())
                );
            }
        });

        this.telaPainelAdminstrador.botaoCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrarFuncionario telaCadastrarFuncionario = new TelaCadastrarFuncionario();
                telaCadastrarFuncionario.setVisible(true);

                new FuncionarioControlador(telaCadastrarFuncionario, new FuncionarioServico(new FuncionarioArmazenamento()));
            }
        });
    }
}

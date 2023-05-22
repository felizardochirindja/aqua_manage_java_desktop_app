package modulos.autenticacao;

import modulos.fatura.FaturaArmazenamento;
import modulos.usuario.UsuarioEntidade;
import modulos.autenticacao.telas.TelaIniciarSessao;
import modulos.autenticacao.telas.ValidadorTelaIniciarSessao;
import modulos.cliente.ClienteArmazenamento;
import modulos.cliente.ClienteControlador;
import modulos.cliente.ClienteServico;
import modulos.cliente.telas.TelaCadastrarCliente;
import modulos.cliente.telas.TelaListarClientes;
import modulos.usuario.administrador.painel.PainelAdministradorControlador;
import modulos.usuario.administrador.painel.TelaPainelAdminstrador;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AutenticacaoControlador {
    private TelaIniciarSessao telaIniciarSessao;

    private AutenticacaoServico autenticacaoServico;

    public AutenticacaoControlador(
            TelaIniciarSessao telaIniciarSessao,
            AutenticacaoServico autenticacaoServico
    ) {
        this.telaIniciarSessao = telaIniciarSessao;

        this.telaIniciarSessao.getCampoNome().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaIniciarSessao.labelErroNome.setText(ValidadorTelaIniciarSessao.validarCampoNome(telaIniciarSessao.getNome()));
                actualizarEstadoBotaoEntrar();
            }
        });

        this.telaIniciarSessao.getCampoNome().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaIniciarSessao.labelErroNome.setText(ValidadorTelaIniciarSessao.validarCampoNome(telaIniciarSessao.getNome()));
                actualizarEstadoBotaoEntrar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaIniciarSessao.labelErroNome.setText(ValidadorTelaIniciarSessao.validarCampoNome(telaIniciarSessao.getNome()));
                actualizarEstadoBotaoEntrar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaIniciarSessao.getCampoPalavraPasse().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaIniciarSessao.labelErroPalavraPasse.setText(ValidadorTelaIniciarSessao.validarCampoPalavraPasse(telaIniciarSessao.getPalavraPasse()));
                actualizarEstadoBotaoEntrar();
            }
        });

        this.telaIniciarSessao.getCampoPalavraPasse().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaIniciarSessao.labelErroPalavraPasse.setText(ValidadorTelaIniciarSessao.validarCampoPalavraPasse(telaIniciarSessao.getPalavraPasse()));
                actualizarEstadoBotaoEntrar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaIniciarSessao.labelErroPalavraPasse.setText(ValidadorTelaIniciarSessao.validarCampoPalavraPasse(telaIniciarSessao.getPalavraPasse()));
                actualizarEstadoBotaoEntrar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaIniciarSessao.botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioEntidade usuario = autenticacaoServico.iniciarSessao(telaIniciarSessao.getNome(), String.valueOf(telaIniciarSessao.getPalavraPasse()));

                if (usuario != null && usuario.getNivelDeAcesso().equals("administrador")) {
                    telaIniciarSessao.dispose();
                    new PainelAdministradorControlador(new TelaPainelAdminstrador());
                }

                if (usuario != null && usuario.getNivelDeAcesso().equals("funcionario")) {
                    telaIniciarSessao.dispose();

                    TelaListarClientes telaListarClientes = new TelaListarClientes();
                    telaListarClientes.setVisible(true);
                    new ClienteControlador(new ClienteServico(new ClienteArmazenamento(), new FaturaArmazenamento()), new TelaCadastrarCliente(), telaListarClientes, null, new AutenticacaoServico(new AutenticacaoArmazenamento()));
                }
            }
        });

        this.telaIniciarSessao.botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaIniciarSessao.dispose();
            }
        });
    }

    private void actualizarEstadoBotaoEntrar() {
        if (
                telaIniciarSessao.labelErroPalavraPasse.getText().isEmpty() &&
                telaIniciarSessao.labelErroNome.getText().isEmpty() &&
                formularioEstaPreenchido()
        ) {
            telaIniciarSessao.botaoEntrar.setEnabled(true);
        } else {
            telaIniciarSessao.botaoEntrar.setEnabled(false);
        }
    }

    private boolean formularioEstaPreenchido() {
        return !telaIniciarSessao.getNome().isEmpty() && !(telaIniciarSessao.getPalavraPasse().length == 0);
    }
}

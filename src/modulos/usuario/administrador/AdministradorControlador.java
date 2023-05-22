package modulos.usuario.administrador;

import modulos.autenticacao.AutenticacaoArmazenamento;
import modulos.autenticacao.AutenticacaoControlador;
import modulos.autenticacao.AutenticacaoServico;
import modulos.autenticacao.telas.TelaIniciarSessao;
import modulos.usuario.administrador.telas.TelaCadastrarAdministrador;
import modulos.usuario.funcionario.FuncionarioArmazenamento;
import modulos.usuario.funcionario.FuncionarioEntidade;
import modulos.usuario.funcionario.telas.ValidadorTelaCadastrarFuncionario;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AdministradorControlador {
    private AdministradorServico administradorServico;
    TelaCadastrarAdministrador telaCadastrarAdministrador;

    public AdministradorControlador(AdministradorServico administradorServico, TelaCadastrarAdministrador telaCadastrarAdministrador) {
        this.administradorServico = administradorServico;
        telaCadastrarAdministrador.setVisible(true);
        this.telaCadastrarAdministrador = telaCadastrarAdministrador;

        this.telaCadastrarAdministrador.getCampoNome().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarAdministrador.labelErroNome.setText(ValidadorTelaCadastrarFuncionario.validarCampoNome(telaCadastrarAdministrador.getNome()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarAdministrador.getCampoNome().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroNome.setText(ValidadorTelaCadastrarFuncionario.validarCampoNome(telaCadastrarAdministrador.getNome()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroNome.setText(ValidadorTelaCadastrarFuncionario.validarCampoNome(telaCadastrarAdministrador.getNome()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarAdministrador.getCampoTelefone().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarAdministrador.labelErroTelefone.setText(ValidadorTelaCadastrarFuncionario.validarCampoTelefone(telaCadastrarAdministrador.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarAdministrador.getCampoTelefone().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroTelefone.setText(ValidadorTelaCadastrarFuncionario.validarCampoTelefone(telaCadastrarAdministrador.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroTelefone.setText(ValidadorTelaCadastrarFuncionario.validarCampoTelefone(telaCadastrarAdministrador.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarAdministrador.getCampoEndereco().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarAdministrador.labelErroEndereco.setText(ValidadorTelaCadastrarFuncionario.validarCampoEndereco(telaCadastrarAdministrador.getEndereco()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarAdministrador.getCampoEndereco().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroEndereco.setText(ValidadorTelaCadastrarFuncionario.validarCampoEndereco(telaCadastrarAdministrador.getEndereco()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroEndereco.setText(ValidadorTelaCadastrarFuncionario.validarCampoEndereco(telaCadastrarAdministrador.getEndereco()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarAdministrador.getCampoPalavraPasse().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarAdministrador.labelErroPalavraPasse.setText(ValidadorTelaCadastrarFuncionario.validarPalavraPasse(telaCadastrarAdministrador.getPalavraPasse()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarAdministrador.getCampoPalavraPasse().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroPalavraPasse.setText(ValidadorTelaCadastrarFuncionario.validarPalavraPasse(telaCadastrarAdministrador.getPalavraPasse()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarAdministrador.labelErroPalavraPasse.setText(ValidadorTelaCadastrarFuncionario.validarPalavraPasse(telaCadastrarAdministrador.getPalavraPasse()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarAdministrador.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministradorEntidade administrador = new AdministradorEntidade();

                administrador.setNome(telaCadastrarAdministrador.getNome());
                administrador.setTelefone(telaCadastrarAdministrador.getTelefone());
                administrador.setEndereco(telaCadastrarAdministrador.getEndereco());
                administrador.setSenha(telaCadastrarAdministrador.getPalavraPasse());

                administradorServico.cadastrarAdministrador(administrador);
                telaCadastrarAdministrador.dispose();
                JOptionPane.showMessageDialog(null, "administrador cadastrato com sucesso!");

                new AutenticacaoControlador(new TelaIniciarSessao(), new AutenticacaoServico(new AutenticacaoArmazenamento(
                        new FuncionarioArmazenamento(), new AdministradorArmazenamento()
                )));
            }
        });
    }

    private void actualizarEstadoBotaoSalvar() {
        if (
                telaCadastrarAdministrador.labelErroNome.getText().isEmpty() &&
                telaCadastrarAdministrador.labelErroEndereco.getText().isEmpty() &&
                telaCadastrarAdministrador.labelErroTelefone.getText().isEmpty() &&
                telaCadastrarAdministrador.labelErroPalavraPasse.getText().isEmpty() &&
                formularioEstaPreenchido()
        ) {
            telaCadastrarAdministrador.botaoSalvar.setEnabled(true);
        } else {
            telaCadastrarAdministrador.botaoSalvar.setEnabled(false);
        }
    }

    private boolean formularioEstaPreenchido() {
        return !telaCadastrarAdministrador.getNome().isEmpty() &&
                !telaCadastrarAdministrador.getEndereco().isEmpty() &&
                !telaCadastrarAdministrador.getPalavraPasse().isEmpty() &&
                !telaCadastrarAdministrador.getTelefone().isEmpty();
    }
}

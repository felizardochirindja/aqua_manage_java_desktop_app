package modulos.usuario.funcionario;

import modulos.usuario.funcionario.telas.TelaCadastrarFuncionario;
import modulos.usuario.administrador.painel.PainelAdministradorControlador;
import modulos.usuario.administrador.painel.TelaPainelAdminstrador;
import modulos.usuario.funcionario.telas.ValidadorTelaCadastrarFuncionario;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FuncionarioControlador {
    private TelaCadastrarFuncionario telaCadastrarFuncionario;
    private FuncionarioServico funcionarioServico;

    public FuncionarioControlador(TelaCadastrarFuncionario telaCadastrarFuncionario, FuncionarioServico funcionarioServico) {
        this.telaCadastrarFuncionario = telaCadastrarFuncionario;
        this.funcionarioServico = funcionarioServico;

        this.telaCadastrarFuncionario.getCampoNome().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarFuncionario.labelErroNome.setText(ValidadorTelaCadastrarFuncionario.validarCampoNome(telaCadastrarFuncionario.getNome()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarFuncionario.getCampoNome().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroNome.setText(ValidadorTelaCadastrarFuncionario.validarCampoNome(telaCadastrarFuncionario.getNome()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroNome.setText(ValidadorTelaCadastrarFuncionario.validarCampoNome(telaCadastrarFuncionario.getNome()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarFuncionario.getCampoTelefone().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarFuncionario.labelErroTelefone.setText(ValidadorTelaCadastrarFuncionario.validarCampoTelefone(telaCadastrarFuncionario.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarFuncionario.getCampoTelefone().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroTelefone.setText(ValidadorTelaCadastrarFuncionario.validarCampoTelefone(telaCadastrarFuncionario.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroTelefone.setText(ValidadorTelaCadastrarFuncionario.validarCampoTelefone(telaCadastrarFuncionario.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarFuncionario.getCampoEndereco().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarFuncionario.labelErroEndereco.setText(ValidadorTelaCadastrarFuncionario.validarCampoEndereco(telaCadastrarFuncionario.getEndereco()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarFuncionario.getCampoEndereco().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroEndereco.setText(ValidadorTelaCadastrarFuncionario.validarCampoEndereco(telaCadastrarFuncionario.getEndereco()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroEndereco.setText(ValidadorTelaCadastrarFuncionario.validarCampoEndereco(telaCadastrarFuncionario.getEndereco()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarFuncionario.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionarioEntidade funcionarioEntidade = new FuncionarioEntidade();

                funcionarioEntidade.setNome(telaCadastrarFuncionario.getNome());
                funcionarioEntidade.setTelefone(telaCadastrarFuncionario.getTelefone());
                funcionarioEntidade.setEndereco(telaCadastrarFuncionario.getEndereco());
                funcionarioEntidade.setSenha(telaCadastrarFuncionario.getPalavraPasse());

                funcionarioServico.criar(funcionarioEntidade);

                JOptionPane.showMessageDialog(null, "funcionario salvo com sucesso!");
                telaCadastrarFuncionario.dispose();
            }
        });

        this.telaCadastrarFuncionario.getCampoIdade().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarFuncionario.labelErroIdade.setText(ValidadorTelaCadastrarFuncionario.validarCampoIdade(telaCadastrarFuncionario.getIdade()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarFuncionario.getCampoIdade().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroIdade.setText(ValidadorTelaCadastrarFuncionario.validarCampoIdade(telaCadastrarFuncionario.getIdade()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroIdade.setText(ValidadorTelaCadastrarFuncionario.validarCampoIdade(telaCadastrarFuncionario.getIdade()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarFuncionario.getCampoIdade().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroIdade.setText(ValidadorTelaCadastrarFuncionario.validarCampoIdade(telaCadastrarFuncionario.getIdade()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroIdade.setText(ValidadorTelaCadastrarFuncionario.validarCampoIdade(telaCadastrarFuncionario.getIdade()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarFuncionario.getCampoPalavraPasse().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarFuncionario.labelErroPalavraPasse.setText(ValidadorTelaCadastrarFuncionario.validarPalavraPasse(telaCadastrarFuncionario.getPalavraPasse()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarFuncionario.getCampoPalavraPasse().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroPalavraPasse.setText(ValidadorTelaCadastrarFuncionario.validarPalavraPasse(telaCadastrarFuncionario.getPalavraPasse()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroPalavraPasse.setText(ValidadorTelaCadastrarFuncionario.validarPalavraPasse(telaCadastrarFuncionario.getPalavraPasse()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarFuncionario.getCampoDataAdmissao().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarFuncionario.labelErroDataAdmissao.setText(ValidadorTelaCadastrarFuncionario.validarCampoDataDeAdmissao(telaCadastrarFuncionario.getDataAdmissao()));
                actualizarEstadoBotaoSalvar();
            }
        });

        telaCadastrarFuncionario.getCampoDataAdmissao().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroDataAdmissao.setText(ValidadorTelaCadastrarFuncionario.validarCampoDataDeAdmissao(telaCadastrarFuncionario.getDataAdmissao()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarFuncionario.labelErroDataAdmissao.setText(ValidadorTelaCadastrarFuncionario.validarCampoDataDeAdmissao(telaCadastrarFuncionario.getDataAdmissao()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarFuncionario.botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarFuncionario.dispose();
            }
        });
    }

    private void actualizarEstadoBotaoSalvar() {
        if (
                telaCadastrarFuncionario.labelErroNome.getText().isEmpty() &&
                telaCadastrarFuncionario.labelErroEndereco.getText().isEmpty() &&
                telaCadastrarFuncionario.labelErroTelefone.getText().isEmpty() &&
                telaCadastrarFuncionario.labelErroPalavraPasse.getText().isEmpty() &&
                formularioEstaPreenchido()
        ) {
            telaCadastrarFuncionario.botaoSalvar.setEnabled(true);
        } else {
            telaCadastrarFuncionario.botaoSalvar.setEnabled(false);
        }
    }

    private boolean formularioEstaPreenchido() {
        return !telaCadastrarFuncionario.getNome().isEmpty() &&
                !telaCadastrarFuncionario.getEndereco().isEmpty() &&
                !telaCadastrarFuncionario.getPalavraPasse().isEmpty() &&
                !telaCadastrarFuncionario.getTelefone().isEmpty();
    }
}

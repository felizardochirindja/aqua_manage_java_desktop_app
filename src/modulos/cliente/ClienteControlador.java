package modulos.cliente;

import modulos.autenticacao.AutenticacaoArmazenamento;
import modulos.autenticacao.AutenticacaoServico;
import modulos.cliente.telas.TelaCadastrarCliente;
import modulos.cliente.telas.TelaListarClientes;
import modulos.fatura.FaturaArmazenamento;
import modulos.fatura.FaturaControlador;
import modulos.fatura.FaturaServico;
import modulos.fatura.telas.TelaInserirDadosDaLeitura;
import modulos.fatura.telas.TelaListarFaturasPorCliente;
import modulos.cliente.telas.ValidadorTelaCadastrarCliente;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteControlador {
    private ClienteServico clienteServico;
    private TelaCadastrarCliente telaCadastrarCliente;
    private TelaListarClientes telaListarClientes;
    private ClienteEntidade cliente;
    private AutenticacaoServico autenticacaoServico;

    private Map<Integer, ClienteEntidade> mapaIdClientes;

    public ClienteControlador(
            ClienteServico clienteServico,
            TelaCadastrarCliente telaCadastrarCliente,
            TelaListarClientes telaListarClientes,
            ClienteEntidade cliente,
            AutenticacaoServico autenticacaoServico
    ) {
        this.clienteServico = clienteServico;
        this.telaCadastrarCliente = telaCadastrarCliente;
        this.telaListarClientes = telaListarClientes;
        this.cliente = cliente;

        popularTabelaClientes();

        if (cliente != null) {
            telaCadastrarCliente.botaoSalvar.setText("actualizar");
            telaCadastrarCliente.radioButtonDesativado.setEnabled(true);
            preencherCamposCliente(cliente);
        }

        if (!autenticacaoServico.getUsuarioLogado().getNivelDeAcesso().equals("administrador")) {
            telaListarClientes.botoesPanel.remove(telaListarClientes.botaoActualizar);
        }

        this.telaCadastrarCliente.getCampoNome().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarCliente.labelErroNome.setText(ValidadorTelaCadastrarCliente.validarCampoNome(telaCadastrarCliente.getNome()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarCliente.getCampoNome().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroNome.setText(ValidadorTelaCadastrarCliente.validarCampoNome(telaCadastrarCliente.getNome()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroNome.setText(ValidadorTelaCadastrarCliente.validarCampoNome(telaCadastrarCliente.getNome()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarCliente.getCampoResidencia().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarCliente.labelErroResidencia.setText(ValidadorTelaCadastrarCliente.validarCampoResidencia(telaCadastrarCliente.getResidencia()));
                actualizarEstadoBotaoSalvar();
            }
        });

        this.telaCadastrarCliente.getCampoResidencia().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroResidencia.setText(ValidadorTelaCadastrarCliente.validarCampoResidencia(telaCadastrarCliente.getResidencia()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroResidencia.setText(ValidadorTelaCadastrarCliente.validarCampoResidencia(telaCadastrarCliente.getResidencia()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        telaListarClientes.tabelaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (telaListarClientes.tabelaClientes.getSelectedRow() == -1) {
                    telaListarClientes.botaoGerarFatura.setEnabled(false);
                    telaListarClientes.botaoListarFaturas.setEnabled(false);
                    telaListarClientes.botaoActualizar.setEnabled(false);
                } else {
                    telaListarClientes.botaoListarFaturas.setEnabled(true);
                    telaListarClientes.botaoActualizar.setEnabled(true);

                    int rowIndex = telaListarClientes.tabelaClientes.getSelectedRow();
                    ClienteEntidade cliente = mapaIdClientes.get(rowIndex);

                    if (cliente.getContrato().estaAtivo()) {
                        telaListarClientes.botaoGerarFatura.setEnabled(true);
                    } else {
                        telaListarClientes.botaoGerarFatura.setEnabled(false);
                    }
                }
            }
        });

        this.telaCadastrarCliente.getCampoTelefone().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarCliente.labelErroTelefone.setText(ValidadorTelaCadastrarCliente.validarCampoTelefone(telaCadastrarCliente.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }
        });

        telaCadastrarCliente.getCampoTelefone().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroTelefone.setText(ValidadorTelaCadastrarCliente.validarCampoTelefone(telaCadastrarCliente.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroTelefone.setText(ValidadorTelaCadastrarCliente.validarCampoTelefone(telaCadastrarCliente.getTelefone()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarCliente.getCampoDataInicioContrato().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarCliente.labelErroDataInicioContrato.setText(ValidadorTelaCadastrarCliente.validarCampoData(telaCadastrarCliente.getDataInicioContrato()));
                actualizarEstadoBotaoSalvar();
            }
        });

        telaCadastrarCliente.getCampoDataInicioContrato().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroDataInicioContrato.setText(ValidadorTelaCadastrarCliente.validarCampoData(telaCadastrarCliente.getDataInicioContrato()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroDataInicioContrato.setText(ValidadorTelaCadastrarCliente.validarCampoData(telaCadastrarCliente.getDataInicioContrato()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        this.telaCadastrarCliente.getCampoDataTerminoContrato().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telaCadastrarCliente.labelErroDataTerminoContrato.setText(ValidadorTelaCadastrarCliente.validarCampoData(telaCadastrarCliente.getDataTerminoContrato()));
                actualizarEstadoBotaoSalvar();
            }
        });

        telaCadastrarCliente.getCampoDataTerminoContrato().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroDataTerminoContrato.setText(ValidadorTelaCadastrarCliente.validarCampoData(telaCadastrarCliente.getDataTerminoContrato()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaCadastrarCliente.labelErroDataTerminoContrato.setText(ValidadorTelaCadastrarCliente.validarCampoData(telaCadastrarCliente.getDataTerminoContrato()));
                actualizarEstadoBotaoSalvar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        telaCadastrarCliente.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteEntidade clienteEntidade = new ClienteEntidade();

                clienteEntidade.setNome(telaCadastrarCliente.getNome());
                clienteEntidade.setResidencia(telaCadastrarCliente.getResidencia());
                clienteEntidade.setTelefone(telaCadastrarCliente.getTelefone());

                ContratoEntidade contrato = new ContratoEntidade();

                contrato.setDataInicio(telaCadastrarCliente.getDataInicioContrato());
                contrato.setTipo(telaCadastrarCliente.getTipoContrato());
                contrato.setDataTermino(telaCadastrarCliente.getDataTerminoContrato());
                contrato.setFormaDePagamento(telaCadastrarCliente.getFormaPagamento());

                if (telaCadastrarCliente.radioButtonAtivo.isSelected()) {
                    contrato.setAtivo(true);
                }

                if (telaCadastrarCliente.radioButtonDesativado.isSelected()) {
                    contrato.setAtivo(false);
                }

                clienteEntidade.setContrato(contrato);


                if (cliente == null) {
                    clienteServico.criarCliente(clienteEntidade);
                    JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                }

                if (cliente != null) {
                    clienteEntidade.setCodigo(cliente.getCodigo());
                    clienteServico.actualizarCliente(clienteEntidade);
                    JOptionPane.showMessageDialog(null, "Cliente actualizado com sucesso!");
                }

                telaCadastrarCliente.dispose();

                TelaListarClientes telaListarClientes = new TelaListarClientes();
                telaListarClientes.setVisible(true);

                telaListarClientes.setVisible(true);
                new ClienteControlador(
                        new ClienteServico(new ClienteArmazenamento(), new FaturaArmazenamento()),
                        telaCadastrarCliente, telaListarClientes,
                        null, new AutenticacaoServico(new AutenticacaoArmazenamento())
                );
            }
        });

        telaCadastrarCliente.radioButtonAtivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String data = LocalDate.now().format(formatters);

                telaCadastrarCliente.getCampoDataInicioContrato().setText(data);
                telaCadastrarCliente.getCampoDataTerminoContrato().setText("");
            }
        });

        telaCadastrarCliente.radioButtonDesativado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String data = LocalDate.now().format(formatters);

                telaCadastrarCliente.getCampoDataTerminoContrato().setText(data);
            }
        });

        telaCadastrarCliente.botaoVoltarPaienelCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarCliente.dispose();

                if (cliente != null) {
                    TelaListarClientes telaListarClientes = new TelaListarClientes();
                    telaListarClientes.setVisible(true);

                    telaListarClientes.setVisible(true);
                    new ClienteControlador(
                            new ClienteServico(new ClienteArmazenamento(), new FaturaArmazenamento()),
                            telaCadastrarCliente, telaListarClientes,
                            null, new AutenticacaoServico(new AutenticacaoArmazenamento())
                    );
                }
            }
        });

        telaCadastrarCliente.botaoVoltarPaienelContrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastrarCliente.dispose();

                if (cliente != null) {
                    TelaListarClientes telaListarClientes = new TelaListarClientes();
                    telaListarClientes.setVisible(true);

                    telaListarClientes.setVisible(true);
                    new ClienteControlador(
                            new ClienteServico(new ClienteArmazenamento(), new FaturaArmazenamento()),
                            telaCadastrarCliente, telaListarClientes,
                            null, new AutenticacaoServico(new AutenticacaoArmazenamento())
                    );
                }
            }
        });

        telaListarClientes.botaoGerarFatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = telaListarClientes.tabelaClientes.getSelectedRow();

                ClienteEntidade cliente = mapaIdClientes.get(rowIndex);

                if (cliente.getContrato().getFormaDePagamento().equals("taxa unica")) {
                    new FaturaServico(new FaturaArmazenamento()).gerarFatura(cliente);
                    JOptionPane.showMessageDialog(null, "fatura gerada com sucesso!");
                } else {
                    new FaturaControlador(
                            new TelaListarFaturasPorCliente(),
                            new TelaInserirDadosDaLeitura(),
                            new FaturaServico(new FaturaArmazenamento()),
                            cliente
                    );
                }
            }
        });

        telaListarClientes.botaoListarFaturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = telaListarClientes.tabelaClientes.getSelectedRow();

                ClienteEntidade cliente = mapaIdClientes.get(rowIndex);

                new FaturaControlador(new TelaListarFaturasPorCliente(), new FaturaServico(new FaturaArmazenamento()), cliente);
            }
        });

        telaListarClientes.botaoActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = telaListarClientes.tabelaClientes.getSelectedRow();

                ClienteEntidade cliente = mapaIdClientes.get(rowIndex);

                TelaCadastrarCliente telaCadastrarCliente = new TelaCadastrarCliente();
                telaCadastrarCliente.setVisible(true);

                telaListarClientes.dispose();

                new ClienteControlador(
                        new ClienteServico(new ClienteArmazenamento(), new FaturaArmazenamento()),
                        telaCadastrarCliente, new TelaListarClientes(),
                        cliente, new AutenticacaoServico(new AutenticacaoArmazenamento())
                );
            }
        });
    }

    private void actualizarEstadoBotaoSalvar() {
        if (
                telaCadastrarCliente.labelErroNome.getText().isEmpty() &&
                telaCadastrarCliente.labelErroResidencia.getText().isEmpty() &&
                telaCadastrarCliente.labelErroTelefone.getText().isEmpty() &&
                telaCadastrarCliente.labelErroDataInicioContrato.getText().isEmpty() &&
                telaCadastrarCliente.labelErroDataTerminoContrato.getText().isEmpty() &&
                formularioEstaPreenchido()
        ) {
            telaCadastrarCliente.botaoSalvar.setEnabled(true);
        } else {
            telaCadastrarCliente.botaoSalvar.setEnabled(false);
        }
    }

    private boolean formularioEstaPreenchido() {
        return !telaCadastrarCliente.getNome().isEmpty() &&
                !telaCadastrarCliente.getResidencia().isEmpty() &&
                !telaCadastrarCliente.getTelefone().isEmpty() &&
                !telaCadastrarCliente.getDataInicioContrato().isEmpty() &&
                !telaCadastrarCliente.getDataTerminoContrato().isEmpty();
    }

    private void popularTabelaClientes() {
        List<ClienteEntidade> clientes = this.clienteServico.listarClientes();
        mapaIdClientes = new HashMap<>();

        for (int i = 0; i < clientes.size(); i++) {
            Object[] rowData = {
                    clientes.get(i).getNome(),
                    clientes.get(i).getResidencia(),
                    clientes.get(i).getTelefone(),
                    clientes.get(i).getContrato().getTipo(),
                    clientes.get(i).getContrato().getFormaDePagamento(),
                    clientes.get(i).getContrato().estaAtivo() ? "activo" : "encerado",
            };

            this.telaListarClientes.tabelaModelo.addRow(rowData);
            mapaIdClientes.put(i, clientes.get(i));
        }
    }

    private void preencherCamposCliente(ClienteEntidade cliente) {
        telaCadastrarCliente.getCampoNome().setText(cliente.getNome());
        telaCadastrarCliente.getCampoResidencia().setText(cliente.getResidencia());
        telaCadastrarCliente.getCampoTelefone().setText(cliente.getTelefone());
        telaCadastrarCliente.getCampoDataInicioContrato().setText(cliente.getContrato().getDataInicio());
        telaCadastrarCliente.getCampoDataTerminoContrato().setText(cliente.getContrato().getDataTermino());
        telaCadastrarCliente.getComboBoxFormaPagamento().setSelectedItem(cliente.getContrato().getFormaDePagamento());
        telaCadastrarCliente.getComboBoxTipoContrato().setSelectedItem(cliente.getContrato().getTipo());

        telaCadastrarCliente.radioButtonAtivo.setSelected(cliente.getContrato().estaAtivo());
        telaCadastrarCliente.radioButtonDesativado.setSelected(!cliente.getContrato().estaAtivo());

        actualizarEstadoBotaoSalvar();
    }
}

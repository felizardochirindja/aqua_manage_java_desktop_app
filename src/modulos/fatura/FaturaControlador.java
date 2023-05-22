package modulos.fatura;

import modulos.cliente.ClienteEntidade;
import modulos.fatura.entidades.FaturaEntidade;
import modulos.fatura.telas.TelaInserirDadosDaLeitura;
import modulos.fatura.telas.TelaListarFaturasPorCliente;
import modulos.fatura.telas.ValidadorTelasFatura;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaturaControlador {
    private TelaListarFaturasPorCliente telaListarFaturas;
    private TelaInserirDadosDaLeitura telaInserirDadosDaLeitura;
    private FaturaServico faturaServico;
    private Map<Integer, FaturaEntidade> mapaFaturas;

    public FaturaControlador(
            TelaListarFaturasPorCliente telaListarFaturas,
            TelaInserirDadosDaLeitura telaInserirDadosDaLeitura,
            FaturaServico faturaServico,
            ClienteEntidade cliente
    ) {
        this.telaListarFaturas = telaListarFaturas;
        this.faturaServico = faturaServico;
        telaInserirDadosDaLeitura.setVisible(true);
        this.telaInserirDadosDaLeitura = telaInserirDadosDaLeitura;

        this.telaInserirDadosDaLeitura.botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaInserirDadosDaLeitura.dispose();
            }
        });

        this.telaInserirDadosDaLeitura.botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaInserirDadosDaLeitura.dispose();

                LeituraDoContador leituraDoContador = new LeituraDoContador();
                leituraDoContador.setQuantidade( Integer.valueOf(telaInserirDadosDaLeitura.getConsumo()));

                faturaServico.gerarFatura(leituraDoContador, cliente);
                JOptionPane.showMessageDialog(null, "fatura gerada com sucesso!");
            }
        });

        telaInserirDadosDaLeitura.getCampoConsumo().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                telaInserirDadosDaLeitura.labelErroDataDaLeitura.setText(ValidadorTelasFatura.validarCampoConsumo(telaInserirDadosDaLeitura.getConsumo()));
                actualizarEstadoBotaoConfirmarConsumo();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                telaInserirDadosDaLeitura.labelErroDataDaLeitura.setText(ValidadorTelasFatura.validarCampoConsumo(telaInserirDadosDaLeitura.getConsumo()));
                actualizarEstadoBotaoConfirmarConsumo();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    public FaturaControlador(
            TelaListarFaturasPorCliente telaListarFaturas,
            FaturaServico faturaServico,
            ClienteEntidade cliente
    ) {
        telaListarFaturas.setVisible(true);
        this.telaListarFaturas = telaListarFaturas;
        this.faturaServico = faturaServico;

        List<FaturaEntidade> faturas = this.faturaServico.listarFaturasPorCliente(cliente.getCodigo());
        popularTabelaClientes(faturas);

        telaListarFaturas.tabelaFuncionarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (telaListarFaturas.tabelaFuncionarios.getSelectedRow() == -1) {
                    telaListarFaturas.botaoImprimir.setEnabled(false);
                    telaListarFaturas.botaoListarMultas.setEnabled(false);
                    telaListarFaturas.botaoPagar.setEnabled(false);
                } else {
                    telaListarFaturas.botaoImprimir.setEnabled(true);
                    telaListarFaturas.botaoListarMultas.setEnabled(true);

                    int rowIndex = telaListarFaturas.tabelaFuncionarios.getSelectedRow();
                    FaturaEntidade fatura = mapaFaturas.get(rowIndex);

                    if (fatura.getStatus().equals("paga")) {
                        telaListarFaturas.getCampoValorAPagar().setEnabled(false);
                    } else {
                        telaListarFaturas.getCampoValorAPagar().setEnabled(true);
                    }

                    telaListarFaturas.tabelaFuncinariosEstaSelecionada = true;
                }
            }
        });

        telaListarFaturas.getCampoValorAPagar().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent event) {
                try {
                    Integer.parseInt(telaListarFaturas.getValorAPagar());

                    if (Integer.parseInt(telaListarFaturas.getValorAPagar()) < 0) {
                        telaListarFaturas.getCampoValorAPagar().setText("");
                    }
                } catch (NumberFormatException exception) {
                    SwingUtilities.invokeLater(() -> {
                        telaListarFaturas.getCampoValorAPagar().setText("");
                    });
                }

                actualizarEstadoBotaoPagar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    Integer.parseInt(telaListarFaturas.getValorAPagar());

                    if (Integer.parseInt(telaListarFaturas.getValorAPagar()) < 0) {
                        telaListarFaturas.getCampoValorAPagar().setText("");
                    }
                } catch (NumberFormatException exception) {
                    SwingUtilities.invokeLater(() -> {
                        telaListarFaturas.getCampoValorAPagar().setText("");
                    });
                }

                actualizarEstadoBotaoPagar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        telaListarFaturas.botaoPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = telaListarFaturas.tabelaFuncionarios.getSelectedRow();

                FaturaEntidade fatura = mapaFaturas.get(rowIndex);

                int resposta = JOptionPane.showConfirmDialog(
                        null, "o senhor " + fatura.getClienteEntidade().getNome() + " esta a pagar " + telaListarFaturas.getValorAPagar() + "?"
                );

                if (resposta == JOptionPane.YES_OPTION) {
                    if (Integer.parseInt(telaListarFaturas.getValorAPagar()) > fatura.getValorRemanescente()) {
                        JOptionPane.showMessageDialog(null, "valor superior a divida!");
                        return;
                    }

                    if (Integer.parseInt(telaListarFaturas.getValorAPagar()) < fatura.getValorRemanescente() * 0.5) {
                        JOptionPane.showMessageDialog(null, "pagamento em parcelas deve ser em duas prestacoes!");
                        return;
                    }

                    faturaServico.pagarFatura(fatura, Integer.valueOf(telaListarFaturas.getValorAPagar()));
                    telaListarFaturas.dispose();

                    new FaturaControlador(new TelaListarFaturasPorCliente(), new FaturaServico(new FaturaArmazenamento()), cliente);
                }
            }
        });
    }

    private void actualizarEstadoBotaoPagar() {
        if (
                telaListarFaturas.tabelaFuncinariosEstaSelecionada &&
                !telaListarFaturas.getValorAPagar().isEmpty()
        ) {
            telaListarFaturas.botaoPagar.setEnabled(true);
        } else {
            telaListarFaturas.botaoPagar.setEnabled(false);
        }
    }

    private void actualizarEstadoBotaoConfirmarConsumo() {
        System.out.println(telaInserirDadosDaLeitura.getConsumo());

        if (telaInserirDadosDaLeitura.getConsumo().isEmpty()) {
            telaInserirDadosDaLeitura.botaoConfirmar.setEnabled(false);
        } else {
            telaInserirDadosDaLeitura.botaoConfirmar.setEnabled(true);
        }
    }

    private void popularTabelaClientes(List<FaturaEntidade> faturas) {
        mapaFaturas = new HashMap<>();

        for (int i = 0; i < faturas.size(); i++) {
            Object[] rowData = {
                    faturas.get(i).getClienteEntidade().getNome(),
                    faturas.get(i).getDataDeEmissao(),
                    faturas.get(i).getClienteEntidade().getContrato().getTipo(),
                    faturas.get(i).getClienteEntidade().getContrato().getFormaDePagamento(),
                    faturas.get(i).getValorPorPgar(),
                    faturas.get(i).getValorPago(),
                    faturas.get(i).getStatus(),
                    faturas.get(i).getValorRemanescente(),
            };

            this.telaListarFaturas.tabelaModelo.addRow(rowData);
            mapaFaturas.put(i, faturas.get(i));
        }
    }
}

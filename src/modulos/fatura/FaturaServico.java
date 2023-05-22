package modulos.fatura;

import modulos.cliente.ClienteEntidade;
import modulos.fatura.entidades.FaturaEntidade;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FaturaServico {
    private FaturaArmazenamento faturaArmazenamento;

    public FaturaServico(FaturaArmazenamento faturaArmazenamento) {
        this.faturaArmazenamento = faturaArmazenamento;
    }

    public void gerarFatura(LeituraDoContador leitura, ClienteEntidade cliente) {
        FaturaEntidade fatura = new FaturaEntidade();
        fatura.setLeituraDoContador(leitura);
        fatura.setClienteEntidade(cliente);

        fatura.setValorPorPgar(leitura.getQuantidade() * 22);
        fatura.setValorRemanescente(leitura.getQuantidade() * 22);

        fatura.setValorPago(0);
        fatura.setStatus("aberta");
        fatura.setDataDeEmissao(LocalDate.now().toString());

        String codigoDaFatura = UUID.randomUUID().toString();
        fatura.setCodigo(codigoDaFatura);

        faturaArmazenamento.criar(fatura);
    }

    public void gerarFatura(ClienteEntidade cliente) {
        FaturaEntidade fatura = new FaturaEntidade();
        fatura.setClienteEntidade(cliente);

        fatura.setValorPorPgar(700);
        fatura.setValorRemanescente(700);

        fatura.setValorPago(0);
        fatura.setStatus("aberta");
        fatura.setDataDeEmissao(LocalDate.now().toString());

        String codigoDaFatura = UUID.randomUUID().toString();
        fatura.setCodigo(codigoDaFatura);

        faturaArmazenamento.criar(fatura);
    }

    public void pagarFatura(FaturaEntidade fatura, double valor) {
        List<FaturaEntidade> faturas = faturaArmazenamento.listarFaturas();

        for (int i = 0; i < faturas.size(); i++) {
            if (faturas.get(i).getCodigo().equals(fatura.getCodigo())) {
                faturas.get(i).setValorPago(fatura.getValorPago() + valor);
                faturas.get(i).setValorRemanescente(fatura.getValorPorPgar() + fatura.getValorPago() - valor);

                if (fatura.getValorPorPgar() == fatura.getValorPago() + valor) {
                    faturas.get(i).setStatus("paga");
                }

                if (fatura.getValorPorPgar() > fatura.getValorPago() + valor) {
                    faturas.get(i).setStatus("pendente");
                }
            }
        }

        faturaArmazenamento.actualizar(faturas);
    }

    public List<FaturaEntidade> listarFaturas() {
        return faturaArmazenamento.listarFaturas();
    }

    public List<FaturaEntidade> listarFaturasPorCliente(String codigoCliente) {
        return faturaArmazenamento.listarFaturasPorCliente(codigoCliente);
    }
}

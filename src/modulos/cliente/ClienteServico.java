package modulos.cliente;

import modulos.fatura.FaturaArmazenamento;

import java.util.List;
import java.util.UUID;

public class ClienteServico {
    private ClienteArmazenamento clienteArmazenamento;
    private FaturaArmazenamento faturaArmazenamento;

    public ClienteServico(
            ClienteArmazenamento clienteArmazenamento,
            FaturaArmazenamento faturaArmazenamento
    ) {
        this.clienteArmazenamento = clienteArmazenamento;
        this.faturaArmazenamento = faturaArmazenamento;
    }

    public void criarCliente(ClienteEntidade clienteEntidade) {
        String codigoDoCliente = UUID.randomUUID().toString();
        clienteEntidade.setCodigo(codigoDoCliente);

        List<ClienteEntidade> clienteEntidades = listarClientes();
        clienteEntidades.add(clienteEntidade);

        this.clienteArmazenamento.criar(clienteEntidades);
    }

    public List<ClienteEntidade> listarClientes() {
        return this.clienteArmazenamento.listarClientes();
    }

    public void actualizarCliente(ClienteEntidade clienteEntidade) {
        this.clienteArmazenamento.actualizar(clienteEntidade);
        this.faturaArmazenamento.actualizarPorCliente(clienteEntidade);
    }
}

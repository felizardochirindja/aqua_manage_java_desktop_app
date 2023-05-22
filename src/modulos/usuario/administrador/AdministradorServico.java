package modulos.usuario.administrador;

import java.util.List;
import java.util.UUID;

public class AdministradorServico {
    private AdministradorArmazenamento administradorArmazenamento;

    public AdministradorServico(AdministradorArmazenamento administradorArmazenamento) {
        this.administradorArmazenamento = administradorArmazenamento;
    }

    public void cadastrarAdministrador(AdministradorEntidade administrador) {
        administrador.setNivelDeAcesso("administrador");

        this.administradorArmazenamento.criar(administrador);
    }

    public List<AdministradorEntidade> listarAdministradores() {
        return this.administradorArmazenamento.listar();
    }
}

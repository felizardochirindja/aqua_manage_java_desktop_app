package modulos.cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteArmazenamento {
    public void criar(List<ClienteEntidade> clienteEntidades) {
        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\clientes.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(clienteEntidades);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actualizar(ClienteEntidade cliente) {
        List<ClienteEntidade> clientes = listarClientes();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo().equals(cliente.getCodigo())) {
                clientes.get(i).setNome(cliente.getNome());
                clientes.get(i).setTelefone(cliente.getTelefone());
                clientes.get(i).setResidencia(cliente.getResidencia());
                clientes.get(i).setContrato(cliente.getContrato());
            }
        }

        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\clientes.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(clientes);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ClienteEntidade> listarClientes() {
        List<ClienteEntidade> clientes = new ArrayList<>();

        try {
            FileInputStream ficheiro = new FileInputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\clientes.dat");
            ObjectInputStream in = new ObjectInputStream(ficheiro);

            clientes = (ArrayList<ClienteEntidade>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
        }catch (Exception e){
            e.printStackTrace();
        }

        return clientes;
    }
}

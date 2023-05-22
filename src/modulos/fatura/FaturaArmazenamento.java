package modulos.fatura;

import modulos.cliente.ClienteEntidade;
import modulos.fatura.entidades.FaturaEntidade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FaturaArmazenamento {
    public void criar(FaturaEntidade fatura) {
        String codigoDaFatura = UUID.randomUUID().toString();
        fatura.setCodigo(codigoDaFatura);

        List<FaturaEntidade> faturas = this.listarFaturas();
        faturas.add(fatura);

        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\faturas.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(faturas);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            System.out.println(e.getStackTrace());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<FaturaEntidade> listarFaturas() {
        List<FaturaEntidade> faturas = new ArrayList<>();

        try {
            FileInputStream ficheiro = new FileInputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\faturas.dat");
            ObjectInputStream in = new ObjectInputStream(ficheiro);

            faturas = (ArrayList<FaturaEntidade>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            System.out.println(e.getStackTrace());
        }catch (Exception e){
            e.printStackTrace();
        }

        return faturas;
    }

    public List<FaturaEntidade> listarFaturasPorCliente(String codigoCliente) {
        List<FaturaEntidade> faturas = listarFaturas();
        List<FaturaEntidade> faturasPorCliente = new ArrayList<>();

        for (FaturaEntidade fatura: faturas) {
            if (fatura.getClienteEntidade().getCodigo().equals(codigoCliente)) {
                faturasPorCliente.add(fatura);
            }
        }

        return faturasPorCliente;
    }

    public void actualizar(List<FaturaEntidade> faturas) {
        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\faturas.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(faturas);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            System.out.println(e.getStackTrace());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actualizarPorCliente(ClienteEntidade cliente) {
        List<FaturaEntidade> faturas = listarFaturas();

        for (int i = 0; i < faturas.size(); i++) {
            if (faturas.get(i).getClienteEntidade().getCodigo().equals(cliente.getCodigo())) {
                faturas.get(i).getClienteEntidade().setNome(cliente.getNome());
            }
        }

        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\faturas.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(faturas);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            System.out.println(e.getStackTrace());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

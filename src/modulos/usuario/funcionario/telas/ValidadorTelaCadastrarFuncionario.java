package modulos.usuario.funcionario.telas;

import java.util.regex.Pattern;

public class ValidadorTelaCadastrarFuncionario {
    private ValidadorTelaCadastrarFuncionario() {}

    public static String validarCampoNome(String nome) {
        if (nome.isEmpty()) {
            return "O nome é obrigatório";
        }

        return "";
    }

    public static String validarPalavraPasse(String palavraPasse) {
        if (palavraPasse.isEmpty()) {
            return "a palavra-passe é obrigatório";
        }

        return "";
    }

    public static String validarCampoTelefone(String telefone) {
        if (telefone.isEmpty()) {
            return "o telefone é obrigario";
        }

        try {
            Long.parseLong(telefone);
        } catch (NumberFormatException e) {
            return "o telefone deve ser uma sequencia de digitos";
        }

        if (!Pattern.compile("8[234567]\\d{7}").matcher(telefone).matches()) {
            return "a sequencia dos digitos nao é valida";
        }

        return "";
    }

    public static String validarCampoEndereco(String residencia) {
        if (residencia.isEmpty()) {
            return "a residencia é obrigatória";
        }

        return "";
    }

    public static String validarCampoIdade(String idade) {
        if (idade.isEmpty()) {
            return "a idade é obrigatoria";
        }

        try {
            Integer.parseInt(idade);
        } catch (NumberFormatException e) {
            return "a idade deve ser um numero";
        }

        return "";
    }

    public static String validarCampoDataDeAdmissao(String dataDeAdmissao) {
        if (dataDeAdmissao.isEmpty()) {
            return "a data de admissao é obrigatoria";
        }

        if (!Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$").matcher(dataDeAdmissao).matches()) {
            return "formato da data invalido";
        }

        return "";
    }
}

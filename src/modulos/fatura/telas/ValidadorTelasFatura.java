package modulos.fatura.telas;

public class ValidadorTelasFatura {
    public static String validarCampoConsumo(String idade) {
        if (idade.isEmpty()) {
            return "o consumo é obrigatorio";
        }

        try {
            Integer.parseInt(idade);
        } catch (NumberFormatException e) {
            return "deve ser um numero";
        }

        return "";
    }
}

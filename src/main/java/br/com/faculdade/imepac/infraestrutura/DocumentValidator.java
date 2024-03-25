package br.com.faculdade.imepac.infraestrutura;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class DocumentValidator {

    public static boolean validaCpf(String cpf){
        //Valida cpf
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        if (erros.size() > 0){
            // caso a lista de erros nao esteja vazia o cpf e considerado invalido
            return false;
        }
        return false;
    }

    public static boolean validaRg(String rg){
        //Valida rg
        if (rg.length() < 8){
            // caso o tamanho do rg for menor que 8 e considerado invalido
            return false;
        }
        return true;
    }

    public static String mascaraCpf(String cpf){
        // Retorna cpf formatado
        StringBuilder cpfFormatter= new StringBuilder(cpf);
        cpfFormatter.insert(3, ".");
        cpfFormatter.insert(7, ".");
        cpfFormatter.insert(11, "-");
        return String.valueOf(cpfFormatter);
    }
}

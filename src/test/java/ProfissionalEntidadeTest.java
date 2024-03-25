import br.com.faculdade.imepac.entidade.pessoa.Profissional;
import br.com.faculdade.imepac.infraestrutura.DocumentValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfissionalEntidadeTest {
    private Profissional profissional;
    @BeforeEach
    public void setUp(){
        // Configura o ambiente de teste antes que cada metodo seja executado
        this.profissional = new Profissional();
    }
    @Test
    public void deveRetornarUmaStringSemCaracteresEspeciaisESemEspacamentoNoInicioENoFim(){
        //Verifica se o metodo setNome remove espacamento no inicio e fim de uma string ou caracter especial
        var nomeComEspacamentoECaracteresEspeciais = " 1 - Teste "; // Given-contexto
        this.profissional.setNome(nomeComEspacamentoECaracteresEspeciais); // When-quando
        assertEquals("Teste",profissional.getNome()); //Then-despecho
    }

    @Test
    public void deveRetornarFalseCasoOCpfFornecidoSejaInvalido(){
        //Verifica se o metodo validaCpf retorna false quando o cpf passado e invalido
        var cpfInvalido = ("12312312312");
        var resultado = DocumentValidator.validaCpf(cpfInvalido);
        assertEquals(false, resultado);
    }
    @Test
    public void deveRetornarCpfFormatado(){
        //Verifica se quando o cpf e atribuido ele esta sendo formatado no padrao (000.000.000-00)
       var cpfNaoFormatado = "12312312309";
       profissional.setCpf(cpfNaoFormatado);
       assertEquals("123.123.123-09", profissional.getCpf());
    }
    @Test
    public void deveRetornarFalseCasoORgFornecidoSejaInvalido(){
        //Verifica se o metodo validaRg retorna false quando o rg passado e invalido
        var rgInvalido = ("1234567");
        var resultado = DocumentValidator.validaRg(rgInvalido);
        assertEquals(false, resultado);    }
}

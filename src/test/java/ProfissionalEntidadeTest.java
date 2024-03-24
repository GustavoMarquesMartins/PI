import br.com.faculdade.imepac.entidade.pessoa.Profissional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfissionalEntidadeTest {
    private Profissional profissional;
    @BeforeEach
    public void setUp(){
        // Configura o ambiente de teste antes da execução de cada método
        this.profissional = new Profissional();
    }
    @Test
    public void deveRetornarUmaStringSemCaracteresEspeciaisESemEspacamentoNoInicioENoFim(){
        var nomeComEspacamentoECaracteresEspeciais = " 1 - Teste "; // Given-contexto
        this.profissional.setNome(nomeComEspacamentoECaracteresEspeciais); // When-quando
        assertEquals("Teste",profissional.getNome());
    }
}

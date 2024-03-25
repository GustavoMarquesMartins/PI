package br.com.faculdade.imepac.entidade.pessoa;


import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.faculdade.imepac.infraestrutura.DocumentValidator;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "profissionais")
@Data
@NoArgsConstructor
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String rg;

    private String cpf;

    private LocalDate nascimento;

    private boolean habilitacao;

    private String MEI;

    private boolean status;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String endereco;

    private String telefone;

    private String email;

    @OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    private Curriculo curriculo;

    @Enumerated
    private Profissao dadosProfissao;

    public void setNome(String nome){
        //Remove qualquer espacamento no inicio e fim de uma string ou caracter especial
        var nomeSemEspacosNoInicioENoFim = nome.strip();
        String nomeSemQualquerCaracterEspecial = nomeSemEspacosNoInicioENoFim.replaceAll("[^a-zA-Z]", "");
        this.nome = nomeSemQualquerCaracterEspecial;
    }

    public void setCpf(String cpf) {
        // Atribui um cpf para a instancia
        this.cpf = DocumentValidator.mascaraCpf(cpf);
    }
}

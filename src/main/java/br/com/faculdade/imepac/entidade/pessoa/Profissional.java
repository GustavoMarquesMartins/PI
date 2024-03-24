package br.com.faculdade.imepac.entidade.pessoa;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
        var nomeSemEspacosNoInicioENoFim = nome.strip();
        String nomeSemQualquerCaracterEspecial = nomeSemEspacosNoInicioENoFim.replaceAll("[^a-zA-Z]", "");
        this.nome = nomeSemQualquerCaracterEspecial;
    }

}

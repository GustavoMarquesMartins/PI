package br.com.faculdade.imepac.employeemangement;

import br.com.faculdade.imepac.dao.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.*;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Persistence persistence = new Persistence(em);

        var curriculo = new Curriculo();

        curriculo.setNome("Nome");
        curriculo.setDataNascimento(LocalDate.of(2023,02,12));
        curriculo.setEndereco("Endereco");
        curriculo.setEmail("Email");
        curriculo.setTelefone("Telefone");
// ---------------------------------------------------------------------------------------------------


        var experiencia_profissional1 = new Curriculo.ExperienciaProfissional();
        var experiencia_profissional2 = new Curriculo.ExperienciaProfissional();

        experiencia_profissional1.setCargo("Gerente");
        experiencia_profissional1.setEmpresa("Imepac");
        experiencia_profissional1.setPeriodoInicio(LocalDate.of(2023,02,12));
        experiencia_profissional1.setPeriodoFim(LocalDate.of(2023,02,12));
        experiencia_profissional1.setCurriculo(curriculo);

        experiencia_profissional2.setCargo("Gerente");
        experiencia_profissional2.setEmpresa("Imepac");
        experiencia_profissional2.setPeriodoInicio(LocalDate.of(2023,02,12));
        experiencia_profissional2.setPeriodoFim(LocalDate.of(2023,02,12));
        experiencia_profissional2.setCurriculo(curriculo);

        curriculo.setExperienciaProfissional(List.of(experiencia_profissional1,experiencia_profissional2));


// ---------------------------------------------------------------------------------------------------


        var experiencia_educacional1 = new Curriculo.ExperienciaEducacional();

        experiencia_educacional1.setInstituicao("Imepac");
        experiencia_educacional1.setCurso("ADS");
        experiencia_educacional1.setCurso("graduação");
        experiencia_educacional1.setPeriodoInicio(LocalDate.of(2023,02,12));
        experiencia_educacional1.setPeriodoFim(LocalDate.of(2023,02,12));
        experiencia_profissional1.setDescricao("descricao");
        experiencia_educacional1.setCurriculo(curriculo);

        curriculo.setExperienciaEducacional(List.of(experiencia_educacional1));
        curriculo.setHabilidades(List.of("Habilidade1","Habilidade2"));

        // ---------------------------------------------------------------------------------------------------

        var profissional = new Profissional();

        profissional.setNome("Alberto");
        profissional.setRg("1234567");
        try {
            profissional.setCpf("123.456.789-01110");
        }catch (Exception e){
            System.out.println(e);
        }
        profissional.setNascimento(LocalDate.of(1980, 5, 10));
        profissional.setHabilitacao(true);
        profissional.setMEI("123456789");
        profissional.setStatus(true);
        profissional.setEstadoCivil(EstadoCivil.CASADO);
        profissional.setCor(Cor.BRANCO);
        profissional.setGenero(Genero.MASCULINO);
        profissional.setEndereco("Rua ABC, 123");
        profissional.setTelefone("(11) 98765-4321");
        profissional.setEmail("roberto@example.com");
// ---------------------------------------------------------------------------------------------------
        var profissao = new Profissao();
        profissao.setCargo("Cargo");
        profissao.setSalario(new BigDecimal("12.00"));
        profissao.setCargaHoraria(8);
        profissao.setPeriodo(PeriodoDia.MATUTINO);
        profissao.setAcolhido(true);

        curriculo.setProfissional(profissional);

// ---------------------------------------------------------------------------------------------------

        profissional.setDadosProfissao(profissao);
        profissional.setCurriculo(curriculo);

        em.getTransaction().begin();
        persistence.salvar(profissional);
        em.getTransaction().commit();

    }
}

package br.edu.ifsul.lpoo.agencia.testes;

import br.edu.ifsul.lpoo.agencia.model.Cidade;
import br.edu.ifsul.lpoo.agencia.model.Endereco;
import br.edu.ifsul.lpoo.agencia.model.Estado;
import br.edu.ifsul.lpoo.agencia.model.Funcionario;
import br.edu.ifsul.lpoo.agencia.model.Pais;
import br.edu.ifsul.lpoo.agencia.model.dao.InterfacePersistencia;
import br.edu.ifsul.lpoo.agencia.model.dao.PersistenciaJPA;
import java.util.List;
import org.junit.Test;

public class TestePersistenciaJPA {

    @Test
    public void testarPersistenciaPais() {

        InterfacePersistencia persistencia = PersistenciaJPA.getInstance();
        if (persistencia.conexaoAberta()) {

            Pais pais = (Pais) persistencia.find(Pais.class, new Integer(1));
            if(pais == null) {
                Pais p = new Pais();
                p.setNome("Argentina");
                persistencia.persist(p);
                p.setNome("Brasil");
                persistencia.persist(p);
                System.out.println("Pais criado: " + p.getCodigo());
            } else {
                System.out.println("Pais encontrado: " + pais.getCodigo());
            }
        }
        persistencia.fecharConexao();
    }

    @Test
    public void testarPersistenciaEstado() {
        InterfacePersistencia persistencia = PersistenciaJPA.getInstance();
        if (persistencia.conexaoAberta()) {
            Estado estado = (Estado) persistencia.find(Estado.class, new Integer(1));
            if(estado == null) {
                Estado est = new Estado();
                est.setNome("Rio Grande do Sul");
                est.setUf("RS");
                est.setPais((Pais) persistencia.find(Pais.class, new Integer(1)));
                Cidade cid = new Cidade();
                cid.setNome("Passo Fundo");
                cid.setEstado(est);
                persistencia.persist(est);
                System.out.println("Estado criado: " + est.getCodigo());
            } else {
                System.out.println("Estado encontrado: " + estado.getCodigo());
            }
        }
        persistencia.fecharConexao();
    }
    
    @Test
    public void testarPersistenciaCidade() {
        InterfacePersistencia persistencia = PersistenciaJPA.getInstance();
        if (persistencia.conexaoAberta()) {
            Cidade cidade = (Cidade) persistencia.find(Cidade.class, new Integer(1));
            if(cidade == null) {
                Cidade cid = new Cidade();
                cid.setNome("Passo Fundo");
                cid.setEstado((Estado) persistencia.find(Estado.class, new Integer(1)));
                persistencia.persist(cid);
                System.out.println("Cidade criada: " + cid.getCodigo());
            } else {
                System.out.println("Cidade encontrada: " + cidade.getCodigo());
            }
        }
        persistencia.fecharConexao();
    }

    @Test
    public void testarPersistenciaFuncionario() {

        System.out.println("Executando teste na classe TestePersistenciaJPA -> testarPersistenciaFuncionario");
        InterfacePersistencia persistencia = PersistenciaJPA.getInstance();
        if (persistencia.conexaoAberta()) {
            System.out.println("Abriu a conexao JPA");

            Endereco end = new Endereco();
            end.setCep("99010010");
            Funcionario func = new Funcionario();
            func.setNome("Eu");
            func.setEndereco(end);
            func.setCidade((Cidade) persistencia.find(Cidade.class, new Integer(1)));
            func.setLogin("diego");
            func.setMatricula("20172");
            func.setSenha("1234");
            persistencia.persist(func);

            Funcionario funcionarioEncontrado = (Funcionario) persistencia.find(Funcionario.class, new Integer(1));

            if (funcionarioEncontrado != null) {
                System.out.println("Funcionario encontrado: " + funcionarioEncontrado.getNome());
            } else {
                System.out.println("Nao encontrou o funcionario 1");
            }

            List<Funcionario> list = persistencia.listFuncionario();
            if (list.isEmpty()) {
                Funcionario newfunc = new Funcionario();
                newfunc.setNome("Eu");
                newfunc.setEndereco(end);
                newfunc.setCidade((Cidade) persistencia.find(Cidade.class, new Integer(1)));
                newfunc.setLogin("diego");
                newfunc.setMatricula("20172");
                newfunc.setSenha("1234");
                persistencia.persist(newfunc);
            } else {
                for (Funcionario f : list) {
                    System.out.println("funcionario codigo: " + f.getCodigo());

                    // remover objeto
                }
            }

            persistencia.fecharConexao();
            System.out.println("Fechou a conexao !!");
        } else {
            System.out.println("Nao abriu a conexao");
        }
    }

}

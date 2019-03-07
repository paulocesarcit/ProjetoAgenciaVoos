package br.edu.ifsul.lpoo.agencia.testes;

import br.edu.ifsul.lpoo.agencia.model.Pais;
import br.edu.ifsul.lpoo.agencia.model.dao.InterfacePersistencia;
import br.edu.ifsul.lpoo.agencia.model.dao.PersistenciaJPA;
import org.junit.Test;

public class TestePersistenciaJPA {
    
    @Test
    public void testarPesistenciaFuncionario(){
        
        System.out.println("Executando teste na classe TestePersistenciaJPA -> testarPersistenciaFuncionario");
        InterfacePersistencia persistencia = PersistenciaJPA.getInstance();
        if (persistencia.conexaoAberta()){
            System.out.println("Abriu a conexao JPA");
            
            // inserir um país //
            Pais p = new Pais();
            p.setNome("Brasil");
            persistencia.persist(p); // insere no banco de dados
            System.out.println("Inseriu no banco de dados o pais: "+p.getCodigo());
            
            // alterar um país //
            p.setNome("Argentina");
            persistencia.persist(p);
            
            // remover um país //
            persistencia.remove(p);
            
            persistencia.fecharConexao();
            System.out.println("Fechou a conexao !!");
        } else {
            System.out.println("Nao abriu a conexao");
        }
    }
}

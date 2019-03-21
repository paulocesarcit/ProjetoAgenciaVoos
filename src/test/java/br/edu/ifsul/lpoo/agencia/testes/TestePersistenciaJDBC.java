package br.edu.ifsul.lpoo.agencia.testes;

import br.edu.ifsul.lpoo.agencia.model.dao.InterfacePersistencia;
import br.edu.ifsul.lpoo.agencia.model.dao.PersistenciaJDBC;
import org.junit.Test;

public class TestePersistenciaJDBC {
    
    @Test
    public void testarPersiste4nciaFuncionario(){
        InterfacePersistencia persistencia = PersistenciaJDBC.getInstance();
        if (persistencia.conexaoAberta()) {
            // TODO: chamar o metodo login
            // implementa-lo com java.sql.PrepareStatemment
            // imprimir o codigo do funcionario encontrado/nao encontrado
            // colocar um else fazendo qualquer coisa (se nao da erro)
            persistencia.login("postgres", "postgres");
        }
        persistencia.fecharConexao();
    }
}

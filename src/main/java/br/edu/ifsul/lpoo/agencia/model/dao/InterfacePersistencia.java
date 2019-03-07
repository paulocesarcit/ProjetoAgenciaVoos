package br.edu.ifsul.lpoo.agencia.model.dao;

import br.edu.ifsul.lpoo.agencia.model.Funcionario;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InterfacePersistencia {
    
    public Boolean conexaoAberta();
    public void fecharConexao();
    public void persist(Object o);
    public List<Funcionario> listFuncionario();
    public void remove(Object o);
    public CriteriaBuilder getCriteriaBuilder();
    
}

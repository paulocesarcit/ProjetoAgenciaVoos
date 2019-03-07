package br.edu.ifsul.lpoo.agencia.model.dao;

import br.edu.ifsul.lpoo.agencia.model.Funcionario;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class PersistenciaJPA implements InterfacePersistencia {
    //introducao ao JPA
    //https://www.caelum.com.br/apostila-java-web/uma-introducao-pratica-ao-jpa-com-hibernate/#usando-o-jpa
    private static InterfacePersistencia persistenciaJPA;
    private EntityManagerFactory factory;
    private EntityManager entity;
    
    private PersistenciaJPA(){
        
        factory = Persistence.createEntityManagerFactory("pu_eclipseLink_Postgresql");
        entity = factory.createEntityManager();
    }
    // static em interface: https://www.guj.com.br/t/uso-de-static-em-interfaces/41923
    //  Design Pattern Singleton
    //  https://www.devmedia.com.br/design-patterns-singleton-parte-3/16782
    public static InterfacePersistencia getInstance(){
        
        if(persistenciaJPA == null)
            persistenciaJPA = new PersistenciaJPA();
        
        return persistenciaJPA;
    }
    
    @Override
    public Boolean conexaoAberta() {
        
       return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        
        entity.close();
        factory.close();
        persistenciaJPA = null;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        
        return entity.getCriteriaBuilder();
    }
    
    @Override
    public void persist(Object o) {
        // em JPA persistir é sinonimo de sincronizar com a fonte de dados
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    @Override
    public List<Funcionario> listFuncionario() {
        
        //return (List<Funcionario>) entity.createNamedQuery("Funcionario.orderbyCodigo").getResultList();
        return null;
    }

    @Override
    public void remove(Object o) {
        
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }
    
}

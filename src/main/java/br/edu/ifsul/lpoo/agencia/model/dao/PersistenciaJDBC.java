package br.edu.ifsul.lpoo.agencia.model.dao;

import br.edu.ifsul.lpoo.agencia.model.Funcionario;
import br.edu.ifsul.lpoo.agencia.model.Pais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;

public class PersistenciaJDBC implements InterfacePersistencia{
    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "postgres";
    public static final String URL = "jdbc:postgresql://localhost:5432/db_agencia";
    private Connection con = null;
    
    private static PersistenciaJDBC persistencia;
    
    private PersistenciaJDBC() {
    
        try{
            Class.forName(DRIVER);
            this.con = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static InterfacePersistencia getInstance(){
        if(persistencia == null)
            persistencia = new PersistenciaJDBC();
        return persistencia;
    }

    @Override
    public Boolean conexaoAberta() {
        try {
            return !con.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void fecharConexao() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void persist(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pais> listPais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario login(String login, String senha) {
        // TODO: implementar usando o java.sql.PrepareStatemment
        return null;
    }

    @Override
    public Object find(Class c, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

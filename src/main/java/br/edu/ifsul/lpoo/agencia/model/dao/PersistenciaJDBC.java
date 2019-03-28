package br.edu.ifsul.lpoo.agencia.model.dao;

import br.edu.ifsul.lpoo.agencia.model.Cidade;
import br.edu.ifsul.lpoo.agencia.model.Estado;
import br.edu.ifsul.lpoo.agencia.model.Funcionario;
import br.edu.ifsul.lpoo.agencia.model.Pais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try{
            PreparedStatement ps;
            if (o instanceof Funcionario){
                Funcionario f = (Funcionario) o;
                if (f.getCodigo() == null){
                    // insert
                    ps = this.con.prepareStatement("insert into pessoa (nome, login, senha, codigo_cidade, tipoPessoa) values (?,?,?,?,?)");
                    ps.setString(1, f.getNome());
                    ps.setString(2, f.getLogin());
                    ps.setString(3, f.getSenha());
                    ps.setInt(4, f.getCidade().getCodigo());
                    ps.setString(5, f.getTipoPessoa());
                    System.out.println("Funcionario {" + f.getNome() + "} adicionado.");
                } else {
                    // update
                    ps = this.con.prepareStatement("update pessoa set nome=?, login=?, senha=?, codigo_cidade=?, tipoPesoa=? where codigo=?");
                    ps.setString(1, f.getNome());
                    ps.setString(2, f.getLogin());
                    ps.setString(3, f.getSenha());
                    ps.setInt(4, f.getCidade().getCodigo());
                    ps.setString(5, f.getTipoPessoa());
                    ps.setInt(6, f.getCodigo());
                    System.out.println("Funcionario {" + f.getNome() + "} atualizado.");
                }
            } else if (o instanceof Pais){;
                Pais p = (Pais) o;
                if (p.getCodigo() == null){
                    // insert
                    ps = this.con.prepareStatement("insert into pais (nome) values (?)");
                    ps.setString(1, p.getNome());
                    System.out.println("Pais {" + p.getNome() + "} adicionado.");
                } else {
                    // update
                    ps = this.con.prepareStatement("update pais set nome=? where codigo=?");
                    ps.setString(1, p.getNome());
                    ps.setInt(2, p.getCodigo());
                    System.out.println("Pais {" + p.getNome() + "} atualizado.");
                }
            } else if (o instanceof Estado){
                Estado es = (Estado) o;
                if (es.getCodigo() == null){
                    // insert
                    ps = this.con.prepareStatement("insert into estado (nome, uf, pais) values (?,?,?)");
                    ps.setString(1, es.getNome());
                    ps.setString(2, es.getUf());
                    ps.setInt(3, es.getPais().getCodigo());
                    System.out.println("Estado {" + es.getNome() + "} adicionado.");
                } else {
                    // update
                    ps = this.con.prepareStatement("update estado set nome=?, uf=?, pais=? where codigo=?");
                    ps.setString(1, es.getNome());
                    ps.setString(2, es.getUf());
                    ps.setInt(3, es.getPais().getCodigo());
                    ps.setInt(4, es.getCodigo());
                    System.out.println("Estado {" + es.getNome() + "} atualizado.");
                }
            } else if (o instanceof Cidade){
                Cidade cid = (Cidade) o;
                if (cid.getCodigo() == null){
                    // insert
                    ps = this.con.prepareStatement("insert into cidade (nome, estado) values (?,?)");
                    ps.setString(1, cid.getNome());
                    ps.setInt(2, cid.getEstado().getCodigo());
                    System.out.println("Cidade {" + cid.getNome() + "} adicionado.");
                } else {
                    // update
                    ps = this.con.prepareStatement("update cidade set nome=?, estado=? where codigo=?");
                    ps.setString(1, cid.getNome());
                    ps.setInt(2, cid.getEstado().getCodigo());
                    ps.setInt(3, cid.getCodigo());
                    System.out.println("Cidade {" + cid.getNome() + "} atualizado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        Funcionario f = null;
        try{
            PreparedStatement ps = this.con.prepareStatement("select matricula, login, senha from tb_pessoa where login=? and senha=?");
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                f = new Funcionario();
                f.setMatricula(rs.getString("matricula"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public Object find(Class c, Object id) {
        try{
            PreparedStatement ps;
            if (c == Funcionario.class){
                ps = this.con.prepareStatement("select * from tb_pessoa where codigo=?");
                ps.setInt(1, Integer.parseInt(id.toString()));
                
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    Funcionario f = new Funcionario();
                    // TODO : ARRUMAR SET CIDADE
                    f.setNome(rs.getString("nome"));
                    f.setLogin(rs.getString("login"));
                    f.setSenha(rs.getString("senha"));
                    f.setCidade(rs.getInt("codigo_cidade"));
                    f.setTipoPessoa(rs.getString("tipoPessoa"));
                    return f;
                }
            } else if (c == Cidade.class){
                // TODO : FAZER PARA TODOS OS TIPOS
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

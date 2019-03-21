package br.edu.ifsul.lpoo.agencia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue(value = "F")
@NamedQueries({ 
    @NamedQuery(name="Funcionario.orderbyCodigo",
               query="Select f FROM Funcionario f order by f.codigo asc"),
    @NamedQuery(name="Funcionario.login",
               query="Select f FROM Funcionario f where f.login = :paramLogin and f.senha = :paramSenha")
})
public class Funcionario extends Pessoa implements Serializable{
    
    @Column(nullable = false)    
    private String matricula;
    
    @Column(nullable = false)
    private String login;
    
    @Column(nullable = false)
    private String senha;
    
    public Funcionario(){
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}

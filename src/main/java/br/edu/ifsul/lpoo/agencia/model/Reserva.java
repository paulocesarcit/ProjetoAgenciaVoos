package br.edu.ifsul.lpoo.agencia.model;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "tb_reserva")
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Calendar data_reserva;
    
    @ManyToOne
    @JoinColumn(name = "codigo_funcionario", nullable = false)
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "codigo_passageiro", nullable = false)
    private Passageiro passageiro;
    
    @OneToMany(mappedBy = "reserva")
    private List<ReservaRota> rotasReservadas;
    
    @Column(nullable = true, length = 200)
    private String observacoes;

    public Reserva() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Calendar getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Calendar data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public List<ReservaRota> getRotasReservadas() {
        return rotasReservadas;
    }

    public void setRotaReservada(ReservaRota rotaReservada) {
        // logica pra adicionar no array
        // testar se for null inicializar, se n adc
        if (this.rotasReservadas == null){
            this.rotasReservadas = new ArrayList<ReservaRota>();
        } else {
            this.rotasReservadas.add(rotaReservada);
        }
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}

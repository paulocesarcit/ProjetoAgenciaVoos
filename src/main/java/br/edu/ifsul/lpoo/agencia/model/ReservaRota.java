package br.edu.ifsul.lpoo.agencia.model;

import java.util.Calendar;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "tb_reservarota")
public class ReservaRota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(nullable = false)
    private Integer numeroAssento;
    
    @ManyToOne
    @JoinColumn(name = "codigo_reserva", nullable = false)
    private Reserva reserva;
    
    @ManyToOne
    @JoinColumn(name = "codigo_rota", nullable = false)
    private Rota rota;
    
    @Temporal(javax.persistence.TemporalType.TIME)
    private Calendar dt_partida;

    public ReservaRota() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Integer getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public Calendar getDt_partida() {
        return dt_partida;
    }

    public void setDt_partida(Calendar dt_partida) {
        this.dt_partida = dt_partida;
    }
    
}

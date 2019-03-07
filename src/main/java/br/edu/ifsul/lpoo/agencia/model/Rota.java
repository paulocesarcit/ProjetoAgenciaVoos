package br.edu.ifsul.lpoo.agencia.model;

import java.util.Calendar;
import javax.persistence.ManyToOne;

public class Rota {
    
    private Integer codigo;
    private DiaSemana diaSemana;
    private Calendar horaPartida;
    
    @ManyToOne
    private Trecho trecho;
    
    @ManyToOne
    private TipoAeronave tipoAeronave;
    private String descricao;

    public Rota() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Calendar getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Calendar horaPartida) {
        this.horaPartida = horaPartida;
    }

    public Trecho getTrecho() {
        return trecho;
    }

    public void setTrecho(Trecho trecho) {
        this.trecho = trecho;
    }

    public TipoAeronave getTipoAeronave() {
        return tipoAeronave;
    }

    public void setTipoAeronave(TipoAeronave tipoAeronave) {
        this.tipoAeronave = tipoAeronave;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}

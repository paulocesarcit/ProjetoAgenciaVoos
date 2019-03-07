package br.edu.ifsul.lpoo.agencia.model;

public class Trecho {
    
    private Integer codigo;
    private String descricao;
    private Aeroporto partida;
    private Aeroporto chegada;
    private Integer tempoDuracaoMin;

    public Trecho() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aeroporto getPartida() {
        return partida;
    }

    public void setPartida(Aeroporto partida) {
        this.partida = partida;
    }

    public Aeroporto getChegada() {
        return chegada;
    }

    public void setChegada(Aeroporto chegada) {
        this.chegada = chegada;
    }

    public Integer getTempoDuracaoMin() {
        return tempoDuracaoMin;
    }

    public void setTempoDuracaoMin(Integer tempoDuracaoMin) {
        this.tempoDuracaoMin = tempoDuracaoMin;
    }
    
}

package br.edu.ifsul.lpoo.agencia.model;

public class TipoAeronave {
    
    private Integer codigo;
    private String descricao;
    private Integer qtdLugares;

    public TipoAeronave() {
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

    public Integer getQtdLugares() {
        return qtdLugares;
    }

    public void setQtdLugares(Integer qtdLugares) {
        this.qtdLugares = qtdLugares;
    }
    
}

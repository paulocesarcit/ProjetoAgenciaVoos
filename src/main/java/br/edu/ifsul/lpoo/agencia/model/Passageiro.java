package br.edu.ifsul.lpoo.agencia.model;

public class Passageiro extends Pessoa {
    
    private String nroCartao;

    public Passageiro() {
    }

    public String getNroCartao() {
        return nroCartao;
    }

    public void setNroCartao(String nroCartao) {
        this.nroCartao = nroCartao;
    }
    
}

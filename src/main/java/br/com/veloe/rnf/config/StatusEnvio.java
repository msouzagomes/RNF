package br.com.veloe.rnf.config;

public enum StatusEnvio {

    NAOEMITIDA("NAOEMITIDA"),
    EMITIDA("EMITIDA");
    private String descricao;

    StatusEnvio(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}

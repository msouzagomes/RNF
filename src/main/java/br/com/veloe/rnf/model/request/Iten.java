package br.com.veloe.rnf.model.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cfop",
        "codigo",
        "descricao",
        "ncm",
        "quantidade",
        "unidadeMedida",
        "valorUnitario",
        "frete",
        "outrasDespesas",
        "combustivel",
        "impostos"
})
@Generated("jsonschema2pojo")
public class Iten {

    @JsonProperty("cfop")
    private String cfop;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("ncm")
    private String ncm;
    @JsonProperty("quantidade")
    private Integer quantidade;
    @JsonProperty("unidadeMedida")
    private String unidadeMedida;
    @JsonProperty("valorUnitario")
    private Integer valorUnitario;
    @JsonProperty("frete")
    private Integer frete;
    @JsonProperty("outrasDespesas")
    private Integer outrasDespesas;
    @JsonProperty("combustivel")
    private Combustivel combustivel;
    @JsonProperty("impostos")
    private Impostos impostos;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

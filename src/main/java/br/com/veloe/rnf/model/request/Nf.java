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
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "ambienteEmissao",
        "naturezaOperacao",
        "tipoOperacao",
        "finalidade",
        "consumidorFinal",
        "indicadorPresencaConsumidor",
        "cliente",
        "enviarPorEmail",
        "itens",
        "informacoesAdicionais"
})
@Generated("jsonschema2pojo")
public class Nf {

    @JsonProperty("id")
    private String id;
    @JsonProperty("ambienteEmissao")
    private String ambienteEmissao;
    @JsonProperty("naturezaOperacao")
    private String naturezaOperacao;
    @JsonProperty("tipoOperacao")
    private String tipoOperacao;
    @JsonProperty("finalidade")
    private String finalidade;
    @JsonProperty("consumidorFinal")
    private Boolean consumidorFinal;
    @JsonProperty("indicadorPresencaConsumidor")
    private String indicadorPresencaConsumidor;
    @JsonProperty("cliente")
    private Cliente cliente;
    @JsonProperty("enviarPorEmail")
    private Boolean enviarPorEmail;
    @JsonProperty("itens")
    private List<Iten> itens = null;
    @JsonProperty("informacoesAdicionais")
    private String informacoesAdicionais;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

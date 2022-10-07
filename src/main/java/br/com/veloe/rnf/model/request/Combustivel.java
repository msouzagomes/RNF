package br.com.veloe.rnf.model.request;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codigoProdutoANP",
        "percentualGasNatural",
        "codif",
        "quantidadeFaturadaTempAmbiente",
        "ufConsumo",
        "cide"
})
@Generated("jsonschema2pojo")
public class Combustivel {

    @JsonProperty("codigoProdutoANP")
    private String codigoProdutoANP;
    @JsonProperty("percentualGasNatural")
    private String percentualGasNatural;
    @JsonProperty("codif")
    private String codif;
    @JsonProperty("quantidadeFaturadaTempAmbiente")
    private Integer quantidadeFaturadaTempAmbiente;
    @JsonProperty("ufConsumo")
    private String ufConsumo;
    @JsonProperty("cide")
    private Cide cide;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

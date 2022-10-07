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
        "uf",
        "cidade",
        "logradouro",
        "numero",
        "complemento",
        "bairro",
        "cep"
})
@Generated("jsonschema2pojo")
public class Endereco {

    @JsonProperty("uf")
    private String uf;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("cep")
    private String cep;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

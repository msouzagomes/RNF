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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tipoPessoa",
        "indicadorContribuinteICMS",
        "nome",
        "email",
        "telefone",
        "cpfCnpj",
        "endereco"
})
@Generated("jsonschema2pojo")
public class Cliente {

    @JsonProperty("tipoPessoa")
    private String tipoPessoa;
    @JsonProperty("indicadorContribuinteICMS")
    private String indicadorContribuinteICMS;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefone")
    private String telefone;
    @JsonProperty("cpfCnpj")
    private String cpfCnpj;
    @JsonProperty("endereco")
    private Endereco endereco;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

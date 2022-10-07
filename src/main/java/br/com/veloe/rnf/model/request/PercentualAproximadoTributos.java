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
        "simplificado",
        "fonte"
})
@Generated("jsonschema2pojo")
public class PercentualAproximadoTributos {

    @JsonProperty("simplificado")
    private Simplificado simplificado;
    @JsonProperty("fonte")
    private String fonte;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

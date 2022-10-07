package br.com.veloe.rnf.model.request;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "envioAutomatico",
        "dataInicio",
        "dataFim",
        "ecId"
})
@Generated("jsonschema2pojo")
public class ConfigEc {

    @JsonProperty("id")
    private String id;
    @JsonProperty("envioAutomatico")
    private String envioAutomatico;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("dataInicio")
    private Date dataInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("dataFim")
    private String dataFim;
    @JsonProperty("ecId")
    private String ecId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

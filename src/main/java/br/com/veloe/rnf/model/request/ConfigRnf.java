package br.com.veloe.rnf.model.request;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.util.Date;
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
        "dataInicio",
        "dataFim",
        "idFilial",
        "configuracaoVeiculos",
        "mostrarPlaca",
        "mostrarCentroCusto",
        "agruparNotaPor",
        "ativo"
})
@Generated("jsonschema2pojo")
public class ConfigRnf {

    @JsonProperty("id")
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("dataInicio")
    private Date dataInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("dataFim")
    private Date dataFim;
    @JsonProperty("idFilial")
    private String idFilial;
    @JsonProperty("configuracaoVeiculos")
    private List<ConfiguracaoVeiculo> configuracaoVeiculos = null;
    @JsonProperty("mostrarPlaca")
    private Boolean mostrarPlaca;
    @JsonProperty("mostrarCentroCusto")
    private Boolean mostrarCentroCusto;
    @JsonProperty("agruparNotaPor")
    private String agruparNotaPor;
    @JsonProperty("ativo")
    private Boolean ativo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}

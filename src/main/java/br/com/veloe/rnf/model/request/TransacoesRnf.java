package br.com.veloe.rnf.model.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

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
        "configRnf",
        "configEc",
        "nfs"
})
@Generated("jsonschema2pojo")
public class TransacoesRnf {

    @JsonProperty("configRnf")
    private ConfigRnf configRnf;
    @JsonProperty("configEc")
    private ConfigEc configEc;
    @JsonProperty("nfs")
    private List<Nf> nfs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

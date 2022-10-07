package br.com.veloe.rnf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "RNFRoboEmissorNfConfigEcEntity")
@Table(name = "RNFRoboEmissorNf.ConfigEc", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfConfigEcEntity {

    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "configEcId", length = 36)
    private String configEcId;

    @Column(name = "EnvioAutomatico", length = 40)
    private String envioAutomatico;

    @Column(name = "DataInicio")
    private Instant dataInicio;

    @Column(name = "DataFim")
    private Instant dataFim;

    @Column(name = "EcId", length = 36)
    private String ecId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdConfigRnf")
    private RNFRoboEmissorNfConfigRnfEntity rnfRoboEmissorNfConfigRnfEntity;

}
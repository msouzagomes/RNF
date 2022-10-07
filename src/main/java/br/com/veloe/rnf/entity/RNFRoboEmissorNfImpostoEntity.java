package br.com.veloe.rnf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "RNFRoboEmissorNfImpostoEntity")
@Table(name = "RNFRoboEmissorNf.Imposto", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfImpostoEntity {

    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "TributoSimplificadoPercentual")
    private Double tributoSimplificadoPercentual;

    @Column(name = "Fonte", length = 20)
    private String fonte;

    @Column(name = "IcmsOrigem")
    private Integer icmsOrigem;

    @Column(name = "IcmsSituacaoTributaria", length = 4)
    private String icmsSituacaoTributaria;

    @Column(name = "PisSituacaoTributaria", length = 4)
    private String pisSituacaoTributaria;

    @Column(name = "CofinsSituacaoTributaria", length = 4)
    private String cofinsSituacaoTributaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdItem")
    private RNFRoboEmissorNfItemEntity rnfRoboEmissorNfItemEntity;

}
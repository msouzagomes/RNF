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
@Entity(name = "RNFRoboEmissorNfNfEntity")
@Table(name = "RNFRoboEmissorNf.Nf", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfNfEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "NfsId", length = 36)
    private String nfsId;

    @Column(name = "AmbienteEmissao", length = 20)
    private String ambienteEmissao;

    @Column(name = "NaturezaOperacao", length = 40)
    private String naturezaOperacao;

    @Column(name = "TipoOperacao", length = 10)
    private String tipoOperacao;

    @Column(name = "Finalidade", length = 10)
    private String finalidade;

    @Column(name = "ConsumidorFinal", nullable = false)
    private Boolean consumidorFinal = false;

    @Column(name = "IndicadorPresencaConsumidor", length = 20)
    private String indicadorPresencaConsumidor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdConfigRnf")
    private RNFRoboEmissorNfConfigRnfEntity rnfRoboEmissorNfConfigRnfEntity;

}
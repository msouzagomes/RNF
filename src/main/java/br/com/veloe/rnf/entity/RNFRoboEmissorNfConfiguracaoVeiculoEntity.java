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
@Entity(name = "RNFRoboEmissorNfConfiguracaoVeiculoEntity")
@Table(name = "RNFRoboEmissorNf.ConfiguracaoVeiculo", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfConfiguracaoVeiculoEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "ConfiguracaoVeiculosId", length = 36)
    private String configuracaoVeiculosId;

    @Column(name = "IdVeiculo", length = 36)
    private String idVeiculo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdConfigRnf", nullable = false)
    private RNFRoboEmissorNfConfigRnfEntity rnfRoboEmissorNfConfigRnfEntity;

}
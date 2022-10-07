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
@Entity(name = "RNFRoboEmissorNfCombustivelEntity")
@Table(name = "RNFRoboEmissorNf.Combustivel", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfCombustivelEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "CodigoProdutoANP", length = 10)
    private String codigoProdutoANP;

    @Column(name = "PercentualGasNatural", length = 10)
    private String percentualGasNatural;

    @Column(name = "Codif", length = 10)
    private String codif;

    @Column(name = "QuantidadeFaturadaTempAmbiente")
    private Integer quantidadeFaturadaTempAmbiente;

    @Column(name = "UfConsumo", length = 2)
    private String ufConsumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdItem")
    private RNFRoboEmissorNfItemEntity rnfRoboEmissorNfItemEntity;

}
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
@Entity(name = "RNFRoboEmissorNfCideEntity")
@Table(name = "RNFRoboEmissorNf.Cide", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfCideEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "QuantidadeBaseCalculo")
    private Integer quantidadeBaseCalculo;

    @Column(name = "ValorAliquota")
    private Integer valorAliquota;

    @Column(name = "Valor")
    private Integer valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCombustivel")
    private RNFRoboEmissorNfCombustivelEntity rnfRoboEmissorNfCombustivelEntity;

}
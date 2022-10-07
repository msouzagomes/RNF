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
@Entity(name = "RNFRoboEmissorNfItemEntity")
@Table(name = "RNFRoboEmissorNf.Item", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfItemEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "Cfop", length = 10)
    private String cfop;

    @Column(name = "Codigo", length = 10)
    private String codigo;

    @Column(name = "Descricao", length = 100)
    private String descricao;

    @Column(name = "Ncm", length = 10)
    private String ncm;

    @Column(name = "Quantidade")
    private Integer quantidade;

    @Column(name = "UnidadeMedida", length = 5)
    private String unidadeMedida;

    @Column(name = "ValorUnitario")
    private Integer valorUnitario;

    @Column(name = "Frete")
    private Integer frete;

    @Column(name = "OutrasDespesas")
    private Integer outrasDespesas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNf")
    private RNFRoboEmissorNfNfEntity rnfRoboEmissorNfNfEntity;

}
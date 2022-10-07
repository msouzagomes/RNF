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
@Entity(name = "RNFRoboEmissorNfClienteEntity")
@Table(name = "RNFRoboEmissorNf.Cliente", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfClienteEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "TipoPessoa", length = 10)
    private String tipoPessoa;

    @Column(name = "IndicadorContribuinteICMS", length = 20)
    private String indicadorContribuinteICMS;

    @Column(name = "Nome", length = 100)
    private String nome;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Telefone", length = 15)
    private String telefone;

    @Column(name = "CpfCnpj", length = 15)
    private String cpfCnpj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNf")
    private RNFRoboEmissorNfNfEntity rnfRoboEmissorNfNfEntity;


}
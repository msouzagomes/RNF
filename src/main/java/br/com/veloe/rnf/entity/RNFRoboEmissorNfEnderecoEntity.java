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
@Entity(name = "RNFRoboEmissorNfEnderecoEntity")
@Table(name = "RNFRoboEmissorNf.Endereco", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfEnderecoEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "Uf", length = 2)
    private String uf;

    @Column(name = "Cidade", length = 20)
    private String cidade;

    @Column(name = "Logradouro", length = 100)
    private String logradouro;

    @Column(name = "Numero", length = 10)
    private String numero;

    @Column(name = "Complemento", length = 20)
    private String complemento;

    @Column(name = "Bairro", length = 40)
    private String bairro;

    @Column(name = "Cep", length = 10)
    private String cep;

    @Column(name = "EnviarPorEmail", nullable = false)
    private Boolean enviarPorEmail = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCliente")
    private RNFRoboEmissorNfClienteEntity rnfRoboEmissorNfClienteEntity;

}
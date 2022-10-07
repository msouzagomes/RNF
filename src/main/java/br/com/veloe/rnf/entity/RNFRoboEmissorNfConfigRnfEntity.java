package br.com.veloe.rnf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "RNFRoboEmissorNfConfigRnfEntity")
@Table(name = "RNFRoboEmissorNf.ConfigRnf", schema = "RNFRoboEmissorNf")
public class RNFRoboEmissorNfConfigRnfEntity {
    @Id
    @Column(name = "Id", nullable = false, length = 36)
    private String id;

    @Column(name = "ConfigRnfId", nullable = false, length = 36)
    private String configRnfId;

    @Column(name = "DataInicio")
    private Instant dataInicio;

    @Column(name = "DataFim")
    private Instant dataFim;

    @Column(name = "IdFilial", length = 36)
    private String idFilial;

    @Column(name = "MostrarPlaca", nullable = false)
    private Boolean mostrarPlaca = false;

    @Column(name = "MostrarCentroCusto", nullable = false)
    private Boolean mostrarCentroCusto = false;

    @Column(name = "AgruparNotaPor", length = 15)
    private String agruparNotaPor;

    @Column(name = "DataInclusao")
    private Instant dataInclusao;

    @Column(name = "Ativo", nullable = false)
    private Boolean ativo = false;

    @Column(name = "StatusEnvio", length = 15)
    private String statusEnvio;

}
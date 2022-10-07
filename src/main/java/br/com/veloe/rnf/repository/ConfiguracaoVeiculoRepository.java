package br.com.veloe.rnf.repository;

import br.com.veloe.rnf.entity.RNFRoboEmissorNfConfiguracaoVeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoVeiculoRepository extends JpaRepository<RNFRoboEmissorNfConfiguracaoVeiculoEntity, Integer> {
}
package br.com.veloe.rnf.repository;

import br.com.veloe.rnf.entity.RNFRoboEmissorNfConfigEcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigEcRepository extends JpaRepository<RNFRoboEmissorNfConfigEcEntity, Integer> {
}

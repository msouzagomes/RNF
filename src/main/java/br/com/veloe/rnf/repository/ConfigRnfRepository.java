package br.com.veloe.rnf.repository;

import br.com.veloe.rnf.entity.RNFRoboEmissorNfConfigRnfEntity;
import br.com.veloe.rnf.model.request.TransacoesRnf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigRnfRepository extends JpaRepository<RNFRoboEmissorNfConfigRnfEntity, Integer> {
    List<RNFRoboEmissorNfConfigRnfEntity> findByConfigRnfIdAndIdFilial(String configRnfId, String idFilial);
}

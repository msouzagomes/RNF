package br.com.veloe.rnf.repository;

import br.com.veloe.rnf.entity.RNFRoboEmissorNfNfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NfRepository extends JpaRepository<RNFRoboEmissorNfNfEntity, Integer> {
}

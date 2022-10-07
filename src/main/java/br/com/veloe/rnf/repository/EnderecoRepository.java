package br.com.veloe.rnf.repository;

import br.com.veloe.rnf.entity.RNFRoboEmissorNfEnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<RNFRoboEmissorNfEnderecoEntity,Integer> {
}

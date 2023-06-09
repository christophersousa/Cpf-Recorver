package maxmilhas.com.br.cpfrecorder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maxmilhas.com.br.cpfrecorder.model.Cpf;

@Repository
public interface CpfRepository extends JpaRepository<Cpf, Integer> {
    Optional<Cpf> findByCpf(String cpf);
}

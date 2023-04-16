package sptech.school.voveaplication.domain.arquivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.voveaplication.domain.arquivo.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
}

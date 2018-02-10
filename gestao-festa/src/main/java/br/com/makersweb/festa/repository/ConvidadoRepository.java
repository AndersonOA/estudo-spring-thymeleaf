package br.com.makersweb.festa.repository;

import br.com.makersweb.festa.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}

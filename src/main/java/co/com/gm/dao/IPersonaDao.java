package co.com.gm.dao;

import co.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaDao extends CrudRepository<Persona,Long> {
}

package br.com.nagata.dev.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import br.com.nagata.dev.model.ClienteEntity;

public interface ClienteRepository
    extends CrudRepository<ClienteEntity, Long>, JpaSpecificationExecutor<ClienteEntity> {

}

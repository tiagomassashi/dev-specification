package br.com.nagata.dev.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import br.com.nagata.dev.model.DocumentoEntity;
import br.com.nagata.dev.model.pk.DocumentoPK;

public interface DocumentoRepository extends CrudRepository<DocumentoEntity, DocumentoPK>,
    JpaSpecificationExecutor<DocumentoEntity> {
}

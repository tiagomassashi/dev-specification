package br.com.nagata.dev.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import br.com.nagata.dev.model.Document;
import br.com.nagata.dev.model.pk.DocumentPK;

public interface DocumentRepository extends CrudRepository<Document, DocumentPK>,
    JpaSpecificationExecutor<Document> {
}

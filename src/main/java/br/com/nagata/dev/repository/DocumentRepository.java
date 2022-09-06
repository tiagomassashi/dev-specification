package br.com.nagata.dev.repository;

import br.com.nagata.dev.model.Document;
import br.com.nagata.dev.model.pk.DocumentPK;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository
    extends CrudRepository<Document, DocumentPK>, JpaSpecificationExecutor<Document> {}

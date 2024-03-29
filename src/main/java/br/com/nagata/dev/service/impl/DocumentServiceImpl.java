package br.com.nagata.dev.service.impl;

import br.com.nagata.dev.model.Document;
import br.com.nagata.dev.repository.DocumentRepository;
import br.com.nagata.dev.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentServiceImpl implements DocumentService {

  private final DocumentRepository repository;

  @Autowired
  public DocumentServiceImpl(DocumentRepository repository) {
    this.repository = repository;
  }

  @Override
  public Document saveDocument(Document document) {
    log.info("processing save document...");

    Document newDocument = repository.save(document);

    log.info("save document successfully processed!");
    return newDocument;
  }
}

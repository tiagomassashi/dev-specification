package br.com.nagata.dev.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.nagata.dev.model.DocumentoEntity;
import br.com.nagata.dev.repository.DocumentoRepository;
import br.com.nagata.dev.service.DocumentoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocumentoServiceImpl implements DocumentoService {

  private DocumentoRepository repository;

  @Autowired
  public DocumentoServiceImpl(DocumentoRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public DocumentoEntity saveDocument(DocumentoEntity documento) {
    log.info("processing save document...");

    DocumentoEntity newDocumento = repository.save(documento);

    log.info("save document successfully processed!");
    return newDocumento;
  }
}

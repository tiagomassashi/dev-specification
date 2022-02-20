package br.com.nagata.dev.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.nagata.dev.model.Document;
import br.com.nagata.dev.repository.DocumentRepository;

@ExtendWith(MockitoExtension.class)
class DocumentServiceImplTest {

  @InjectMocks private DocumentServiceImpl service;
  @Mock private DocumentRepository repository;

  @Test
  void testSaveDocumentSuccess(@Mock Document entity) {
    when(repository.save(Mockito.any())).thenReturn(entity);
    Document newDocument = service.saveDocument(entity);
    assertNotNull(newDocument, "Expected document entity not null");
  }
}

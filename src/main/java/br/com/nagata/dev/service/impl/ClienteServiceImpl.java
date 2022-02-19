package br.com.nagata.dev.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import br.com.nagata.dev.enums.TipoClienteEnum;
import br.com.nagata.dev.exception.BusinessException;
import br.com.nagata.dev.model.ClienteEntity;
import br.com.nagata.dev.model.DocumentoEntity;
import br.com.nagata.dev.model.dto.ClienteDTO;
import br.com.nagata.dev.repository.ClienteRepository;
import br.com.nagata.dev.repository.specification.ClienteSpecification;
import br.com.nagata.dev.service.ClienteService;
import br.com.nagata.dev.service.DocumentoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

  private ClienteRepository repository;
  private DocumentoService documentoService;

  @Autowired
  public ClienteServiceImpl(ClienteRepository repository, DocumentoService documentoService) {
    this.repository = repository;
    this.documentoService = documentoService;
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public ClienteEntity saveCustomer(ClienteDTO cliente) {
    log.info("processing save customer...");

    ClienteEntity newCliente = repository.save(new ClienteEntity(cliente));

    List<DocumentoEntity> documentos = new ArrayList<>();

    cliente.getDocumentos().stream().forEach(
        dto -> documentos.add(documentoService.saveDocument(new DocumentoEntity(dto, newCliente))));

    newCliente.setDocumentosCliente(documentos);

    log.info("save customer successfully processed!");
    return newCliente;
  }

  @Override
  public ClienteEntity getCustomerById(Long id) throws BusinessException {
    log.info("processing get customer by id...");

    ClienteEntity cliente = repository.findById(id)
        .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "customer not found"));

    log.info("get customer by id successfully processed!");
    return cliente;
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void deleteCustomerById(Long id) throws BusinessException {
    log.info("processing delete customer by id...");

    ClienteEntity cliente = repository.findById(id)
        .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "customer not found"));

    repository.delete(cliente);

    log.info("delete customer by id successfully processed!");
  }

  @Override
  public Page<ClienteEntity> getCustomers(String nome, TipoClienteEnum tipo, Pageable pageable) {
    log.info("processing get customers...");

    Page<ClienteEntity> clientes = repository.findAll(
        Specification
            .where(ClienteSpecification.likeNome(nome).and(ClienteSpecification.equalTipo(tipo))),
        pageable);

    log.info("get customers successfully processed!");
    return clientes;
  }
}

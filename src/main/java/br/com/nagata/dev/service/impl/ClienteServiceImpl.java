package br.com.nagata.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.nagata.dev.model.ClienteEntity;
import br.com.nagata.dev.model.dto.ClienteDTO;
import br.com.nagata.dev.repository.ClienteRepository;
import br.com.nagata.dev.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

  private ClienteRepository repository;

  @Autowired
  public ClienteServiceImpl(ClienteRepository repository) {
    this.repository = repository;
  }

  @Override
  public ClienteDTO saveCustomer(ClienteDTO cliente) {
    log.info("processing save customer...");

    ClienteEntity newCliente = repository.save(new ClienteEntity(cliente));

    log.info("save customer processed successfully!");
    return new ClienteDTO(newCliente);
  }

}

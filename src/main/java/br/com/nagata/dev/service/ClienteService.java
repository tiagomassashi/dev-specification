package br.com.nagata.dev.service;

import br.com.nagata.dev.model.dto.ClienteDTO;

public interface ClienteService {

  ClienteDTO saveCustomer(ClienteDTO cliente);
  
  ClienteDTO getCustomerById(Long id);
}

package br.com.nagata.dev.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.nagata.dev.enums.TipoClienteEnum;
import br.com.nagata.dev.exception.BusinessException;
import br.com.nagata.dev.model.ClienteEntity;
import br.com.nagata.dev.model.dto.ClienteDTO;

public interface ClienteService {

  ClienteEntity saveCustomer(ClienteDTO cliente);

  ClienteEntity getCustomerById(Long id) throws BusinessException;

  void deleteCustomerById(Long id) throws BusinessException;

  Page<ClienteEntity> getCustomers(String nome, TipoClienteEnum tipo, Pageable pageable);
}

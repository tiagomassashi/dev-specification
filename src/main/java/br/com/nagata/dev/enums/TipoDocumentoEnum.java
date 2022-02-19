package br.com.nagata.dev.enums;

import lombok.Getter;

@Getter
public enum TipoDocumentoEnum {
  RG("01"), CPF("02"), CNPJ("03"), RNE("04");

  private String codigo;

  private TipoDocumentoEnum(String codigo) {
    this.codigo = codigo;
  }
}

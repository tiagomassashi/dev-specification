package br.com.nagata.dev.enums;

import lombok.Getter;

@Getter
public enum DocumentTypeEnum {
  RG("01"), CPF("02"), CNPJ("03"), RNE("04");

  private String code;

  private DocumentTypeEnum(String code) {
    this.code = code;
  }
}

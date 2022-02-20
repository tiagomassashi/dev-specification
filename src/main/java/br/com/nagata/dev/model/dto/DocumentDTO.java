package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.enums.DocumentTypeEnum;
import br.com.nagata.dev.model.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {

  private DocumentTypeEnum type;
  private String number;

  public DocumentDTO(Document entity) {
    this.type = entity.getId().getDocumentType();
    this.number = entity.getDocumentNumber();
  }
}

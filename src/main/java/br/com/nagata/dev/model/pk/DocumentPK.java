package br.com.nagata.dev.model.pk;

import br.com.nagata.dev.enums.DocumentTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class DocumentPK implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "CD_CLIE", length = 9, nullable = false)
  private Long customerCode;

  @Column(name = "TP_DOCT", length = 2, nullable = false)
  private DocumentTypeEnum documentType;
}

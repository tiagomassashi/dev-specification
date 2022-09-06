package br.com.nagata.dev.model;

import br.com.nagata.dev.model.dto.DocumentDTO;
import br.com.nagata.dev.model.pk.DocumentPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_DOCT_CLIE", schema = "PUBLIC")
public class Document {

  @EmbeddedId private DocumentPK id;

  @Column(name = "NR_DOCT", length = 20, nullable = false)
  private String documentNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CD_CLIE", insertable = false, updatable = false)
  private Customer customer;

  public Document(DocumentDTO dto, Customer customer) {
    this.id = new DocumentPK();
    this.id.setDocumentType(dto.getType());
    this.id.setCustomerCode(customer.getCustomerCode());
    this.documentNumber = dto.getNumber();
    this.customer = customer;
  }
}

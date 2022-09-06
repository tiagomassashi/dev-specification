package br.com.nagata.dev.model;

import br.com.nagata.dev.enums.CustomerTypeEnum;
import br.com.nagata.dev.model.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CLIE", schema = "PUBLIC")
public class Customer {

  @Id
  @SequenceGenerator(name = "customerSequence", sequenceName = "PUBLIC.SQ_CLIE", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerSequence")
  @Column(name = "CD_CLIE", length = 9, nullable = false)
  private Long customerCode;

  @Column(name = "NM_CLIE", length = 80, nullable = false)
  private String customerName;

  @Enumerated(EnumType.STRING)
  @Column(name = "TP_CLIE", length = 10, nullable = false)
  private CustomerTypeEnum customerType;

  @Column(name = "DH_INCL", nullable = false)
  private LocalDateTime registrationDateTime;

  @OneToMany(
      mappedBy = "id.customerCode",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Document> customerDocuments;

  public Customer(CustomerDTO dto) {
    this.customerName = dto.getName();
    this.customerType = dto.getType();
    this.registrationDateTime = LocalDateTime.now();
  }
}

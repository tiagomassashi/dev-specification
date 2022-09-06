package br.com.nagata.dev.repository.specification;

import br.com.nagata.dev.enums.CustomerTypeEnum;
import br.com.nagata.dev.enums.DocumentTypeEnum;
import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.Document;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

public class CustomerSpecification {

  private static final String ID = "id";
  private static final String CUSTOMER_NAME = "customerName";
  private static final String CUSTOMER_TYPE = "customerType";
  private static final String CUSTOMER_DOCUMENTS = "customerDocuments";
  private static final String DOCUMENT_TYPE = "documentType";
  private static final String DOCUMENT_NUMBER = "documentNumber";

  private CustomerSpecification() {
    throw new IllegalStateException("Utility class");
  }

  public static Specification<Customer> likeName(String name) {
    return (root, query, builder) ->
        StringUtils.hasLength(name)
            ? builder.like(builder.upper(root.get(CUSTOMER_NAME)), "%" + name.toUpperCase() + "%")
            : null;
  }

  public static Specification<Customer> equalCustomerType(CustomerTypeEnum customerType) {
    return (root, query, builder) ->
        customerType != null ? builder.equal(root.get(CUSTOMER_TYPE), customerType) : null;
  }

  public static Specification<Customer> equalDocument(DocumentTypeEnum type, String number) {
    return (root, query, builder) -> {
      if (type != null && StringUtils.hasLength(number)) {
        final Join<Customer, Document> documents = root.join(CUSTOMER_DOCUMENTS, JoinType.INNER);
        Predicate predicateType = builder.equal(documents.get(ID).get(DOCUMENT_TYPE), type);
        Predicate predicateNumber = builder.equal(documents.get(DOCUMENT_NUMBER), number);
        return builder.and(predicateType, predicateNumber);
      }
      return null;
    };
  }
}

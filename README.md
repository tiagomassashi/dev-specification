# dev-specification
Desenvolvimento de um projeto para estudo de Spring Data JPA - Specifications, utilizando Java11 e H2.

```bash
# Clone este repositório
$ git clone https://github.com/tiagomassashi/dev-specification.git
```
## Funções
### Incluir cliente:
- URL: http://localhost:8080/dev-specification/api/v1/customer
- Method: POST
- Body:
```json
{
    "name": "Nagata",
    "type": "NORMAL",
    "documents": [
        {
            "type": "CPF",
            "number": "2"
        },
        {
            "type": "RNE",
            "number": "1"
        }
    ]
}
```

### Buscar por Id:
- URL: http://localhost:8080/dev-specification/api/v1/customer/{id}
- Method: GET

### Deletar por Id:
- URL: http://localhost:8080/dev-specification/api/v1/customer/{id}
- Method: DELETE

### Listar Clientes:
- URL: http://localhost:8080/dev-specification/api/v1/customer
- Method: GET

Param | Type | Example | URL Example
--- | --- | --- | ---
customerName | String | Nagata | customerName=Nagata
customerType | Enum | NORMAL , ESPECIAL | customerType=NORMAL
documentType | Enum | RG , CPF , CNPJ , RNE | documentType=RNE
documentNumber | String | 12345678901 | documentNumber=12345678901
page | int | 1 | page=1
size | int | 10 | size=10

### H2 Console:
- URL: http://localhost:8080/dev-specification/h2-console

```yaml
url: jdbc:h2:mem:dev
username: sa
password:
```

### Actuator:
- Health URL: http://localhost:8080/dev-specification/actuator/health
- Method: GET

```json
{
    "status": "UP",
    "components": {
        "db": {
            "status": "UP",
            "details": {
                "database": "H2",
                "validationQuery": "isValid()"
            }
        },
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 494384795648,
                "free": 379734364160,
                "threshold": 10485760,
                "exists": true
            }
        },
        "ping": {
            "status": "UP"
        }
    }
}
```

- Info URL: http://localhost:8080/dev-specification/actuator/info
- Method: GET

```json
{
    "app": {
        "groupId": "br.com.nagata.dev",
        "artifactId": "dev-specification",
        "version": "0.0.1-SNAPSHOT",
        "java": {
            "version": "17.0.2"
        }
    }
}
```

### Swagger
- URL: http://localhost:8080/dev-specification/swagger-ui/index.html#/

##

### Contato

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/tiago-nagata-5ba95ab6/)

package br.com.dmtech.pontointeligente.model

import org.hibernate.validator.constraints.Length
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class FuncionarioDTO (
  @get:NotEmpty(message = "Nome deve ser preenchido")
  @get:Length(min = 3, max = 200, message = "Nome deve está entre 3 e 200 caracteres")
 val nome: String,

  @get:NotEmpty(message =  "Nome deve ser preenchido")
  @get:Email(message = "Email inválido")
  @get:Length(min = 5, max = 50,  message = "Email deve ta entre 5 e 50")
 val email: String,

 val senha: String,
 val cpf: String,
 val perfil: PerfilEnum,
 val empresaId: String,
 val valorHora: BigDecimal? = null,
 val qtdHorasTrabalhadasDia: Float? = 0.0F,
 val qtdHorasAlmoco: Float? =  0.0F,
 val id: String? = null
)
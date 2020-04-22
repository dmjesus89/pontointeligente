package br.com.dmtech.pontointeligente.model

import org.hibernate.validator.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CNPJ
import org.springframework.data.mongodb.core.mapping.Document


data class EmpresaDTO(
        @get:NotEmpty(message = "Razão Social Deve ser preenchido")
    val razaoSocial: String,
    @get:NotEmpty(message = "CNPJ Deve ser preenchido")
    @get:CNPJ(message = "CNPJ inválido")
    val cnpj: String,
     val id: String? = null
)
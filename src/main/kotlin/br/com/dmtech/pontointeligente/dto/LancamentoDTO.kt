package br.com.dmtech.pontointeligente.model

import org.hibernate.validator.constraints.NotEmpty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


data class LancamentoDTO (
     @get:NotEmpty(message = "Data não pode ser vazia")
    val data: String,

     @get:NotEmpty(message = "Tipo não pode ser vazio")
    val tipo: TipoEnum,
    val funcionarioId: String,
    val descricao: String? = "",
    val localizacao: String? = "",
    @Id val id: String? = null
)
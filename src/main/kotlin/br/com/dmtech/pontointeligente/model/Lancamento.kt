package br.com.dmtech.pontointeligente.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Lancamento (

    val data: String,
    val tipo: TipoEnum,
    val funcionarioId: String,
    val descricao: String? = "",
    val localizacao: String? = "",
    @Id var id: String? = null
)
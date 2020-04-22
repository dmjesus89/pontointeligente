package br.com.dmtech.pontointeligente.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Empresa(
    val razaoSocial: String,
    val cnpj: String,
     val id: String? = null
)
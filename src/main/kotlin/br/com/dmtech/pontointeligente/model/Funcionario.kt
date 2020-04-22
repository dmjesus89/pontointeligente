package br.com.dmtech.pontointeligente.model

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal


@Document
data class Funcionario (

 val nome: String,
 val email: String,
 val senha: String,
 val cpf: String,
 val perfil: PerfilEnum,
 val empresaId: String,
 val valorHora: BigDecimal?=null,
 val qtdHorasTrabalhadasDia: Float? = 0.0F,
 val qtdHorasAlmoco: Float? =  0.0F,
 val id: String? = null
)
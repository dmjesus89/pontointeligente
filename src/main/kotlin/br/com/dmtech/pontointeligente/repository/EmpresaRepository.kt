package br.com.dmtech.pontointeligente.repository

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.model.Lancamento
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository : MongoRepository<Empresa, String> {

    fun findByCnpj(cnpj: String): Empresa?;
}